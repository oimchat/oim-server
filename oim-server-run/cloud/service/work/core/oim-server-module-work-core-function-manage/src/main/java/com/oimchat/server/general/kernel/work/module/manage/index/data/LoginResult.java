package com.oimchat.server.general.kernel.work.module.manage.index.data;

import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;

/**
 * Description <br>
 * Date 2020-05-28 15:54:42<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class LoginResult {

	private String token;
	private UserData user;

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
