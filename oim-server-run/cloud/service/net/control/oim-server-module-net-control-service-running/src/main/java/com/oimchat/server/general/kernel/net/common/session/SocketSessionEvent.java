package com.oimchat.server.general.kernel.net.common.session;

import com.onlyxiahui.framework.net.session.SocketSession;

/**
 * <br>
 * Date 2020-11-16 08:55:38<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public interface SocketSessionEvent {

	void online(SocketSession socketSession);

	void offline(SocketSession socketSession);

	void close(SocketSession socketSession);
}
