package com.oimchat.server.general.kernel.work.module.manage.system.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.manage.system.entity.Role;
import com.onlyxiahui.aware.basic.dao.BaseEntityDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;

/**
 * 
 * date 2018-07-12 10:32:12<br>
 * description
 * 
 * @author XiaHui<br>
 * @since
 */
@Repository
public class RoleDAO extends BaseEntityDAO<Role> {

	String namespace = "system.role";

	public List<Role> queryList(QueryWrapper map) {
		List<Role> list = this.queryListByName(namespace + ".queryList", map, Role.class);
		return list;
	}

	public List<Role> getListByIds(List<String> ids) {
		if (null == ids || ids.isEmpty()) {
			return new ArrayList<>();
		}
		QueryWrapper map = new QueryWrapper();
		map.put("ids", ids);
		List<Role> list = this.queryListByName(namespace + ".queryList", map, Role.class);
		return list;
	}

	public List<Role> getListByOutIds(List<String> outIds) {
		QueryWrapper map = new QueryWrapper();
		map.put("outIds", outIds);
		List<Role> list = this.queryListByName(namespace + ".queryList", map, Role.class);
		return list;
	}
}
