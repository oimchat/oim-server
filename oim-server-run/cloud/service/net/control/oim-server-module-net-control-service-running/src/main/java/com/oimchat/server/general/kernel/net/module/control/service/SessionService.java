package com.oimchat.server.general.kernel.net.module.control.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.cloud.net.basic.bean.ServerInfo;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.framework.net.session.SocketSession;
import com.onlyxiahui.wofa.server.net.core.session.SocketSessionHandler;

/**
 * @author Only
 * @date 2016年5月20日 上午11:45:04
 */
@Service
@Transactional
public class SessionService {

	@Resource
	SocketSessionHandler socketSessionHandler;

	public ResultMessage auth(SocketSession socketSession, ServerInfo serverInfo) {
		socketSession.setAuth(true);
		socketSession.setKey(serverInfo.getId());
		putSocketSession(socketSession);
		ResultMessage message = new ResultMessage();
		return message;
	}

	private void putSocketSession(SocketSession socketSession) {
		socketSessionHandler.sessionPut(socketSession);
	}
}
