package com.oimchat.server.cloud.action.register.data;

import com.onlyxiahui.common.action.description.annotation.DocTitle;

/**
 * Description <br>
 * Date 2021-01-12 14:50:55<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class ServerData {

	/**
	 * 服务技术名
	 */
	@DocTitle("服务技术名")
	private String serviceName;

	/**
	 * 服务显示名
	 */
	@DocTitle("服务显示名")
	private String serviceTitle;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceTitle() {
		return serviceTitle;
	}

	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
}
