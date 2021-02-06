
package com.oimchat.server.general.kernel.net.impl.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.basic.definition.session.SocketSessionStore;
import com.oimchat.server.general.kernel.net.define.session.SocketSessionStoreHandler;
import com.oimchat.server.general.kernel.net.module.system.data.OnlineInfo;
import com.oimchat.server.general.kernel.net.module.system.function.SocketSessionFunction;
import com.oimchat.server.general.kernel.system.module.setting.manager.MultipleOnlineStrategyManager;
import com.onlyxiahui.framework.net.session.SocketSession;
import com.onlyxiahui.wofa.server.net.core.session.SocketSessionHandler;

/**
 * Description <br>
 * Date 2020-04-13 11:09:02<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class SocketSessionStoreHandlerImpl implements SocketSessionStoreHandler, SocketSessionStore {

	@Autowired
	SocketSessionHandler socketSessionHandler;
	@Autowired
	MultipleOnlineStrategyManager multipleOnlineStrategyManager;
	@Autowired
	SocketSessionFunction socketSessionFunction;

	@Override
	public void put(SocketSession socketSession, OnlineInfo onlineInfo) {
		if (null == socketSession.getTag() || socketSession.getTag().isEmpty()) {
			socketSession.setTag("0");
		}
		String type = socketSession.getTag();
		String key = socketSession.getKey();
		String onlineId = socketSession.getKey();
		boolean isMultiple = multipleOnlineStrategyManager.isMultiple(type);
		String offlineTag = isMultiple ? null : type;
		socketSessionFunction.otherOnline(key, offlineTag, onlineId, onlineInfo);
		socketSessionHandler.sessionPut(socketSession);
	}

	@Override
	public boolean has(String key) {
		return socketSessionHandler.sessionHas(key);
	}

	@Override
	public void remove(SocketSession socketSession) {
		socketSessionHandler.sessionRemove(socketSession);
	}
}
