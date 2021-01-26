package com.oimchat.server.general.kernel.work.module.base.chat.data.query;

/**
 * 
 * Date 2019-02-17 18:12:00<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class UserChatQuery extends BaseChatQuery {

	private String sendUserId;
	private String receiveUserId;

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

}
