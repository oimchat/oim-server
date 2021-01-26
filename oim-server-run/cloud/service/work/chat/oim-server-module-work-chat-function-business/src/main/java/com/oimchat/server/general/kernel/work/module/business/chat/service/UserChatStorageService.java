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
import com.oimchat.server.general.kernel.work.module.base.chat.handler.UserChatUnreadHandler;
import com.oimchat.server.general.kernel.work.module.base.chat.manager.RecentChatManager;
import com.oimchat.server.general.kernel.work.module.base.chat.manager.UserChatStorageManager;

/**
 * 
 * Description <br>
 * Date 2016-08-23 11:20:14<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Service
public class UserChatStorageService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	UserChatStorageManager userChatStorageManager;
	@Resource
	UserDataStore userDataStore;
	@Resource
	RecentChatManager recentChatManager;
	@Resource
	UserChatUnreadHandler userChatUnreadHandler;

	public void add(
			String sendUserId,
			String receiveUserId,
			String messageKey,
			String contentId,
			List<ChatItem> chatItems,
			long timestamp,
			boolean isSend) {
		UserSimple sendUserData = userDataStore.getUserSimpleById(sendUserId);
		UserSimple receiveUserData = userDataStore.getUserSimpleById(receiveUserId);
		if (null != sendUserData && null != receiveUserData) {
			userChatStorageManager.save(
					sendUserData,
					receiveUserData,
					messageKey,
					contentId,
					chatItems,
					timestamp,
					isSend);

			// 添加最近聊天对象
			recentChatManager.saveOrUpdate(sendUserId, receiveUserId, RecentChat.TYPE_USER, timestamp, contentId, messageKey);
			recentChatManager.saveOrUpdate(receiveUserId, sendUserId, RecentChat.TYPE_USER, timestamp, contentId, messageKey);
			// 更新未读数量
			userChatUnreadHandler.refreshUserChatUnread(receiveUserId, sendUserId, contentId, timestamp);
		}
	}
}
