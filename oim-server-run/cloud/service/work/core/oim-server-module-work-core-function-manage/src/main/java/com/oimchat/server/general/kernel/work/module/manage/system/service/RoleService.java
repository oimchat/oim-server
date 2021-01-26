package com.oimchat.server.general.kernel.work.module.manage.system.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.manage.system.dao.RoleDAO;
import com.oimchat.server.general.kernel.work.module.manage.system.dao.RoleFunctionDAO;
import com.oimchat.server.general.kernel.work.module.manage.system.dao.UserRoleDAO;
import com.oimchat.server.general.kernel.work.module.manage.system.data.RoleQuery;
import com.oimchat.server.general.kernel.work.module.manage.system.entity.Role;
import com.oimchat.server.general.kernel.work.module.manage.system.entity.RoleFunction;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.utils.base.util.time.DateUtil;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;

/**
 * 
 * date 2018-07-12 11:15:01<br>
 * description
 * 
 * @author XiaHui<br>
 * @since
 */
@Service
@Transactional
public class RoleService {

	@Resource
	RoleDAO roleDAO;
	@Resource
	RoleFunctionDAO roleFunctionDAO;
	@Resource
	UserRoleDAO userRoleDAO;

	public Role getRole(String id) {
		id = (null == id) ? "" : id;
		return roleDAO.getById(id);
	}

	public void addOrUpdate(Role role, List<String> menuIds) {
		if (null == role.getId() || "".equals(role.getId())) {
			role.setCreatedDateTime(DateUtil.getCurrentDateTime());
			roleDAO.save(role);
		} else {
			roleDAO.updateSelective(role);
		}
		String roleId = role.getId();
		addOrUpdate(roleId, menuIds);
	}

	public void addOrUpdate(String roleId, List<String> menuIds) {
		List<RoleFunction> rmList = roleFunctionDAO.getListByRoleId(roleId);

		List<RoleFunction> deleteList = new ArrayList<RoleFunction>();
		Map<String, RoleFunction> map = new HashMap<String, RoleFunction>();
		for (RoleFunction rm : rmList) {
			if (map.containsKey(rm.getFunctionId())) {
				deleteList.add(rm);
			}
			map.put(rm.getFunctionId(), rm);
		}

		List<RoleFunction> addList = new ArrayList<RoleFunction>();
		if (null != menuIds) {
			for (String menuId : menuIds) {
				RoleFunction rm = map.remove(menuId);
				if (null == rm) {
					rm = new RoleFunction();
					rm.setRoleId(roleId);
					rm.setFunctionId(menuId);
					addList.add(rm);
				}
			}
		}
		deleteList.addAll(map.values());
		if (!addList.isEmpty()) {
			for (RoleFunction rm : addList) {
				roleFunctionDAO.save(rm);
			}
		}
		if (!deleteList.isEmpty()) {
			for (RoleFunction rm : deleteList) {
				roleFunctionDAO.deleteById(rm.getId());
			}
		}
	}

	public void delete(String id) {
		roleDAO.deleteById(id);
		roleFunctionDAO.deleteByRoleId(id);
		userRoleDAO.deleteByRoleId(id);
	}

	public List<Role> queryList(RoleQuery query, Page page) {
		List<Role> list = roleDAO.list(query, page);
		return list;
	}

	public List<Role> allList() {
		QueryWrapper map = new QueryWrapper();
		List<Role> roleList = roleDAO.queryList(map);
		return roleList;
	}

	public List<RoleFunction> getRoleMenuListByRoleId(String roleId) {
		List<RoleFunction> rmList = roleFunctionDAO.getListByRoleId(roleId);
		return rmList;
	}
}
