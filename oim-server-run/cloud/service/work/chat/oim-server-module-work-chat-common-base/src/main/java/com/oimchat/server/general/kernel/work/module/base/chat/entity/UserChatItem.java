package com.oimchat.server.general.kernel.work.module.base.chat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import com.onlyxiahui.aware.basic.bean.PrimaryStringEntity;
import com.onlyxiahui.extend.hibernate.annotation.Comment;

/**
 * 用户的聊天记录<br>
 * Date 2019-02-17 11:54:27<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "im_user_chat_item", indexes = {
		@Index(name = "index_contentId", columnList = "contentId", unique = false),
		@Index(name = "index_messageKey", columnList = "messageKey", unique = false),
		@Index(name = "index_receiveUserId", columnList = "receiveUserId", unique = false),
		@Index(name = "index_sendUserId", columnList = "sendUserId", unique = false),
		@Index(name = "index_timestamp", columnList = "timestamp", unique = false) })
@DynamicInsert
@DynamicUpdate
public class UserChatItem extends PrimaryStringEntity {

	@Comment("消息id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String contentId;

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

	@Comment("发送用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String sendUserId;

	@Comment("类型：如文本、图片、表情、文件等")
	@ColumnDefault("''")
	@Column(nullable = false, length = 5)
	private String type;

	@Comment("原来的内容")
	@Type(type = "text")
	private String originalValue;

	@Comment("过滤后内容")
	@Type(type = "text")
	private String filterValue;

	@Comment("排序")
	@ColumnDefault("0")
	@Column(name = "`sort`", nullable = false)
	private Integer sort;

	@Comment("段落")
	@ColumnDefault("0")
	@Column(nullable = false)
	private Integer section;

	@Comment("时间戳（毫秒）")
	@ColumnDefault("0")
	@Column(nullable = false, length = 32)
	private Long timestamp;

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

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

	public String getSendUserId() {
		return sendUserId;
	}

	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOriginalValue() {
		return originalValue;
	}

	public void setOriginalValue(String value) {
		this.originalValue = value;
	}

	public String getFilterValue() {
		return filterValue;
	}

	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSection() {
		return section;
	}

	public void setSection(Integer section) {
		this.section = section;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
