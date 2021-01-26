package com.oimchat.server.general.kernel.work.module.base.group.data.query;

/**
 * 被邀请查询<br>
 * Date 2019-06-08 19:10:57<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class GroupInviteeApplyQuery {

	/**
	 * 处理结果：0:未处理 1:同意 2:拒绝 3:忽略
	 */
	private String inviteeHandleType;

	public String getInviteeHandleType() {
		return inviteeHandleType;
	}

	public void setInviteeHandleType(String inviteeHandleType) {
		this.inviteeHandleType = inviteeHandleType;
	}
}
