
package com.oimchat.server.general.kernel.work.module.base.group.data.dto;

import java.util.List;

import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupJoinSetting;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupJoinVerifyQuestion;

/**
 * 群加入验证设置<br>
 * Date 2020-04-11 16:01:31<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class GroupJoinSettingEntityCase {

	/**
	 * 设置信息
	 */
	private GroupJoinSetting setting;
	/**
	 * 验证问题
	 */
	private List<GroupJoinVerifyQuestion> questions;

	public GroupJoinSettingEntityCase() {
		super();
	}

	public GroupJoinSettingEntityCase(GroupJoinSetting setting, List<GroupJoinVerifyQuestion> questions) {
		super();
		this.setting = setting;
		this.questions = questions;
	}

	public GroupJoinSetting getSetting() {
		return setting;
	}

	public void setSetting(GroupJoinSetting setting) {
		this.setting = setting;
	}

	public List<GroupJoinVerifyQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<GroupJoinVerifyQuestion> questions) {
		this.questions = questions;
	}
}
