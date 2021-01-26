package com.oimchat.server.general.kernel.work.module.business.group.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.group.data.dto.GroupJoinApplyData;
import com.oimchat.server.general.kernel.work.module.base.group.data.dto.GroupJoinHandleData;
import com.oimchat.server.general.kernel.work.module.base.group.data.dto.JoinVerifyAnswer;
import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupJoinApplyEntityCase;
import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupJoinApplyQuery;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupJoinApply;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupJoinVerifyAnswer;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupJoinService;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupJoinSettingService;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupJoinVerifyAnswerService;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupManageService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.bean.CountInfo;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 加入群业务接口<br>
 * Date 2019-01-20 20:49:52<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.3.0
 */
@Component
@ActionMapping(value = "1.3.007")
public class GroupJoinAction {

	@Resource
	private GroupJoinSettingService groupJoinSettingService;
	@Resource
	private GroupJoinService groupJoinService;
	@Resource
	private GroupManageService groupManageService;
	@Resource
	private GroupJoinVerifyAnswerService groupJoinVerifyAnswerService;

	/**
	 * 获取申请加入数量(群主/管理员)<br>
	 * Date 2019-01-27 10:39:08<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @return
	 * @since 1.0.0
	 */

	@ActionMapping(value = "1.1.0001")
	public CountInfo queryJoinApplyReceiveCount(
			UserSession userSession,
			@Define("body.query") GroupJoinApplyQuery query) {
		Page page = new Page();
		page.setSize(1);
		String userId = userSession.getUserId();
		groupManageService.queryJoinRequestList(userId, query, page);
		return new CountInfo(page.getTotalCount());
	}

	/**
	 * 获取申请加入列表(群主/管理员)<br>
	 * Date 2019-01-27 10:39:08<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0002")
	public PageResult<List<GroupJoinApply>> queryJoinApplyReceiveList(
			UserSession userSession,
			@Define("body.query") GroupJoinApplyQuery query,
			@Define("body.page") Page page) {
		String userId = userSession.getUserId();
		List<GroupJoinApply> applys = groupManageService.queryJoinRequestList(userId, query, page);
		return new PageResult<>(page, applys);
	}

	/**
	 * 
	 * 获取申请加入详情列表(群主/管理员)<br>
	 * Date 2020-04-11 20:05:25<br>
	 * 
	 * @param userSession
	 * @param query
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0003")
	public PageResult<List<GroupJoinApplyEntityCase>> queryJoinApplyDataReceiveList(
			UserSession userSession,
			@Define("body.query") GroupJoinApplyQuery query,
			@Define("body.page") Page page) {
		String userId = userSession.getUserId();

		List<String> applyIds = new ArrayList<>();
		List<String> groupIds = new ArrayList<>();

		List<GroupJoinApply> applys = groupManageService.queryJoinRequestList(userId, query, page);

		for (GroupJoinApply ap : applys) {
			groupIds.add(ap.getGroupId());
			applyIds.add(ap.getId());
		}
		Map<String, List<GroupJoinVerifyAnswer>> answerMap = new HashMap<>();

		List<GroupJoinVerifyAnswer> answers = groupJoinVerifyAnswerService.getListByApplyIds(groupIds, applyIds);

		for (GroupJoinVerifyAnswer a : answers) {
			String aid = a.getApplyId();
			List<GroupJoinVerifyAnswer> list = answerMap.get(aid);
			if (null == list) {
				list = new ArrayList<>();
				answerMap.put(aid, list);
			}
			list.add(a);
		}

		List<GroupJoinApplyEntityCase> list = new ArrayList<>();

		for (GroupJoinApply ap : applys) {
			String aid = ap.getId();
			List<GroupJoinVerifyAnswer> answerList = answerMap.get(aid);
			list.add(new GroupJoinApplyEntityCase(ap, answerList));
		}
		return new PageResult<>(page, list);
	}

	/**
	 * 处理加入申请<br>
	 * Date 2019-01-26 14:44:23<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param handle
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0005")
	public Info joinHandle(
			UserSession userSession,
			@Define("body.handle") GroupJoinHandleData handle) {
		// String applyId;// 请求记录id
		// String applyUserId;// 添加联系人的请求用户
		// String groupId;// 被添加的用户
		// String handleType;// 处理结果：0:未处理 1:同意 2:拒绝 3:忽略
		// String message;// 附加消息
		String handleUserId = userSession.getUserId();
		handle.setHandleUserId(handleUserId);
		Info info = groupJoinService.joinHandle(handle);
		return info;
	}

	/**
	 * 申请加入<br>
	 * Date 2019-01-26 14:43:22<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param apply
	 * @param answers
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0006")
	public Info joinRequest(
			UserSession userSession,
			@Define("body.apply") GroupJoinApplyData apply,
			@Define("body.answers") List<JoinVerifyAnswer> answers) {
		String userId = userSession.getUserId();
		apply.setApplyUserId(userId);
		Info info = groupJoinService.joinApply(apply, answers);
		return info;
	}
}
