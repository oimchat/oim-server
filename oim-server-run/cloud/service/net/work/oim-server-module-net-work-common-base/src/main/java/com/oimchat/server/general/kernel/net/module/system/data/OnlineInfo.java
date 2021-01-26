
package com.oimchat.server.general.kernel.net.module.system.data;

import com.oimchat.server.basic.common.data.client.Client;

/**
 * Description <br>
 * Date 2020-04-13 21:43:11<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class OnlineInfo {

	private Client client;
	private String location;
	private String netAddress;
	private Long onlineTimestamp;
	private boolean currentOffline;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

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

	public boolean isCurrentOffline() {
		return currentOffline;
	}

	public void setCurrentOffline(boolean currentOffline) {
		this.currentOffline = currentOffline;
	}
}
