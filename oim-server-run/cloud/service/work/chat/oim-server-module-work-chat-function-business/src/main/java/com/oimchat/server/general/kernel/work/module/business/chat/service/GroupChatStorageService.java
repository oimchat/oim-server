package com.oimchat.server.general.kernel.work.module.business.chat.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.define.chat.store.UserDataStore;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.ChatItem;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.UserSimple;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.RecentChat;
import com.oimchat.server.general.kernel.work.module.base.chat.manager.GroupChatStorageManager;
import com.oimchat.server.general.kernel.work.module.base.chat.manager.RecentChatManager;

/**
 * 
 * Date 2019-03-08 13:48:52<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class GroupChatStorageService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private UserDataStore userDataStore;
	@Resource
	private GroupChatStorageManager groupChatStorageManager;
	@Resource
	private RecentChatManager recentChatManager;

	public void add(
			String groupId,
			String userId,
			String messageKey,
			String contentId,
			List<ChatItem> chatItems,
			long timestamp) {
		UserSimple user = userDataStore.getUserSimpleById(userId);
		groupChatStorageManager.save(
				groupId,
				user,
				contentId,
				messageKey,
				chatItems,
				timestamp);
		// 添加最近聊天对象
		recentChatManager.saveOrUpdate(userId, groupId, RecentChat.TYPE_GROUP, timestamp, contentId, messageKey);
	}
}
