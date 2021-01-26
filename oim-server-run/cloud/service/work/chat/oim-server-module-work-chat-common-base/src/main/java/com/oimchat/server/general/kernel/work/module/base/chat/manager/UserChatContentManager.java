package com.oimchat.server.general.kernel.work.module.base.chat.manager;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.module.base.chat.dao.UserChatContentDAO;
import com.oimchat.server.general.kernel.work.module.base.chat.data.query.UserChatContentQuery;
import com.onlyxiahui.aware.basic.work.type.lang.BooleanEnum;
import com.onlyxiahui.common.data.common.data.Page;

/**
 * 
 * Date 2019-02-17 17:57:44<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class UserChatContentManager {

	@Resource
	UserChatContentDAO userChatContentDAO;

	/**
	 * 
	 * 获取未读消息数量<br>
	 * Date 2020-04-17 18:48:18<br>
	 * 
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public int getUnreadCountByUserId(String userId) {
		UserChatContentQuery query = new UserChatContentQuery();
		query.setReceiveUserId(userId);
		query.setIsRead(BooleanEnum.FALSE.getCode().toString());
		Page page = new Page();
		page.setSize(1);
		userChatContentDAO.queryList(query, page);
		return page.getTotalCount();
	}

	public int getUnreadCountByUserId(String receiveUserId, String sendUserId) {
		UserChatContentQuery query = new UserChatContentQuery();
		query.setReceiveUserId(receiveUserId);
		query.setSendUserId(sendUserId);
		query.setIsRead(BooleanEnum.FALSE.getCode().toString());
		Page page = new Page();
		page.setSize(1);
		userChatContentDAO.queryList(query, page);
		return page.getTotalCount();
	}
}
