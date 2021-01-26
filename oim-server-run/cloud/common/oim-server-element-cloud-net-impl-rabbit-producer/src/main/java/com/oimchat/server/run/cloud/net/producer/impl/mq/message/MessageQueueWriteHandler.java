package com.oimchat.server.run.cloud.net.producer.impl.mq.message;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.oimchat.server.cloud.net.basic.message.data.MessageData;
import com.oimchat.server.cloud.net.extend.session.manager.SocketSessionKeyManager;
import com.oimchat.server.run.cloud.net.work.impl.mq.message.MessageQueue;
import com.onlyxiahui.common.lib.util.json.JsonUtil;

/**
 * 这个用于扩展，统一发送消息，未来做扩展，多台服务器的时候用mq
 * 
 * @author XiaHui
 * @date 2017-11-23 17:55:57
 */
@Component
public class MessageQueueWriteHandler {

	@Resource
	RabbitTemplate messageRabbitTemplate;

	@Resource
	SocketSessionKeyManager userSessionKeyManager;

	public void push(Object data) {
		String json = JsonUtil.toJson(data);
		MessageData messageData = new MessageData();
		messageData.setType(MessageData.type_all);
		messageData.setData(json);
		String message = JsonUtil.toJson(messageData);
		messageRabbitTemplate.convertAndSend(MessageQueue.MESSAGE_FANOUT, "", message);
	}

	public void push(String key, Object data) {
		String json = JsonUtil.toJson(data);
		Set<Serializable> ids = userSessionKeyManager.getServerKeySet(key);

		MessageData messageData = new MessageData();
		messageData.setType(MessageData.type_one);
		messageData.setData(json);
		messageData.setKey(key);
		String message = JsonUtil.toJson(messageData);
		for (Serializable id : ids) {
			messageRabbitTemplate.convertAndSend(MessageQueue.MESSAGE_DIRECT, id.toString(), message);
		}
	}

	public void push(List<String> keyList, Object data) {
		String json = JsonUtil.toJson(data);
		for (String key : keyList) {
			Set<Serializable> ids = userSessionKeyManager.getServerKeySet(key);
			MessageData messageData = new MessageData();
			messageData.setType(MessageData.type_one);
			messageData.setData(json);
			messageData.setKey(key);
			String message = JsonUtil.toJson(messageData);
			for (Serializable id : ids) {
				messageRabbitTemplate.convertAndSend(MessageQueue.MESSAGE_DIRECT, id.toString(), message);
			}
		}
	}

	public void pushWithout(String key, Object data) {
		String json = JsonUtil.toJson(data);
		MessageData messageData = new MessageData();
		messageData.setType(MessageData.type_without_one);
		messageData.setKey(key);
		messageData.setData(json);
		String message = JsonUtil.toJson(messageData);
		messageRabbitTemplate.convertAndSend(MessageQueue.MESSAGE_FANOUT, "", message);

	}

	public void pushWithout(List<String> keyList, Object data) {
		String json = JsonUtil.toJson(data);
		MessageData messageData = new MessageData();
		messageData.setType(MessageData.type_without_list);
		messageData.setKeyList(keyList);
		messageData.setData(json);
		String message = JsonUtil.toJson(messageData);
		messageRabbitTemplate.convertAndSend(MessageQueue.MESSAGE_FANOUT, "", message);
	}
}
