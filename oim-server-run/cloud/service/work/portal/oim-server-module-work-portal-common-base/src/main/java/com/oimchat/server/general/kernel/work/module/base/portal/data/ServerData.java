package com.oimchat.server.general.kernel.work.module.base.portal.data;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务信息<br>
 * Date 2019-01-15 22:07:50<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */

public class ServerData {

	/**
	 * 服务名
	 */
	private String name;

	/**
	 * 服务编码
	 */
	private String code;

	/**
	 * 服务描述
	 */
	private String description;

	/**
	 * 是否启用
	 */
	private boolean enabled;

	/**
	 * 地址列表
	 */
	List<ServerAddressData> addresses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<ServerAddressData> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<ServerAddressData> addresses) {
		this.addresses = addresses;
	}

	public void addAddress(ServerAddressData data) {
		if (null == addresses) {
			addresses = new ArrayList<>();
		}
		addresses.add(data);
	}
}
