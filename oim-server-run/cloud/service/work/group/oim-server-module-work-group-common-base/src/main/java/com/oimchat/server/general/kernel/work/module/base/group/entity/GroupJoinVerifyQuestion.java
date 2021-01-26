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
 * 加入群时验证问题 <br>
 * Date 2019-07-27 16:24:12<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "im_group_join_verify_question", indexes = {
		@Index(name = "index_groupId", columnList = "groupId", unique = false) })
@DynamicInsert
@DynamicUpdate
public class GroupJoinVerifyQuestion extends PrimaryStringEntity {

	/**
	 * 群id
	 */
	@Comment("群id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String groupId;

	/**
	 * 问题
	 */
	@Comment("问题")
	@ColumnDefault("''")
	@Column(nullable = false, length = 200)
	private String question;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
