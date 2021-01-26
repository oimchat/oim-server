package com.oimchat.server.cloud.action.register.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.cloud.action.register.config.RegisterActionProperties;
import com.oimchat.server.cloud.action.register.data.ActionData;
import com.oimchat.server.cloud.action.register.handler.extend.ActionRegisterMappingMethodHandler;
import com.onlyxiahui.common.action.description.DocumentContext;
import com.onlyxiahui.common.action.description.DocumentService;
import com.onlyxiahui.common.action.description.bean.MethodData;
import com.onlyxiahui.common.action.description.bean.ModuleData;
import com.onlyxiahui.common.action.description.handler.MethodHandler;
import com.onlyxiahui.common.action.description.handler.impl.method.ActionMappingMethodHandler;
import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import com.onlyxiahui.common.utils.base.security.Md5Util;
import com.onlyxiahui.aware.common.auth.annotation.PermissionMapping;
import com.onlyxiahui.aware.common.auth.type.PermissionType;

/**
 * Description <br>
 * Date 2021-01-12 17:09:31<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class ActionMappingHandler {

	@Autowired
	RegisterActionProperties config;

	public void laodActionData(ActionDataStream stream) {
		if (null != stream) {
			new Thread() {
				@Override
				public void run() {
					String[] actionPackages = config.getActionPackages();
					if (null != actionPackages && actionPackages.length > 0) {
						DocumentService documentService = new DocumentService();

						DocumentContext context = documentService.getDocumentContext();
						for (Iterator<MethodHandler> i = context.getMethodHandlers().iterator(); i.hasNext();) {
							Object o = i.next();
							if (ActionMappingMethodHandler.class == o.getClass()) {
								i.remove();
							}
						}
						context.getMethodHandlers().add(new ActionRegisterMappingMethodHandler());
						List<ModuleData> list = documentService.scanPackages(actionPackages);
						List<ActionData> actions = getActionDatas(list);
						stream.list(actions);
					}
				}
			}.start();
		}
	}

	public List<ActionData> getActionDatas(List<ModuleData> list) {
		Map<String, ActionData> map = new HashMap<>((null == list) ? 256 : list.size());
		List<ActionData> functions = new ArrayList<>();
		Map<String, String> tempMap = new HashMap<>(256);
		if (null == list) {
			return functions;
		}
		for (ModuleData n : list) {
			String key = n.getKey();
			String k = Md5Util.lower32(key);
			n.setKey(k);
			tempMap.put(key, k);
		}

		for (ModuleData n : list) {
			String superKey = n.getSuperKey();
			if (StringUtil.isNotBlank(superKey)) {
				String sk = tempMap.get(superKey);
				if (null != sk) {
					superKey = sk;
				} else {
					superKey = "";
				}
				n.setSuperKey(superKey);
			} else {
				n.setSuperKey("");
			}
		}

		for (ModuleData n : list) {

			String key = n.getKey();
			String superKey = n.getSuperKey();
			String title = n.getTitle();

			ActionData f = new ActionData();
			f.setKey(key);
			f.setSuperKey(superKey);
			f.setName(title);
			f.setPath("");
			f.setIsAction(0);

			ActionData tn = map.get(key);
			if (tn == null) {
				map.put(key, f);

				List<MethodData> methods = n.getMethods();
				if (null != methods && !methods.isEmpty()) {
					List<ActionData> fs = getActionDatas(map, key, methods);
					if (null != fs && !fs.isEmpty()) {
						functions.add(f);
						functions.addAll(fs);
					}
				}
			}
		}
		return functions;
	}

	public List<ActionData> getActionDatas(Map<String, ActionData> map, String superKey, List<MethodData> methods) {
		List<ActionData> functions = new ArrayList<>();
		for (MethodData md : methods) {
			String key = md.getKey();
			String title = md.getTitle();
			Set<String> actions = md.getActions();

			PermissionType type = PermissionType.auth;
			Map<String, Object> extend = md.getExtend();
			if (null != extend && extend.containsKey(PermissionMapping.class.getName())) {
				Object o = extend.get(PermissionMapping.class.getName());
				if (o instanceof PermissionMapping) {
					PermissionMapping pm = (PermissionMapping) o;
					type = pm.type();
				}
			}

			String permissionType = type.toString();

			if (null != actions && !actions.isEmpty()) {
				for (String path : actions) {
					path = prependLeadingSlash(path);
					key = (StringUtil.isNotBlank(path)) ? Md5Util.lower32(path) : Md5Util.lower32(key);
					ActionData f = new ActionData();
					f.setKey(key);
					f.setSuperKey(superKey);
					f.setName(title);
					f.setPath(path);
					f.setPermissionType(permissionType);
					f.setIsAction(1);

					ActionData tn = map.get(key);
					if (tn == null) {
						map.put(key, f);
						functions.add(f);
					}
				}
			} else {
				key = Md5Util.lower32(key);
				ActionData f = new ActionData();
				f.setKey(key);
				f.setSuperKey(superKey);
				f.setName(title);
				f.setPath("");
				f.setPermissionType(permissionType);
				f.setIsAction(1);

				ActionData tn = map.get(key);
				if (tn == null) {
					map.put(key, f);
					functions.add(f);
				}
			}
		}
		return functions;
	}

	private static String prependLeadingSlash(String pattern) {
		String pre = "/";
		if (StringUtil.isNotBlank(pattern) && !pattern.startsWith(pre)) {
			return pre + pattern;
		} else {
			return pattern;
		}
	}
}
