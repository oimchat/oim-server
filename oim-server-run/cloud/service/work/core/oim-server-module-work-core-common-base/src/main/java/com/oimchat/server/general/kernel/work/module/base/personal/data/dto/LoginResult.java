package com.oimchat.server.general.kernel.work.module.base.personal.data.dto;

import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;

/**
 * 登录结果<br>
 * Date 2019-01-06 12:08:30<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class LoginResult {

	/**
	 * 授权令牌
	 */
	private String token;

	/**
	 * 用户
	 */
	private UserData user;

	public LoginResult() {
		super();
	}

	public LoginResult(String token, UserData user) {
		super();
		this.token = token;
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserData getUser() {
		return user;
	}

	public void setUser(UserData user) {
		this.user = user;
	}

}
