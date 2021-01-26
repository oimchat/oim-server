package com.oimchat.server.general.kernel.core.gateway.common.route.fallback;

import java.net.URI;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.oimchat.server.general.kernel.core.gateway.common.data.ResultHead;
import com.oimchat.server.general.kernel.core.gateway.common.route.RouterConstant;
import com.onlyxiahui.aware.basic.work.business.error.SystemError;
import com.onlyxiahui.common.lib.util.json.JsonUtil;
import com.onlyxiahui.common.message.node.Head;
import com.onlyxiahui.common.message.result.ResultMessage;

import reactor.core.publisher.Mono;

/**
 * 
 * 网关通过路由规则到后端服务出现异常问题时的回退方法，保证调用端始终拿到可理解数据。 <br>
 * Date 2020-03-09 12:37:34<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@RestController
public class FallbackController {

	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	String headKey = "head";
	String key = "key";

	@RequestMapping("/fallback")
	public Mono<Object> fallback(ServerWebExchange exchange) {
		Throwable throwable = exchange.getAttributeOrDefault(ServerWebExchangeUtils.HYSTRIX_EXECUTION_EXCEPTION_ATTR, new Throwable());
		String message = throwable.getMessage();
		// 将调用栈信息转换成字符串方便日志输出
		String stackTrace = ExceptionUtils.getStackTrace(throwable);
		// 获取当前请求地址
		LinkedHashSet<URI> originalRequestUris = exchange.getAttributeOrDefault(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR, new LinkedHashSet<>(0));
		Iterator<URI> it = originalRequestUris.iterator();
		String requestUri = null;
		if (it.hasNext()) {
			requestUri = it.next().toString();
		}
		log.warn("Request uri: {} enter fallback method, message: {}, stack trace: {}", requestUri, message, stackTrace);
		Object requestBody = exchange.getAttribute(RouterConstant.CACHED_REQUEST_BODY);

		ResultMessage result = new ResultMessage();
		result.setHead(getResultHead(requestBody));
		result.addError(SystemError.FALLBACK.value(), SystemError.FALLBACK.message());
		result.bodyPut("data", "X-FAS-GW=1");
		return Mono.just(result);
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
}
