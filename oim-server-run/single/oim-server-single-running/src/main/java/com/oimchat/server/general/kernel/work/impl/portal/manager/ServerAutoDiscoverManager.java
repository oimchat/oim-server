
package com.oimchat.server.general.kernel.work.impl.portal.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.oimchat.server.general.kernel.work.common.config.constant.ServerConstant;
import com.oimchat.server.general.kernel.work.module.base.portal.data.ServerAddressData;
import com.oimchat.server.general.kernel.work.module.base.portal.data.ServerData;
import com.oimchat.server.run.g.ServerDataProperties;
import com.onlyxiahui.aware.basic.work.type.net.AddressType;
import com.onlyxiahui.aware.basic.work.type.net.Protocol;
import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import com.onlyxiahui.common.utils.base.net.AddressUtil;
import com.onlyxiahui.wofa.server.socket.netty.config.NetServerProperties;
import com.onlyxiahui.wofa.server.socket.netty.config.SslData;
import com.onlyxiahui.wofa.server.socket.netty.config.TcpServerData;
import com.onlyxiahui.wofa.server.socket.netty.config.WebSocketServerData;

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
	private NetServerProperties netServerProperties;
	@Autowired
	private Environment environment;
	@Autowired
	private ServerDataProperties serverDataProperties;

	public List<ServerData> getServerDataList() {
		return discoverServerInfos();
	}

	public List<ServerData> discoverServerInfos() {
		List<ServerData> list = new ArrayList<>();

		if (!serverDataProperties.isAutoDiscover()) {
			return list;
		}
		String main = (ServerConstant.ServerType.main.value());
		String file = (ServerConstant.ServerType.file.value());

		List<ServerAddressData> mainAddresses = new ArrayList<>();
		ServerData mainServerData = new ServerData();
		String address = AddressUtil.getLocalIpV4();

		List<TcpServerData> tcpServers = netServerProperties.getTcpServers();
		List<WebSocketServerData> webSocketServers = netServerProperties.getWebSocketServers();
		if (null != tcpServers) {
			for (TcpServerData tcp : tcpServers) {
				boolean isSsl = isSsl(tcp.getSsl());
				ServerAddressData mainTcp = new ServerAddressData();
				mainTcp.setAddress(address);
				mainTcp.setPort(tcp.getPort());
				mainTcp.setProtocol(Protocol.TCP.value());
				mainTcp.setAddressType(AddressType.IPv4.value());
				mainTcp.setEnabled(true);
				mainTcp.setFeature(isSsl ? "ssl" : "");
				mainAddresses.add(mainTcp);
			}
		}

		if (null != webSocketServers) {
			for (WebSocketServerData websocket : webSocketServers) {

				boolean isSsl = isSsl(websocket.getSsl());
				ServerAddressData mainWebSocket = new ServerAddressData();
				String websocketPath = isSsl ? "wss://" : "ws://" + address + ":" + websocket.getPort() + websocket.getPath();
				// #聊天服务的webSocket路径
				// im.server.websocket.path=ws://192.168.200.1:12020/oim/websocket
				// websocket地址
				mainWebSocket.setAddress(websocketPath);
				mainWebSocket.setPort(websocket.getPort());
				mainWebSocket.setProtocol(isSsl ? Protocol.WSS.value() : Protocol.WS.value());
				mainWebSocket.setAddressType(AddressType.URL.value());
				mainWebSocket.setEnabled(true);
				mainWebSocket.setFeature(isSsl ? "ssl" : "");
				mainAddresses.add(mainWebSocket);
			}
		}
		String serverPort = environment.getProperty("server.port");
		String serverAddress = environment.getProperty("oim.server.address");
		serverPort = (null == serverPort || serverPort.isEmpty()) ? "8080" : serverPort;
		address = (null == serverAddress || serverAddress.isEmpty()) ? address : serverAddress;

		String http = ("443".equals(serverPort)) ? "https://" : "http://";
		String port = ("80".equals(serverPort) || "443".equals(serverPort)) ? "" : (":" + serverPort);
		String url = (http + address + port);

		ServerAddressData mainHttp = new ServerAddressData();
		// #聊天服务的http地址
		mainHttp.setAddress(url);
		mainHttp.setPort(0);
		mainHttp.setProtocol(Protocol.HTTP.value());
		mainHttp.setAddressType(AddressType.URL.value());
		mainHttp.setEnabled(true);

		mainAddresses.add(mainHttp);

		mainServerData.setAddresses(mainAddresses);
		mainServerData.setCode(main);

		list.add(mainServerData);

		/**
		 * 文件服务地址
		 */
		ServerAddressData fileHttp = new ServerAddressData();
		fileHttp.setAddress(url);
		fileHttp.setPort(0);
		fileHttp.setProtocol(Protocol.HTTP.value());
		fileHttp.setAddressType(AddressType.URL.value());
		fileHttp.setEnabled(true);

		ServerData fileServerData = new ServerData();
		fileServerData.setCode(file);
		fileServerData.setEnabled(true);
		fileServerData.addAddress(fileHttp);

		list.add(fileServerData);
		return list;
	}

	private boolean isSsl(SslData ssl) {
		boolean isSsl = (null != ssl && StringUtil.isNotBlank(ssl.getCertificatePath()));
		return isSsl;
	}
}
