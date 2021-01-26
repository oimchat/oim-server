package com.oimchat.server.general.kernel.core.gateway.common.exception;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * 全局错误处理程序
 * 
 * @author XiaHui <onlovexiahui@qq.com>
 * @version 1.0.0
 * @date 2019/07/03 13:46
 * @since 1.0.0
 */
@Component
@Order(-2)
public class GlobalErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {

	public GlobalErrorWebExceptionHandler(
			GlobalErrorAttributes errorAttributes,
			ApplicationContext applicationContext,
			ServerCodecConfigurer serverCodecConfigurer) {
		super(errorAttributes, new ResourceProperties(), applicationContext);
		super.setMessageWriters(serverCodecConfigurer.getWriters());
		super.setMessageReaders(serverCodecConfigurer.getReaders());
	}

	/**
	 * 创建一个RouterFunction，可以将错误路由和处理为JSON响应或HTML视图。
	 *
	 * @param errorAttributes 用于提取错误的ErrorAttributes实例信息
	 * @return
	 */
	@Override
	protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
		return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
	}

	private Mono<ServerResponse> renderErrorResponse(final ServerRequest request) {
		final Map<String, Object> errorPropertiesMap = getErrorAttributes(request, ErrorAttributeOptions.defaults());
		return ServerResponse.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(errorPropertiesMap));
	}
}
