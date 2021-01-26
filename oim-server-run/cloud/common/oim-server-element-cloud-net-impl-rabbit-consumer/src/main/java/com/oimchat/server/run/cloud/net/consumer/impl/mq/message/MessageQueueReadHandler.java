package com.oimchat.server.run.cloud.net.consumer.impl.mq.message;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.onlyxiahui.wofa.server.net.core.session.SocketSessionBox;

@Component
public class MessageQueueReadHandler {

	@Resource
	SocketSessionBox socketSessionBox;

	public void push(Object data) {
		socketSessionBox.push(data);
	}

	public void push(String key, Object data) {
		socketSessionBox.push(key, data);
	}

	public void push(List<String> keyList, Object data) {
		socketSessionBox.push(keyList, data);
	}

	public void pushWithout(String key, Object data) {
		socketSessionBox.push(key, data);
	}

	public void pushWithout(List<String> keyList, Object data) {
		socketSessionBox.pushWithout(keyList, data);
	}
}
