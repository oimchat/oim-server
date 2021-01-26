package com.oimchat.server.general.kernel.work.module.business.chat.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.chat.data.query.RecentChatQuery;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.RecentChat;
import com.oimchat.server.general.kernel.work.module.business.chat.service.RecentChatService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.bean.CountInfo;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 
 * 最近聊天业务接口<br>
 * Date 2020-04-16 19:34:29<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 * @docModuleSuperKey 2.0.0
 */
@Component
@ActionMapping(value = "2.1.001")
public class RecentChatAction {

	@Resource
	RecentChatService recentChatService;

	/**
	 * 
	 * 获取数量<br>
	 * Date 2020-04-17 19:34:42<br>
	 * 
	 * @param userSession
	 * @param query
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0001")
	public CountInfo queryCount(
			UserSession userSession,
			@Define("body.query") RecentChatQuery query) {
		Page page = new Page();
		page.setSize(1);
		String userId = userSession.getUserId();
		query.setUserId(userId);
		recentChatService.queryList(query, page);
		return new CountInfo(page.getTotalCount());
	}

	/**
	 * 
	 * 获取列表<br>
	 * Date 2020-04-17 19:34:54<br>
	 * 
	 * @param userSession
	 * @param query
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0002")
	public PageResult<List<RecentChat>> queryList(
			UserSession userSession,
			@Define("body.query") RecentChatQuery query,
			@Define("body.page") Page page) {
		String userId = userSession.getUserId();
		query.setUserId(userId);
		List<RecentChat> list = recentChatService.queryList(query, page);
		return new PageResult<>(page, list);
	}

	/**
	 * 
	 * 根据id获取详情<br>
	 * Date 2020-04-17 20:09:35<br>
	 * 
	 * @param userSession
	 * @param id
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0003")
	public RecentChat getById(
			UserSession userSession,
			@Define("body.id") String id) {
//		String userId = userSession.getUserId();
		RecentChat m = recentChatService.getById(id);
		return m;
	}

	/**
	 * 
	 * 删除<br>
	 * Date 2020-04-17 20:09:35<br>
	 * 
	 * @param userSession
	 * @param id
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0004")
	public void remove(
			UserSession userSession,
			@Define("body.userId") String userId,
			@Define("body.chatId") String chatId,
			@Define("body.type") String type) {
		userId = userSession.getUserId();
		recentChatService.remove(userId, chatId, type);
	}
}
