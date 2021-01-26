package com.oimchat.server.general.kernel.support.file.module.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.onlyxiahui.common.utils.base.net.AddressUtil;

/**
 * Description <br>
 * Date 2019-07-06 14:17:21<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class FileServerConfig {

	@Value("${server.port}")
	private String serverPort;

	@Value("${oim.server.config.file.upload-path}")
	private String path = "upload";

	@Value("${oim.server.config.file.request-prefix}")
	private String prefix = "";

	private String downloadPath = "download";

	private String url;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUrl() {
		return url;
	}

	public String getDownloadPath() {
		return downloadPath;
	}

	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	String defaultAddress = "default_address";

	@Value("${oim.server.config.file.request-address}")
	public void setUrl(String url) {
		if (null == url || url.isEmpty() || defaultAddress.equals(url)) {
			String address = AddressUtil.getLocalIpV4();
			String fileHttp = ("443".equals(serverPort)) ? "https://" : "http://";
			String filePort = ("80".equals(serverPort) || "443".equals(serverPort)) ? "" : (":" + serverPort);
			this.url = (fileHttp + address + filePort);
		} else {
			this.url = url;
		}
	}
}
