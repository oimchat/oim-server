package com.oimchat.server.general.kernel.work.module.base.group.data.query;

import java.util.List;

/**
 * 群邀请处理信息<br>
 * Date 2019-01-25 22:05:37<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class GroupInviteVerifyHandleData {

	/**
	 * 请求记录id
	 */
	private List<String> applyIds;
	/**
	 * 处理结果：0:未处理 1:同意 2:拒绝 3:忽略
	 */
	private String verifyHandleType;
	/**
	 * 验证用户
	 */
	private String verifyUserId;
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

	public String getVerifyHandleType() {
		return verifyHandleType;
	}

	public void setVerifyHandleType(String verifyHandleType) {
		this.verifyHandleType = verifyHandleType;
	}

	public String getVerifyUserId() {
		return verifyUserId;
	}

	public void setVerifyUserId(String verifyUserId) {
		this.verifyUserId = verifyUserId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
