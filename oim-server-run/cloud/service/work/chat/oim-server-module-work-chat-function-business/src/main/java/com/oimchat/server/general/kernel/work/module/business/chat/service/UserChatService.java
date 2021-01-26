package com.oimchat.server.general.kernel.work.module.business.chat.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.oimchat.server.basic.definition.session.SocketSessionStore;
import com.oimchat.server.general.kernel.work.define.chat.mq.UserChatQueue;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.ChatItem;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Content;
import com.oimchat.server.general.kernel.work.module.base.chat.manager.ChatManager;
import com.oimchat.server.general.kernel.work.module.base.chat.push.UserChatPush;
import com.onlyxiahui.aware.basic.base.generate.KeyGenerate;

/**
 * 
 * Description <br>
 * Date 2019-06-28 14:53:30<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Service
public class UserChatService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	ChatManager chatManager;
	@Resource
	UserChatPush userChatPush;
	@Resource
	SocketSessionStore socketSessionStore;
	@Resource
	UserChatQueue userChatQueue;
	@Resource
	KeyGenerate keyGenerate;

	/**
	 * 
	 * Date 2019-02-17 12:12:36<br>
	 * Description 用户对用户聊天
	 * 
	 * @author XiaHui<br>
	 * @param key
	 * @param sendUserId
	 * @param receiveUserId
	 * @param content
	 * @since 1.0.0
	 */
	public void userChat(String key, String sendUserId, String receiveUserId, Content content) {
		if (null == content.getKey() || content.getKey().isEmpty()) {
			content.setKey(key);
		}
		String id = keyGenerate.getId();
		content.setId(id);

		List<ChatItem> chatItems = chatManager.wordsFilter(content);
		boolean send = socketSessionStore.has(receiveUserId);

		List<String> idList = new ArrayList<String>();
		idList.add(sendUserId);
		idList.add(receiveUserId);
		userChatPush.pushUserChat(idList, key, sendUserId, receiveUserId, content);
		userChatQueue.add(sendUserId, receiveUserId, content, chatItems, send);
	}
}
