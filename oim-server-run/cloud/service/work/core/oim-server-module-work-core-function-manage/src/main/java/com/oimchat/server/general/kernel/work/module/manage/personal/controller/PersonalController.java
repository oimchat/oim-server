package com.oimchat.server.general.kernel.work.module.manage.personal.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;
import com.oimchat.server.general.kernel.work.module.manage.personal.service.PersonalService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

import com.onlyxiahui.aware.common.auth.annotation.PermissionMapping;
import com.onlyxiahui.aware.common.auth.type.PermissionType;

/**
 * 个人中心<br>
 * date 2018-06-04 14:59:44<br>
 * 
 * @author XiaHui<br>
 * @since
 */
@RestController
@ActionMapping("/manage")
public class PersonalController {

	@Resource
	PersonalService personalService;

	/**
	 * 
	 * 个人信息<br>
	 * Date 2020-06-07 11:33:42<br>
	 * 
	 * @param userSession
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.auth)
	@ActionMapping("/v1/personal/info/get")
	public UserData user(
			UserSession userSession) {
		UserData user = personalService.getUserDataById(userSession.getUserId());
		return user;
	}

	/**
	 * 
	 * 修改密码<br>
	 * Date 2020-06-07 11:33:54<br>
	 * 
	 * @param id
	 * @param newPassword
	 * @param oldPassword
	 * @param userContext
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.auth)
	@ActionMapping("/v1/personal/info/update.password")
	public Info updatePassword(
			@Define("body.id") String id,
			@Define("body.newPassword") String newPassword,
			@Define("body.oldPassword") String oldPassword,
			UserSession userContext) {
		Info info = personalService.updatePassword(userContext.getUserId(), newPassword, oldPassword);
		return info;
	}
}
