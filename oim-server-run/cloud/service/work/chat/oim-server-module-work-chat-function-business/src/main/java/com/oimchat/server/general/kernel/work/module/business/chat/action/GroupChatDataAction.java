package com.oimchat.server.general.kernel.work.module.business.chat.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.GroupChatData;
import com.oimchat.server.general.kernel.work.module.base.chat.data.query.GroupChatQuery;
import com.oimchat.server.general.kernel.work.module.business.chat.service.GroupChatHistoryService;
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
 * 群聊记录业务接口<br>
 * Date 2020-04-16 19:34:29<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 * @docModuleSuperKey 2.0.0
 */
@Component
@ActionMapping(value = "2.3.002")
public class GroupChatDataAction {

	@Resource
	GroupChatHistoryService groupChatHistoryService;

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
	public CountInfo queryGroupChatDataCount(
			UserSession userSession,
			@Define("body.query") GroupChatQuery query) {
		Page page = new Page();
		page.setSize(1);
		// String GroupId = userSession.getUserId();
		groupChatHistoryService.queryGroupChatDataList(query, page);
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
	public ResultBodyMessage<PageResult<List<GroupChatData>>> queryGroupChatDataList(
			UserSession userSession,
			@Define("body.query") GroupChatQuery query,
			@Define("body.page") Page page) {
//		String GroupId = userSession.getUserId();
		ResultBodyMessage<PageResult<List<GroupChatData>>> m = groupChatHistoryService.queryGroupChatDataList(query, page);
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
	public GroupChatData getGroupChatDataByContentId(
			UserSession userSession,
			@Define("body.contentId") String contentId) {
//		String userId = userSession.getGroupId();
		GroupChatData m = groupChatHistoryService.getGroupChatDataByContentId(contentId);
		return m;
	}

	// 1.1.0004 ids 1.1.0005 key 1.1.0006 keys

	@ActionMapping(value = "1.1.0004")
	public List<GroupChatData> getGroupChatDataByContentIds(
			UserSession userSession,
			@Define("body.contentIds") List<String> contentIds) {
//		String userId = userSession.getGroupId();
		List<GroupChatData> list = groupChatHistoryService.getGroupChatDataListByContentIds(contentIds);
		return list;
	}

	/**
	 * 
	 * 获取聊天记录(以数据库id为条件)<br>
	 * Date 2019-05-25 08:04:55<br>
	 * 
	 * @param head
	 * @param groupId
	 * @param startId
	 * @param direction
	 * @param count
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0007")
	public ResultBodyMessage<ListBody<List<GroupChatData>>> getGroupChatDataListByStartId(
			HeadImpl head,
			@Define("body.groupId") String groupId,
			@Define("body.startId") String startId,
			@Define("body.direction") String direction,
			@Define("body.count") int count) {
		ResultBodyMessage<ListBody<List<GroupChatData>>> m = groupChatHistoryService.getGroupChatDataListByByStartId(
				groupId,
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
	 * @param groupId
	 * @param startMessageKey
	 * @param direction
	 * @param count
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0008")
	public ResultBodyMessage<ListBody<List<GroupChatData>>> getGroupChatLogByMessageKey(HeadImpl head,
			@Define("body.groupId") String groupId,
			@Define("body.startMessageKey") String startMessageKey,
			@Define("body.direction") String direction,
			@Define("body.count") int count) {
		ResultBodyMessage<ListBody<List<GroupChatData>>> m = groupChatHistoryService.getGroupChatDataListByStartMessageKey(
				groupId,
				startMessageKey,
				direction,
				count);
		return m;
	}

	// 1.1.0008 1.1.0009 1.1.0010

	// 获取未读消息数量 1.1.0011
	// 获取未读消息列表 1.1.0012
}
