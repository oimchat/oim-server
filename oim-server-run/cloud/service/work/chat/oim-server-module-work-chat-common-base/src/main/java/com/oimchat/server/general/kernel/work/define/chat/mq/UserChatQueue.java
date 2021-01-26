package com.oimchat.server.general.kernel.work.define.chat.mq;

import java.util.List;

import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.ChatItem;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Content;

/**
 * Description <br>
 * Date 2019-06-28 14:02:36<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public interface UserChatQueue {

	void add(String sendUserId, String receiveUserId, Content content, List<ChatItem> chatItems, boolean send);
}
