package com.oimchat.server.general.kernel.work.module.base.group.data.dto;

/**
 * 
 * 用户加入群时回答验证问题<br>
 * Date: 2018-04-22 10:12:27<br>
 * 
 * @author: XiaHui
 */
public class JoinVerifyAnswer {

	/**
	 * 请求消息的id(对应GroupJoinRequest中的id)
	 */
	private String applyId;
	/**
	 * 申请的用户
	 */
	private String applyUserId;
	/**
	 * 加入的群
	 */
	private String groupId;
	/**
	 * 问题id(对应GroupJoinVerifyQuestion中的id)
	 */
	private String questionId;
	/**
	 * 问题
	 */
	private String question;
	/**
	 * 答案
	 */
	private String answer;

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(String applyUserId) {
		this.applyUserId = applyUserId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
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
}
