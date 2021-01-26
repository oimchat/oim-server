package com.oimchat.server.general.kernel.work.module.business.group.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.basic.common.util.KeyUtil;
import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupMemberDAO;
import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupRelationDAO;
import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupMemberQuery;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupMember;
import com.oimchat.server.general.kernel.work.module.base.group.manager.GroupMemberManager;
import com.oimchat.server.general.kernel.work.module.base.group.push.GroupBusinessPush;
import com.oimchat.server.general.kernel.work.module.base.group.push.GroupMemberPush;
import com.oimchat.server.general.kernel.work.module.base.group.push.GroupRelationPush;
import com.onlyxiahui.aware.basic.work.business.error.ErrorCode;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.message.bean.Info;

/**
 * 
 * Date 2019-01-21 12:46:31<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
@Transactional
public class GroupMemberService {

	@Resource
	private GroupMemberDAO groupMemberDAO;
	@Resource
	private GroupRelationDAO groupRelationDAO;

	@Resource
	private GroupMemberManager groupMemberManager;

	@Resource
	private GroupBusinessPush groupBusinessPush;
	@Resource
	private GroupMemberPush groupMemberPush;
	@Resource
	private GroupRelationPush groupRelationPush;

	/**
	 * 
	 * 分页条件查询<br>
	 * Date 2020-04-12 18:04:23<br>
	 * 
	 * @param query
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	public List<GroupMember> queryList(GroupMemberQuery query, Page page) {
		return groupMemberManager.queryList(query, page);
	}

	public GroupMember getById(String id) {
		GroupMember data = groupMemberDAO.getById(id);
		return data;
	}

	public GroupMember getByGroupIdUserId(String groupId, String userId) {
		GroupMember data = groupMemberDAO.getByGroupIdUserId(groupId, userId);
		return data;
	}

	public List<GroupMember> getListByGroupId(String groupId) {
		return groupMemberDAO.getListByGroupId(groupId);
	}

	public List<GroupMember> getListByUserId(String userId) {
		return groupMemberDAO.getListByUserId(userId);
	}

	/**
	 * 
	 * Date 2019-01-23 22:15:19<br>
	 * Description 修改群成员备注名
	 * 
	 * @author XiaHui<br>
	 * @param handleUserId
	 * @param groupId
	 * @param userId
	 * @param remark
	 * @return
	 * @since 1.0.0
	 */
	public Info updateRemark(String handleUserId, String groupId, String userId, String remark) {
		Info info = new Info();
		// 自己修改自己的群显示名称
		boolean isOwner = handleUserId.equals(userId);
		// 管理员或者群主
		boolean hasPermission = groupMemberManager.isAdmin(groupId, handleUserId) || groupMemberManager.isOwner(groupId, handleUserId);

		if (isOwner || hasPermission) {
			boolean mark = groupMemberDAO.updateNickname(groupId, userId, remark);
			if (!mark) {
				info.addWarning(ErrorCode.business.code("002"), "修改失败！");
			} else {
				List<String> userIds = groupMemberManager.getGroupMemberUserIdList(groupId);
				groupMemberPush.pushUpdate(userIds, KeyUtil.getKey(), groupId, userId);
			}
		} else {
			info.addWarning(ErrorCode.business.code("001"), "对不起，您没有权限修改！");
		}
		return info;
	}

	/**
	 * 
	 * Date 2019-01-23 22:13:27<br>
	 * Description 设置用户权限
	 * 
	 * @author XiaHui<br>
	 * @param handleUserId
	 * @param groupId
	 * @param userId
	 * @param position
	 * @return
	 * @since 1.0.0
	 */
	public Info updatePosition(String handleUserId, String groupId, String userId, String position) {
		// 只能是群主才能设置权限
		Info info = new Info();
		// 自己
		boolean isOwner = handleUserId.equals(userId);
		// 群主
		boolean hasPermission = groupMemberManager.isOwner(groupId, handleUserId);
		if (!isOwner && hasPermission) {
			boolean mark = groupMemberDAO.updatePosition(groupId, userId, position);
			if (!mark) {
				info.addWarning(ErrorCode.business.code("002"), "修改失败！");
			} else {
				List<String> userIds = groupMemberManager.getGroupMemberUserIdList(groupId);
				groupMemberPush.pushUpdatePosition(userIds, KeyUtil.getKey(), groupId, userId, position);
			}
		} else if (isOwner) {
			info.addWarning(ErrorCode.business.code("001"), "对不起，不能设置自己！");
		} else if (!hasPermission) {
			info.addWarning(ErrorCode.business.code("002"), "对不起，您没有权限！");
		}
		return info;
	}

	/**
	 * 
	 * Date 2019-01-23 22:12:12<br>
	 * Description 删除群成员
	 * 
	 * @author XiaHui<br>
	 * @param handleUserId
	 * @param groupId
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public Info delete(String handleUserId, String groupId, String userId) {
		// 自己不能删除自己，需要用退群的方式
		Info info = new Info();
		// 自己
		boolean isOwner = handleUserId.equals(userId);
		// 管理员或者群主
		boolean hasPermission = groupMemberManager.isAdmin(groupId, userId) || groupMemberManager.isOwner(groupId, userId);

		if (!isOwner && hasPermission) {
			boolean mark = groupMemberDAO.deleteByGroupIdUserId(groupId, userId);
			groupRelationDAO.deleteGroupCategoryMember(userId, groupId);

			if (!mark) {
				info.addWarning(ErrorCode.business.code("003"), "删除失败！");
			} else {

				// TODO 推送信息
				List<String> userIds = groupMemberManager.getGroupMemberUserIdList(groupId);
				groupMemberPush.pushDelete(userIds, KeyUtil.getKey(), groupId, userId);

				List<String> ids = new ArrayList<>();
				ids.add(userId);
				groupRelationPush.pushDelete(ids, KeyUtil.getKey(), groupId);
			}
		} else if (isOwner) {
			info.addWarning(ErrorCode.business.code("001"), "对不起，您没有权限！");
		} else if (!hasPermission) {
			info.addWarning(ErrorCode.business.code("002"), "对不起，您没有权限！");
		}
		return info;
	}

	/**
	 * 
	 * 推送信息变更 <br>
	 * Date 2020-05-14 21:26:26<br>
	 * 
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public Info pushMemberInfoUpdate(String userId) {
		Info info = new Info();
		List<GroupMember> inMemberList = groupMemberDAO.getListByUserId(userId);
		for (GroupMember gm : inMemberList) {
			String groupId = gm.getGroupId();
			List<String> userIds = new ArrayList<>();
			List<GroupMember> groupMemberList = groupMemberDAO.getListByGroupId(groupId);
			for (GroupMember m : groupMemberList) {
				userIds.add(m.getUserId());
			}
			groupMemberPush.pushInfoUpdate(userIds, KeyUtil.getKey(), groupId, userId);
		}
		return info;
	}
}
