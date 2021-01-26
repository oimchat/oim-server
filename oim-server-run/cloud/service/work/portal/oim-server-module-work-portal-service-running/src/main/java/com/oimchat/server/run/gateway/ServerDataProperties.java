
package com.oimchat.server.run.gateway;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.oimchat.server.general.common.api.inside.common.data.ServerConfigData;

/**
 * Description <br>
 * Date 2020-04-13 11:11:50<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@ConfigurationProperties("oim.server.config.portal.address")
public class ServerDataProperties {

	private List<ServerConfigData> serverInfos;
	private boolean autoDiscoverGateway = true;
	private boolean autoDiscoverNet = true;

	public List<ServerConfigData> getServerInfos() {
		return serverInfos;
	}

	public void setServerInfos(List<ServerConfigData> serverInfos) {
		this.serverInfos = serverInfos;
	}

	public boolean isAutoDiscoverGateway() {
		return autoDiscoverGateway;
	}

	public void setAutoDiscoverGateway(boolean autoDiscoverGateway) {
		this.autoDiscoverGateway = autoDiscoverGateway;
	}

	public boolean isAutoDiscoverNet() {
		return autoDiscoverNet;
	}

	public void setAutoDiscoverNet(boolean autoDiscoverNet) {
		this.autoDiscoverNet = autoDiscoverNet;
	}
}
