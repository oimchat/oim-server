package com.oimchat.server.general.kernel.work.module.manage.system.controller;

import java.util.List;

import javax.annotation.Resource;

import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import org.springframework.stereotype.Controller;

import com.oimchat.server.general.kernel.work.module.base.user.entity.User;
import com.oimchat.server.general.kernel.work.module.base.user.type.UserTypeEnum;
import com.oimchat.server.general.kernel.work.module.manage.system.data.Admin;
import com.oimchat.server.general.kernel.work.module.manage.system.data.AdminQuery;
import com.oimchat.server.general.kernel.work.module.manage.system.service.AdminService;
import com.oimchat.server.general.kernel.work.module.manage.user.service.UserService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.bean.ExistInfo;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

import com.onlyxiahui.aware.common.auth.annotation.PermissionMapping;
import com.onlyxiahui.aware.common.auth.type.PermissionType;

/**
 * 系统用户管理<br>
 * date 2018-07-19 09:29:16<br>
 * 
 * @author XiaHui<br>
 * @since
 */
@Controller
@ActionMapping("/manage")
public class AdminController {

	@Resource
	UserService userService;
	@Resource
	AdminService adminService;

	/**
	 * 
	 * 用户列表<br>
	 * Date 2020-06-07 11:35:03<br>
	 * 
	 * @param query
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.grant)
	@ActionMapping("/v1/system/admin/list")
	public PageResult<List<Admin>> list(
			@Define("body.query") AdminQuery query,
			@Define("body.page") Page page) {
		List<Admin> list = adminService.queryList(query, page);
		return new PageResult<>(page, list);
	}

	/**
	 * 
	 * 新增/更新用户<br>
	 * Date 2020-06-07 11:35:20<br>
	 * 
	 * @param user
	 * @param roleIds
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.grant)
	@ActionMapping("/v1/system/admin/add.or.update")
	public ResultBodyMessage<User> addOrUpdate(
			@Define("body.user") User user,
			@Define("body.roleIds") List<String> roleIds) {
		ResultBodyMessage<User> rm = new ResultBodyMessage<>(user);
		user.setType(UserTypeEnum.admin.getCode().toString());
		Info info = adminService.addOrUpdate(user, roleIds);
		rm.setInfo(info);
		return rm;
	}

	/**
	 * 
	 * 获取详情<br>
	 * Date 2020-06-07 11:35:45<br>
	 * 
	 * @param id
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping("/v1/system/admin/get.by.id")
	public Admin get(
			@Define("body.id") String id) {
		Admin user = adminService.getById(id);
		return user;
	}

	/**
	 * 
	 * 是否已经存在<br>
	 * Date 2020-06-07 11:35:51<br>
	 * 
	 * @param id
	 * @param account
	 * @param email
	 * @param mobile
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping("/v1/system/admin/is.exist")
	public ExistInfo isExist(
			@Define("body.id") String id,
			@Define("body.account") String account,
			@Define("body.email") String email,
			@Define("body.mobile") String mobile) {
		boolean isExist = false;

		if (StringUtil.isNotBlank(account)) {
			isExist = userService.isExistAccount(id, account);
		}
		if (!isExist && StringUtil.isNotBlank(email)) {
			isExist = userService.isExistEmail(id, email);
		}
		if (!isExist && StringUtil.isNotBlank(mobile)) {
			isExist = userService.isExistMobile(id, mobile);
		}
		return new ExistInfo(isExist);
	}

	/**
	 * 
	 * 加载详情<br>
	 * Date 2020-06-07 11:35:57<br>
	 * 
	 * @param id
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping("/v1/system/admin/load.by.id")
	public Admin loadById(
			@Define("body.id") String id) {
		Admin user = adminService.getById(id);
		return user;
	}

	/**
	 * 
	 * 修改密码<br>
	 * Date 2020-06-07 11:36:01<br>
	 * 
	 * @param userId
	 * @param password
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.grant)
	@ActionMapping("/v1/system/admin/update.password")
	public ResultMessage updatePassword(
			@Define("body.id") String userId,
			@Define("body.password") String password) {
		ResultMessage rm = new ResultMessage();
		String text = "";
		boolean mark = true;
		if (null == password || "".equals(password)) {
			mark = false;
			text = ("密码不能为空！");
		}
		if (mark) {
			mark = userService.updatePassword(userId, password);
			text = mark ? ("修改成功！") : ("修改失败！");
		}
		if (!mark) {
			rm.addWarning("001", text);
		}
		return rm;
	}

	/**
	 * 
	 * 启用/禁用<br>
	 * Date 2020-06-07 11:36:13<br>
	 * 
	 * @param userId
	 * @param isDisable
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.grant)
	@ActionMapping("/v1/system/admin/update.is.disable")
	public ResultMessage updateIsDisable(
			@Define("body.id") String userId,
			@Define("body.isDisable") Integer isDisable) {
		ResultMessage rm = new ResultMessage();
		String text = "";
		int count = userService.updateIsDisable(userId, isDisable);
		boolean mark = count > 0;
		text = mark ? ("修改成功！") : ("修改失败！");
		if (!mark) {
			rm.addWarning("001", text);
		}
		return rm;
	}

	/**
	 * 
	 * 取消管理员<br>
	 * Date 2020-06-07 11:36:08<br>
	 * 
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.grant)
	@ActionMapping("/v1/system/admin/set.to.general")
	public ResultMessage setToGeneral(
			@Define("body.id") String userId) {
		ResultMessage rm = new ResultMessage();
		String text = "";
		boolean mark = userService.updateType(userId, UserTypeEnum.general.getCode().toString());
		text = mark ? ("修改成功！") : ("修改失败！");
		if (!mark) {
			rm.addWarning("001", text);
		}
		return rm;
	}
}
