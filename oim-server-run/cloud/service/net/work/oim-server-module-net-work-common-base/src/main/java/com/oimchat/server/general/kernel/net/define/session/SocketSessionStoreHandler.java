package com.oimchat.server.general.kernel.net.define.session;

import com.oimchat.server.general.kernel.net.module.system.data.OnlineInfo;
import com.onlyxiahui.framework.net.session.SocketSession;

/**
 * Date 2018-03-01 11:15:11<br>
 * 
 * @author: XiaHui
 */
public interface SocketSessionStoreHandler {

	public void put(SocketSession socketSession, OnlineInfo onlineInfo);

	public boolean has(String key);

	public void remove(SocketSession socketSession);
}
