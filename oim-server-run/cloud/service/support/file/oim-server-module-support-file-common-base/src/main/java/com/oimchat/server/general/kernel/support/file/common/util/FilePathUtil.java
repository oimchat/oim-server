package com.oimchat.server.general.kernel.support.file.common.util;

import com.onlyxiahui.common.utils.base.lang.string.StringUtil;

import com.onlyxiahui.common.utils.base.util.time.DateUtil;

/**
 * @author XiaHui
 * @date 2017-11-24 22:52:39
 */
public class FilePathUtil {

	/**
	 * 获取根目录
	 * 
	 * @param rootPath
	 * @return
	 */
	public static StringBuilder getRootPath(String rootPath) {
		StringBuilder root = new StringBuilder();
		return root.append((StringUtil.isNotBlank(rootPath)) ? rootPath : "");
	}

	public static String getNodePath() {
		return getNodePath("");
	}

	public static String getNodePath(String basePath) {
		String separator = "/";
		basePath = (null == basePath) ? "" : basePath;
		boolean hasSeparator = basePath.endsWith(separator);
		StringBuilder nodePath = new StringBuilder();
		nodePath.append(basePath);
		nodePath.append(hasSeparator ? "" : separator);
		nodePath.append(DateUtil.getCurrentYear());
		nodePath.append(separator);
		nodePath.append(DateUtil.getCurrentMonth());
		nodePath.append(separator);
		nodePath.append(DateUtil.getCurrentDay());
		nodePath.append(separator);
		return nodePath.toString();
	}

	public static String getFullPath(String rootPath, String nodePath) {

		String separator = "/";
		rootPath = (null == rootPath) ? "" : rootPath;
		boolean hasSeparator = rootPath.endsWith(separator);

		// 全路径和真实保存文件名
		StringBuilder sb = new StringBuilder();
		sb.append(rootPath);
		sb.append(hasSeparator ? "" : separator);
		sb.append(nodePath);
		return sb.toString();
	}

	public static String getFullPathName(String fullPath, String saveFullName) {
		String separator = "/";
		fullPath = (null == fullPath) ? "" : fullPath;
		boolean hasSeparator = fullPath.endsWith(separator);

		// 全路径和真实保存文件名
		StringBuilder sb = new StringBuilder();
		sb.append(fullPath);
		sb.append(hasSeparator ? "" : separator);
		sb.append(saveFullName);
		return sb.toString();
	}

	public static String mergeUrlPath(String... paths) {
		StringBuilder sb = new StringBuilder();
		if (null != paths) {
			int length = paths.length;
			// int last = length - 1;
			for (int i = 0; i < length; i++) {
				String name = paths[i];
				if (null != name && !name.isEmpty()) {
					if (i > 0 && i < length) {
						boolean hasSeparator = sb.toString().endsWith("/") || name.startsWith("/");
						// boolean hasSeparator = name.endsWith("/");
						if (!hasSeparator) {
							sb.append("/");
						}
					}
					sb.append(name);
				}
			}
		}
		return sb.toString();
	}
}
