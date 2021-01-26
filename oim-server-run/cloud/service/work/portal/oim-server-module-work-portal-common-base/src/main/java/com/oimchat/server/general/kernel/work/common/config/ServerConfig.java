package com.oimchat.server.general.kernel.work.common.config;

import java.util.ArrayList;
import java.util.List;

import com.oimchat.server.general.kernel.work.common.config.constant.ServerConstant;
import com.onlyxiahui.aware.basic.work.type.net.AddressType;
import com.onlyxiahui.aware.basic.work.type.net.Protocol;

/**
 * Date 2019-01-15 16:34:38<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */

public class ServerConfig {

	/**
	 * 网络协议类型列表
	 */
	List<String> protocolList = new ArrayList<>();
	/**
	 * 地址类型列表
	 */
	List<String> addressTypeList = new ArrayList<>();
	/**
	 * 服务类型列表
	 */
	List<String> serverTypeList = new ArrayList<>();

	public ServerConfig() {

		protocolList.add(Protocol.TCP.value());
		protocolList.add(Protocol.UDP.value());
		protocolList.add(Protocol.HTTP.value());
		protocolList.add(Protocol.WS.value());
		protocolList.add(Protocol.WSS.value());
		protocolList.add(Protocol.FTP.value());

		addressTypeList.add(AddressType.IPv4.value());
		addressTypeList.add(AddressType.IPv6.value());
		addressTypeList.add(AddressType.URL.value());

		serverTypeList.add(ServerConstant.ServerType.main.value());
		serverTypeList.add(ServerConstant.ServerType.file.value());
		serverTypeList.add(ServerConstant.ServerType.video.value());
		serverTypeList.add(ServerConstant.ServerType.voice.value());
	}

	public List<String> getProtocolList() {
		return protocolList;
	}

	public List<String> getAddressTypeList() {
		return protocolList;
	}

	public List<String> getServerTypeList() {
		return serverTypeList;
	}
}
