package com.oimchat.server.general.kernel.core.gateway.common.data;

import com.onlyxiahui.common.message.node.Head;

/**
 * 
 * Date 2018-12-25 09:29:03<br>
 * Description 头部接口
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class HeadImpl implements Head {
	/**
	 * 消息的id，标识消息的唯一性
	 */
	private String key;
	/**
	 * 请求接口名称
	 */
	private String service;
	/**
	 * 请求动作类型
	 */
	private String action;
	/**
	 * 请求方法
	 */
	private String method;
	/**
	 * 请求接口版本
	 */
	private String version;
	/**
	 * 响应时间
	 */
	private long timestamp;

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public void setKey(String key) {
		this.key = key;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
