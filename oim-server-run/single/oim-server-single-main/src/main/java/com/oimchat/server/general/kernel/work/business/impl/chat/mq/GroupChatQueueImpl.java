package com.oimchat.server.general.kernel.work.business.impl.chat.mq;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import com.oimchat.server.general.kernel.work.define.chat.mq.GroupChatQueue;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.ChatItem;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Content;
import com.oimchat.server.general.kernel.work.module.business.chat.service.GroupChatStorageService;

/**
 * Description <br>
 * Date 2019-06-28 15:37:44<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class GroupChatQueueImpl implements GroupChatQueue {

	GroupChatEventProducer producer;

	@Resource
	GroupChatStorageService groupChatStorageService;

	public GroupChatQueueImpl() {
		GroupChatEventFactory factory = new GroupChatEventFactory();
		int bufferSize = 1024 * 1024;
		Disruptor<GroupChatEvent> disruptor = new Disruptor<>(factory, bufferSize, DaemonThreadFactory.INSTANCE);
		disruptor.handleEventsWith((event, sequence, endOfBatch) -> on(event));
		disruptor.start();
		RingBuffer<GroupChatEvent> ringBuffer = disruptor.getRingBuffer();
		producer = new GroupChatEventProducer(ringBuffer);
	}

	private void on(GroupChatEvent event) {
		try {
			Content c = event.getContent();
			String groupId = event.getGroupId();
			String userId = event.getUserId();
			String messageKey = c.getKey();
			String contentId = c.getId();
			List<ChatItem> chatItems = event.getChatItems();
			long timestamp = c.getTimestamp();
			groupChatStorageService.add(
					groupId,
					userId,
					messageKey,
					contentId,
					chatItems,
					timestamp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add(String groupId, String userId, Content content, List<ChatItem> chatItems) {
		producer.onData(groupId, userId, content, chatItems);
	}
}
