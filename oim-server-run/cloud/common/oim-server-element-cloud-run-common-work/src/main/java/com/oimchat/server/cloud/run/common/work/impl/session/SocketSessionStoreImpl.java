package com.oimchat.server.cloud.run.common.work.impl.session;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.definition.session.SocketSessionStore;
import com.oimchat.server.cloud.net.extend.session.manager.SocketSessionKeyManager;

/**
 * Description <br>
 * Date 2020-05-16 21:01:04<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class SocketSessionStoreImpl implements SocketSessionStore {

	@Resource
	SocketSessionKeyManager userSessionKeyManager;

	@Override
	public boolean has(String key) {
		return userSessionKeyManager.hasSession(key);
	}
}
