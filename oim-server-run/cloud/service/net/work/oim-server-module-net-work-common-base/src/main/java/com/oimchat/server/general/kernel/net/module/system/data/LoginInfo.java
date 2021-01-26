
package com.oimchat.server.general.kernel.net.module.system.data;

/**
 * Description <br>
 * Date 2020-04-13 21:48:57<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class LoginInfo {

	private String location;
	private String netAddress;
	private Long onlineTimestamp;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNetAddress() {
		return netAddress;
	}

	public void setNetAddress(String netAddress) {
		this.netAddress = netAddress;
	}

	public Long getOnlineTimestamp() {
		return onlineTimestamp;
	}

	public void setOnlineTimestamp(Long onlineTimestamp) {
		this.onlineTimestamp = onlineTimestamp;
	}
}
