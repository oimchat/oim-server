package com.oimchat.server.run.auth;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.PathContainer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import com.alibaba.fastjson.JSON;
import com.oimchat.server.basic.common.work.app.SessionEnum;
import com.oimchat.server.basic.definition.auth.business.UserTokenAuthBox;
import com.oimchat.server.basic.definition.auth.business.type.TokenStatus;
import com.oimchat.server.basic.definition.auth.manage.UserPermissionAuthBox;
import com.onlyxiahui.aware.basic.work.business.error.SystemError;
import com.onlyxiahui.common.message.node.Head;
import com.onlyxiahui.common.message.result.ResultMessage;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Description <br>
 * Date 2020-06-07 11:55:05<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class AuthFilter implements WebFilter {

	protected final Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	UserTokenAuthBox userAuthBox;
	@Autowired
	UserPermissionAuthBox userPermissionAuth;

	@Autowired
	SkipPathBox skipPathBox;
	@Autowired
	PermissionPathBox interceptPathBox;

	boolean isSkip(ServerWebExchange exchange) {
		PathContainer lookupPath = exchange.getRequest().getPath().pathWithinApplication();
		boolean has = skipPathBox.has(lookupPath);
		return has;
	}

	boolean isRoot(String key, String token) {
		return userPermissionAuth.isRoot(key);
	}

	boolean isAuth(String key, String token) {
		String uid1 = userAuthBox.getUserId(token);
		boolean mark = (StringUtils.isNotBlank(uid1) && uid1.equals(key));
		return mark;
	}

	TokenStatus verify(String key, String token) {
		return userAuthBox.verify(key, token);
	}

	boolean needPermission(ServerWebExchange exchange) {
		PathContainer lookupPath = exchange.getRequest().getPath().pathWithinApplication();
		return interceptPathBox.has(lookupPath);
	}

	boolean hasPermission(String key, String path) {
		return userPermissionAuth.hasPermission(key, path);
	}

	private DataBuffer getBodyBuffer(ServerHttpResponse response, Object result) {
		return response.bufferFactory().wrap(JSON.toJSONBytes(result));
	}

	private Head getResultHead() {
		ResultHead head = new ResultHead();
		head.setKey(System.currentTimeMillis() + "");
		head.setTimestamp(System.currentTimeMillis());
		return head;
	}

	Mono<Void> intercept(ServerWebExchange exchange, String code, String message) {
		exchange.getResponse().setStatusCode(HttpStatus.OK);
		exchange.getResponse().getHeaders().add("Content-Type", "application/json;charset=UTF-8");

		exchange.getResponse().getHeaders().add("Access-Control-Allow-Origin", "*");
		exchange.getResponse().getHeaders().add("Access-Control-Allow-Credentials", "true");
		// 响应类型允许的方法
		exchange.getResponse().getHeaders().add("Access-Control-Allow-Methods", "*");
		// 响应头设置
		exchange.getResponse().getHeaders().add("Access-Control-Allow-Headers", "*");

		ResultMessage result = new ResultMessage();
		result.setHead(getResultHead());
		result.addError(code, message);
		return exchange.getResponse().writeWith(Flux.just(this.getBodyBuffer(exchange.getResponse(), result)));
	}

	Mono<Void> intercept(ServerWebExchange exchange, boolean isAuth, String token, String key) {
		String message = SystemError.AUTHENTICATION_FAILED.message();

		if ((StringUtils.isNotBlank(token) && StringUtils.isNotBlank(token))) {
			if (isAuth) {
				message = "无权访问！";
			} else {
				message = "登录已过时！";
			}
		}
		String code = SystemError.AUTHENTICATION_FAILED.value();
		return intercept(exchange, code, message);
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		String token = exchange.getRequest().getHeaders().getFirst(SessionEnum.token.getName());
		String key = exchange.getRequest().getHeaders().getFirst(SessionEnum.key.getName());
		String path = exchange.getRequest().getPath().value();

		ServerHttpRequest request = exchange.getRequest();
		HttpMethod hm = request.getMethod();
		if (HttpMethod.OPTIONS == hm) {
			return chain.filter(exchange);
		}
		if (isSkip(exchange)) {
			return chain.filter(exchange);
		}
		if (isRoot(key, token)) {
			return chain.filter(exchange);
		}

		TokenStatus status = verify(key, token);

		boolean isAuth = TokenStatus.available == status;

		if (!isAuth) {
			return intercept(exchange, isAuth, token, key);
		} else {
			if (needPermission(exchange)) {
				if (!hasPermission(key, path)) {
					return intercept(exchange, isAuth, token, key);
				}
			}
		}
		return chain.filter(exchange);
	}

	class ResultHead implements Head {
		private String key;
		private Long timestamp;

		@Override
		public String getKey() {
			return key;
		}

		@Override
		public void setKey(String key) {
			this.key = key;
		}

		public Long getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Long timestamp) {
			this.timestamp = timestamp;
		}
	}
}
