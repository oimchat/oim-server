package com.oimchat.server.general.kernel.work.module.base.group.data.dto;

import java.util.List;

/**
 * 处理加入群申请<br>
 * Date 2019-01-25 22:05:37<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class GroupJoinHandleData {
	/**
	 * 请求记录id
	 */
	private List<String> applyIds;
	/**
	 * 处理用户
	 */
	private String handleUserId;
	/**
	 * 处理结果
	 */
	private String handleType;
	/**
	 * 附加消息
	 */
	private String message;

	public List<String> getApplyIds() {
		return applyIds;
	}

	public void setApplyIds(List<String> applyIds) {
		this.applyIds = applyIds;
	}

	public String getHandleUserId() {
		return handleUserId;
	}

	public void setHandleUserId(String handleUserId) {
		this.handleUserId = handleUserId;
	}

	public String getHandleType() {
		return handleType;
	}

	public void setHandleType(String handleType) {
		this.handleType = handleType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
