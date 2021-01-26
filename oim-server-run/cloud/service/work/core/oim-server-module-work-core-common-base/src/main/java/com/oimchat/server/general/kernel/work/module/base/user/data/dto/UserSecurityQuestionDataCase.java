
package com.oimchat.server.general.kernel.work.module.base.user.data.dto;

import java.util.List;

import com.oimchat.server.general.kernel.work.module.base.user.data.UserSecurityQuestionData;

/**
 * 用户密保问题列表信息 <br>
 * Date 2020-04-09 19:34:40<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class UserSecurityQuestionDataCase {

	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 安全问题列表
	 */
	private List<UserSecurityQuestionData> items;

	public UserSecurityQuestionDataCase() {
		super();
	}

	public UserSecurityQuestionDataCase(String userId, List<UserSecurityQuestionData> items) {
		super();
		this.userId = userId;
		this.items = items;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<UserSecurityQuestionData> getItems() {
		return items;
	}

	public void setItems(List<UserSecurityQuestionData> items) {
		this.items = items;
	}
}
