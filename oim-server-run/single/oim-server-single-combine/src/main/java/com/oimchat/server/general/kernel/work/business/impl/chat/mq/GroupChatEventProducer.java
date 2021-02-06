package com.oimchat.server.general.kernel.work.business.impl.chat.mq;

import java.util.List;

import com.lmax.disruptor.RingBuffer;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.ChatItem;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Content;

/**
 * Description <br>
 * Date 2019-06-28 15:04:35<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class GroupChatEventProducer {

	private final RingBuffer<GroupChatEvent> ringBuffer;

	public GroupChatEventProducer(RingBuffer<GroupChatEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	public void onData(String groupId, String userId, Content content, List<ChatItem> chatItems) {
		long sequence = ringBuffer.next(); // Grab the next sequence
		try {
			GroupChatEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor
			event.setGroupId(groupId);
			event.setUserId(userId);
			event.setContent(content);
			event.setChatItems(chatItems);
		} finally {
			ringBuffer.publish(sequence);
		}
	}
}
