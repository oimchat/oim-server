package com.oimchat.server.general.kernel.work.module.base.group.entity;

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
 * 
 * 用户加入群时回答验证问题 <br>
 * Date 2019-07-27 17:35:50<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "im_group_join_verify_answer", indexes = {
		@Index(name = "index_applyId", columnList = "applyId", unique = false),
		@Index(name = "index_applyUserId", columnList = "applyUserId", unique = false),
		@Index(name = "index_groupId", columnList = "groupId", unique = false),
		@Index(name = "index_questionId", columnList = "questionId", unique = false) })
@DynamicInsert
@DynamicUpdate
public class GroupJoinVerifyAnswer extends PrimaryStringEntity {

	/**
	 * 请求消息的id(对应GroupJoinApply中的id)
	 */
	@Comment("请求消息的id(对应GroupJoinApply中的id)")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String applyId;

	/**
	 * 申请的用户id
	 */
	@Comment("申请的用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String applyUserId;

	/**
	 * 加入的群
	 */
	@Comment("群id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String groupId;

	/**
	 * 问题id(对应GroupJoinVerifyQuestion中的id
	 */
	@Comment("问题id(对应GroupJoinVerifyQuestion中的id)")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String questionId;

	/**
	 * 问题
	 */
	@Comment("问题")
	@ColumnDefault("''")
	@Column(nullable = false, length = 200)
	private String question;

	/**
	 * 答案
	 */
	@Comment("答案")
	@ColumnDefault("''")
	@Column(nullable = false, length = 200)
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
