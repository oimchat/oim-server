package com.oimchat.doc.config;

import java.util.Iterator;
import java.util.List;

import com.onlyxiahui.common.action.description.DocumentContext;
import com.onlyxiahui.common.action.description.handler.MethodHandler;
import com.onlyxiahui.common.action.description.handler.ResultHandler;
import com.onlyxiahui.common.action.description.handler.impl.method.ActionMappingMethodHandler;
import com.onlyxiahui.common.action.description.handler.impl.method.RequestMappingMethodHandler;
import com.onlyxiahui.common.action.description.handler.impl.method.RestMappingMethodHandler;
import com.onlyxiahui.common.action.description.handler.impl.result.DefaultResultHandler;
import com.onlyxiahui.general.doc.spring.boot.OnlyDocumentConfigurer;

/**
 * Description <br>
 * Date 2020-01-13 14:21:37<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
public class OnlyDocumentConfigurerImpl implements OnlyDocumentConfigurer {

	@Override
	public void config(DocumentContext context) {
//		context.setDocClassScanner(new OnlyPathClassScanner());
		List<ResultHandler> list = context.getResultHandlers();
		for (Iterator<ResultHandler> i = list.iterator(); i.hasNext();) {
			Object o = i.next();
			if (DefaultResultHandler.class == o.getClass()) {
				i.remove();
			}
		}

		for (Iterator<MethodHandler> i = context.getMethodHandlers().iterator(); i.hasNext();) {
			Object o = i.next();
			if (ActionMappingMethodHandler.class == o.getClass()) {
				i.remove();
			}
			if (RequestMappingMethodHandler.class == o.getClass()) {
				i.remove();
			}
			if (RestMappingMethodHandler.class == o.getClass()) {
				i.remove();
			}
		}
		context.getMethodHandlers().add(new OnlyActionMappingMethodHandler());
		context.getMethodHandlers().add(new OnlyRequestMappingMethodHandler());
		context.getMethodHandlers().add(new OnlyRestMappingMethodHandler());
		context.getMethodHandlers().add(new OnlyActionMappingMethodHandler());
		context.getResultHandlers().add(new OnlyDocResultHandler());
	}
}
