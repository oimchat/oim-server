package com.oimchat.server.general.kernel.work.module.business.chat.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.UserChatData;
import com.oimchat.server.general.kernel.work.module.base.chat.data.query.UserChatQuery;
import com.oimchat.server.general.kernel.work.module.base.chat.data.query.UserChatUnreadQuery;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.UserChatUnread;
import com.oimchat.server.general.kernel.work.module.base.chat.push.UserChatDataPush;
import com.oimchat.server.general.kernel.work.module.business.chat.service.UserChatDataService;
import com.oimchat.server.general.kernel.work.module.business.chat.service.UserChatHistoryService;
import com.oimchat.server.general.kernel.work.module.business.chat.service.UserChatUnreadService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.base.HeadImpl;
import com.onlyxiahui.common.data.common.bean.CountInfo;
import com.onlyxiahui.common.data.common.data.ListBody;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 
 * 私聊记录业务接口<br>
 * Date 2020-04-16 19:34:29<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 * @docModuleSuperKey 2.0.0
 */
@Component
@ActionMapping(value = "2.2.002")
public class UserChatDataAction {

	@Resource
	UserChatHistoryService userChatHistoryService;
	@Resource
	UserChatDataService userChatDataService;
	@Resource
	UserChatUnreadService userChatUnreadService;
	@Resource
	UserChatDataPush userChatDataPush;

	/**
	 * 
	 * 历史记录数量<br>
	 * Date 2020-04-17 19:34:42<br>
	 * 
	 * @param userSession
	 * @param query
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0001")
	public CountInfo queryUserChatDataCount(
			UserSession userSession,
			@Define("body.query") UserChatQuery query) {
		Page page = new Page();
		page.setSize(1);
		// String userId = userSession.getUserId();
		userChatHistoryService.queryUserChatDataList(query, page);
		return new CountInfo(page.getTotalCount());
	}

	/**
	 * 
	 * 历史记录列表<br>
	 * Date 2020-04-17 19:34:54<br>
	 * 
	 * @param userSession
	 * @param query
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0002")
	public ResultBodyMessage<PageResult<List<UserChatData>>> queryUserChatDataList(
			UserSession userSession,
			@Define("body.query") UserChatQuery query,
			@Define("body.page") Page page) {
//		String userId = userSession.getUserId();
		ResultBodyMessage<PageResult<List<UserChatData>>> m = userChatHistoryService.queryUserChatDataList(query, page);
		return m;
	}

	/**
	 * 
	 * 根据id获取详情<br>
	 * Date 2020-04-17 20:09:35<br>
	 * 
	 * @param userSession
	 * @param contentId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0003")
	public UserChatData getUserChatDataByContentId(
			UserSession userSession,
			@Define("body.contentId") String contentId) {
//		String userId = userSession.getUserId();
		UserChatData m = userChatHistoryService.getUserChatDataByContentId(contentId);
		return m;
	}

	// 1.1.0004 ids 1.1.0005 key 1.1.0006 keys
	@ActionMapping(value = "1.1.0004")
	public List<UserChatData> getUserChatDataByContentIds(
			UserSession userSession,
			@Define("body.contentIds") List<String> contentIds) {
//		String userId = userSession.getUserId();
		List<UserChatData> list = userChatHistoryService.getUserChatDataListBycontentIds(contentIds);
		return list;
	}

	/**
	 * 
	 * 获取聊天记录(以数据库id为条件)<br>
	 * Date 2019-05-25 08:04:55<br>
	 * 
	 * @param head
	 * @param sendUserId
	 * @param receiveUserId
	 * @param startId
	 * @param direction
	 * @param count
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0007")
	public ResultBodyMessage<ListBody<List<UserChatData>>> getUserChatDataListByStartId(
			HeadImpl head,
			@Define("body.sendUserId") String sendUserId,
			@Define("body.receiveUserId") String receiveUserId,
			@Define("body.startId") String startId,
			@Define("body.direction") String direction,
			@Define("body.count") int count) {
		ResultBodyMessage<ListBody<List<UserChatData>>> m = userChatHistoryService.getUserChatDataListByStartId(
				sendUserId,
				receiveUserId,
				startId,
				direction,
				count);
		return m;
	}

	/**
	 * 
	 * 获取聊天记录(以消息key为条件) <br>
	 * Date 2019-05-25 08:05:13<br>
	 * 
	 * @param head
	 * @param sendUserId
	 * @param receiveUserId
	 * @param startMessageKey
	 * @param direction
	 * @param count
	 * @return Object
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0008")
	public ResultBodyMessage<ListBody<List<UserChatData>>> getUserChatLogByMessageKey(HeadImpl head,
			@Define("body.sendUserId") String sendUserId,
			@Define("body.receiveUserId") String receiveUserId,
			@Define("body.startMessageKey") String startMessageKey,
			@Define("body.direction") String direction,
			@Define("body.count") int count) {
		ResultBodyMessage<ListBody<List<UserChatData>>> m = userChatHistoryService.getUserChatDataListByStartMessageKey(
				sendUserId,
				receiveUserId,
				startMessageKey,
				direction,
				count);
		return m;
	}

	/**
	 * 
	 * 标记信息为已读(根据sendUserId)<br>
	 * Date 2019-05-25 08:23:23<br>
	 * 
	 * @param head
	 * @param userSession
	 * @param sendUserId  void
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0009")
	public void updateToReadBySendUserId(HeadImpl head,
			UserSession userSession,
			@Define("body.sendUserId") String sendUserId) {
		String receiveUserId = userSession.getUserId();
		userChatDataService.updateToReadBySendUserId(receiveUserId, sendUserId);
		String key = head.getKey();

		List<String> writeKeys = new ArrayList<String>();
		writeKeys.add(sendUserId);
		writeKeys.add(receiveUserId);
		userChatDataPush.pushRead(writeKeys, key, sendUserId, receiveUserId);
	}

	/**
	 * 
	 * 标记信息为已读(根据contentId)<br>
	 * Date 2020-04-16 19:46:30<br>
	 * 
	 * @param head
	 * @param userSession
	 * @param contentId
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0011")
	public void updateToReadByContentId(
			HeadImpl head,
			UserSession userSession,
			@Define("body.sendUserId") String sendUserId,
			@Define("body.contentId") String contentId) {
		String receiveUserId = userSession.getUserId();
		userChatDataService.updateToReadByContentId(receiveUserId, contentId);
		String key = head.getKey();

		List<String> writeKeys = new ArrayList<String>();
		writeKeys.add(sendUserId);
		writeKeys.add(receiveUserId);
		userChatDataPush.pushRead(writeKeys, key, sendUserId, receiveUserId, contentId);
	}

	/**
	 * 
	 * 标记信息为已读(根据messageKey)<br>
	 * Date 2020-04-16 19:46:30<br>
	 * 
	 * @param head
	 * @param userSession
	 * @param contentId
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0013")
	public void updateToReadByMessageKey(HeadImpl head,
			UserSession userSession,
			@Define("body.messageKey") String messageKey) {
	}

	// 1.1.0010 1.1.0012 1.1.0014

	/**
	 * 
	 * 获取未读消息联系人数量<br>
	 * Date 2020-04-17 19:35:46<br>
	 * 
	 * @param head
	 * @param userSession
	 * @param query
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0015")
	public CountInfo getUserChatUnreadCount(
			HeadImpl head,
			UserSession userSession,
			@Define("body.query") UserChatUnreadQuery query) {

		Page page = new Page();
		page.setSize(1);

		String userId = userSession.getUserId();
		query.setReceiveUserId(userId);

		userChatUnreadService.queryList(query, page);
		return new CountInfo(page.getTotalCount());
	}

	/**
	 * 
	 * 获取未读消息联系人列表<br>
	 * Date 2020-04-17 19:36:13<br>
	 * 
	 * @param head
	 * @param userSession
	 * @param page
	 * @param query
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0016")
	public PageResult<List<UserChatUnread>> getUserChatUnreadList(
			HeadImpl head,
			UserSession userSession,
			@Define("body.page") Page page,
			@Define("body.query") UserChatUnreadQuery query) {

		String userId = userSession.getUserId();
		query.setReceiveUserId(userId);

		List<UserChatUnread> list = userChatUnreadService.queryList(query, page);
		return new PageResult<>(page, list);
	}
}
