package com.oimchat.server.general.kernel.net.module.system.push;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.oimchat.server.basic.common.util.KeyUtil;
import com.oimchat.server.general.kernel.net.module.system.data.OnlineInfo;
import com.onlyxiahui.common.data.common.builder.PushMessageBuilder;
import com.onlyxiahui.common.message.push.PushBodyMessage;
import com.onlyxiahui.framework.net.session.SocketSession;

@Service
public class SystemAuthPush {

	String action = "1.0.002";

	/**
	 * 推送其他客户端登陆信息
	 *
	 * @param set
	 * @param offline
	 * @param client
	 */
	public void pushOtherOnline(Set<SocketSession> set, OnlineInfo onlineInfo) {

		String method = "1.2.0001";
		String key = KeyUtil.getKey();
		PushBodyMessage<OnlineInfo> message = PushMessageBuilder.buildBody(key, action, method, onlineInfo);
		for (SocketSession ss : set) {
			try {
				ss.write(message);
			} catch (Exception e) {
			}
		}
	}
}
