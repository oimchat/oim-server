package com.oimchat.server.general.kernel.work.module.base.group.data.query;

/**
 * 群邀请查询<br>
 * Date 2019-06-08 19:10:57<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class GroupInviteVerifyQuery {

	/**
	 * 处理结果：0:未处理 1:同意 2:拒绝 3:忽略
	 */
	private String verifyHandleType;

	public String getVerifyHandleType() {
		return verifyHandleType;
	}

	public void setVerifyHandleType(String verifyHandleType) {
		this.verifyHandleType = verifyHandleType;
	}
}
