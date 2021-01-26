package com.oimchat.server.general.kernel.core.gateway.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.cloud.gateway.support.TimeoutException;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ResponseStatusException;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import com.oimchat.server.general.kernel.core.gateway.common.data.ResultHead;
import com.onlyxiahui.aware.basic.work.business.error.SystemError;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.common.utils.base.beans.BeanToMapUtil;

/**
 * 
 * 自定义接口返回格式，在系统出错的情况下。
 * 
 * @author XiaHui [onlovexiahui@qq.com]
 * @version 1.0.0
 * @date 2019/07/03 11:55
 * @since 1.0.0
 */
@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
		Throwable error = getError(request);
		HttpStatus errorStatus = determineHttpStatus(error);
		log.error("Request uri: {}, error: {}, message: {}, exception: {}, trace: {}",
				request.uri().toString(), errorStatus.getReasonPhrase(), determineMessage(error),
				error.getClass().getName(), determineStackTrace(error));

		String code = SystemError.SYSTEM_EXCEPTIONS.value();
		if (error instanceof BindingResult) {
			code = SystemError.PARAMETER_ERROR.value();
		} else if (error instanceof TimeoutException) {
			code = SystemError.REQUEST_TIMEOUT.value();
		} else if (error instanceof HystrixTimeoutException) {
			code = SystemError.FALLBACK.value();
		} else if (error instanceof ResponseStatusException) {
			code = SystemError.INVALID_REQUEST.value();
		}

		ResultHead head = new ResultHead() {

			long timestamp = System.currentTimeMillis();

			public String getKey() {
				return System.currentTimeMillis() + "";
			}

			public long getTimestamp() {
				return timestamp;
			}
		};

		ResultMessage result = new ResultMessage();
		result.setHead(head);
		result.addError(code, determineMessage(error));
		result.bodyPut("data", "X-OIM-GW=1");

		Map<String, Object> r = BeanToMapUtil.toMap(result);
		return r;
	}

	private HttpStatus determineHttpStatus(Throwable error) {
		if (error instanceof ResponseStatusException) {
			return ((ResponseStatusException) error).getStatus();
		}
		ResponseStatus responseStatus = AnnotatedElementUtils.findMergedAnnotation(error.getClass(), ResponseStatus.class);
		if (responseStatus != null) {
			return responseStatus.code();
		}
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

	private String determineMessage(Throwable error) {
		if (error instanceof WebExchangeBindException) {
			return error.getMessage();
		}
		if (error instanceof ResponseStatusException) {
			ResponseStatusException r = ((ResponseStatusException) error);
			String s = r.getReason();
			if (null == s) {
				s = (null != r.getStatus()) ? r.getStatus().toString() : "服务不可用";
			}
			return s;
		}
		ResponseStatus responseStatus = AnnotatedElementUtils.findMergedAnnotation(error.getClass(), ResponseStatus.class);
		if (responseStatus != null) {
			return responseStatus.reason();
		}
		return error.getMessage();
	}

	private String determineStackTrace(Throwable error) {
		StringWriter stackTrace = new StringWriter();
		error.printStackTrace(new PrintWriter(stackTrace));
		stackTrace.flush();
		return stackTrace.toString();
	}
}
