package com.oimchat.doc.config;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.onlyxiahui.aware.common.auth.annotation.PermissionMapping;
import com.onlyxiahui.common.action.description.DocumentContext;
import com.onlyxiahui.common.action.description.bean.MethodData;
import com.onlyxiahui.common.action.description.bean.ModuleData;
import com.onlyxiahui.common.action.description.handler.impl.method.RestMappingMethodHandler;

/**
 * Description <br>
 * Date 2020-07-17 15:20:52<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class OnlyRestMappingMethodHandler extends RestMappingMethodHandler {
	@Override
	public MethodData handle(DocumentContext context, ModuleData moduleData, Method method) {
		MethodData methodData = super.handle(context, moduleData, method);
		if (null != methodData) {
			PermissionMapping pm = method.getAnnotation(PermissionMapping.class);
			if (null != pm) {
				Map<String, Object> extend = methodData.getExtend();
				if (null == extend) {
					extend = new HashMap<>();
					methodData.setExtend(extend);
				}
				extend.put(PermissionMapping.class.getName(), pm);
			}
		}
		return methodData;
	}
}
