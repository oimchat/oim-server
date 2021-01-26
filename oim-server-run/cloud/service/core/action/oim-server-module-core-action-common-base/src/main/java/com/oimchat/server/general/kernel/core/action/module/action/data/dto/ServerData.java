package com.oimchat.server.general.kernel.core.action.module.action.data.dto;

import org.hibernate.validator.constraints.Length;

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
	@Length(min = 0, max = 256, message = "服务技术名(serviceName)长度不能超过{max}")
	private String serviceName;

	/**
	 * 服务显示名
	 */
	@DocTitle("服务显示名")
	@Length(min = 0, max = 256, message = "服务显示名(serviceTitle)长度不能超过{max}")
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
