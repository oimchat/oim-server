/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oimchat.server.general.kernel.work.module.business.portal.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.oimchat.server.general.kernel.work.module.base.portal.data.ServerData;
import com.oimchat.server.general.kernel.work.module.business.portal.service.ServerService;
import com.onlyxiahui.common.data.common.data.ListBody;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

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
public class ServerController {

	@Resource
	private ServerService serverService;

	/**
	 * 获取服务器地址列表<br>
	 * Date 2017-11-26 09:12:37<br>
	 * 
	 * @author XiaHui
	 * @return
	 */
	@PermissionMapping(type = PermissionType.skip)
	@ActionMapping("/v1/portal/server/address.list")
	public ResultBodyMessage<ListBody<List<ServerData>>> serverAddressList() {
		List<ServerData> list = serverService.getServerDataList();
		ResultBodyMessage<ListBody<List<ServerData>>> rm = new ResultBodyMessage<>(new ListBody<>(list));
		return rm;
	}
}
