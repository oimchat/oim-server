package com.oimchat.server.general.kernel.work.module.base.chat.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.onlyxiahui.aware.basic.bean.PrimaryStringEntity;
import com.onlyxiahui.extend.hibernate.annotation.Comment;
import com.onlyxiahui.extend.query.hibernate.annotation.CreatedTimestamp;

/**
 * 用户最近聊天<br>
 * Date 2019-01-18 13:51:03<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "im_recent_chat", indexes = {
		@Index(name = "index_userId", columnList = "userId", unique = false),
		@Index(name = "index_messageKey", columnList = "messageKey", unique = false),
		@Index(name = "index_contentId", columnList = "contentId", unique = false),
		@Index(name = "index_chatId", columnList = "chatId", unique = false),
		@Index(name = "index_timestamp", columnList = "timestamp", unique = false) })
@DynamicInsert
@DynamicUpdate
public class RecentChat extends PrimaryStringEntity {

	/**
	 * 用户id
	 */
	@Comment("用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String userId;

	/**
	 * 消息key
	 */
	@Comment("消息key")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String messageKey;

	/**
	 * 消息id
	 */
	@Comment("消息id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String contentId;

	/**
	 * 具体聊天对象的id（如联系人，群）
	 */
	@Comment("具体聊天对象的id（如联系人，群）")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String chatId;

	/**
	 * 类型： 1：联系人 2：群 3：讨论组 4：聊天室
	 */
	@Comment("类型： 1：联系人  2：群 3：讨论组 4：聊天室")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String type;

	/**
	 * 时间（格式：2019-01-01 00:00:00）
	 */
	@Comment("时间（格式：2019-01-01 00:00:00）")
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime dateTime;

	/**
	 * 时间戳（毫秒）
	 */
	@Comment("时间戳（毫秒）")
	@CreatedTimestamp
	@Column(nullable = false, length = 32)
	private Long timestamp;

	public static String TYPE_USER = "1";// 联系人
	public static String TYPE_GROUP = "2";// 群
	public static String TYPE_TEAM = "3";// 讨论组
	public static String TYPE_ROOM = "4";// 聊天室
	public static String TYPE_MEETING = "5";// 会议

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getChatId() {
		return chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
