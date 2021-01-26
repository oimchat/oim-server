package com.oimchat.server.general.kernel.work.module.base.group.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupJoinSetting;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;

/**
 * 
 * Date 2019-01-22 22:21:50<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class GroupJoinSettingDAO extends BaseDAO {

	public GroupJoinSetting get(String id) {
		return this.get(GroupJoinSetting.class, id);
	}

	public GroupJoinSetting getByGroupId(String groupId) {
		GroupJoinSetting bean = null;

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("groupId", groupId);

		String sql = "select * from " + EntityUtil.getTableName(GroupJoinSetting.class) + " where groupId=:groupId";
		List<GroupJoinSetting> list = this.queryListBySql(sql, queryWrapper, GroupJoinSetting.class, null);

		if (null != list && !list.isEmpty()) {
			bean = list.get(0);
		}
		return bean;
	}

	public String getIdByGroupId(String groupId) {
		String id = null;

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("groupId", groupId);

		String sql = "select id from " + EntityUtil.getTableName(GroupJoinSetting.class) + " where groupId=:groupId";
		List<String> list = this.queryListBySql(sql, queryWrapper, String.class, null);

		if (null != list && !list.isEmpty()) {
			id = list.get(0);
		}
		return id;
	}

	public <T> T getByGroupId(String groupId, Class<T> clazz) {
		T bean = null;

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("groupId", groupId);

		String sql = "select * from " + EntityUtil.getTableName(GroupJoinSetting.class) + " where groupId=:groupId";
		List<T> list = this.queryListBySql(sql, queryWrapper, clazz, null);

		if (null != list && !list.isEmpty()) {
			bean = list.get(0);
		}
		return bean;
	}
}
