package com.oimchat.server.general.kernel.net.module.work.data;

import java.util.List;

/**
 * Description <br>
 * Date 2021-01-19 09:04:54<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class ServerConfigData {

	private String host;

	/**
	 * 地址列表
	 */
	private List<ServerAddressData> addresses;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public List<ServerAddressData> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<ServerAddressData> addresses) {
		this.addresses = addresses;
	}
}
