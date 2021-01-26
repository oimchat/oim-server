package com.oimchat.server.general.kernel.support.file.module.common.service;

import javax.annotation.Resource;

import com.oimchat.server.general.kernel.support.file.common.util.FilePathUtil;
import com.oimchat.server.general.kernel.support.file.module.common.manager.FileServerConfigManager;
import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import org.springframework.stereotype.Service;

/**
 * Description <br>
 * Date 2019-07-06 14:18:07<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Service
public class FileServerConfigService {

	@Resource
	private FileServerConfigManager fileServerConfigManager;

	public String getServerUrl() {
		return fileServerConfigManager.getServerUrl();
	}

	public String getNodePath(String node) {
		return fileServerConfigManager.getNodePath(node);
	}

	public String getRootPath() {
		return fileServerConfigManager.getRootPath();
	}

	public String getFileUrl(String nodePath) {
		String d = fileServerConfigManager.getDownloadPath();
		String url = "";
		String path = getServerUrl();
		if (StringUtil.isNotBlank(path)) {
			url = FilePathUtil.mergeUrlPath(path, d, nodePath);
		}
		return url;
	}

	public String getFileUrlById(String api) {
		String url = "";
		String path = getServerUrl();
		if (StringUtil.isNotBlank(path)) {
			url = FilePathUtil.mergeUrlPath(path, api);
		}
		return url;
	}
}
