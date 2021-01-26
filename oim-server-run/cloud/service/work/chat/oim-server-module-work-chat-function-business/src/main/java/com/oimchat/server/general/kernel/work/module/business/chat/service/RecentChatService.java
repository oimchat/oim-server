package com.oimchat.server.general.kernel.work.module.business.chat.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.module.base.chat.dao.RecentChatDAO;
import com.oimchat.server.general.kernel.work.module.base.chat.data.query.RecentChatQuery;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.RecentChat;
import com.onlyxiahui.common.data.common.data.Page;

/**
 * 
 * Description <br>
 * Date 2019-06-28 14:53:30<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Service
public class RecentChatService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	RecentChatDAO recentChatDAO;

	public boolean remove(String userId, String chatId, String type) {
		boolean mark = 0 < recentChatDAO.deleteBy(userId, chatId, type);
		return mark;
	}

	public List<RecentChat> queryList(RecentChatQuery query, Page page) {
		return recentChatDAO.queryList(page, query);
	}

	public RecentChat getById(String id) {
		return recentChatDAO.getById(id);
	}
}
