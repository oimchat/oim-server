package com.oimchat.server.cloud.action.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.cloud.action.register.client.RegisterActionHandlerInvokeSide;
import com.oimchat.server.cloud.action.register.common.config.RegisterActionConfigEnvironment;
import com.oimchat.server.cloud.action.register.data.ServerData;
import com.oimchat.server.cloud.action.register.handler.ActionMappingHandler;
import com.onlyxiahui.common.utils.base.lang.string.StringUtil;

/**
 * Description <br>
 * Date 2021-01-12 17:44:28<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class ActionDataRegisterService {

	@Autowired
	ActionMappingHandler actionMappingHandler;

	@Autowired
	RegisterActionHandlerInvokeSide registerActionHandlerInvokeSide;

	@Autowired
	RegisterActionConfigEnvironment registerActionConfigEnvironment;

	public void register() {
		String serviceName = registerActionConfigEnvironment.getServiceName();
		if (StringUtil.isNotBlank(serviceName)) {
			ServerData server = new ServerData();
			server.setServiceName(serviceName);

			actionMappingHandler.laodActionData(list -> {
				registerActionHandlerInvokeSide.push(server, list);
			});
		}
	}
}
