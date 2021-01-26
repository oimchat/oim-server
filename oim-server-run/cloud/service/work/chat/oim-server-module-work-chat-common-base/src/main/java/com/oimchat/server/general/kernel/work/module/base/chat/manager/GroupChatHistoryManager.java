package com.oimchat.server.general.kernel.work.module.base.chat.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.module.base.chat.dao.GroupChatItemDAO;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.GroupChatData;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.GroupMemberSimple;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.GroupSimple;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.UserSimple;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Content;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Item;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Section;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.GroupChatContent;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.GroupChatItem;

/**
 * 
 * Date 2019-03-08 13:45:37<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class GroupChatHistoryManager {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	GroupChatItemDAO groupChatItemDAO;

	public List<GroupChatData> convertGroupChatDataList(List<GroupChatContent> chatContentList, boolean inverted) {

		List<GroupChatData> contents = new ArrayList<>();

		List<String> contentIds = new ArrayList<String>();
		for (GroupChatContent rcc : chatContentList) {
			contentIds.add(rcc.getId());
		}
		Map<String, List<GroupChatItem>> chatItemMap = new HashMap<String, List<GroupChatItem>>();
		if (!contentIds.isEmpty()) {
			List<GroupChatItem> chatItemList = groupChatItemDAO.getListByContentIds(contentIds);
			for (GroupChatItem rci : chatItemList) {
				List<GroupChatItem> list = chatItemMap.get(rci.getContentId());
				if (null == list) {
					list = new ArrayList<GroupChatItem>();
					chatItemMap.put(rci.getContentId(), list);
				}
				list.add(rci);
			}
		}

		for (GroupChatContent rcc : chatContentList) {

			String contentId = rcc.getId();

			String groupId = rcc.getGroupId();
			String messageKey = rcc.getMessageKey();
			String groupName = rcc.getGroupName();
			String groupHead = rcc.getGroupHead();
			String groupAvata = rcc.getGroupAvatar();

			String userId = rcc.getUserId();
			String userName = rcc.getUserName();
			String userNickname = rcc.getUserNickname();
			String userHead = rcc.getUserHead();
			String userAvatar = rcc.getUserAvatar();
			String userPosition = rcc.getUserPosition();
			String userGroupNickname = rcc.getUserGroupNickname();

			GroupSimple group = new GroupSimple();
			group.setId(groupId);
			group.setName(groupName);
			group.setHead(groupHead);
			group.setAvatar(groupAvata);

			UserSimple userData = new UserSimple();
			userData.setId(userId);
			userData.setName(userName);
			userData.setNickname(userNickname);
			userData.setHead(userHead);
			userData.setAvatar(userAvatar);

			GroupMemberSimple groupMember = new GroupMemberSimple();
			groupMember.setGroupId(groupId);
			groupMember.setUserId(userId);
			groupMember.setPosition(userPosition);
			groupMember.setNickname(userGroupNickname);

			long timestamp = rcc.getTimestamp();
			List<GroupChatItem> list = chatItemMap.get(rcc.getId());
			List<Section> sections = new ArrayList<Section>();
			if (null != list && !list.isEmpty()) {
				int index = -1;
				Section section;
				List<Item> items = null;
				for (GroupChatItem rci : list) {
					if (index != rci.getSection()) {
						index = rci.getSection();

						items = new ArrayList<Item>();
						section = new Section();
						section.setItems(items);
						sections.add(section);
					}

					Item item = new Item();
					item.setType(rci.getType());
					item.setValue(rci.getFilterValue());
					if (null != items) {
						items.add(item);
					}
				}

				Content content = new Content();
				content.setId(contentId);
				content.setKey(messageKey);

				content.setTimestamp(timestamp);
				content.setSections(sections);

				// TODO
				GroupChatData data = new GroupChatData();
//				data.setGroupId(groupId);
//				data.setMessageKey(messageKey);
//				data.setContentId(contentId);

				data.setGroup(group);
				data.setUser(userData);
				data.setContent(content);
				data.setGroupMember(groupMember);

				if (inverted) {
					contents.add(0, data);
				} else {
					contents.add(data);
				}
			}
		}
		return contents;
	}
}
