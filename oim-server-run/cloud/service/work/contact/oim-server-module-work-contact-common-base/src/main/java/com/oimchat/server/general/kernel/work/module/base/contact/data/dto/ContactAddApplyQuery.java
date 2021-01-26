package com.oimchat.server.general.kernel.work.module.base.contact.data.dto;

import java.util.List;

/**
 * 联系人添加请求查询<br>
 * Date 2019-06-08 19:07:53<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class ContactAddApplyQuery {

	/**
	 * 处理结果：0:未处理 1:同意 2:拒绝 3:忽略
	 */
	private String handleType;
	/**
	 * 处理结果：0:未处理 1:同意 2:拒绝 3:忽略
	 */
	private List<String> handleTypes;

	public String getHandleType() {
		return handleType;
	}

	public void setHandleType(String handleType) {
		this.handleType = handleType;
	}

	public List<String> getHandleTypes() {
		return handleTypes;
	}

	public void setHandleTypes(List<String> handleTypes) {
		this.handleTypes = handleTypes;
	}
}
