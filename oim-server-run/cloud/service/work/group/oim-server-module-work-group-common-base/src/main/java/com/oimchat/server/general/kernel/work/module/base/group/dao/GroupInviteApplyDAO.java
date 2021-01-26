package com.oimchat.server.general.kernel.work.module.base.group.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupInviteeApplyQuery;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupInviteApply;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;
import com.onlyxiahui.extend.query.page.QueryPage;

/**
 * 
 * Date 2019-01-20 11:52:08<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class GroupInviteApplyDAO extends BaseDAO {

	public GroupInviteApply get(String id) {
		return this.get(GroupInviteApply.class, id);
	}

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	public void delete(String id) {
		this.deleteById(GroupInviteApply.class, id);
	}

	public List<GroupInviteApply> getListByGroupId(String groupId, Page page) {
		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage qp = queryWrapper.setPage(page.getNumber(), page.getSize());
		queryWrapper.put("groupId", groupId);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from " + EntityUtil.getTableName(GroupInviteApply.class) + " ");
		sql.append(" where ");
		sql.append(" groupId=:groupId ");
		List<GroupInviteApply> list = this.queryListBySql(sql.toString(), queryWrapper, GroupInviteApply.class, null);
		page.setTotalCount(qp.getTotalCount());
		page.setTotalPage(qp.getTotalPage());
		return list;
	}

	/**
	 * 
	 * Description 获取未处理列表 <br>
	 * Date 2019-06-13 08:55:48<br>
	 * 
	 * @param groupId
	 * @param userIds
	 * @return List<GroupInviteApply>
	 * @since 1.0.0
	 */
	public List<GroupInviteApply> getUntreatedListByInviteeUserIds(String groupId, List<String> userIds) {
		if (null == userIds || userIds.isEmpty()) {
			return new ArrayList<>();
		}
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("groupId", groupId);
		queryWrapper.put("verifyHandleType", GroupInviteApply.verify_handle_type_untreated);
		queryWrapper.put("inviteeHandleType", GroupInviteApply.invitee_handle_type_untreated);
		queryWrapper.put("userIds", userIds);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from " + EntityUtil.getTableName(GroupInviteApply.class) + " ");
		sql.append(" where ");
		sql.append(" groupId=:groupId ");
		sql.append(" and inviteeUserId in ( :userIds ) ");
		sql.append(" and ( verifyHandleType=:verifyHandleType or inviteeHandleType=:inviteeHandleType ) ");
		List<GroupInviteApply> list = this.queryListBySql(sql.toString(), queryWrapper, GroupInviteApply.class, null);
		return list;
	}

	/**
	 * 
	 * Date 2019-01-27 10:15:05<br>
	 * Description 获取个人被邀请加入群的信息列表（管理员/群主已经同意）
	 * 
	 * @author XiaHui<br>
	 * @param inviteeUserId
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	public List<GroupInviteApply> getListByInviteeUserId(String inviteeUserId, Page page) {
		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage qp = queryWrapper.setPage(page.getNumber(), page.getSize());
		queryWrapper.put("inviteeUserId", inviteeUserId);
		queryWrapper.put("verifyHandleType", GroupInviteApply.verify_handle_type_accept);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from " + EntityUtil.getTableName(GroupInviteApply.class) + " ");
		sql.append(" where ");
		sql.append(" inviteeUserId=:inviteeUserId ");
		sql.append(" and verifyHandleType=:verifyHandleType ");
		List<GroupInviteApply> list = this.queryListBySql(sql.toString(), queryWrapper, GroupInviteApply.class, null);
		page.setTotalCount(qp.getTotalCount());
		page.setTotalPage(qp.getTotalPage());
		return list;
	}

	public List<GroupInviteApply> queryInviteeList(String inviteeUserId, GroupInviteeApplyQuery query, Page page) {
		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage qp = queryWrapper.setPage(page.getNumber(), page.getSize());
		queryWrapper.put("inviteeUserId", inviteeUserId);
		queryWrapper.put("verifyHandleType", GroupInviteApply.verify_handle_type_accept);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from " + EntityUtil.getTableName(GroupInviteApply.class) + " ");
		sql.append(" where ");
		sql.append(" inviteeUserId=:inviteeUserId ");
		sql.append(" and verifyHandleType=:verifyHandleType ");
		if (null != query) {
			queryWrapper.put("inviteeHandleType", query.getInviteeHandleType());
			if (null != query.getInviteeHandleType() && !query.getInviteeHandleType().isEmpty()) {
				sql.append(" and inviteeHandleType=:inviteeHandleType ");
			}
		}
		List<GroupInviteApply> list = this.queryListBySql(sql.toString(), queryWrapper, GroupInviteApply.class, null);
		page.setTotalCount(qp.getTotalCount());
		page.setTotalPage(qp.getTotalPage());
		return list;
	}
}
