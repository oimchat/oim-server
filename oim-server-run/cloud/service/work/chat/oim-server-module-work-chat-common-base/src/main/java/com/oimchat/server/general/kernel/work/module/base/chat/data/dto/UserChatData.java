package com.oimchat.server.general.kernel.work.module.base.chat.data.dto;

import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Content;

/**
 * 聊天信息<br>
 * Date 2019-02-17 17:54:19<br>
 * 
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */

public class UserChatData {

//	private String messageKey;
//	private String contentId;
	private UserSimple receiveUser;
	private UserSimple sendUser;
	private Content content;
//	public String getMessageKey() {
//		return messageKey;
//	}
//
//	public void setMessageKey(String messageKey) {
//		this.messageKey = messageKey;
//	}
//
//	public String getContentId() {
//		return contentId;
//	}
//
//	public void setContentId(String contentId) {
//		this.contentId = contentId;
//	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public UserSimple getReceiveUser() {
		return receiveUser;
	}

	public void setReceiveUser(UserSimple receiveUser) {
		this.receiveUser = receiveUser;
	}

	public UserSimple getSendUser() {
		return sendUser;
	}

	public void setSendUser(UserSimple sendUser) {
		this.sendUser = sendUser;
	}
}
