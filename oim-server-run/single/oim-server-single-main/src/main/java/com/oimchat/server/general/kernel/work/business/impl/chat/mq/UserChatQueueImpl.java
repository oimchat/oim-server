package com.oimchat.server.general.kernel.work.business.impl.chat.mq;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import com.oimchat.server.general.kernel.work.define.chat.mq.UserChatQueue;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.ChatItem;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Content;
import com.oimchat.server.general.kernel.work.module.business.chat.service.UserChatStorageService;

/**
 * Description <br>
 * Date 2019-06-28 14:41:54<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class UserChatQueueImpl implements UserChatQueue {

	UserChatEventProducer producer;

	@Resource
	UserChatStorageService userChatStorageService;

	public UserChatQueueImpl() {
		UserChatEventFactory factory = new UserChatEventFactory();
		int bufferSize = 1024 * 1024;
		Disruptor<UserChatEvent> disruptor = new Disruptor<>(factory, bufferSize, DaemonThreadFactory.INSTANCE);
		disruptor.handleEventsWith((event, sequence, endOfBatch) -> on(event));
		disruptor.start();
		RingBuffer<UserChatEvent> ringBuffer = disruptor.getRingBuffer();
		producer = new UserChatEventProducer(ringBuffer);
	}

	@Override
	public void add(String sendUserId, String receiveUserId, Content content, List<ChatItem> chatItems, boolean send) {
		producer.onData(sendUserId, receiveUserId, content, chatItems, send);
	}

	public void on(UserChatEvent event) {
		try {
			Content c = event.getContent();
			String sendUserId = event.getSendUserId();
			String receiveUserId = event.getReceiveUserId();
			String messageKey = c.getKey();
			String contentId = c.getId();
			List<ChatItem> chatItems = event.getChatItems();
			long timestamp = c.getTimestamp();
			boolean isSend = event.isSend();

			userChatStorageService.add(
					sendUserId,
					receiveUserId,
					messageKey,
					contentId,
					chatItems,
					timestamp,
					isSend);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
