package com.oimchat.server.general.kernel.work.module.base.group.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupJoinVerifyAnswer;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;

/**
 * 
 * @author: XiaHui
 * @date 2018-04-25 09:04:49
 */
@Repository
public class GroupJoinVerifyAnswerDAO extends BaseDAO {

	public GroupJoinVerifyAnswer get(String id) {
		return this.get(GroupJoinVerifyAnswer.class, id);
	}

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	public void delete(String id) {
		this.deleteById(GroupJoinVerifyAnswer.class, id);
	}

	public List<GroupJoinVerifyAnswer> getListByGroupId(String groupId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("groupId", groupId);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from " + EntityUtil.getTableName(GroupJoinVerifyAnswer.class) + " ");
		sql.append(" where ");
		sql.append(" groupId=:groupId ");
		List<GroupJoinVerifyAnswer> list = this.queryListBySql(sql.toString(), queryWrapper, GroupJoinVerifyAnswer.class, null);
		return list;
	}

	public List<GroupJoinVerifyAnswer> getListByApplyId(String groupId, String applyId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("groupId", groupId);
		queryWrapper.put("applyId", applyId);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from " + EntityUtil.getTableName(GroupJoinVerifyAnswer.class) + " ");
		sql.append(" where ");
		sql.append(" groupId=:groupId ");
		sql.append(" and applyId=:applyId ");
		List<GroupJoinVerifyAnswer> list = this.queryListBySql(sql.toString(), queryWrapper, GroupJoinVerifyAnswer.class, null);
		return list;
	}

	public List<GroupJoinVerifyAnswer> getListByApplyIds(List<String> groupIds, List<String> applyIds) {
		if (null == applyIds || applyIds.isEmpty()) {
			return new ArrayList<>();
		}
		if (null == groupIds || groupIds.isEmpty()) {
			return new ArrayList<>();
		}
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("groupIds", groupIds);
		queryWrapper.put("applyIds", applyIds);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from " + EntityUtil.getTableName(GroupJoinVerifyAnswer.class) + " ");
		sql.append(" where ");
		sql.append(" groupId in( :groupIds )");
		sql.append(" and applyId in( :applyIds) ");
		List<GroupJoinVerifyAnswer> list = this.queryListBySql(sql.toString(), queryWrapper, GroupJoinVerifyAnswer.class, null);
		return list;
	}
}
