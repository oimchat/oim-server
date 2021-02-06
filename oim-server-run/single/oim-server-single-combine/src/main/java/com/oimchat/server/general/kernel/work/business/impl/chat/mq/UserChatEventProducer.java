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

public class UserChatEventProducer {

	private final RingBuffer<UserChatEvent> ringBuffer;

	public UserChatEventProducer(RingBuffer<UserChatEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	public void onData(String sendUserId, String receiveUserId, Content content, List<ChatItem> chatItems, boolean send) {
		long sequence = ringBuffer.next(); // Grab the next sequence
		try {
			UserChatEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor
			event.setSendUserId(sendUserId);
			event.setReceiveUserId(receiveUserId);
			event.setContent(content);
			event.setChatItems(chatItems);
			event.setSend(send);
		} finally {
			ringBuffer.publish(sequence);
		}
	}
}
