package com.oimchat.server.run.dispatcher.auth;

import com.onlyxiahui.common.message.node.Head;

/**
 * 
 * <br>
 * Date 2019-08-09 15:35:19<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class ResultHead implements Head {
	/**
	 * 消息的id，标识消息的唯一性
	 */
	private String key;
	/**
	 * 响应时间
	 */
	private long timestamp;

	@Override
	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String getKey() {
		return key;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
