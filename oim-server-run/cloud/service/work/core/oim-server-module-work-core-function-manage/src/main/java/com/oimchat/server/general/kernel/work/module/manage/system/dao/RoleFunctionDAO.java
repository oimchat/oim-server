package com.oimchat.server.general.kernel.work.module.manage.system.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.manage.system.entity.RoleFunction;
import com.onlyxiahui.aware.basic.dao.BaseEntityDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;

/*
 * 
 */
@Repository
public class RoleFunctionDAO extends BaseEntityDAO<RoleFunction> {

	public List<RoleFunction> getListByRoleIds(List<String> roleIds) {
		if (null == roleIds || roleIds.isEmpty()) {
			return new ArrayList<>();
		}
		String sql = "select * from " + EntityUtil.getTableName(RoleFunction.class) + " where roleId in( :roleIds )";
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("roleIds", roleIds);
		List<RoleFunction> list = this.queryListBySql(sql, queryWrapper, RoleFunction.class, null);
		return list;
	}

	public List<RoleFunction> getListByRoleId(String roleId) {
		String sql = "select * from " + EntityUtil.getTableName(RoleFunction.class) + " where roleId = :roleId";
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("roleId", roleId);
		List<RoleFunction> list = this.queryListBySql(sql, queryWrapper, RoleFunction.class, null);
		return list;
	}

	public int deleteByRoleId(String roleId) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from " + EntityUtil.getTableName(RoleFunction.class) + " where roleId= :roleId");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("roleId", roleId);
		return this.executeSql(sql.toString(), queryWrapper);
	}

	public int deleteByFunctionId(String functionId) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from " + EntityUtil.getTableName(RoleFunction.class) + " where functionId = :functionId");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("functionId", functionId);
		return this.executeSql(sql.toString(), queryWrapper);
	}
}
