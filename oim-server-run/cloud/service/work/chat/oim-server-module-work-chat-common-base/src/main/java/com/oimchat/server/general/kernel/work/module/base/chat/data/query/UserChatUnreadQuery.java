
package com.oimchat.server.general.kernel.work.module.base.chat.data.query;

/**
 * Description <br>
 * Date 2020-04-17 19:22:46<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class UserChatUnreadQuery {

	private String receiveUserId;
	private String sendUserId;

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
}
