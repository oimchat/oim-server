package com.oimchat.server.general.kernel.net.module.work.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.oimchat.server.general.kernel.net.module.work.data.ServerAddressData;
import com.oimchat.server.general.kernel.net.module.work.data.ServerConfigData;
import com.onlyxiahui.aware.basic.work.type.net.AddressType;
import com.onlyxiahui.aware.basic.work.type.net.Protocol;
import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import com.onlyxiahui.common.utils.base.net.AddressUtil;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.wofa.server.socket.netty.config.NetServerProperties;
import com.onlyxiahui.wofa.server.socket.netty.config.SslData;
import com.onlyxiahui.wofa.server.socket.netty.config.TcpServerData;
import com.onlyxiahui.wofa.server.socket.netty.config.WebSocketServerData;

/**
 * 
 * Description <br>
 * Date 2020-05-15 10:45:33<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@RestController
@ActionMapping
public class ServerConfigController {

	@Autowired
	private NetServerProperties netServerProperties;

	List<ServerAddressData> list = new ArrayList<>();
	ServerConfigData data = new ServerConfigData();

	@ActionMapping(value = "/v1/config/server.config/get.data")
	public ServerConfigData get() {
		return data;
	}

	@PostConstruct
	public void initServerAddress() {
		list.clear();
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
				list.add(mainTcp);
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
				list.add(mainWebSocket);
			}
		}
		data.setAddresses(list);
		data.setHost(address);
//
//		TcpServerData tcp = netServerProperties.getTcp();
//		WebSocketServerData websocket = netServerProperties.getWebsocket();
//
//		String address = AddressUtil.getLocalIpV4();
//
//		ServerAddressData mainTcp = new ServerAddressData();
//		ServerAddressData mainWebSocket = new ServerAddressData();
//
//		mainTcp.setAddress(address);
//		mainTcp.setPort(tcp.getPort());
//		mainTcp.setProtocol(Protocol.TCP.value());
//		mainTcp.setAddressType(AddressType.IPv4.value());
//		mainTcp.setEnabled(true);
//
//		String websocketPath = "ws://" + address + ":" + websocket.getPort() + websocket.getPath();
//		// #聊天服务的webSocket路径
//		// im.server.websocket.path=ws://192.168.200.1:12020/oim/websocket
//		// websocket地址
//		mainWebSocket.setAddress(websocketPath);
//		mainWebSocket.setPort(websocket.getPort());
//		mainWebSocket.setProtocol(Protocol.WebSocket.value());
//		mainWebSocket.setAddressType(AddressType.URL.value());
//		mainWebSocket.setEnabled(true);
//
//		list.add(mainTcp);
//		list.add(mainWebSocket);
	}

	private boolean isSsl(SslData ssl) {
		boolean isSsl = (null != ssl && StringUtil.isNotBlank(ssl.getCertificatePath()));
		return isSsl;
	}
}
