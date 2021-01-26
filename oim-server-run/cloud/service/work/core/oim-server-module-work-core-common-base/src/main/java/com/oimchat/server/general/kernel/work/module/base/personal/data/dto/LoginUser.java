
package com.oimchat.server.general.kernel.work.module.base.personal.data.dto;

/**
 * 用户登录信息<br>
 * Date 2020-04-09 21:03:15<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class LoginUser {

	/**
	 * 帐号
	 */
	private String account;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 验证码
	 */
	private String verifyCode;
	/**
	 * 在线状态
	 */
	private String status;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
