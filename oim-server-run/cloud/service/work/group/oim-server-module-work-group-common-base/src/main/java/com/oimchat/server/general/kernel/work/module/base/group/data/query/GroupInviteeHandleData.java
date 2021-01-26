package com.oimchat.server.general.kernel.work.module.base.group.data.query;

import java.util.List;

/**
 * 被邀请加入群处理<br>
 * Date 2019-01-25 22:05:37<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class GroupInviteeHandleData {

	/**
	 * 请求记录id
	 */
	private List<String> applyIds;
	/**
	 * 处理结果：0:未处理 1:同意 2:拒绝 3:忽略
	 */
	private String inviteeHandleType;
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

	public String getInviteeHandleType() {
		return inviteeHandleType;
	}

	public void setInviteeHandleType(String inviteeHandleType) {
		this.inviteeHandleType = inviteeHandleType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
