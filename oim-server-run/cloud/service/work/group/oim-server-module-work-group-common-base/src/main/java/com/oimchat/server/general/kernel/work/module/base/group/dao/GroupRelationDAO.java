package com.oimchat.server.general.kernel.work.module.base.group.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupRelation;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;

/**
 * 
 * Date 2019-01-20 21:22:56<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class GroupRelationDAO extends BaseDAO {

	/**
	 * 根据用户id获取所有群和群分组关联的相关信息
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GroupRelation> getListByUserId(String userId) {
		StringBuilder hql = new StringBuilder();
		hql.append("select gcm from ");
		hql.append(GroupRelation.class.getName());
		hql.append(" gcm where gcm.userId= '");
		hql.append(userId);
		hql.append("'");
		List<GroupRelation> list = (List<GroupRelation>) this.find(hql.toString());
		return list;
	}

	@SuppressWarnings("unchecked")
	public GroupRelation getByGroupId(String userId, String groupId) {
		GroupRelation gcm = null;
		StringBuilder hql = new StringBuilder();
		hql.append("select gcm from ");
		hql.append(GroupRelation.class.getName());
		hql.append(" gcm where gcm.userId= '");
		hql.append(userId);
		hql.append("'");
		hql.append(" and gcm.groupId= '");
		hql.append(groupId);
		hql.append("'");

		List<GroupRelation> list = (List<GroupRelation>) this.find(hql.toString());
		if (null != list && !list.isEmpty()) {
			gcm = list.get(0);
		}
		return gcm;
	}

	/**
	 * 
	 * Date 2019-01-20 21:13:44<br>
	 * Description 移动群到其它分组
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param groupId
	 * @param categoryId
	 * @return
	 * @since 1.0.0
	 */
	public int updateGroupCategoryId(String userId, String groupId, String categoryId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("userId", userId);
		queryWrapper.put("groupId", groupId);
		queryWrapper.put("categoryId", categoryId);

		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(GroupRelation.class) + " set ");
		sql.append(" categoryId=:categoryId ");
		sql.append(" where ");
		sql.append(" userId=:userId ");
		sql.append(" and groupId=:groupId ");
		int count = this.executeSql(sql.toString(), queryWrapper);
		return count;
	}

	public int updateChangeCategoryId(String userId, String oldCategoryId, String newCategoryId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("userId", userId);
		queryWrapper.put("oldCategoryId", oldCategoryId);
		queryWrapper.put("newCategoryId", newCategoryId);

		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(GroupRelation.class) + " set ");
		sql.append(" categoryId=:newCategoryId ");
		sql.append(" where ");
		sql.append(" userId=:userId ");
		sql.append(" and categoryId=:oldCategoryId ");
		int count = this.executeSql(sql.toString(), queryWrapper);
		return count;
	}

	public int updateRemark(String userId, String groupId, String remark) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("userId", userId);
		queryWrapper.put("groupId", groupId);
		queryWrapper.put("remark", remark);

		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(GroupRelation.class) + " set ");
		sql.append(" remark=:remark ");
		sql.append(" where ");
		sql.append(" userId=:userId ");
		sql.append(" and groupId=:groupId ");
		int count = this.executeSql(sql.toString(), queryWrapper);
		return count;
	}

	/**
	 * 
	 * Date 2019-01-20 20:56:02<br>
	 * Description 退出群
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param groupId
	 * @return
	 * @since 1.0.0
	 */
	public int deleteGroupCategoryMember(String userId, String groupId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("userId", userId);
		queryWrapper.put("groupId", groupId);

		StringBuilder sql = new StringBuilder();
		sql.append(" delete from " + EntityUtil.getTableName(GroupRelation.class) + " ");
		sql.append(" where ");
		sql.append(" userId=:userId ");
		sql.append(" and groupId=:groupId ");
		int count = this.executeSql(sql.toString(), queryWrapper);
		return count;
	}

	public int deleteOutUserIdByGroupId(String groupId, String userId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from " + EntityUtil.getTableName(GroupRelation.class) + " ");
		sql.append(" where groupId=:groupId  and userId <>:userId");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("groupId", groupId);
		queryWrapper.put("userId", userId);
		int i = this.executeSql(sql.toString(), queryWrapper);
		return i;
	}
}
