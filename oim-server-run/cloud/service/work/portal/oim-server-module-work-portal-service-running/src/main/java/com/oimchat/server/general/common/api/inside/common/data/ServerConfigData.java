package com.oimchat.server.general.common.api.inside.common.data;

import com.oimchat.server.general.kernel.work.module.base.portal.data.ServerData;

/**
 * Description <br>
 * Date 2021-01-19 09:04:54<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class ServerConfigData extends ServerData {

	private String host;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
}
