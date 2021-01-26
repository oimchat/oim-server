package com.oimchat.server.general.kernel.net.module.control.action;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import com.oimchat.server.cloud.net.basic.bean.ServerInfo;
import com.oimchat.server.general.kernel.net.module.control.service.SessionService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.framework.net.session.SocketSession;

/**
 * 
 * @author XiaHui
 * @date 2018-04-30 08:00:14
 */
@RestController
@ActionMapping(value = "service.1.001")
public class RegisterAction {

	@Resource
	private SessionService sessionService;

	@ActionMapping(value = "1.1.0001")
	public ResultMessage auth(
			SocketSession socketSession,
			@Define("body") ServerInfo serverInfo) {
		ResultMessage message = sessionService.auth(socketSession, serverInfo);
		return message;
	}
}
