package com.oimchat.server.general.kernel.work.module.business.group.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupInviteVerifyHandleData;
import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupInviteVerifyQuery;
import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupInviteeApplyQuery;
import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupInviteeHandleData;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupInviteApply;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupInviteApplyService;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupInviteService;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupManageService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.bean.CountInfo;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 群邀请业务接口<br>
 * Date 2019-01-20 20:49:52<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.3.0
 */
@Component
@ActionMapping(value = "1.3.008")
public class GroupInviteAction {

	@Resource
	private GroupInviteService groupInviteService;
	@Resource
	private GroupManageService groupManageService;
	@Resource
	private GroupInviteApplyService groupInviteApplyService;

	/**
	 * 获取申请邀请数量(群主/管理员)<br>
	 * Date 2019-01-27 10:51:05<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @return
	 * @since 1.0.0
	 */

	@ActionMapping(value = "1.1.0001")
	public CountInfo getInviteApplyReceiveCount(
			UserSession userSession,
			@Define("body.query") GroupInviteVerifyQuery query) {
		Page page = new Page();
		page.setSize(1);
		String userId = userSession.getUserId();
		groupManageService.queryInviteRequestList(userId, query, page);
		return new CountInfo(page.getTotalCount());
	}

	/**
	 * 获取申请邀请列表(群主/管理员)<br>
	 * Date 2019-01-27 10:51:54<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param page
	 * @return
	 * @since 1.0.0
	 */

	@ActionMapping(value = "1.1.0002")
	public PageResult<List<GroupInviteApply>> getInviteApplyReceiveList(
			UserSession userSession,
			@Define("body.query") GroupInviteVerifyQuery query,
			@Define("body.page") Page page) {
		String userId = userSession.getUserId();
		List<GroupInviteApply> applys = groupManageService.queryInviteRequestList(userId, query, page);
		return new PageResult<>(page, applys);
	}

	/**
	 * 
	 * 1.1.0003<br>
	 * Date 2020-04-16 11:25:34<br>
	 * 
	 * @param userSession
	 * @param query
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	public PageResult<List<GroupInviteApply>> getInviteApplyDataReceiveList(
			UserSession userSession,
			@Define("body.query") GroupInviteVerifyQuery query,
			@Define("body.page") Page page) {
		String userId = userSession.getUserId();
		List<GroupInviteApply> applys = groupManageService.queryInviteRequestList(userId, query, page);
		return new PageResult<>(page, applys);
	}

	/**
	 * 
	 * 1.1.0004 <br>
	 * Date 2020-04-16 11:25:05<br>
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public GroupInviteApply getById() {
		return null;
	}

	/**
	 * 审批处理邀请(群主/管理员)<br>
	 * Date 2019-01-27 10:56:14<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param handle
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0005")
	public Info inviteVerifyHandle(
			UserSession userSession,
			@Define("body.handle") GroupInviteVerifyHandleData handle) {
		String verifyHandleUserId = userSession.getUserId();

		List<String> inviteApplyIds = handle.getApplyIds();
		String verifyHandleType = handle.getVerifyHandleType();
		Info info = groupInviteService.verifyHandle(verifyHandleUserId, inviteApplyIds, verifyHandleType);
		return info;
	}

	/**
	 * 邀请加入<br>
	 * Date 2019-01-27 10:23:38<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param groupId
	 * @param userIds
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0006")
	public Info invite(
			UserSession userSession,
			@Define("body.groupId") String groupId,
			@Define("body.userIds") List<String> userIds) {
		String inviterUserId = userSession.getUserId();
		Info info = groupInviteService.invite(inviterUserId, groupId, userIds);
		return info;
	}

	/**
	 * 获取被邀请数量<br>
	 * Date 2019-01-27 10:28:43<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0007")
	public CountInfo getCountByInviteeUserId(
			UserSession userSession,
			@Define("body.query") GroupInviteeApplyQuery query) {
		Page page = new Page();
		page.setSize(1);
		String inviteeUserId = userSession.getUserId();
		groupInviteApplyService.queryInviteeList(inviteeUserId, query, page);
		return new CountInfo(page.getTotalCount());
	}

	/**
	 * 获取被邀请列表<br>
	 * Date 2019-01-27 10:29:03<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0008")
	public PageResult<List<GroupInviteApply>> getListByInviteeUserId(
			UserSession userSession,
			@Define("body.query") GroupInviteeApplyQuery query,
			@Define("body.page") Page page) {
		String inviteeUserId = userSession.getUserId();
		List<GroupInviteApply> applys = groupInviteApplyService.queryInviteeList(inviteeUserId, query, page);
		return new PageResult<>(page, applys);
	}

	/**
	 * 
	 * 处理被邀请(同意/拒绝)<br>
	 * Date 2020-04-12 19:59:22<br>
	 * 
	 * @param userSession
	 * @param handle
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0010")
	public ResultMessage inviteInviteeHandle(
			UserSession userSession,
			@Define("body.handle") GroupInviteeHandleData handle) {
		String inviteeUserId = userSession.getUserId();
		Info info = null;
		if (null != handle.getApplyIds()) {
			for (String applyId : handle.getApplyIds()) {
				info = groupInviteService.inviteeHandle(inviteeUserId, applyId, handle.getInviteeHandleType());
			}
		}
		ResultMessage message = new ResultMessage();
		if (null != info) {
			message.setInfo(info);
		} else {
			message.addWarning("3.001", "数据异常");
		}
		return message;
	}
}
