
package com.oimchat.server.general.kernel.work.impl.portal.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.general.common.api.inside.common.data.ServerConfigData;
import com.oimchat.server.general.common.api.inside.core.gateway.GatewayDiscoverInterface;
import com.oimchat.server.general.common.api.inside.net.work.ServerConfigInterface;
import com.oimchat.server.run.gateway.ServerDataProperties;

/**
 * Description <br>
 * Date 2020-05-15 17:46:44<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class ServerAutoDiscoverManager {

	@Autowired
	ServerConfigInterface serverConfigInterface;
	@Autowired
	GatewayDiscoverInterface gatewayDiscoverInterface;
	@Autowired
	ServerDataProperties serverDataProperties;

	public List<ServerConfigData> getServerDataList() {
		return discoverMainServerInfos();
	}

	public List<ServerConfigData> discoverMainServerInfos() {
		List<ServerConfigData> list = new ArrayList<>();
		if (serverDataProperties.isAutoDiscoverNet()) {
			ServerConfigData data = serverConfigInterface.getServerConfigData();
			if (null != data) {
				list.add(data);
			}
		}
		if (serverDataProperties.isAutoDiscoverGateway()) {
			ServerConfigData data = gatewayDiscoverInterface.getServerConfigData();
			if (null != data) {
				list.add(data);
			}
		}
		return list;
	}

	public ServerConfigData choiceCombine(ServerConfigData source, ServerConfigData target) {
		ServerConfigData data = null;
		if (null != source && null != target) {
			if (null != target.getAddresses() && !target.getAddresses().isEmpty()) {
				data = target;
			} else {
				data = source;
//				if (null != source.getAddresses() && !source.getAddresses().isEmpty()) {
//					String sourceHost = source.getHost();
//					String targetHost = target.getHost();
//					if (StringUtil.isNotBlank(targetHost)) {
//						for (ServerAddressData sad : source.getAddresses()) {
//							if (null != sad && null != sad.getAddress()) {
//								String address = sad.getAddress();
//								sad.setAddress(address.replace(sourceHost, targetHost));
//							}
//						}
//					}
//				}
			}
		}
		return data;
	}

}
