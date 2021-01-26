
package com.oimchat.server.general.kernel.work.module.base.group.data.query;

import java.util.List;

import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupJoinApply;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupJoinVerifyAnswer;

/**
 * 加入群申请详情<br>
 * Date 2020-04-11 19:54:16<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class GroupJoinApplyEntityCase {

	/**
	 * 申请
	 */
	private GroupJoinApply apply;
	/**
	 * 答案
	 */
	private List<GroupJoinVerifyAnswer> answers;

	public GroupJoinApplyEntityCase() {
		super();
	}

	public GroupJoinApplyEntityCase(GroupJoinApply apply, List<GroupJoinVerifyAnswer> answers) {
		super();
		this.apply = apply;
		this.answers = answers;
	}

	public GroupJoinApply getApply() {
		return apply;
	}

	public void setApply(GroupJoinApply apply) {
		this.apply = apply;
	}

	public List<GroupJoinVerifyAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<GroupJoinVerifyAnswer> answers) {
		this.answers = answers;
	}
}
