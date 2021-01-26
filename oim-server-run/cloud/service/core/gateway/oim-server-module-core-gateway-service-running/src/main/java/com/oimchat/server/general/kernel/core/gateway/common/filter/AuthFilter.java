package com.oimchat.server.general.kernel.core.gateway.common.filter;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.PathContainer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.TypeReference;
import com.oimchat.server.basic.definition.auth.business.type.TokenStatus;
import com.oimchat.server.general.kernel.core.gateway.auth.service.AddressAuthService;
import com.oimchat.server.general.kernel.core.gateway.auth.service.AuthService;
import com.oimchat.server.general.kernel.core.gateway.common.data.ResultHead;
import com.oimchat.server.general.kernel.core.gateway.common.route.AuthConstant;
import com.oimchat.server.general.kernel.core.gateway.common.route.RouterConstant;
import com.oimchat.server.general.kernel.core.gateway.common.util.WebAddressUtil;
import com.onlyxiahui.aware.basic.work.business.error.ErrorCode;
import com.onlyxiahui.aware.basic.work.business.error.SystemError;
import com.onlyxiahui.common.lib.util.json.JsonUtil;
import com.onlyxiahui.common.message.node.Head;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.common.utils.base.lang.string.StringUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * 
 * 路由鉴权<br>
 * Date 2020-01-02 11:52:16<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered {

	@Resource
	private AuthService authService;
	@Resource
	private AddressAuthService addressAuthService;
	@Resource
	private PathBox pathBox;

	String headKey = "head";
	String key = "key";

	/**
	 * 封装返回值
	 *
	 * @param response
	 * @param result
	 * @return
	 */
	private DataBuffer getBodyBuffer(ServerHttpResponse response, Object result) {
		return response.bufferFactory().wrap(JSON.toJSONBytes(result));
	}

	Mono<Void> intercept(ServerWebExchange exchange, Object requestBody, String code, String message) {
		exchange.getResponse().setStatusCode(HttpStatus.OK);
		exchange.getResponse().getHeaders().add("Content-Type", "application/json;charset=UTF-8");
		ResultMessage result = new ResultMessage();
		result.setHead(getResultHead(requestBody));
		result.addError(code, message);
		return exchange.getResponse().writeWith(Flux.just(this.getBodyBuffer(exchange.getResponse(), result)));
	}

	/**
	 * 
	 * 无需拦截 <br>
	 * Date 2021-01-19 10:10:52<br>
	 * 
	 * @param exchange
	 * @return
	 * @since 1.0.0
	 */
	boolean isSkip(ServerWebExchange exchange) {
		PathContainer lookupPath = exchange.getRequest().getPath().pathWithinApplication();
		boolean has = pathBox.isSkip(lookupPath);
		return has;
	}

	/**
	 * 
	 * 需要权限 <br>
	 * Date 2021-01-19 10:11:04<br>
	 * 
	 * @param exchange
	 * @return
	 * @since 1.0.0
	 */
	boolean isGrant(ServerWebExchange exchange) {
		PathContainer lookupPath = exchange.getRequest().getPath().pathWithinApplication();
		return pathBox.isGrant(lookupPath);
	}

	boolean isRoot(String key, String token) {
		return authService.isRoot(key);
	}

	TokenStatus verify(String key, String token) {
		return authService.verify(key, token);
	}

	boolean isAuth(String key, String token) {
		return authService.isAuth(key, token);
	}

	boolean hasPermission(String key, String path) {
		return authService.hasPermission(key, path);
	}

	private String getToken(Object body, String authorization) {
		if (null == authorization || authorization.isEmpty()) {
			if (body instanceof Map) {
				Map<?, ?> map = (Map<?, ?>) body;
				Object head = map.get("head");
				if (head instanceof Map) {
					Object value = ((Map<?, ?>) head).get("token");
					authorization = (null == value) ? "" : value.toString();
				}
			} else if (body instanceof String) {
				String json = body.toString();
				if (JsonUtil.maybeJsonObject(json)) {
					Object value = JSONPath.read(json, "head.token");
					authorization = (null == value) ? "" : value.toString();
				}
			}
		}
		return authorization;
	}

	private Head getResultHead(Object data) {
		ResultHead head = new ResultHead();
		head.setKey(System.currentTimeMillis() + "");
		if (data instanceof Map) {
			Map<?, ?> map = (Map<?, ?>) data;
			Object h = map.get("head");
			if (head instanceof Map) {
				@SuppressWarnings("unchecked")
				Map<Object, Object> value = ((Map<Object, Object>) h);
				Object o = value.get(key);
				if (null != o) {
					head.setKey(o.toString());
				}
			}
		} else if (data instanceof String) {
			String json = data.toString();
			if (JsonUtil.maybeJsonObject(json)) {
				LinkedHashMap<String, Object> map = JSONObject.parseObject(json, new TypeReference<LinkedHashMap<String, Object>>() {
				});

				Object h = map.get("head");
				if (head instanceof Map) {
					@SuppressWarnings("unchecked")
					Map<Object, Object> value = ((Map<Object, Object>) h);
					Object o = value.get(key);
					if (null != o) {
						head.setKey(o.toString());
					}
				}
			}
		}
		head.setTimestamp(System.currentTimeMillis());
		return head;
	}

	private boolean authAddress(ServerWebExchange exchange) {
		String ip = WebAddressUtil.getIpAddress(exchange.getRequest());
		if (StringUtil.isBlank(ip)) {
			return false;
		}
		return addressAuthService.addressAuth(ip);
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		Object requestBody = exchange.getAttribute(RouterConstant.CACHED_REQUEST_BODY);
		// 白名单过滤
		if (!authAddress(exchange)) {
			return intercept(exchange, requestBody, SystemError.ACCESS_DENIED.value(), SystemError.ACCESS_DENIED.message());
		}

		String path = exchange.getRequest().getPath().value();
//		String service = "";
//		Object r = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
//		if (r instanceof Route) {
//			Route route = (org.springframework.cloud.gateway.route.Route) r;
//			URI uri = route.getUri();
//			if (null != uri) {
//				service = uri.getHost();
//			}
//		}

		// 不用拦截
		if (isSkip(exchange)) {
			return chain.filter(exchange);
		}

		String authorization = exchange.getRequest().getHeaders().getFirst(AuthConstant.TOKEN);
		String source = exchange.getRequest().getHeaders().getFirst(AuthConstant.KEY);
		String token = getToken(requestBody, authorization);

		TokenStatus status = verify(source, token);

		boolean isAuth = TokenStatus.available == status;
		if (isAuth) {
			// 超级管理员
			if (isRoot(key, token)) {
				return chain.filter(exchange);
			}

			if (isGrant(exchange)) {
				if (!hasPermission(key, path)) {
					return intercept(exchange, requestBody, SystemError.ACCESS_DENIED.value(), SystemError.ACCESS_DENIED.message());
				}
			}
		} else {
			boolean expired = TokenStatus.expired == status;
			String code = !expired ? SystemError.AUTHENTICATION_FAILED.value() : ErrorCode.system.code("016");
			String message = !expired ? SystemError.AUTHENTICATION_FAILED.message() : "认证过时";
			return intercept(exchange, requestBody, code, message);
		}
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return 200;
	}
}
