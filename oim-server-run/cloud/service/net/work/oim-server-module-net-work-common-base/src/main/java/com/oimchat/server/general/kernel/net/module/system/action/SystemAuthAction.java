package com.oimchat.server.general.kernel.net.module.system.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.data.client.Client;
import com.oimchat.server.general.kernel.net.module.system.service.SocketSessionAuthService;
import com.onlyxiahui.aware.common.auth.annotation.PermissionMapping;
import com.onlyxiahui.aware.common.auth.type.PermissionType;
// import com.onlyxiahui.common.annotation.action.MethodMapping;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.framework.net.session.SocketSession;

/**
 * 安全业务接口<br>
 * Date 2019-01-20 19:12:16<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey net
 */
@Component
@ActionMapping(value = "1.0.002")
public class SystemAuthAction {

	@Resource
	SocketSessionAuthService socketSessionAuthService;

	/**
	 * 
	 * 连接认证<br>
	 * Date 2020-04-14 09:09:52<br>
	 * 
	 * @param socketSession
	 * @param client
	 * @param token
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.skip)
	// @MethodMapping(value = "", isIntercept = false)
	@ActionMapping(value = "1.1.0001")
	public Object auth(
			SocketSession socketSession,
			@Define("body.client") Client client,
			@Define("body.token") String token) {
		Info info = socketSessionAuthService.auth(socketSession, client, token);
		return info;
	}
}
