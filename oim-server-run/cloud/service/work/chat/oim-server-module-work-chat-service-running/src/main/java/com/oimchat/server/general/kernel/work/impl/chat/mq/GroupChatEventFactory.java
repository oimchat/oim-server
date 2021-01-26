package com.oimchat.server.general.kernel.work.impl.chat.mq;

import com.lmax.disruptor.EventFactory;

/**
 * Description <br>
 * Date 2019-06-28 15:00:30<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class GroupChatEventFactory implements EventFactory<GroupChatEvent> {

	@Override
	public GroupChatEvent newInstance() {
		return new GroupChatEvent();
	}
}
