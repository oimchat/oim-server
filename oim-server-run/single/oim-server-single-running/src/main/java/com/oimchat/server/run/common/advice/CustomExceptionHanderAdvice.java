package com.oimchat.server.run.common.advice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebExchange;

import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.framework.action.dispatcher.general.exception.MessageValidException;
import com.onlyxiahui.framework.json.validator.ValidatorResult;

/**
 * 全局业务异常处理 Description <br>
 * Date 2020-05-20 15:10:28<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@ControllerAdvice
public class CustomExceptionHanderAdvice {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 数据校验异常
	 *
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(WebExchangeBindException.class)
	public Object handleWebBindException(WebExchangeBindException ex, ServerWebExchange exchange) {
		List<FieldError> fieldErrors = ex.getFieldErrors();
		ResultMessage m = new ResultMessage();
		if (null != fieldErrors) {
			for (FieldError fieldError : fieldErrors) {
				m.addError("2.000", "[" + fieldError.getField() + "]:" + fieldError.getDefaultMessage());
			}
		}
		return m;
	}

	/**
	 * 全局异常
	 *
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public Object exception(Exception ex, ServerWebExchange exchange) {
		// 业务异常
		ResultMessage m = new ResultMessage();
		if (ex instanceof MessageValidException) {
			MessageValidException mve = (MessageValidException) ex;
			List<ValidatorResult> list = mve.getList();
			if (null != list) {
				int size = list.size();
				size = size > 100 ? 100 : size;
				for (int i = 0; i < size; i++) {
					ValidatorResult vr = list.get(i);
					m.addWarning(vr.getErrorCode(), "[" + vr.getPropertyPath() + "]:" + vr.getMessage());
				}
			}
		} else {
			m.addError("1.001", ex.getMessage());
			m.addWarning("1.001", "系统异常");
			logger.error(ex.getMessage(), ex);
			ex.printStackTrace();
		}
		return m;
	}
}
