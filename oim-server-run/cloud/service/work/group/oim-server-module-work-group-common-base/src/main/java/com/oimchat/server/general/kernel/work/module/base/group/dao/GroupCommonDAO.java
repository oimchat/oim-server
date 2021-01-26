package com.oimchat.server.general.kernel.work.module.base.group.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.group.entity.Group;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupHead;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupInviteApply;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupJoinApply;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupMember;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupRelation;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.page.QueryPage;

/**
 * 
 * Date 2019-01-21 12:33:12<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class GroupCommonDAO extends BaseDAO {

	/**
	 * 
	 * Date 2019-01-21 12:31:53<br>
	 * Description 获取用户所加入/拥有的群列表
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public List<Group> getGroupListByGroupCategoryMemberUserId(String userId) {
		StringBuilder hql = new StringBuilder();
		hql.append("select g from ");
		hql.append(Group.class.getName());
		hql.append(" g where g.id in ");
		hql.append("(select gcm.groupId from ");
		hql.append(GroupRelation.class.getName());
		hql.append(" gcm where userId='");
		hql.append(userId);
		hql.append("')");
		List<Group> list = (List<Group>) this.find(hql.toString());
		return list;
	}

	/**
	 * 
	 * Date 2019-01-21 12:31:17<br>
	 * Description 获取用户所加入/拥有的群列表
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public List<Group> getGroupListByGroupMemberUserId(String userId) {

		StringBuilder hql = new StringBuilder();
		hql.append("select g from ");
		hql.append(Group.class.getName());
		hql.append(" g where g.id in ");
		hql.append("(select gm.groupId from ");
		hql.append(GroupMember.class.getName());
		hql.append(" gm where userId='");
		hql.append(userId);
		hql.append("')");
		List<Group> list = (List<Group>) this.find(hql.toString());
		return list;
	}

	/**
	 * 
	 * Date 2019-01-21 12:31:17<br>
	 * Description 获取用户所加入/拥有群的头像列表
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public List<GroupHead> getGroupHeadListByGroupMemberUserId(String userId) {
		StringBuilder sql = new StringBuilder();
		sql.append("select gh.* from ");
		sql.append(" im_group_head ");
		sql.append(" gh where gh.groupId in ");
		sql.append("(select gcm.groupId from ");
		sql.append(" im_group_member ");
		sql.append(" gcm where userId=:userId ");
		sql.append(")");
		sql.append(" and not exists ( select 1 from im_group_head b where b.groupId = gh.groupId and b.createdDateTime > gh.createdDateTime )");

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("userId", userId);
		List<GroupHead> list = this.queryListBySql(sql.toString(), queryWrapper, GroupHead.class, null);
		return list;
	}

//	/**
//	 * 根据群id，获取所有成员
//	 * 
//	 * @param groupId
//	 * @return
//	 */
//	public List<UserData> getUserDataListByGroupMemberGroupId(String groupId) {
//		QueryWrapper queryWrapper = new QueryWrapper();
//		queryWrapper.addParameter("groupId", groupId);
//		List<UserData> userList = this.queryListByName("group.common.getUserDataListByGroupMemberGroupId", queryWrapper, UserData.class);
//		return userList;
//	}
//
//	public List<UserData> getUserDataListOfAllUserInGroupByGroupMemberUserId(String userId) {
//		QueryWrapper queryWrapper = new QueryWrapper();
//		queryWrapper.addParameter("userId", userId);
//		List<UserData> userList = this.queryListByName("group.common.getUserDataListOfAllUserInGroupByGroupMemberUserId", queryWrapper, UserData.class);
//		return userList;
//	}

	/**
	 * 
	 * Date 2019-01-24 22:08:14<br>
	 * Description 管理员或者群主获取申请加入群的请求列表
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	public List<GroupJoinApply> getJoinRequestListByUserId(String userId, Page page) {
		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage qp = queryWrapper.setPage(page.getNumber(), page.getSize());
		queryWrapper.put("userId", userId);
		queryWrapper.put("admin", GroupMember.position_admin);
		queryWrapper.put("owner", GroupMember.position_owner);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from im_group_join_apply ");
		sql.append(" where ");
		sql.append(" groupId in (");
		sql.append(" select groupId from im_group_member where ");
		sql.append(" userId=:userId ");
		sql.append(" and ( position =:admin or position =:owner )");
		sql.append(" ) ");
		List<GroupJoinApply> list = this.queryListBySql(sql.toString(), queryWrapper, GroupJoinApply.class, null);
		page.setTotalCount(qp.getTotalCount());
		page.setTotalPage(qp.getTotalPage());
		return list;
	}

	/**
	 * 
	 * Date 2019-01-26 09:34:41<br>
	 * Description 管理员或者群主获取审批邀请的用户
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	public List<GroupInviteApply> getInviteRequestListByUserId(String userId, Page page) {
		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage qp = queryWrapper.setPage(page.getNumber(), page.getSize());
		queryWrapper.put("userId", userId);
		queryWrapper.put("admin", GroupMember.position_admin);
		queryWrapper.put("owner", GroupMember.position_owner);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from im_group_invite_apply ");
		sql.append(" where ");
		sql.append(" groupId in (");
		sql.append(" select groupId from im_group_member where ");
		sql.append(" userId=:userId ");
		sql.append(" and ( position =:admin or position =:owner )");
		sql.append(" ) ");
		List<GroupInviteApply> list = this.queryListBySql(sql.toString(), queryWrapper, GroupInviteApply.class, null);
		page.setTotalCount(qp.getTotalCount());
		page.setTotalPage(qp.getTotalPage());
		return list;
	}
}
