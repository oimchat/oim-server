package com.oimchat.server.general.kernel.work.module.base.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.onlyxiahui.aware.basic.bean.PrimaryStringEntity;
import com.onlyxiahui.extend.hibernate.annotation.Comment;

/**
 * 密保问信息<br>
 * Date 2019-01-20 09:48:36<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity(name = "im_user_security_question")
@Table(name = "im_user_security_question", indexes = {
		@Index(name = "index_userId", columnList = "userId", unique = false) })
@DynamicInsert
@DynamicUpdate
public class UserSecurityQuestion extends PrimaryStringEntity {

	/**
	 * 用户id
	 */
	@Comment("用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String userId;
	/**
	 * 密保问题
	 */
	@Comment("密保问题")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String question;
	/**
	 * 密保答案
	 */
	@Comment("密保答案")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String answer;

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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
