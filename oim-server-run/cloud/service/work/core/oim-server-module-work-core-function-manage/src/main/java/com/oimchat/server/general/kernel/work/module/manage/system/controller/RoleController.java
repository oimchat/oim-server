package com.oimchat.server.general.kernel.work.module.manage.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.oimchat.server.general.kernel.work.module.manage.system.data.RoleQuery;
import com.oimchat.server.general.kernel.work.module.manage.system.entity.Role;
import com.oimchat.server.general.kernel.work.module.manage.system.entity.RoleFunction;
import com.oimchat.server.general.kernel.work.module.manage.system.service.RoleService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 角色管理<br>
 * date 2018-06-04 14:59:44<br>
 * 
 * @author XiaHui<br>
 * @since
 */
@RestController
@ActionMapping("")
public class RoleController {

	@Autowired
	RoleService roleService;

	/**
	 * 
	 * 列表<br>
	 * Date 2020-06-07 11:39:52<br>
	 * 
	 * @param query
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping("/v1/system/role/list")
	public PageResult<List<Role>> list(
			@Define("body.query") RoleQuery query,
			@Define("body.page") Page page) {
		List<Role> list = roleService.queryList(query, page);
		return new PageResult<List<Role>>(page, list);
	}

	/**
	 * 
	 * 新增/更新<br>
	 * Date 2020-06-07 11:39:57<br>
	 * 
	 * @param role
	 * @param menuIds
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping("/v1/system/role/add.or.update")
	public Role addOrUpdate(
			@Define("body.role") Role role,
			@Define("body.functionIds") List<String> menuIds) {
		roleService.addOrUpdate(role, menuIds);
		return role;
	}

	/**
	 * 
	 * 获取详情<br>
	 * Date 2020-06-07 11:40:15<br>
	 * 
	 * @param id
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping("/v1/system/role/get.by.id")
	public Role get(
			@Define("body.id") String id) {
		Role role = roleService.getRole(id);
		return role;
	}

	/**
	 * 
	 * 删除<br>
	 * Date 2020-06-07 11:40:11<br>
	 * 
	 * @param id
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping("/v1/system/role/delete.by.id")
	public ResultMessage deleteById(
			@Define("body.id") String id) {
		ResultMessage rm = new ResultMessage();
		roleService.delete(id);
		return rm;
	}

	/**
	 * 
	 * 所有列表<br>
	 * Date 2020-06-07 11:40:06<br>
	 * 
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping("/v1/system/role/all.list")
	public List<Role> allList() {
		List<Role> list = roleService.allList();
		return list;
	}

	/**
	 * 
	 * 角色拥有权限<br>
	 * Date 2020-06-07 11:40:02<br>
	 * 
	 * @param id
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping("/v1/system/role/role.function.list")
	public List<RoleFunction> roleFunctionList(
			@Define("body.id") String id) {
		List<RoleFunction> list = roleService.getRoleMenuListByRoleId(id);
		return list;
	}
}
