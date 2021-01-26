package com.oimchat.server.general.kernel.work.module.base.contact.data.dto;

/**
 * 用户被添加的时验证问题回答<br>
 * Date 2019-01-06 12:10:20<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class VerifyAnswer {

	/**
	 * 问题id(对应ContactAddVerifyQuestion中的id)
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
