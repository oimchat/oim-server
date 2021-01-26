package com.oimchat.server.general.kernel.core.action.module.action.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.oimchat.server.general.kernel.core.action.module.action.data.dto.ServerData;
import com.oimchat.server.general.kernel.core.action.module.action.entity.ServerActionInfo;
import com.oimchat.server.general.kernel.core.action.module.action.service.ServerActionInfoExtendService;
import com.oimchat.server.general.kernel.core.action.module.action.service.ServerActionInfoService;
import com.onlyxiahui.common.action.description.annotation.DocModule;
import com.onlyxiahui.common.action.description.annotation.DocTitle;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 
 * 服务的Action信息<br>
 * Date 2020-11-08 18:55:40<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]
 * @since 1.0.0
 * @docModuleSuperKey manage
 */
@DocTitle("服务的Action信息")
@DocModule(superKey = "manage")
@RestController
public class ServerActionInfoExtendController {

	@Autowired
	ServerActionInfoService serverActionInfoService;

	@Autowired
	ServerActionInfoExtendService serverActionInfoExtendService;

	/**
	 * 注册Action
	 * 
	 * @param query
	 * @param page
	 * @return Info
	 * @since 1.0.0
	 */
	@DocTitle("注册Action")
	@ActionMapping("/v1/action/server.action.info/register")
	public Info register(
			@Define("body.items") List<ServerActionInfo> items,
			@Define("body.page") Page page,
			@Define("body.server") ServerData serverData) {

		serverActionInfoExtendService.register(serverData, items);
		return new Info();
	}
}