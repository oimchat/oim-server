package com.oimchat.server.general.kernel.work.module.business.chat.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.module.base.chat.dao.UserChatContentDAO;
import com.oimchat.server.general.kernel.work.module.base.chat.dao.UserChatDAO;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.UserChatData;
import com.oimchat.server.general.kernel.work.module.base.chat.data.query.UserChatContentQuery;
import com.oimchat.server.general.kernel.work.module.base.chat.data.query.UserChatQuery;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.UserChatContent;
import com.oimchat.server.general.kernel.work.module.base.chat.manager.UserChatHistoryManager;
import com.oimchat.server.general.kernel.work.module.base.chat.type.DirectionEnum;
import com.oimchat.server.general.kernel.work.module.base.chat.util.UserChatKeyUtil;
import com.onlyxiahui.common.data.common.data.ListBody;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.message.result.ResultBodyMessage;

/**
 * 
 * Description <br>
 * Date 2016-08-23 11:20:14<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Service
public class UserChatHistoryService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	UserChatDAO userChatDAO;
	@Resource
	UserChatContentDAO userChatContentDAO;
	@Resource
	UserChatHistoryManager userChatHistoryManager;

	/**
	 * 根据记录表id查询用户聊天记录（上翻，下拉方式的）
	 * 
	 * @param sendUserId
	 * @param receiveUserId
	 * @param startId
	 * @param direction
	 * @param count
	 * @return
	 */
	public ResultBodyMessage<ListBody<List<UserChatData>>> getUserChatDataListByStartId(
			String sendUserId,
			String receiveUserId,
			String startId,
			String direction,
			int count) {
		return getUserChatDataList(
				sendUserId,
				receiveUserId,
				startId,
				null,
				direction,
				count);
	}

	public ResultBodyMessage<ListBody<List<UserChatData>>> getUserChatDataListByStartMessageKey(
			String sendUserId,
			String receiveUserId,
			String startMessageKey,
			String direction,
			int count) {
		return getUserChatDataList(
				sendUserId,
				receiveUserId,
				null,
				startMessageKey,
				direction,
				count);
	}

	public ResultBodyMessage<ListBody<List<UserChatData>>> getUserChatDataList(
			String sendUserId,
			String receiveUserId,
			String startId,
			String startMessageKey,
			String direction,
			int count) {
		boolean after = DirectionEnum.after.isEquals(direction);

		Page page = new Page();
		page.setSize(count);

		List<UserChatData> contents = new ArrayList<UserChatData>();
		if ((null != sendUserId && !"".equals(sendUserId)) || (null != receiveUserId && !"".equals(receiveUserId))) {

			UserChatContent ucc = null;
			if (null != startId && !"".equals(startId)) {
				ucc = userChatContentDAO.get(UserChatContent.class, startId);
			} else if (null != startMessageKey && !"".equals(startMessageKey)) {
				String ownKey = UserChatKeyUtil.getUserChatKey(sendUserId, receiveUserId);
				ucc = userChatContentDAO.getByMessageKey(ownKey, startMessageKey);
			}

			long timestamp = 0;
			if (null != ucc && ucc.getTimestamp() > 0) {
				timestamp = ucc.getTimestamp();
			}
			List<UserChatContent> chatContentList = userChatDAO.getUserChatContentList(receiveUserId, sendUserId, startId, startMessageKey, after, timestamp, page);
			contents = userChatHistoryManager.convertUserChatDataList(chatContentList, true);
		}
		ListBody<List<UserChatData>> body = new ListBody<>(contents);
		ResultBodyMessage<ListBody<List<UserChatData>>> m = new ResultBodyMessage<>(body);
		return m;
	}

	/**
	 * 分页查询聊天记录
	 * 
	 * @param sendUserId
	 * @param receiveUserId
	 * @param chatQuery
	 * @param page
	 * @return
	 */
	public ResultBodyMessage<PageResult<List<UserChatData>>> queryUserChatDataList(UserChatQuery query, Page page) {
		String sendUserId = query.getSendUserId();
		String receiveUserId = query.getReceiveUserId();
		List<UserChatData> contents = new ArrayList<UserChatData>();
		if ((null != sendUserId && !"".equals(sendUserId)) || (null != receiveUserId && !"".equals(receiveUserId))) {
			List<UserChatContent> list = userChatDAO.queryUserChatContentList(query, page);
			contents = userChatHistoryManager.convertUserChatDataList(list, true);
		}
		PageResult<List<UserChatData>> body = new PageResult<>(page, contents);
		ResultBodyMessage<PageResult<List<UserChatData>>> m = new ResultBodyMessage<>(body);
		return m;
	}

	public UserChatData getUserChatDataByContentId(String contentId) {
		Page page = new Page();
		UserChatContentQuery query = new UserChatContentQuery();
		query.setId(contentId);
		List<UserChatContent> list = userChatContentDAO.queryList(query, page);
		List<UserChatData> contents = userChatHistoryManager.convertUserChatDataList(list, true);
		return null == contents || contents.isEmpty() ? null : contents.get(0);
	}

	public List<UserChatData> getUserChatDataListBycontentIds(List<String> contentIds) {
		List<UserChatContent> list = userChatContentDAO.getListByIds(contentIds);
		List<UserChatData> contents = userChatHistoryManager.convertUserChatDataList(list, true);
		return contents;
	}
}
