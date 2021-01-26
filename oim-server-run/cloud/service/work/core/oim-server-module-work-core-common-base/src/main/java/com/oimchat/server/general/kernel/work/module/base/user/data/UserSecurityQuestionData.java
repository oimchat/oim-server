package com.oimchat.server.general.kernel.work.module.base.user.data;

/**
 * 用户密保问题信息<br>
 * Date 2019-01-20 09:48:28<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */

public class UserSecurityQuestionData {

	/**
	 * id
	 */
	private String id;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 问题
	 */
	private String question;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
