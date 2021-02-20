package com.oimchat.server.run.initialize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oimchat.doc.config.OnlyDocumentConfigurerImpl;
import com.oimchat.server.general.kernel.support.file.module.common.config.FileServerConfig;
import com.oimchat.server.general.kernel.work.module.manage.system.entity.Function;
import com.oimchat.server.general.kernel.work.module.manage.system.service.FunctionService;
import com.oimchat.server.run.auth.PermissionPathBox;
import com.oimchat.server.run.auth.SkipPathBox;
import com.onlyxiahui.aware.common.auth.annotation.PermissionMapping;
import com.onlyxiahui.aware.common.auth.type.PermissionType;
import com.onlyxiahui.common.action.description.DocumentService;
import com.onlyxiahui.common.action.description.bean.MethodData;
import com.onlyxiahui.common.action.description.bean.ModuleData;
import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import com.onlyxiahui.common.utils.base.security.Md5Util;
import com.onlyxiahui.general.doc.spring.boot.bean.TreeNode;

/**
 * Description <br>
 * Date 2020-05-29 17:33:43<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Service
public class InitializerFunction {
	protected final Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	FunctionService functionService;

	@Autowired
	SkipPathBox skipPathBox;
	@Autowired
	PermissionPathBox permissionPathBox;

	@Autowired
	FileServerConfig fileServerConfig;

	FunctionConverter functionConverter = new FunctionConverter();

	@PostConstruct
	public void initDoc() {
		skipPathBox.add("/doc/*");
		skipPathBox.add("/doc/**");
		skipPathBox.add("/actuator/*");
		skipPathBox.add("/actuator/**");
		skipPathBox.add("/download/*");
		skipPathBox.add("/download/**");

		String download = fileServerConfig.getDownloadPath();
		skipPathBox.add("/" + download + "/*");
		skipPathBox.add("/" + download + "/**");
	}

	public void laodAuthFunction() {
		new Thread() {
			@Override
			public void run() {
				DocumentService documentService = new DocumentService();
				OnlyDocumentConfigurerImpl c = new OnlyDocumentConfigurerImpl();
				c.config(documentService.getDocumentContext());
				List<ModuleData> list = documentService.scanPackages("com.oimchat.server");
				setPermissionModules(list);
			}
		}.start();
	}

	/*******************************/

	/**
	 * 
	 * Description 设置需要拦截或者不拦截的功能<br>
	 * Date 2020-11-22 13:00:50<br>
	 * 
	 * @param list
	 * @since 1.0.0
	 */
	public void setPermissionModules(List<ModuleData> list) {
		if (null != list) {
			for (ModuleData m : list) {
				List<MethodData> methods = m.getMethods();
				setPermissionMethods(methods);
			}
		}
	}

	public void setPermissionMethods(List<MethodData> methods) {
		if (null != methods) {
			for (MethodData methodData : methods) {

				PermissionType type = PermissionType.auth;
				Map<String, Object> extend = methodData.getExtend();
				if (null != extend && extend.containsKey(PermissionMapping.class.getName())) {
					Object o = extend.get(PermissionMapping.class.getName());
					if (o instanceof PermissionMapping) {
						PermissionMapping pm = (PermissionMapping) o;
						type = pm.type();
					}
				}

				Set<String> set = methodData.getActions();

				if (PermissionType.skip == type) {
					for (String path : set) {
						path = prependLeadingSlash(path);
						skipPathBox.add(path);
					}
				}
				if (PermissionType.grant == type) {
					for (String path : set) {
						path = prependLeadingSlash(path);
						permissionPathBox.add(path);
					}
				}
			}
		}
	}

	/*******************************/

	public void initializeModule(List<ModuleData> list) {
		List<Function> functions = functionConverter.getFunctions(list);
		functionService.saveOrUpdate("", functions);
	}

	public void initialize(List<TreeNode> allList) {
		Map<String, TreeNode> allMap = new HashMap<>(256);
		if (null != allList) {
			for (TreeNode n : allList) {
				allMap.put(n.getKey(), n);
			}

			for (TreeNode n : allList) {
				String key = n.getKey();
				String path = n.getPath();
				path = prependLeadingSlash(path);
				key = (StringUtils.isNotBlank(path)) ? Md5Util.lower32(path) : Md5Util.lower32(key);
				n.setKey(key);
			}

			for (TreeNode n : allList) {
				String superKey = n.getSuperKey();

				if (StringUtils.isNotBlank(superKey)) {
					TreeNode sn = allMap.get(superKey);
					if (null != sn) {
						superKey = sn.getKey();
					} else {
						superKey = Md5Util.lower32(superKey);
					}
					n.setSuperKey(superKey);
				}
			}

			Map<String, TreeNode> map = new HashMap<>(256);
			List<Function> functions = new ArrayList<>();
			for (TreeNode n : allList) {

				String key = n.getKey();
				String superKey = n.getSuperKey();
				String title = n.getTitle();
//				boolean action = n.isAction();

				String path = n.getPath();
				path = prependLeadingSlash(path);
				Function f = new Function();
				f.setId(key);
				f.setSuperId(superKey);
				f.setName(title);
				f.setPath(path);

				TreeNode tn = map.get(key);
				if (tn != null) {

					String s = "n:" + n.getKey() + "/" + n.getPath();
					String t = "t:" + tn.getKey() + "/" + tn.getPath();
					logger.debug(s + "\n" + t);
				} else {
					map.put(key, n);
					functions.add(f);
				}
			}

			functionService.saveOrUpdate("", functions);
		}
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
