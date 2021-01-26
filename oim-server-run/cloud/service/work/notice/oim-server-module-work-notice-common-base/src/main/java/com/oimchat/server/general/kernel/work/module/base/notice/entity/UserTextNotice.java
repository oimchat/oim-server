package com.oimchat.server.general.kernel.work.module.base.notice.entity;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.onlyxiahui.aware.basic.bean.PrimaryStringEntity;

/**
 * date 2016-01-04 21:18:55<br>
 * 用户收到通知的记录表，关联通知表。
 * 
 * @author XiaHui
 */
@Entity(name = "im_user_text_notice")
@Table(name = "im_user_text_notice", indexes = {
		@Index(name = "ix_userId", columnList = "userId", unique = false),
		@Index(name = "ix_textNoticeId", columnList = "textNoticeId", unique = false) })
public class UserTextNotice extends PrimaryStringEntity {

	private String userId;// 接受通知的用户id
	private String textNoticeId;// 通知表的id
	private String isRead;// 是否已读 0:false/未读 1:true/已读

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTextNoticeId() {
		return textNoticeId;
	}

	public void setTextNoticeId(String textNoticeId) {
		this.textNoticeId = textNoticeId;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

}
