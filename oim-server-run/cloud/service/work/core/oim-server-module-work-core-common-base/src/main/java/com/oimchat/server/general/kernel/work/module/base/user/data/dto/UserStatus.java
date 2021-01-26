
package com.oimchat.server.general.kernel.work.module.base.user.data.dto;

/**
 * 用户状态信息 <br>
 * Date 2020-04-10 19:28:57<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class UserStatus {

	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 状态
	 */
	private String status;

	public UserStatus() {
		super();
	}

	public UserStatus(String userId, String status) {
		super();
		this.userId = userId;
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
