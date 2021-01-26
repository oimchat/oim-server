package com.oimchat.server.general.kernel.work.module.base.chat.manager;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.chat.dao.RecentChatDAO;
import com.oimchat.server.general.kernel.work.module.base.chat.data.query.RecentChatQuery;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.RecentChat;
import com.onlyxiahui.common.data.common.data.Page;

/**
 * 
 * Date 2019-03-08 09:12:44<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class RecentChatManager {

	@Resource
	RecentChatDAO recentChatDAO;

	@Transactional()
	public void saveOrUpdate(
			String userId,
			String chatId,
			String type,
			long timestamp,
			String contentId,
			String messageKey) {

		RecentChat data = new RecentChat();

		data.setContentId(contentId);
		data.setMessageKey(messageKey);

		data.setUserId(userId);
		data.setChatId(chatId);
		data.setType(type);
		data.setTimestamp(timestamp);
		data.setDateTime(LocalDateTime.now());
		saveOrUpdate(data);
	}

	public void saveOrUpdate(RecentChat recentChat) {
		long timestamp = null == recentChat.getTimestamp() || 0 == recentChat.getTimestamp() ? System.currentTimeMillis() : recentChat.getTimestamp();
		RecentChat bean = recentChatDAO.getLastRecentChat(recentChat.getUserId(), recentChat.getChatId(), recentChat.getType());
		if (null != bean) {
			bean.setContentId(recentChat.getContentId());
			bean.setMessageKey(recentChat.getMessageKey());
			bean.setDateTime(LocalDateTime.now());
			bean.setTimestamp(timestamp);
			recentChatDAO.update(bean);
		} else {
			recentChatDAO.save(recentChat);
		}
	}

	public List<RecentChat> queryList(Page page, RecentChatQuery query) {
		return recentChatDAO.queryList(page, query);
	}
}
