package com.oimchat.server.general.kernel.work.module.base.chat.entity;

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
 * 用户聊天未读<br>
 * Date 2019-02-17 11:58:41<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "im_user_chat_unread", indexes = {
		@Index(name = "index_receiveUserId", columnList = "receiveUserId", unique = false),
		@Index(name = "index_sendUserId", columnList = "sendUserId", unique = false) })
@DynamicInsert
@DynamicUpdate
public class UserChatUnread extends PrimaryStringEntity {

	@Comment("接受用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String receiveUserId;

	@Comment("发送用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String sendUserId;

	@Comment("消息id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String lastContentId;

	@Comment("未读数量")
	@ColumnDefault("0")
	@Column(nullable = false, length = 11)
	private Integer unreadCount;

	@Comment("时间戳（毫秒）")
	@ColumnDefault("0")
	@Column(nullable = false, length = 32)
	private Long timestamp;

	public String getReceiveUserId() {
		return receiveUserId;
	}

	public void setReceiveUserId(String receiveUserId) {
		this.receiveUserId = receiveUserId;
	}

	public String getSendUserId() {
		return sendUserId;
	}

	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}

	public String getLastContentId() {
		return lastContentId;
	}

	public void setLastContentId(String lastContentId) {
		this.lastContentId = lastContentId;
	}

	public Integer getUnreadCount() {
		return unreadCount;
	}

	public void setUnreadCount(Integer unreadCount) {
		this.unreadCount = unreadCount;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
