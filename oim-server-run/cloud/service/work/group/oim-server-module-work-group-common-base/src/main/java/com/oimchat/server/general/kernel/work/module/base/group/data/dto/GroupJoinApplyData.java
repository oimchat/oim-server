package com.oimchat.server.general.kernel.work.module.base.group.data.dto;

/**
 * 加入群申请信息<br>
 * Date 2019-01-06 12:11:55<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class GroupJoinApplyData {

	/**
	 * 请求用户
	 */
	private String applyUserId;
	/**
	 * 申请的群id
	 */
	private String groupId;
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

	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
}
