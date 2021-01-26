package com.oimchat.server.general.kernel.work.module.base.chat.data.query;

import java.util.List;

/**
 * 聊天内容查询<br>
 * Date 2019-01-06 12:07:20<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class BaseChatQuery {

	private String text;
	private String type;
	private Long startTimestamp;
	private Long endTimestamp;
	private List<String> messageKeys;
	private List<String> contentIds;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(Long startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public Long getEndTimestamp() {
		return endTimestamp;
	}

	public void setEndTimestamp(Long endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

	public List<String> getMessageKeys() {
		return messageKeys;
	}

	public void setMessageKeys(List<String> messageKeys) {
		this.messageKeys = messageKeys;
	}

	public List<String> getContentIds() {
		return contentIds;
	}

	public void setContentIds(List<String> contentIds) {
		this.contentIds = contentIds;
	}
}
