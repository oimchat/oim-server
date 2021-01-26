
package com.oimchat.server.general.kernel.net.module.portal.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlyxiahui.common.utils.base.net.AddressUtil;
import com.onlyxiahui.wofa.server.socket.netty.config.NetServerProperties;
import com.onlyxiahui.wofa.server.socket.netty.config.TcpServerData;

/**
 * Description <br>
 * Date 2020-05-14 21:49:43<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class ServerConfig {

	private int port = 12002;
	private String host = AddressUtil.getLocalIpV4();

	@Autowired
	private NetServerProperties netServerProperties;

	public int getPort() {
		List<TcpServerData> l = netServerProperties.getTcpServers();
		if (null != l && !l.isEmpty()) {
			port = l.get(0).getPort();
		}
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
}
