/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oimchat.server.general.kernel.work.module.manage.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;

import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.oimchat.server.general.kernel.work.module.manage.portal.data.ServerDeployType;
import com.onlyxiahui.aware.common.auth.annotation.PermissionMapping;
import com.onlyxiahui.aware.common.auth.type.PermissionType;

/**
 * 服务器入口<br>
 * 
 * @author XiaHui
 * @docModuleSuperKey portal
 */
@Controller
@ActionMapping
public class ServerDeployController {

	@Autowired
	private Environment environment;

	/**
	 * 获取服务器部署信息<br>
	 * Date 2017-11-26 09:12:37<br>
	 * 
	 * @author XiaHui
	 * @return
	 */
	@PermissionMapping(type = PermissionType.auth)
	@ActionMapping("/portal/v1/config/server/deploy.info")
	public ServerDeployType deployType() {
		String key = "server.type";
		String value = environment.getProperty(key);
		return new ServerDeployType(value);
	}
}
