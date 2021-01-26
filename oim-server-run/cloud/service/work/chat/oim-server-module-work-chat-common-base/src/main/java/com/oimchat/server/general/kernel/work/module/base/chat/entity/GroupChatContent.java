package com.oimchat.server.general.kernel.work.module.base.chat.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.onlyxiahui.aware.basic.bean.BaseEntity;
import com.onlyxiahui.extend.hibernate.annotation.Comment;
import com.onlyxiahui.extend.query.hibernate.annotation.CreatedTimestamp;

/**
 * 群的聊天记录<br>
 * Date 2019-01-18 11:53:01<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "im_group_chat_content", indexes = {
		@Index(name = "index_messageKey", columnList = "messageKey", unique = false),
		@Index(name = "index_groupId", columnList = "groupId", unique = false),
		@Index(name = "index_userId", columnList = "userId", unique = false),
		@Index(name = "index_timestamp", columnList = "timestamp", unique = false) })
@DynamicInsert
@DynamicUpdate
public class GroupChatContent extends BaseEntity {

	/**
	 * 主键id
	 */
	@Comment("主键id")
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 40)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Comment("消息key")
	@ColumnDefault("''")
	@Column(nullable = false, length = 80)
	private String messageKey;

	@Comment("群id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String groupId;

	@Comment("群当时名称")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String groupName;

	@Comment("群当时系统头像")
	@ColumnDefault("'1'")
	@Column(nullable = false, length = 5)
	private String groupHead;

	@Comment("群当时自定义头像")
	@ColumnDefault("''")
	@Column(nullable = false, length = 500)
	private String groupAvatar;

	@Comment("发送消息用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String userId;

	@Comment("用户当时系统头像")
	@ColumnDefault("'1'")
	@Column(nullable = false, length = 5)
	private String userHead;

	@Comment("用户当时自定义头像地址")
	@ColumnDefault("''")
	@Column(nullable = false, length = 500)
	private String userAvatar;

	@Comment("用户当时权限")
	@ColumnDefault("'3'")
	@Column(nullable = false, length = 2)
	private String userPosition;

	@Comment("用户姓名")
	@ColumnDefault("''")
	@Column(nullable = false, length = 200)
	private String userName;

	@Comment("用户当时昵称")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String userNickname;

	@Comment("用户当时群中显示昵称")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String userGroupNickname;

	@Comment("时间（格式：2019-01-01 00:00:00）")
	@ColumnDefault("'0001-01-01 00:00:00'")
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime dateTime;

	@Comment("时间戳（毫秒）")
	@ColumnDefault("0")
	@CreatedTimestamp
	@Column(nullable = false, length = 32)
	private Long timestamp;

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupHead() {
		return groupHead;
	}

	public void setGroupHead(String groupHead) {
		this.groupHead = groupHead;
	}

	public String getGroupAvatar() {
		return groupAvatar;
	}

	public void setGroupAvatar(String groupAvatar) {
		this.groupAvatar = groupAvatar;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserHead() {
		return userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserGroupNickname() {
		return userGroupNickname;
	}

	public void setUserGroupNickname(String userGroupNickname) {
		this.userGroupNickname = userGroupNickname;
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
