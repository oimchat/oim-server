package com.oimchat.server.general.kernel.work.module.manage.index.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.manage.index.data.LoginResult;
import com.oimchat.server.general.kernel.work.module.manage.index.service.IndexService;
import com.oimchat.server.general.kernel.work.module.manage.system.entity.Function;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.data.ListBody;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

import com.onlyxiahui.aware.common.auth.annotation.PermissionMapping;
import com.onlyxiahui.aware.common.auth.type.PermissionType;

/**
 * 系统入口<br>
 * Date 2018-06-04 14:59:44<br>
 * 
 * @author XiaHui<br>
 * @since
 */
@RestController
@ActionMapping("/manage")
public class IndexController {

	@Resource
	IndexService indexService;

	/**
	 * 
	 * 登录<br>
	 * Date 2020-06-07 11:32:33<br>
	 * 
	 * @param account
	 * @param password
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.skip)
	@ActionMapping("/v1/home/enter/login")
	public ResultBodyMessage<LoginResult> login(
			@Define("body.account") String account,
			@Define("body.password") String password) {
		ResultBodyMessage<LoginResult> rm = indexService.login(account, password);
		return rm;
	}

	/**
	 * 
	 * 加载权限<br>
	 * Date 2020-06-07 11:32:45<br>
	 * 
	 * @param userSession
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.auth)
	@ActionMapping("/v1/home/enter/function.list")
	public ListBody<List<Function>> getFunctionList(
			UserSession userSession) {
		String userId = userSession.getUserId();
		String token = userSession.getToken();
		List<Function> list = indexService.getFunctionList(userId, token);
		return new ListBody<>(list);
	}
}
