package com.oimchat.server.general.kernel.work.module.base.chat.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.basic.common.util.KeyUtil;
import com.oimchat.server.general.kernel.work.module.base.chat.dao.GroupChatDAO;
import com.oimchat.server.general.kernel.work.module.base.chat.dao.RecentChatDAO;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.ChatItem;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.UserSimple;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.GroupChatContent;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.GroupChatItem;

/**
 * 
 * Date 2019-02-17 12:24:49<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class GroupChatStorageManager {

	@Resource
	GroupChatDAO groupChatDAO;
	@Resource
	RecentChatDAO userLastChatDAO;

	@Transactional
	public GroupChatContent save(
			String groupId,
			UserSimple user,
			String contentId,
			String messageKey,
			List<ChatItem> chatItems,
			long timestamp) {
		messageKey = (null == messageKey || "".equals(messageKey)) ? KeyUtil.getKey() : messageKey;

//		List<String> messageKeys = new ArrayList<String>();
//		messageKeys.add(messageKey);
//		List<GroupChatItem> hasList = groupChatDAO.getGroupChatItemListByMessageKeys(messageKeys);
//		if (null != hasList && !hasList.isEmpty()) {
//			return;
//		}
		GroupChatContent content = null;
		if (null != user) {
			content = createGroupChatContent(
					groupId,
					user,
					contentId,
					messageKey,
					timestamp);
			groupChatDAO.save(content);
			save(content, chatItems);
		}
		return content;
	}

	private GroupChatContent createGroupChatContent(
			String groupId,
			UserSimple userData,
			String contentId,
			String messageKey,
			long timestamp) {
		GroupChatContent data = new GroupChatContent();
		data.setId(contentId);
		data.setMessageKey(messageKey);
		data.setGroupId(groupId);
		data.setGroupName("");
		data.setDateTime(LocalDateTime.now());
		data.setTimestamp(timestamp);
		data.setUserHead(userData.getHead());
		data.setUserAvatar(userData.getAvatar());
		data.setUserId(userData.getId());
		data.setUserName(userData.getName());
		data.setUserNickname(userData.getNickname());
		data.setUserGroupNickname("");
		return data;
	}

	private void save(GroupChatContent content, List<ChatItem> chatItems) {
		List<GroupChatItem> list = new ArrayList<GroupChatItem>();
		for (ChatItem item : chatItems) {
			GroupChatItem itemData = new GroupChatItem();

			itemData.setContentId(content.getId());
			itemData.setMessageKey(content.getMessageKey());

			itemData.setGroupId(content.getGroupId());
			itemData.setUserId(content.getUserId());
			itemData.setSort(item.getSort());
			itemData.setSection(item.getSection());
			itemData.setType(item.getType());
			itemData.setOriginalValue(item.getValue());
			itemData.setFilterValue(item.getFilterValue());
			list.add(itemData);
		}
		groupChatDAO.saveList(list);
	}
}
