
package com.oimchat.server.run.portal;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.oimchat.server.general.kernel.work.module.base.portal.data.ServerData;

/**
 * Description <br>
 * Date 2020-04-13 11:11:50<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@ConfigurationProperties("oim.server.config.portal.address")
public class ServerDataProperties {

	private List<ServerData> serverInfos;
	private boolean autoDiscover = true;

	public List<ServerData> getServerInfos() {
		return serverInfos;
	}

	public void setServerInfos(List<ServerData> serverInfos) {
		this.serverInfos = serverInfos;
	}

	public boolean isAutoDiscover() {
		return autoDiscover;
	}

	public void setAutoDiscover(boolean autoDiscover) {
		this.autoDiscover = autoDiscover;
	}

}
