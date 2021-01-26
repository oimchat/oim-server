package com.oimchat.server.general.kernel.work.module.base.contact.data.dto;

/**
 * 添加联系人，被添加者处理后的结果<br>
 * Date 2019-05-12 15:25:07<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class ContactAddResultData {
	/**
	 * 请求记录id
	 */
	private String applyId;
	/**
	 * 添加联系人的请求用户
	 */
	private String applyUserId;
	/**
	 * 被添加的用户
	 */
	private String targetUserId;
	/**
	 * 处理结果：0:未处理 1:同意 2:拒绝 3:忽略
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

	public String getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(String applyUserId) {
		this.applyUserId = applyUserId;
	}

	public String getTargetUserId() {
		return targetUserId;
	}

	public void setTargetUserId(String targetUserId) {
		this.targetUserId = targetUserId;
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
