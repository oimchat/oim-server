package com.oimchat.server.general.kernel.net.module.portal.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import com.oimchat.server.general.kernel.net.module.portal.config.ServerConfig;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * date 2018-06-04 14:59:44<br>
 * description个人中心
 * 
 * @author XiaHui<br>
 * @since
 */
@RestController
@ActionMapping("")
public class PortalController {

	@Resource
	ServerConfig serverConfig;

	@ActionMapping("/v1/portal/server/get.config")
	public ServerConfig getConfig() {
		return serverConfig;
	}
}
