
package com.oimchat.server.general.kernel.work.module.base.chat.data.query;

import java.util.List;

/**
 * Description <br>
 * Date 2020-04-16 19:59:23<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class GroupChatContentQuery {

	private String id;

	private String groupId;
	private String userId;

	private String messageKey;

	private String outId;
	private String outMessageKey;

	private Long timestamp;
	private Long startTimestamp;
	private Long endTimestamp;

	private List<String> ids;
	private List<String> messageKeys;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public String getOutId() {
		return outId;
	}

	public void setOutId(String outId) {
		this.outId = outId;
	}

	public String getOutMessageKey() {
		return outMessageKey;
	}

	public void setOutMessageKey(String outMessageKey) {
		this.outMessageKey = outMessageKey;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
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

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public List<String> getMessageKeys() {
		return messageKeys;
	}

	public void setMessageKeys(List<String> messageKeys) {
		this.messageKeys = messageKeys;
	}
}
