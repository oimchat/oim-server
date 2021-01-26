package com.oimchat.server.general.kernel.work.module.base.personal.data.dto;

import com.oimchat.server.basic.common.data.client.Client;

/**
 * 登录信息<br>
 * Date 2019-01-06 12:08:30<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class LoginData {

	/**
	 * 客户端信息
	 */
	private Client client;

	/**
	 * 登录用户
	 */
	private LoginUser user;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LoginUser getUser() {
		return user;
	}

	public void setUser(LoginUser user) {
		this.user = user;
	}

}
