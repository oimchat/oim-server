package com.oimchat.server.general.kernel.work.module.base.contact.data.dto;

/**
 * 联系人添加请求信息<br>
 * Date 2019-01-06 12:11:55<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class ContactAddApplyData {

	/**
	 * 添加联系人的请求用户
	 */
	private String applyUserId;
	/**
	 * 被添加的用户
	 */
	private String targetUserId;
	/**
	 * 验证问题
	 */
	private String question;
	/**
	 * 答案(当验证方式为回答问题时)
	 */
	private String answer;
	/**
	 * 附加消息
	 */
	private String message;
	/**
	 * 分组id
	 */
	private String categoryId;
	/**
	 * 备注名
	 */
	private String remark;

	public String getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(String applyUserId) {
		this.applyUserId = applyUserId;
	}

	public String getTargetUserId() {
		return targetUserId;
	}

	public void setTargetUserId(String targetUserId) {
		this.targetUserId = targetUserId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String userCategoryId) {
		this.categoryId = userCategoryId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
