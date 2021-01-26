package com.oimchat.server.general.kernel.work.module.base.contact.data.dto;

/**
 * 用户被添加的时验证问题<br>
 * Date 2019-01-06 12:10:42<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class VerifyQuestion {

	/**
	 * id
	 */
	private String id;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
