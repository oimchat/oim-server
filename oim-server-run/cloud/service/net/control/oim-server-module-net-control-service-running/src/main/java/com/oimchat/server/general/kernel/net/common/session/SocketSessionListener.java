package com.oimchat.server.general.kernel.net.common.session;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.onlyxiahui.framework.net.session.SocketSession;

/**
 * <br>
 * Date 2020-11-16 08:55:12<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class SocketSessionListener {

	Set<SocketSessionEvent> set = new HashSet<>();

	public void add(SocketSessionEvent event) {
		set.add(event);
	}

	public void online(SocketSession socketSession) {
		for (SocketSessionEvent e : set) {
			e.online(socketSession);
		}
	}

	public void offline(SocketSession socketSession) {
		for (SocketSessionEvent e : set) {
			e.offline(socketSession);
		}
	}

	public void close(SocketSession socketSession) {
		for (SocketSessionEvent e : set) {
			e.close(socketSession);
		}
	}
}
