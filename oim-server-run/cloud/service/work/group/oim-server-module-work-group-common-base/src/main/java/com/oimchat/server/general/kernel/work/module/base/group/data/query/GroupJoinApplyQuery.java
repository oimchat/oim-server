package com.oimchat.server.general.kernel.work.module.base.group.data.query;

/**
 * 加入群申请查询<br>
 * Date 2019-06-08 19:09:52<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class GroupJoinApplyQuery {

	/**
	 * 处理结果：0:未处理 1:同意 2:拒绝 3:忽略
	 */
	private String handleType;

	public String getHandleType() {
		return handleType;
	}

	public void setHandleType(String handleType) {
		this.handleType = handleType;
	}
}
