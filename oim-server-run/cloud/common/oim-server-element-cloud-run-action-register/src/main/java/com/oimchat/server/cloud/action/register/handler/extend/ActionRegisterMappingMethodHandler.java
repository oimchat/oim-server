
package com.oimchat.server.cloud.action.register.handler.extend;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.onlyxiahui.aware.common.auth.annotation.PermissionMapping;
import com.onlyxiahui.common.action.description.DocumentContext;
import com.onlyxiahui.common.action.description.bean.MethodData;
import com.onlyxiahui.common.action.description.bean.ModuleData;
import com.onlyxiahui.common.action.description.bean.ParameterData;
import com.onlyxiahui.common.action.description.bean.PropertyData;
import com.onlyxiahui.common.action.description.enums.data.JsonDataType;
import com.onlyxiahui.common.action.description.enums.data.ParameterType;
import com.onlyxiahui.common.action.description.handler.impl.method.ActionMappingMethodHandler;

/**
 * Description <br>
 * Date 2020-04-10 10:56:24<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class ActionRegisterMappingMethodHandler extends ActionMappingMethodHandler {

	@Override
	public List<ParameterData> createParameters(
			DocumentContext context,
			ModuleData moduleData,
			MethodData methodData,
			Method method) {
		List<String> aps = moduleData.getPaths();
		List<String> mps = methodData.getPaths();
		String ac = "";
		String mc = "";
		if (null != aps && !aps.isEmpty()) {
			ac = aps.get(0);
		}
		if (null != mps && !mps.isEmpty()) {
			mc = mps.get(0);
		}
		PropertyData head = getHead(ac, mc);
		List<ParameterData> parameters = super.createParameters(
				context,
				moduleData,
				methodData,
				method);
		ParameterData data = new ParameterData(ParameterType.node.type(), head);
		parameters.add(data);
		PermissionMapping pm = method.getAnnotation(PermissionMapping.class);
		if (null != pm) {
			Map<String, Object> extend = methodData.getExtend();
			if (null == extend) {
				extend = new HashMap<>();
				methodData.setExtend(extend);
			}
			extend.put(PermissionMapping.class.getName(), pm);
		}
		return parameters;
	}

	@Override
	public void setRoot(Map<String, PropertyData> rootPathMap, Map<String, PropertyData> pathMap, PropertyData pd, String pathName) {
		if (!pathName.startsWith("body.") && !"body".equals(pathName.trim())) {
			pathName = "body." + pathName;
		}
		super.setRoot(rootPathMap, pathMap, pd, pathName);
	}

	public PropertyData getHead(String a, String m) {
		PropertyData pd = new PropertyData();
		pd.setName("head");
		pd.setType(JsonDataType.Object.type());
		pd.setDescription("信息头部");
		pd.setClassName(Object.class.getName());

		List<PropertyData> nodes = new ArrayList<>();

		PropertyData node = new PropertyData();
		node.setName("key");
		node.setType(JsonDataType.String.type());
		node.setDescription("请求唯一值");
		node.setClassName(String.class.getName());
		nodes.add(node);

		node = new PropertyData();
		node.setName("action");
		node.setType(JsonDataType.String.type());
		node.setDescription("请求服务分类");
		node.setClassName(String.class.getName());
		node.setExample(a);
		nodes.add(node);

		node = new PropertyData();
		node.setName("method");
		node.setType(JsonDataType.String.type());
		node.setDescription("请求具体方法");
		node.setClassName(String.class.getName());
		node.setExample(m);
		nodes.add(node);

		node = new PropertyData();
		node.setName("timestamp");
		node.setType(JsonDataType.Integer.type());
		node.setDescription("响应时间戳（毫秒）");
		node.setClassName(Long.class.getName());
		nodes.add(node);

		pd.setNodes(nodes);
		return pd;
	}
}
