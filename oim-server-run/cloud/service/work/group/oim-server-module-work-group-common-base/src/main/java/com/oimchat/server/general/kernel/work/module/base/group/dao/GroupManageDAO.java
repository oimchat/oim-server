package com.oimchat.server.general.kernel.work.module.base.group.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupInviteVerifyQuery;
import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupJoinApplyQuery;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupInviteApply;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupJoinApply;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupMember;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;
import com.onlyxiahui.extend.query.page.QueryPage;

/**
 * 
 * Date 2019-01-21 12:33:12<br>
 * Description 群管理相关功能
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class GroupManageDAO extends BaseDAO {

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
		sql.append(" select *  from " + EntityUtil.getTableName(GroupJoinApply.class) + " ");
		sql.append(" where ");
		sql.append(" groupId in (");
		sql.append(" select groupId from " + EntityUtil.getTableName(GroupMember.class) + " where ");
		sql.append(" userId=:userId ");
		sql.append(" and ( position =:admin or position =:owner )");
		sql.append(" ) ");
		List<GroupJoinApply> list = this.queryListBySql(sql.toString(), queryWrapper, GroupJoinApply.class, null);
		page.setTotalCount(qp.getTotalCount());
		page.setTotalPage(qp.getTotalPage());
		return list;
	}

	public List<GroupJoinApply> queryJoinRequestList(String userId, GroupJoinApplyQuery query, Page page) {
		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage qp = queryWrapper.setPage(page.getNumber(), page.getSize());
		queryWrapper.put("userId", userId);
		queryWrapper.put("admin", GroupMember.position_admin);
		queryWrapper.put("owner", GroupMember.position_owner);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from " + EntityUtil.getTableName(GroupJoinApply.class) + " ");
		sql.append(" where ");
		sql.append(" groupId in (");
		sql.append(" select groupId from " + EntityUtil.getTableName(GroupMember.class) + " where ");
		sql.append(" userId=:userId ");
		sql.append(" and ( position =:admin or position =:owner )");
		sql.append(" ) ");

		if (null != query) {
			queryWrapper.put("handleType", query.getHandleType());
			if (null != query.getHandleType() && !query.getHandleType().isEmpty()) {
				sql.append(" and handleType =:handleType ");
			}
		}
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
		sql.append(" select *  from " + EntityUtil.getTableName(GroupInviteApply.class) + " ");
		sql.append(" where ");
		sql.append(" groupId in (");
		sql.append(" select groupId from " + EntityUtil.getTableName(GroupMember.class) + " where ");
		sql.append(" userId=:userId ");
		sql.append(" and ( position =:admin or position =:owner )");
		sql.append(" ) ");
		List<GroupInviteApply> list = this.queryListBySql(sql.toString(), queryWrapper, GroupInviteApply.class, null);
		page.setTotalCount(qp.getTotalCount());
		page.setTotalPage(qp.getTotalPage());
		return list;
	}

	public List<GroupInviteApply> queryInviteRequestList(String userId, GroupInviteVerifyQuery query, Page page) {
		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage qp = queryWrapper.setPage(page.getNumber(), page.getSize());
		queryWrapper.put("userId", userId);
		queryWrapper.put("admin", GroupMember.position_admin);
		queryWrapper.put("owner", GroupMember.position_owner);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from " + EntityUtil.getTableName(GroupInviteApply.class) + " ");
		sql.append(" where ");
		sql.append(" groupId in (");
		sql.append(" select groupId from " + EntityUtil.getTableName(GroupMember.class) + " where ");
		sql.append(" userId=:userId ");
		sql.append(" and ( position =:admin or position =:owner )");
		sql.append(" ) ");

		if (null != query) {
			queryWrapper.put("verifyHandleType", query.getVerifyHandleType());
			if (null != query.getVerifyHandleType() && !query.getVerifyHandleType().isEmpty()) {
				sql.append(" and verifyHandleType=:verifyHandleType ");
			}
		}
		List<GroupInviteApply> list = this.queryListBySql(sql.toString(), queryWrapper, GroupInviteApply.class, null);
		page.setTotalCount(qp.getTotalCount());
		page.setTotalPage(qp.getTotalPage());
		return list;
	}
}
