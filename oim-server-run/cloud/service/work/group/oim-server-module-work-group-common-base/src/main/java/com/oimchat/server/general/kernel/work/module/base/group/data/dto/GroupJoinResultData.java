package com.oimchat.server.general.kernel.work.module.base.group.data.dto;

/**
 * 申请加入群的处理结果<br>
 * Date 2019-01-25 22:05:37<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class GroupJoinResultData {

	/**
	 * 请求记录id
	 */
	private String applyId;
	/**
	 * 群id
	 */
	private String groupId;
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

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
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
