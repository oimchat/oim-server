package com.oimchat.server.general.kernel.work.module.base.chat.manager;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.module.base.chat.dao.UserChatUnreadDAO;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.UserChatUnread;

/**
 * 
 * Date 2019-02-17 17:57:44<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class UserChatUnreadManager {

	@Resource
	UserChatUnreadDAO userChatUnreadDAO;

	public int updateUnreadCount(
			String receiveUserId,
			String sendUserId,
			String lastContentId,
			int unreadCount,
			long timestamp) {

		lastContentId = unreadCount == 0 ? "" : lastContentId;
		int count = userChatUnreadDAO.updateUnreadCount(receiveUserId, sendUserId, lastContentId, unreadCount, timestamp);
		if (count <= 0) {
			UserChatUnread data = new UserChatUnread();
			data.setReceiveUserId(receiveUserId);
			data.setSendUserId(sendUserId);
			data.setLastContentId(lastContentId);
			data.setUnreadCount(unreadCount);
			data.setTimestamp(timestamp);
			userChatUnreadDAO.save(data);
			count++;
		}
		return count;
	}
}
