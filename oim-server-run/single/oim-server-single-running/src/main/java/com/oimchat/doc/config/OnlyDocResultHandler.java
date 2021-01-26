package com.oimchat.doc.config;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.onlyxiahui.common.action.description.DocumentContext;
import com.onlyxiahui.common.action.description.bean.MethodData;
import com.onlyxiahui.common.action.description.bean.ModuleData;
import com.onlyxiahui.common.action.description.bean.PropertyData;
import com.onlyxiahui.common.action.description.bean.ResultData;
import com.onlyxiahui.common.action.description.box.JsonDataTypeBox;
import com.onlyxiahui.common.action.description.enums.data.JsonDataType;
import com.onlyxiahui.common.action.description.handler.PropertyHandler;
import com.onlyxiahui.common.action.description.handler.impl.result.DefaultResultHandler;
import com.onlyxiahui.common.action.description.util.ActionClassUtil;
import com.onlyxiahui.common.action.description.util.CommentUtil;
import com.onlyxiahui.common.message.AbstractMessage;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.thoughtworks.qdox.model.JavaClass;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * Description <br>
 * Date 2020-04-09 14:54:08<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
public class OnlyDocResultHandler extends DefaultResultHandler {

	@Override
	public ResultData create(DocumentContext context, ModuleData moduleData, MethodData methodData, Method method) {
		Class<?> returnClass = method.getReturnType();
		Type returnType = method.getGenericReturnType();

		if (Mono.class.isAssignableFrom(returnClass) || Flux.class.isAssignableFrom(returnClass)) {
			boolean isParameterizedType = (returnType instanceof ParameterizedType);
			if (isParameterizedType) {
				ParameterizedType parameterizedType = (ParameterizedType) returnType;
				Type[] types = parameterizedType.getActualTypeArguments();
				if (types.length > 0) {
					Type valueType = types[0];
					if (valueType instanceof Class<?>) {
						returnClass = (Class<?>) valueType;
					}
					if (valueType instanceof ParameterizedType) {
						Type rawType = ((ParameterizedType) valueType).getRawType();
						if (rawType instanceof Class<?>) {
							returnClass = (Class<?>) rawType;
						}
					}
					returnType = valueType;
				}
			}
		}

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

		if (void.class == returnClass) {
			return null;
		}
		ResultData md = new ResultData();

		if (!AbstractMessage.class.isAssignableFrom(returnClass)) {

			String className = ResultMessage.class.getName();
			String description = "信息";
			String type = JsonDataTypeBox.getType(returnClass);

			md.setClassName(className);
			md.setType(type);
			md.setDescription(description);

			List<PropertyData> nodes = new ArrayList<>();

			if (Info.class.isAssignableFrom(returnClass)) {

				PropertyData head = getHead(ac, mc);
				PropertyData body = getBody();
				PropertyData info = getInfo();

				nodes.add(head);
				nodes.add(body);
				nodes.add(info);
			} else if (Map.class.isAssignableFrom(returnClass)) {
				PropertyData head = getHead(ac, mc);
				PropertyData body = getBody();
				PropertyData info = getInfo();

				nodes.add(head);
				nodes.add(body);
				nodes.add(info);

				List<PropertyData> list = null;
				for (PropertyHandler ph : context.getPropertyHandlers()) {
					if (ph.support(context, returnClass, returnType)) {
						list = ph.handle(context, returnClass, returnType);
					}
				}
				body.setNodes(list);
			} else if (Collection.class.isAssignableFrom(returnClass)) {
				PropertyData head = getHead(ac, mc);
				PropertyData body = getBody();
				PropertyData info = getInfo();

				nodes.add(head);
				nodes.add(body);
				nodes.add(info);

				PropertyData pd = new PropertyData();
				pd.setName("items");
				pd.setType(JsonDataType.Array.type());
				pd.setDescription("结果集");
				pd.setClassName(List.class.getName());

				List<PropertyData> list = null;
				for (PropertyHandler ph : context.getPropertyHandlers()) {
					if (ph.support(context, returnClass, returnType)) {
						list = ph.handle(context, returnClass, returnType);
					}
				}
				pd.setNodes(list);

				List<PropertyData> arrayList = new ArrayList<>();
				arrayList.add(pd);

				body.setNodes(arrayList);
			} else {

				PropertyData head = getHead(ac, mc);
				PropertyData body = getBody();
				PropertyData info = getInfo();

				nodes.add(head);
				nodes.add(body);
				nodes.add(info);

				List<PropertyData> list = null;
				for (PropertyHandler ph : context.getPropertyHandlers()) {
					if (ph.support(context, returnClass, returnType)) {
						list = ph.handle(context, returnClass, returnType);
					}
				}
				body.setNodes(list);
			}
			md.setNodes(nodes);
		} else {
			String className = returnClass.getName();
			String description = "";
			String type = JsonDataTypeBox.getType(returnClass);

			JavaClass jc = context.getSourceBox().getJavaClassByName(className);
			if (null != jc) {
				description = CommentUtil.getFirstCommentLine(jc.getComment());
			}
			md.setClassName(className);
			md.setType(type);
			md.setDescription(description);

			if (!ActionClassUtil.isPrimitive(returnClass)) {
				List<PropertyData> nodes = null;
				for (PropertyHandler ph : context.getPropertyHandlers()) {
					if (ph.support(context, returnClass, returnType)) {
						nodes = ph.handle(context, returnClass, returnType);
					}
				}
				md.setNodes(nodes);

				if (null != nodes) {
					PropertyData head = null;
					for (PropertyData n : nodes) {
						if ("head".equals(n.getName())) {
							head = n;
							break;
						}
					}
					if (null == head) {
						head = getHead(ac, mc);
						nodes.add(head);
					} else {
						List<PropertyData> headNodes = getHeadNodes(ac, mc);
						head.setNodes(headNodes);
					}
				}
			}
		}
		return md;
	}

	public PropertyData getInfo() {
		PropertyData pd = new PropertyData();
		pd.setName("info");
		pd.setType(JsonDataType.Object.type());
		pd.setDescription("信息状态（成功/失败）");
		pd.setClassName(Info.class.getName());

		List<PropertyData> nodes = new ArrayList<>();

		PropertyData node = new PropertyData();
		node.setName("success");
		node.setType(JsonDataType.Boolean.type());
		node.setDescription("信息状态：成功：true、失败：false");
		node.setClassName(Boolean.class.getName());
		nodes.add(node);

		node = getErrors();
		nodes.add(node);

		node = getWarnings();
		nodes.add(node);

		node = getPrompts();
		nodes.add(node);

		pd.setNodes(nodes);
		return pd;
	}

	public PropertyData getBody() {
		PropertyData pd = new PropertyData();
		pd.setName("body");
		pd.setType(JsonDataType.Object.type());
		pd.setDescription("信息主体");
		pd.setClassName(Object.class.getName());
		return pd;
	}

	public PropertyData getHead(String a, String m) {
		PropertyData pd = new PropertyData();
		pd.setName("head");
		pd.setType(JsonDataType.Object.type());
		pd.setDescription("信息头部");
		pd.setClassName(Object.class.getName());

		List<PropertyData> nodes = getHeadNodes(a, m);

		pd.setNodes(nodes);
		return pd;
	}

	public List<PropertyData> getHeadNodes(String a, String m) {
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
		return nodes;
	}

	public PropertyData getErrors() {

		PropertyData pd = new PropertyData();
		pd.setName("errors");
		pd.setType(JsonDataType.Array.type());
		pd.setDescription("程序错误信息集合（主要是程序级别错误，如：字段错误、不能为空等）");
		pd.setClassName(List.class.getName());

		List<PropertyData> nodes = new ArrayList<>();
		PropertyData node = getContentInfo();
		nodes.add(node);

		pd.setNodes(nodes);
		return pd;
	}

	public PropertyData getWarnings() {

		PropertyData pd = new PropertyData();
		pd.setName("warnings");
		pd.setType(JsonDataType.Array.type());
		pd.setDescription("业务错误信息集合（主要是业务中错误，如：账号错误、密码错误等）");
		pd.setClassName(List.class.getName());

		List<PropertyData> nodes = new ArrayList<>();
		PropertyData node = getContentInfo();
		nodes.add(node);

		pd.setNodes(nodes);
		return pd;
	}

	public PropertyData getPrompts() {

		PropertyData pd = new PropertyData();
		pd.setName("prompts");
		pd.setType(JsonDataType.Array.type());
		pd.setDescription("成功提醒");
		pd.setClassName(List.class.getName());

		List<PropertyData> nodes = new ArrayList<>();
		PropertyData node = getContentInfo();
		nodes.add(node);

		pd.setNodes(nodes);
		return pd;
	}

	public PropertyData getContentInfo() {
		PropertyData pd = new PropertyData();
		pd.setName("");
		pd.setType(JsonDataType.Object.type());
		pd.setDescription("信息内容");
		pd.setClassName(Object.class.getName());

		List<PropertyData> nodes = getContentInfoNodes();
		pd.setNodes(nodes);
		return pd;
	}

	public List<PropertyData> getContentInfoNodes() {

		List<PropertyData> nodes = new ArrayList<>();

		PropertyData node = new PropertyData();
		node.setName("code");
		node.setType(JsonDataType.String.type());
		node.setDescription("信息编码");
		node.setClassName(String.class.getName());
		nodes.add(node);

		node = new PropertyData();
		node.setName("text");
		node.setType(JsonDataType.String.type());
		node.setDescription("信息内容");
		node.setClassName(String.class.getName());
		nodes.add(node);

		return nodes;
	}
}
