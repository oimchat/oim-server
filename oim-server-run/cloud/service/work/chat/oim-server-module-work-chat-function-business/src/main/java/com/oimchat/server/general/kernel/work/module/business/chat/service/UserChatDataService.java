package com.oimchat.server.general.kernel.work.module.business.chat.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.module.base.chat.dao.UserChatContentDAO;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.UserChatContent;
import com.oimchat.server.general.kernel.work.module.base.chat.handler.UserChatUnreadHandler;

/**
 * 
 * Description <br>
 * Date 2016-08-23 11:20:14<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Service
public class UserChatDataService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	UserChatContentDAO userChatContentDAO;
	@Resource
	UserChatUnreadHandler userChatUnreadHandler;

	public int updateToReadBySendUserId(String receiveUserId, String sendUserId) {
		int count = userChatContentDAO.updateToReadBySendUserId(receiveUserId, sendUserId);
		userChatUnreadHandler.refreshUserChatUnread(receiveUserId, sendUserId, "", System.currentTimeMillis());
		return count;
	}

	public int updateToReadByContentId(String receiveUserId, String contentId) {
		int count = userChatContentDAO.updateToReadById(contentId, receiveUserId);
		UserChatContent data = userChatContentDAO.getById(contentId);
		if (null != data) {
			userChatUnreadHandler.refreshUserChatUnread(receiveUserId, data.getSendUserId(), "", System.currentTimeMillis());
		}
		return count;
	}
}
