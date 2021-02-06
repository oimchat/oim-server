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

public class GroupChatEvent {

	String groupId;
	String userId;
	Content content;
	List<ChatItem> chatItems;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
}
