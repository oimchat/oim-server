package com.oimchat.server.general.kernel.work.module.business.group.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.group.entity.Group;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupHead;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupBusinessService;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupCommonService;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupHeadService;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupManageService;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupMemberService;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.base.HeadImpl;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 群业务接口<br>
 * Date 2019-01-20 20:49:52<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.3.0
 */
@Component
@ActionMapping(value = "1.3.005")
public class GroupBusinessAction {

	@Resource
	private GroupHeadService groupHeadService;
	@Resource
	private GroupService groupService;
	@Resource
	private GroupCommonService groupCommonService;
	@Resource
	private GroupMemberService groupMemberService;
	@Resource
	private GroupManageService groupManageService;
	@Resource
	private GroupBusinessService groupBusinessService;

//	/**
//	 * 获取个人加入群的数量<br>
//	 * Date 2019-01-26 14:40:12<br>
//	 * 
//	 * @author XiaHui<br>
//	 * @param userSession
//	 * @return
//	 * @since 1.0.0
//	 */
//	@ActionMapping(value = "1.1.0001")
//	public CountInfo getGroupCountByGroupMemberUserId(UserSession userSession) {
//		String userId = userSession.getUserId();
//		List<Group> groupList = groupCommonService.getGroupListByGroupMemberUserId(userId);
//		return new CountInfo(groupList.size());
//	}
//
//	/**
//	 * 获取个人加入的群列表<br>
//	 * Date 2019-01-26 14:40:32<br>
//	 * 
//	 * @author XiaHui<br>
//	 * @param userSession
//	 * @return
//	 * @since 1.0.0
//	 */
//	@ActionMapping(value = "1.1.0002")
//	public PageResult<List<Group>> getGroupListByGroupMemberUserId(
//			UserSession userSession,
//			@Define("body.page") Page page) {
//		String userId = userSession.getUserId();
//		List<Group> groupList = groupCommonService.getGroupListByGroupMemberUserId(userId);
//		return new PageResult<>(page, groupList);
//	}

	/**
	 * 创建群<br>
	 * Date 2019-01-26 14:42:17<br>
	 * 
	 * @author XiaHui<br>
	 * @param head
	 * @param userSession
	 * @param group
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0005")
	public ResultBodyMessage<Group> addGroup(
			HeadImpl head, 
			UserSession userSession,
			@Define("body") Group group) {
		String userId = userSession.getUserId();
		ResultBodyMessage<Group> message = groupBusinessService.add(head.getKey(), userId, group);
		return message;
	}

	/**
	 * 修改群<br>
	 * Date 2019-01-26 14:42:29<br>
	 * 
	 * @author XiaHui<br>
	 * @param head
	 * @param userSession
	 * @param group
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0006")
	public Info update(
			HeadImpl head,
			UserSession userSession,
			@Define("body") Group group) {
		String userId = userSession.getUserId();
		Info info = groupBusinessService.update(head.getKey(), userId, group);
		return info;
	}

	/**
	 * 修改头像<br>
	 * Date 2019-01-26 14:42:46<br>
	 * 
	 * @author XiaHui<br>
	 * @param groupHead
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0007")
	public Object uploadHead(UserSession userSession, @Define("body") GroupHead groupHead) {
		String userId = userSession.getUserId();
		return groupHeadService.uploadHead(userId, groupHead);
	}

	/**
	 * 转让群<br>
	 * Date 2019-01-26 14:54:27<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param groupId
	 * @param newOwnerUserId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0008")
	public Info changeGroupOwner(
			UserSession userSession,
			@Define("body.groupId") String groupId,
			@Define("body.newOwnerUserId") String newOwnerUserId) {
		String oldOwnerUserId = userSession.getUserId();
		Info info = groupManageService.changeGroupOwner(groupId, oldOwnerUserId, newOwnerUserId);
		return info;
	}

	/**
	 * 解散群<br>
	 * Date 2019-01-26 15:04:37<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param groupId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0009")
	public ResultMessage disband(
			UserSession userSession,
			@Define("body.groupId") String groupId) {
		String ownerUserId = userSession.getUserId();
		Info info = groupManageService.disbandGroup(groupId, ownerUserId);
		ResultMessage message = new ResultMessage();
		message.setInfo(info);
		return message;
	}

	/**
	 * 退出群<br>
	 * Date 2019-01-27 12:54:59<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param groupId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0010")
	public Info quit(
			UserSession userSession,
			@Define("body.groupId") String groupId) {
		String userId = userSession.getUserId();
		Info info = groupBusinessService.quit(groupId, userId);
		return info;
	}

//	/**
//	 * 
//	 * Date 2019-01-26 14:39:42<br>
//	 * Description 获取群头像信息
//	 * 
//	 * @author XiaHui<br>
//	 * @param groupId
//	 * @return
//	 * @since 1.0.0
//	 */
//	@ActionMapping(value = "1.1.0004")
//	public GroupHead getGroupHead(@Define("body.id") String groupId) {
//		GroupHead groupHead = groupHeadService.getGroupHeadByGroupId(groupId);
//		return groupHead;
//	}

}
