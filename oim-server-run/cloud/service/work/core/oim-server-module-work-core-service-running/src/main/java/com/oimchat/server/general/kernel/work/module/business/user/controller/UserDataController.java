package com.oimchat.server.general.kernel.work.module.business.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;
import com.oimchat.server.general.kernel.work.module.business.user.service.UserService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 
 * Description <br>
 * Date 2020-05-17 19:58:43<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Controller
@ActionMapping("")
public class UserDataController {

	@Resource
	UserService userService;

	@ActionMapping("/v1/user/user.data/get.by.id")
	public UserData get(
			@Define("body.id") String id) {
		UserData user = userService.getUserDataById(id);
		return user;
	}
}
