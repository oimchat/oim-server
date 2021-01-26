package com.oimchat.server.general.kernel.work.module.base.personal.data.dto;

/**
 * 认证信息<br>
 * Date 2019-01-06 12:08:00<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class Auth {

	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 令牌
	 */
	private String token;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
