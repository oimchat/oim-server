package com.oimchat.server.general.kernel.work.module.base.chat.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.chat.manager.UserChatContentManager;
import com.oimchat.server.general.kernel.work.module.base.chat.manager.UserChatUnreadManager;

/**
 * 
 * Description <br>
 * Date 2016-08-23 11:20:14<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Service
public class UserChatUnreadHandler {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	UserChatContentManager userChatContentManager;
	@Resource
	UserChatUnreadManager userChatUnreadManager;

	@Transactional
	public void refreshUserChatUnread(
			String receiveUserId,
			String sendUserId,
			String contentId,
			long timestamp) {
		int unreadCount = userChatContentManager.getUnreadCountByUserId(receiveUserId, sendUserId);
		userChatUnreadManager.updateUnreadCount(receiveUserId, sendUserId, contentId, unreadCount, timestamp);
	}
}
