package com.oimchat.server.general.kernel.work.business.impl.chat.mq;

import java.util.List;

import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.ChatItem;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Content;

/**
 * Description <br>
 * Date 2019-06-28 14:58:49<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class UserChatEvent {

	String sendUserId;
	String receiveUserId;
	Content content;
	List<ChatItem> chatItems;
	boolean send;

	public String getSendUserId() {
		return sendUserId;
	}

	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}

	public String getReceiveUserId() {
		return receiveUserId;
	}

	public void setReceiveUserId(String receiveUserId) {
		this.receiveUserId = receiveUserId;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public List<ChatItem> getChatItems() {
		return chatItems;
	}

	public void setChatItems(List<ChatItem> chatItems) {
		this.chatItems = chatItems;
	}

	public boolean isSend() {
		return send;
	}

	public void setSend(boolean send) {
		this.send = send;
	}
}
