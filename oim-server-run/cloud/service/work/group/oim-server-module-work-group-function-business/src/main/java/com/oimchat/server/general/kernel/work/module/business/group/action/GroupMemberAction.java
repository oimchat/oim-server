package com.oimchat.server.general.kernel.work.module.business.group.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupMemberQuery;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupMember;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupMemberService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.bean.CountInfo;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 群成员业务接口<br>
 * Date 2019-01-20 21:59:18<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.3.0
 */
@Component
@ActionMapping(value = "1.3.004")
public class GroupMemberAction {

	@Resource
	private GroupMemberService groupMemberService;

	/**
	 * 获取个人已经加入群的数量<br>
	 * Date 2019-01-23 21:49:05<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0001")
	public CountInfo getOwnerGroupMemberCount(
			UserSession userSession,
			@Define("body.query.userId") String userId) {
		userId = userSession.getUserId();
		Page page = new Page();
		page.setNumber(1);
		page.setSize(1);

		GroupMemberQuery query = new GroupMemberQuery();
		query.setUserId(userId);

		groupMemberService.queryList(query, page);
		return new CountInfo(page.getTotalCount());
	}

	/**
	 * 获取个人在已经加入群的关系信息（权限）<br>
	 * Date 2019-01-23 21:49:19<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0002")
	public PageResult<List<GroupMember>> getOwnerGroupMemberList(
			UserSession userSession,
			@Define("body.query.userId") String userId,
			@Define("body.page") Page page) {
		userId = userSession.getUserId();
		GroupMemberQuery query = new GroupMemberQuery();
		query.setUserId(userId);

		List<GroupMember> groupMemberList = groupMemberService.queryList(query, page);
		return new PageResult<>(page, groupMemberList);
	}

	/**
	 * 获取成员数量<br>
	 * Date 2019-01-23 21:49:35<br>
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0003")
	public CountInfo queryGroupMemberCount(
			@Define("body.query") GroupMemberQuery query) {

		Page page = new Page();
		page.setNumber(1);
		page.setSize(1);

		if (null != query.getGroupId() && !query.getGroupId().isEmpty()) {
			groupMemberService.queryList(query, page);
		}
		return new CountInfo(page.getTotalCount());
	}

	/**
	 * 获取成员列表<br>
	 * Date 2019-01-23 21:49:45<br>
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0004")
	public PageResult<List<GroupMember>> queryGroupMemberList(
			@Define("body.query") GroupMemberQuery query,
			@Define("body.page") Page page) {
		List<GroupMember> list = null;
		if (null != query.getGroupId() && !query.getGroupId().isEmpty()) {
			list = groupMemberService.queryList(query, page);
		} else {
			list = new ArrayList<>();
		}
		return new PageResult<>(page, list);
	}

	/**
	 * 
	 * 获取详情<br>
	 * Date 2020-04-12 20:58:25<br>
	 * 
	 * @param id
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0005")
	public GroupMember getById(
			@Define("body.id") String id) {
		GroupMember groupMember = groupMemberService.getById(id);
		return groupMember;
	}

	/**
	 * 
	 * 批量获取详情<br>
	 * Date 2020-04-15 12:16:33<br>
	 * 
	 * @param ids
	 * @return
	 * @since 1.0.0
	 * @docIgnore
	 */
	@ActionMapping(value = "1.1.0006")
	public List<GroupMember> getByIds(
			@Define("body.ids") List<String> ids) {
		return new ArrayList<>();
	}

	/**
	 * 获取成员详情<br>
	 * Date 2019-01-23 21:49:58<br>
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0007")
	public GroupMember getGroupMember(
			@Define("body.groupId") String groupId,
			@Define("body.userId") String userId) {
		GroupMember groupMember = groupMemberService.getByGroupIdUserId(groupId, userId);
		return groupMember;
	}

	/**
	 * 
	 * 批量获取详情<br>
	 * Date 2020-04-15 12:16:33<br>
	 * 
	 * @param ids
	 * @return
	 * @since 1.0.0
	 * @docIgnore
	 */
	@ActionMapping(value = "1.1.0008")
	public List<GroupMember> getByUserIds(
			@Define("body.groupId") String groupId,
			@Define("body.userIds") List<String> ids) {
		return new ArrayList<>();
	}

	/**
	 * 
	 * 批量获取详情<br>
	 * Date 2020-04-15 12:16:33<br>
	 * 
	 * @param ids
	 * @return
	 * @since 1.0.0
	 * @docIgnore
	 */
	@ActionMapping(value = "1.1.0009")
	public List<GroupMember> getByGroupIds(
			@Define("body.userId") String userId,
			@Define("body.groupIds") List<String> groupIds) {
		return new ArrayList<>();
	}

	/**
	 * 
	 * 修改群成员昵称<br>
	 * Date 2020-04-11 19:39:28<br>
	 * 
	 * @param userSession
	 * @param groupId
	 * @param userId
	 * @param nickname
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0010")
	public Info updateRemark(
			UserSession userSession,
			@Define("body.groupId") String groupId,
			@Define("body.userId") String userId,
			@Define("body.nickname") String nickname) {
		String handleUserId = userSession.getUserId();
		Info info = groupMemberService.updateRemark(handleUserId, groupId, userId, nickname);
		return info;
	}

	/**
	 * 设置管理员<br>
	 * Date 2019-01-23 21:57:44<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param groupId
	 * @param userId
	 * @param position
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0011")
	public Info updatePosition(
			UserSession userSession,
			@Define("body.groupId") String groupId,
			@Define("body.userId") String userId,
			@Define("body.position") String position) {
		String handleUserId = userSession.getUserId();
		Info info = groupMemberService.updatePosition(handleUserId, groupId, userId, position);
		return info;
	}

	/**
	 * 踢人<br>
	 * Date 2019-01-23 21:58:11<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param groupId
	 * @param userId
	 * @param position
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0012")
	public Info delete(
			UserSession userSession,
			@Define("body.groupId") String groupId,
			@Define("body.userId") String userId) {
		String handleUserId = userSession.getUserId();
		Info info = groupMemberService.delete(handleUserId, groupId, userId);
		return info;
	}
}
