package com.oimchat.server.general.kernel.work.module.base.contact.entity;

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
 * 用户被添加的时验证问题<br>
 * Date 2019-01-20 13:16:40<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "im_contact_add_verify_question", indexes = {
		@Index(name = "index_userId", columnList = "userId", unique = false) })
@DynamicInsert
@DynamicUpdate
public class ContactAddVerifyQuestion extends PrimaryStringEntity {
	/**
	 * 用户id
	 */
	@Comment("用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String userId;
	/**
	 * 问题
	 */
	@Comment("问题")
	@ColumnDefault("''")
	@Column(nullable = false, length = 200)
	private String question;

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
