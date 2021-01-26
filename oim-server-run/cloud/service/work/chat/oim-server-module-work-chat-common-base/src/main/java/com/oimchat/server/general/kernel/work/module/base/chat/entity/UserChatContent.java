package com.oimchat.server.general.kernel.work.module.base.chat.entity;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
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
 * 用户聊天记录<br>
 * Date 2019-01-18 13:49:38<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "im_user_chat_content", indexes = {
		@Index(name = "index_messageKey", columnList = "messageKey", unique = false),
		@Index(name = "index_receiveUserId", columnList = "receiveUserId", unique = false),
		@Index(name = "index_sendUserId", columnList = "sendUserId", unique = false),
		@Index(name = "index_timestamp", columnList = "timestamp", unique = false) })
@AttributeOverride(name = "id", column = @Column(name = "id"))
@DynamicInsert
@DynamicUpdate
public class UserChatContent extends BaseEntity {

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

	@Comment("key")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String ownKey;

	@Comment("消息key")
	@ColumnDefault("''")
	@Column(nullable = false, length = 80)
	private String messageKey;

	@Comment("接受用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String receiveUserId;

	@Comment("接受用户当时系统头像")
	@ColumnDefault("''")
	@Column(nullable = false, length = 5)
	private String receiveUserHead;

	@Comment("接受用户当时自定义头像")
	@ColumnDefault("''")
	@Column(nullable = false, length = 500)
	private String receiveUserAvatar;

	@Comment("接受用户姓名")
	@ColumnDefault("''")
	@Column(nullable = false, length = 200)
	private String receiveUserName;

	@Comment("接受用户昵称")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String receiveUserNickname;

	@Comment("接受用户当时在发送用户中的备注名")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String receiveUserRemarkName;

	@Comment("发送用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String sendUserId;

	@Comment("发送用户当时系统头像")
	@ColumnDefault("'1'")
	@Column(nullable = false, length = 5)
	private String sendUserHead;

	@Comment("发送用户当时自定义头像地址")
	@ColumnDefault("''")
	@Column(nullable = false, length = 500)
	private String sendUserAvatar;

	@Comment("发送用户姓名")
	@ColumnDefault("''")
	@Column(nullable = false, length = 200)
	private String sendUserName;

	@Comment("发送用户当时昵称")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String sendUserNickname;

	@Comment("发送用户当时在接受用户的备注名")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String sendUserRemarkName;

	@Comment("是否已发送: 0：否 1：是")
	@ColumnDefault("'0'")
	@Column(length = 2)
	private String isSend;

	@Comment("是否已发读: 0：否 1：是")
	@ColumnDefault("'0'")
	@Column(length = 2)
	private String isRead;

	@Comment("时间（格式：2019-01-01 00:00:00）")
	@ColumnDefault("'0001-01-01 00:00:00'")
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime dateTime;

	@Comment("时间戳")
	@ColumnDefault("0")
	@CreatedTimestamp
	@Column(nullable = false, length = 32)
	private Long timestamp;

	public String getOwnKey() {
		return ownKey;
	}

	public void setOwnKey(String ownKey) {
		this.ownKey = ownKey;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public String getReceiveUserId() {
		return receiveUserId;
	}

	public void setReceiveUserId(String receiveUserId) {
		this.receiveUserId = receiveUserId;
	}

	public String getReceiveUserHead() {
		return receiveUserHead;
	}

	public void setReceiveUserHead(String receiveUserHead) {
		this.receiveUserHead = receiveUserHead;
	}

	public String getReceiveUserAvatar() {
		return receiveUserAvatar;
	}

	public void setReceiveUserAvatar(String receiveUserAvatar) {
		this.receiveUserAvatar = receiveUserAvatar;
	}

	public String getReceiveUserName() {
		return receiveUserName;
	}

	public void setReceiveUserName(String receiveUserName) {
		this.receiveUserName = receiveUserName;
	}

	public String getReceiveUserNickname() {
		return receiveUserNickname;
	}

	public void setReceiveUserNickname(String receiveUserNickname) {
		this.receiveUserNickname = receiveUserNickname;
	}

	public String getReceiveUserRemarkName() {
		return receiveUserRemarkName;
	}

	public void setReceiveUserRemarkName(String receiveUserRemarkName) {
		this.receiveUserRemarkName = receiveUserRemarkName;
	}

	public String getSendUserId() {
		return sendUserId;
	}

	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}

	public String getSendUserHead() {
		return sendUserHead;
	}

	public void setSendUserHead(String sendUserHead) {
		this.sendUserHead = sendUserHead;
	}

	public String getSendUserAvatar() {
		return sendUserAvatar;
	}

	public void setSendUserAvatar(String sendUserAvatar) {
		this.sendUserAvatar = sendUserAvatar;
	}

	public String getSendUserName() {
		return sendUserName;
	}

	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}

	public String getSendUserNickname() {
		return sendUserNickname;
	}

	public void setSendUserNickname(String sendUserNickname) {
		this.sendUserNickname = sendUserNickname;
	}

	public String getSendUserRemarkName() {
		return sendUserRemarkName;
	}

	public void setSendUserRemarkName(String sendUserRemarkName) {
		this.sendUserRemarkName = sendUserRemarkName;
	}

	public String getIsSend() {
		return isSend;
	}

	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
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
