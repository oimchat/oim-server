package com.oimchat.server.run.initialize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.oimchat.server.general.kernel.work.module.manage.system.entity.Function;
import com.onlyxiahui.aware.common.auth.annotation.PermissionMapping;
import com.onlyxiahui.aware.common.auth.type.PermissionType;
import com.onlyxiahui.common.action.description.bean.MethodData;
import com.onlyxiahui.common.action.description.bean.ModuleData;
import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import com.onlyxiahui.common.utils.base.security.Md5Util;

/**
 * <br>
 * Date 2021-02-03 15:36:38<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class FunctionConverter {

	public List<Function> getFunctions(List<ModuleData> list) {
		Map<String, Function> map = new HashMap<>((null == list) ? 256 : list.size());
		List<Function> functions = new ArrayList<>();
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

			Function f = new Function();
			f.setId(key);
			f.setSuperId(superKey);
			f.setName(title);
			f.setPath("");

			Function tn = map.get(key);
			if (tn == null) {
				map.put(key, f);

				List<MethodData> methods = n.getMethods();
				if (null != methods && !methods.isEmpty()) {
					List<Function> fs = getFunctions(map, key, methods);
					if (null != fs && !fs.isEmpty()) {
						functions.add(f);
						functions.addAll(fs);
					}
				}
			}
		}
		return functions;
	}

	public List<Function> getFunctions(Map<String, Function> map, String superKey, List<MethodData> methods) {
		List<Function> functions = new ArrayList<>();
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

			if (PermissionType.grant == type) {
				if (null != actions && !actions.isEmpty()) {
					for (String path : actions) {
						path = prependLeadingSlash(path);
						key = (StringUtil.isNotBlank(path)) ? Md5Util.lower32(path) : Md5Util.lower32(key);
						Function f = new Function();
						f.setId(key);
						f.setSuperId(superKey);
						f.setName(title);
						f.setPath(path);

						Function tn = map.get(key);
						if (tn == null) {
							map.put(key, f);
							functions.add(f);
						}
					}
				} else {
					key = Md5Util.lower32(key);
					Function f = new Function();
					f.setId(key);
					f.setSuperId(superKey);
					f.setName(title);
					f.setPath("");

					Function tn = map.get(key);
					if (tn == null) {
						map.put(key, f);
						functions.add(f);
					}
				}
			}
		}
		return functions;
	}

	public static String prependLeadingSlash(String pattern) {
		String pre = "/";
		if (StringUtil.isNotBlank(pattern) && !pattern.startsWith(pre)) {
			return pre + pattern;
		} else {
			return pattern;
		}
	}
}
