
package com.oimchat.server.general.kernel.work.module.base.contact.data.dto;

import java.util.List;

/**
 * 添加联系人的认证信息<br>
 * Date 2020-04-10 19:38:00<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class ContactVerifySettingDataCase {

	/**
	 * 验证设置
	 */
	private ContactVerifySettingData setting;
	/**
	 * 问题列表
	 */
	private List<VerifyQuestion> questions;

	public ContactVerifySettingDataCase() {
		super();
	}

	public ContactVerifySettingDataCase(ContactVerifySettingData setting, List<VerifyQuestion> questions) {
		super();
		this.setting = setting;
		this.questions = questions;
	}

	public ContactVerifySettingData getSetting() {
		return setting;
	}

	public void setSetting(ContactVerifySettingData setting) {
		this.setting = setting;
	}

	public List<VerifyQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<VerifyQuestion> questions) {
		this.questions = questions;
	}
}
