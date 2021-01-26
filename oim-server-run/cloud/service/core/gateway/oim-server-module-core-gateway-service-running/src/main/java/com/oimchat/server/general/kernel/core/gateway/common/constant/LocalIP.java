package com.oimchat.server.general.kernel.core.gateway.common.constant;

/**
 * 
 * <br>
 * Date 2019-07-24 16:22:40<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public enum LocalIP {
	/**
	 * 本地地址1 IPv6
	 */
	IP1("0:0:0:0:0:0:0:1"),
	/**
	 * 本地地址2 IPv4
	 */
	IP2("127.0.0.1");
	private String ip;

	LocalIP(String ip) {
		this.ip = ip;
	}

	public String get() {
		return ip;
	}
}
