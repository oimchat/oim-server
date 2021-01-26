package com.oimchat.server.general.kernel.net.common.session;

import java.util.List;

import org.springframework.stereotype.Component;

import com.onlyxiahui.common.lib.util.json.JsonUtil;
import com.onlyxiahui.wofa.server.net.core.session.SocketSessionBox;

@Component
public class SocketSessionBoxComponent extends SocketSessionBox {

	public SocketSessionBoxComponent() {
	}

	public void push(Object data) {
		super.push(JsonUtil.toJson(data));
	}

	public void push(String key, Object data) {
		super.push(key, JsonUtil.toJson(data));
	}

	public void push(List<String> keyList, Object data) {
		super.push(keyList, JsonUtil.toJson(data));
	}

	public void pushWithout(String key, Object data) {
		super.pushWithout(key, JsonUtil.toJson(data));
	}

	public void pushWithout(List<String> keyList, Object data) {
		super.pushWithout(keyList, JsonUtil.toJson(data));
	}
}
