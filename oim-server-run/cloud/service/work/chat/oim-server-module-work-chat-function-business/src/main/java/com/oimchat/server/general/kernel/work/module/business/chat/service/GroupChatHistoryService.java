package com.oimchat.server.general.kernel.work.module.business.chat.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.module.base.chat.dao.GroupChatContentDAO;
import com.oimchat.server.general.kernel.work.module.base.chat.dao.GroupChatDAO;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.GroupChatData;
import com.oimchat.server.general.kernel.work.module.base.chat.data.query.GroupChatContentQuery;
import com.oimchat.server.general.kernel.work.module.base.chat.data.query.GroupChatQuery;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.GroupChatContent;
import com.oimchat.server.general.kernel.work.module.base.chat.manager.GroupChatHistoryManager;
import com.oimchat.server.general.kernel.work.module.base.chat.type.DirectionEnum;
import com.onlyxiahui.common.data.common.data.ListBody;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.message.result.ResultBodyMessage;

/**
 * 
 * Date 2019-03-08 13:48:52<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class GroupChatHistoryService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	GroupChatDAO groupChatDAO;
	@Resource
	GroupChatContentDAO groupChatContentDAO;
	@Resource
	GroupChatHistoryManager groupChatHistoryManager;

	public ResultBodyMessage<ListBody<List<GroupChatData>>> getGroupChatDataListByByStartId(
			String groupId,
			String startId,
			String direction,
			int count) {
		return this.getGroupChatDataList(groupId, startId, null, direction, count);
	}

	public ResultBodyMessage<ListBody<List<GroupChatData>>> getGroupChatDataListByStartMessageKey(
			String groupId,
			String startMessageKey,
			String direction,
			int count) {
		return this.getGroupChatDataList(groupId, null, startMessageKey, direction, count);
	}

	/**
	 * 根据记录表id查询用户聊天记录（上翻，下拉方式的）<br>
	 * Date 2020-04-17 15:54:29<br>
	 * 
	 * @param groupId
	 * @param startId
	 * @param outMessageKey
	 * @param direction
	 * @param count
	 * @return
	 * @since 1.0.0
	 */
	public ResultBodyMessage<ListBody<List<GroupChatData>>> getGroupChatDataList(
			String groupId,
			String startId,
			String startMessageKey,
			String direction, int count) {

		boolean after = DirectionEnum.after.isEquals(direction);

		Page page = new Page();
		page.setSize(count);

		List<GroupChatData> contents = new ArrayList<GroupChatData>();

		if ((null != groupId && !"".equals(groupId))) {

			GroupChatContent ucc = null;
			if (null != startId && !"".equals(startId)) {
				ucc = groupChatContentDAO.get(GroupChatContent.class, startId);
			} else if (null != startMessageKey && !"".equals(startMessageKey)) {
				ucc = groupChatContentDAO.getByMessageKey(groupId, startMessageKey);
			}

			long timestamp = 0;
			if (null != ucc && ucc.getTimestamp() > 0) {
				timestamp = ucc.getTimestamp();
			}

			List<GroupChatContent> chatContentList = groupChatDAO.getGroupChatContentList(
					groupId,
					startId,
					startMessageKey,
					after,
					timestamp,
					page);

			contents = groupChatHistoryManager.convertGroupChatDataList(chatContentList, true);
		}

		ListBody<List<GroupChatData>> body = new ListBody<>(contents);
		ResultBodyMessage<ListBody<List<GroupChatData>>> m = new ResultBodyMessage<>(body);
		return m;
	}

	public ResultBodyMessage<PageResult<List<GroupChatData>>> queryGroupChatDataList(GroupChatQuery query, Page page) {
		String groupId = query.getGroupId();
		List<GroupChatData> contents = new ArrayList<>();
		if ((null != groupId && !"".equals(groupId))) {
			List<GroupChatContent> chatContentList = groupChatDAO.queryGroupChatContentList(query, page);
			contents = groupChatHistoryManager.convertGroupChatDataList(chatContentList, true);
		}
		PageResult<List<GroupChatData>> body = new PageResult<>(page, contents);
		ResultBodyMessage<PageResult<List<GroupChatData>>> m = new ResultBodyMessage<>(body);
		return m;
	}

	public GroupChatData getGroupChatDataByContentId(String contentId) {
		Page page = new Page();
		GroupChatContentQuery query = new GroupChatContentQuery();
		query.setId(contentId);
		List<GroupChatContent> list = groupChatContentDAO.queryList(query, page);
		List<GroupChatData> contents = groupChatHistoryManager.convertGroupChatDataList(list, true);
		return null == contents || contents.isEmpty() ? null : contents.get(0);
	}

	public List<GroupChatData> getGroupChatDataListByContentIds(List<String> contentIds) {
		List<GroupChatContent> list = groupChatContentDAO.getListByIds(contentIds);
		List<GroupChatData> contents = groupChatHistoryManager.convertGroupChatDataList(list, true);
		return contents;
	}
}
