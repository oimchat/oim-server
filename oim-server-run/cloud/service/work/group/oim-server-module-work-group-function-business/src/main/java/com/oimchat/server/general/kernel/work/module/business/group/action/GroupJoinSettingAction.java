package com.oimchat.server.general.kernel.work.module.business.group.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.group.data.dto.GroupJoinSettingEntityCase;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupJoinSetting;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupJoinVerifyQuestion;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupJoinSettingService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 群加入验证设置业务接口<br>
 * Date 2019-01-20 11:55:08<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.3.0
 */
@Component
@ActionMapping(value = "1.3.006")
public class GroupJoinSettingAction {

	@Resource
	private GroupJoinSettingService groupJoinSettingService;

	/**
	 * 
	 * 获取群设置信息<br>
	 * Date 2020-04-11 16:04:55<br>
	 * 
	 * @param userSession
	 * @param groupId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0001")
	public GroupJoinSettingEntityCase get(
			UserSession userSession,
			@Define("body.groupId") String groupId) {
		// String userId = userSession.getUserId();
		GroupJoinSetting data = groupJoinSettingService.getByGroupId(groupId);
		List<GroupJoinVerifyQuestion> list = groupJoinSettingService.getVerifyQuestionListByGroupId(groupId);
		return new GroupJoinSettingEntityCase(data, list);
	}

	/**
	 * 
	 * 修改群设置信息<br>
	 * Date 2020-04-11 16:05:13<br>
	 * 
	 * @param userSession
	 * @param data
	 * @param list
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0002")
	public Info update(
			UserSession userSession,
			@Define("body.setting") GroupJoinSetting data,
			@Define("body.questions") List<GroupJoinVerifyQuestion> list) {
		String userId = userSession.getUserId();
		return groupJoinSettingService.saveOrUpdate(userId, data, list);
	}
}
