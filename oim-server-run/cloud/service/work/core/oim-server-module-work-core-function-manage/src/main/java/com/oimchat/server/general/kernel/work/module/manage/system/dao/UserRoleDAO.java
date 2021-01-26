package com.oimchat.server.general.kernel.work.module.manage.system.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.manage.system.data.UserRoleInfo;
import com.oimchat.server.general.kernel.work.module.manage.system.entity.UserRole;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;

/**
 * 
 * date 2018-07-12 11:00:00<br>
 * description
 * 
 * @author XiaHui<br>
 * @since
 */
@Repository
public class UserRoleDAO extends BaseDAO {

	String namespace = "system.userRole";

	public void delete(String id) {
		this.deleteById(UserRole.class, id);
	}

	public List<UserRole> getListByUserId(String userId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("userId", userId);
		List<UserRole> list = this.queryListByName(namespace + ".getListByUserId", queryWrapper, UserRole.class);
		return list;
	}

	public List<UserRole> getListByUserIds(List<String> userIds) {
		QueryWrapper map = new QueryWrapper();
		map.put("userIds", userIds);
		List<UserRole> list = this.queryListByName(namespace + ".getListByUserIds", map, UserRole.class);
		return list;
	}

	public void deleteByUserId(String userId) {
		QueryWrapper map = new QueryWrapper();
		map.put("userId", userId);

		StringBuilder sql = new StringBuilder();
		sql.append("delete from " + EntityUtil.getTableName(UserRole.class) + " where userId= :userId");
		this.executeSql(sql.toString(), map);
	}

	public void deleteByRoleId(String roleId) {

		QueryWrapper map = new QueryWrapper();
		map.put("roleId", roleId);

		StringBuilder sql = new StringBuilder();
		sql.append("delete from " + EntityUtil.getTableName(UserRole.class) + " where roleId= :roleId");
		this.executeSql(sql.toString(), map);
	}

	public List<UserRoleInfo> getUserRoleInfoListByUserIds(List<String> userIds) {
		if (null == userIds || userIds.isEmpty()) {
			return new ArrayList<>();
		}
		QueryWrapper map = new QueryWrapper();
		map.put("userIds", userIds);
		List<UserRoleInfo> list = this.queryListByName(namespace + ".getUserRoleInfoListByUserIds", map, UserRoleInfo.class);
		return list;
	}
}
