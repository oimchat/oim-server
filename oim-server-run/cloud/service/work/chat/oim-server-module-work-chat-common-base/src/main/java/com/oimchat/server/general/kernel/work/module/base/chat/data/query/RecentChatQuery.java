
package com.oimchat.server.general.kernel.work.module.base.chat.data.query;

/**
 * Description <br>
 * Date 2020-04-16 18:24:14<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class RecentChatQuery {

	/**
	 * 用户id
	 */
	private String userId;

	/**
	 * 消息key
	 */
	private String messageKey;

	/**
	 * 消息id
	 */
	private String contentId;

	/**
	 * 具体聊天对象的id（如联系人，群）
	 */
	private String chatId;

	/**
	 * 类型： 1：联系人 2：群 3：讨论组 4：聊天室
	 */
	private String type;

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

}
