package com.oimchat.server.general.kernel.system.module.setting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.oimchat.server.general.kernel.system.module.setting.data.MultipleCheck;
import com.oimchat.server.general.kernel.system.module.setting.service.MultipleOnlineStrategyService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 
 * Description <br>
 * Date 2020-05-15 10:45:33<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@RestController
@ActionMapping
public class MultipleOnlineStrategyController {

	@Autowired
	MultipleOnlineStrategyService multipleOnlineStrategyService;

	@ActionMapping(value = "/v1/setting/multiple.online.strategy/multiple.check")
	public MultipleCheck multipleCheck(
			@Define("body.type") String type) {
		boolean multiple = multipleOnlineStrategyService.isMultiple(type);
		MultipleCheck mc = new MultipleCheck();
		mc.setMultiple(multiple);
		return mc;
	}
}
