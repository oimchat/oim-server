package com.oimchat.server.general.kernel.net.module.system.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oimchat.server.basic.common.data.client.Client;
import com.oimchat.server.basic.common.work.app.SessionEnum;
import com.oimchat.server.basic.definition.auth.business.UserTokenAuthBox;
import com.oimchat.server.basic.definition.auth.business.UserTokenTempBox;
import com.oimchat.server.general.kernel.net.define.session.SocketSessionStoreHandler;
import com.oimchat.server.general.kernel.net.module.system.data.OnlineInfo;
import com.onlyxiahui.aware.basic.work.business.error.ErrorCode;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.framework.net.session.SocketSession;

/**
 * 
 * Date 2019-02-11 21:33:50<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class SocketSessionAuthService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SocketSessionStoreHandler socketSessionStoreHandler;
	@Autowired
	private UserTokenTempBox userTokenTempBox;
	@Autowired
	private UserTokenAuthBox userTokenAuthBox;

	public Info auth(SocketSession socketSession, Client client, String token) {
		Info info = new Info();
		if (socketSession.isAuth()) {
			return info;
		}

		String userId1 = userTokenTempBox.getUserId(token);
		String userId2 = userTokenAuthBox.getUserId(token);

		String userId = userTokenTempBox.getUserId(token);
		if (null != userId1 && !userId1.isEmpty()) {
			String type = null == client ? null : client.getType();
			type = null == type || "".equals(type) ? "0" : type;

			socketSession.addAttribute(SessionEnum.token, token);
			socketSession.setAuth(true);
			socketSession.setKey(userId1);
			socketSession.setTag(type);

			userTokenAuthBox.put(token, userId);
			putUserSession(socketSession, client);
		} else if (null != userId2 && !userId2.isEmpty()) {
			String type = null == client ? null : client.getType();
			type = null == type || "".equals(type) ? "0" : type;

			socketSession.addAttribute(SessionEnum.token, token);
			socketSession.setAuth(true);
			socketSession.setKey(userId2);
			socketSession.setTag(type);

			putUserSession(socketSession, client);
		} else {
			info.addWarning(ErrorCode.business.code("001"), "认证失败！");
		}
		return info;
	}

	private void putUserSession(SocketSession socketSession, Client client) {
		OnlineInfo onlineInfo = new OnlineInfo();
		onlineInfo.setClient(client);
		onlineInfo.setNetAddress(socketSession.getRemoteAddress());
		onlineInfo.setOnlineTimestamp(System.currentTimeMillis());
		socketSessionStoreHandler.put(socketSession, onlineInfo);
	}
}
