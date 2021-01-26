package com.oimchat.server.run.cloud.net.producer.impl.push;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.run.cloud.net.producer.impl.mq.message.MessageQueueWriteHandler;
import com.onlyxiahui.wofa.server.net.push.handler.DataPushHandler;

/**
 * Description <br>
 * Date 2020-04-03 19:39:36<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class DataPushHandlerImpl implements DataPushHandler {

	@Resource
	MessageQueueWriteHandler messageQueueWriteHandler;

	@Override
	public void push(Object data) {
		messageQueueWriteHandler.push(data);
	}

	@Override
	public void push(String key, Object data) {
		messageQueueWriteHandler.push(key, data);
	}

	@Override
	public void push(List<String> keyList, Object data) {
		messageQueueWriteHandler.push(keyList, data);
	}

	@Override
	public void pushWithout(String key, Object data) {
		messageQueueWriteHandler.pushWithout(key, data);
	}

	@Override
	public void pushWithout(List<String> keyList, Object data) {
		messageQueueWriteHandler.pushWithout(keyList, data);
	}
}
