package com.oimchat.server.general.kernel.support.file.module.common.manager;

import javax.annotation.Resource;

import com.oimchat.server.general.kernel.support.file.common.util.FilePathUtil;
import com.oimchat.server.general.kernel.support.file.module.common.config.FileServerConfig;
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
public class FileServerConfigManager {

	@Resource
	private FileServerConfig fileServerConfig;

	public String getSavePath() {
		return fileServerConfig.getPath();
	}

	public String getServerUrl() {
		return fileServerConfig.getUrl();
	}

	public String getDownloadPath() {
		return fileServerConfig.getDownloadPath();
	}

	public String getRootPath() {
		String path = getSavePath();
		StringBuilder rootPath = FilePathUtil.getRootPath(path);// 拼接文件上传目录
		return rootPath.toString();
	}

	public String getNodePath(String node) {
		String nodePath = FilePathUtil.getNodePath(node);
		return nodePath;
	}

	public String getFileUrlPath(String nodePath) {
		String d = getDownloadPath();
		String url = "";
		String path = getServerUrl();
		if (StringUtil.isNotBlank(path)) {
			url = FilePathUtil.mergeUrlPath(path, d, nodePath);
		}
		return url;
	}

	public String getFileUrlByApi(String api) {
		String url = "";
		String path = getServerUrl();
		if (StringUtil.isNotBlank(path)) {
			url = FilePathUtil.mergeUrlPath(path, api);
		}
		return url;
	}
}
