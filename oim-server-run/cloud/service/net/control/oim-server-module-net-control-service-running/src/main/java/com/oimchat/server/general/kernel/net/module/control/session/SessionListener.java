package com.oimchat.server.general.kernel.net.module.control.session;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oimchat.server.cloud.net.extend.session.manager.SocketSessionKeyManager;
import com.oimchat.server.general.kernel.net.common.session.SocketSessionEvent;
import com.oimchat.server.general.kernel.net.common.session.SocketSessionListener;
import com.onlyxiahui.framework.net.session.SocketSession;

/**
 * <br>
 * Date 2020-11-14 12:08:14<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Service
public class SessionListener {

	@Autowired
	private SocketSessionListener socketSessionListener;

	@Autowired
	private SocketSessionKeyManager socketSessionKeyManager;

	@PostConstruct
	public void setSocketSessionListener() {
		socketSessionListener.add(new SocketSessionEvent() {

			@Override
			public void online(SocketSession socketSession) {
				// String key = socketSession.getKey();
			}

			@Override
			public void offline(SocketSession socketSession) {
				// String key = socketSession.getKey();
			}

			@Override
			public void close(SocketSession socketSession) {
				handleClose(socketSession);
			}
		});
	}

	public void handleClose(SocketSession socketSession) {

		// 当负责与客户端保持长连接的服务挂了，清除其所在服务所有客户端连接信息
		String serverId = socketSession.getKey();
		socketSessionKeyManager.removeAllSession(serverId);
	}
}
