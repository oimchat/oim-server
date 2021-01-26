package com.oimchat.server.general.kernel.work.module.base.contact.data.dto;

/**
 * 添加联系人的验证设置<br>
 * Date 2019-01-06 12:10:04<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class ContactVerifySettingData {

	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 1：允许任何人添加 <br>
	 * 2：需要验证 <br>
	 * 3：需要回答正确的问题 <br>
	 * 4：需要回答问题并由我确认 <br>
	 */
	private String verifyType;
	/**
	 * 验证问题
	 */
	private String question;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVerifyType() {
		return verifyType;
	}

	public void setVerifyType(String verifyType) {
		this.verifyType = verifyType;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
