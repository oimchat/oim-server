
package com.oimchat.server.general.kernel.work.module.base.portal.data;

/**
 * 服务器地址信息<br>
 * Date 2020-04-14 14:55:16<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class ServerAddressData {

	/**
	 * 服务类型id
	 */
	private String serverTypeCode;

	/**
	 * 
	 */
	private int version;
	/**
	 * 
	 * IPv4<br>
	 * IPv6 <br>
	 * Domain<br>
	 * 
	 */
	private String addressType;

	/**
	 * TCP<br>
	 * UDP<br>
	 * FTP<br>
	 * HTTP
	 */
	private String protocol;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 端口
	 */
	private Integer port;

	/**
	 * 是否启用
	 */
	private boolean enabled;

	/**
	 * 
	 */
	private String feature;

	public String getServerTypeCode() {
		return serverTypeCode;
	}

	public void setServerTypeCode(String serverTypeCode) {
		this.serverTypeCode = serverTypeCode;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}
}
