package com.oimchat.server.general.kernel.work.module.base.chat.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.module.base.chat.dao.UserChatItemDAO;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.UserChatData;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.UserSimple;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Content;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Item;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Section;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.UserChatContent;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.UserChatItem;

/**
 * 
 * Date 2019-02-17 17:57:44<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class UserChatHistoryManager {

	@Resource
	UserChatItemDAO userChatItemDAO;

	/**
	 * 
	 * Date 2019-02-17 19:07:55<br>
	 * Description 拼装用户聊天内容列表
	 * 
	 * @author XiaHui<br>
	 * @param chatContentList
	 * @param inverted
	 * @return
	 * @since 1.0.0
	 */
	public List<UserChatData> convertUserChatDataList(List<UserChatContent> chatContentList, boolean inverted) {

		List<UserChatData> contents = new ArrayList<UserChatData>();

		if (null != chatContentList && !chatContentList.isEmpty()) {
			List<String> contentIds = new ArrayList<String>();
			for (UserChatContent cc : chatContentList) {
				contentIds.add(cc.getId());
			}
			Map<String, List<UserChatItem>> chatItemMap = new HashMap<String, List<UserChatItem>>();
			if (!contentIds.isEmpty()) {
				List<UserChatItem> chatItemList = userChatItemDAO.getListByContentIds(contentIds);
				for (UserChatItem item : chatItemList) {
					List<UserChatItem> list = chatItemMap.get(item.getContentId());
					if (null == list) {
						list = new ArrayList<UserChatItem>();
						chatItemMap.put(item.getContentId(), list);
					}
					list.add(item);
				}
			}

			for (UserChatContent cc : chatContentList) {
				String messageKey = cc.getMessageKey();
				String contentId = cc.getId();

				UserSimple receiveUser = new UserSimple();
				receiveUser.setHead(cc.getReceiveUserHead());
				receiveUser.setAvatar(cc.getReceiveUserAvatar());
				receiveUser.setId(cc.getReceiveUserId());
				receiveUser.setName(cc.getReceiveUserName());
				receiveUser.setNickname(cc.getReceiveUserNickname());

				UserSimple sendUser = new UserSimple();
				sendUser.setHead(cc.getSendUserHead());
				sendUser.setAvatar(cc.getSendUserAvatar());
				sendUser.setId(cc.getSendUserId());
				sendUser.setName(cc.getSendUserName());
				sendUser.setNickname(cc.getSendUserNickname());

				long timestamp = cc.getTimestamp();
				List<UserChatItem> list = chatItemMap.get(cc.getId());
				List<Section> sections = new ArrayList<Section>();
				if (null != list && !list.isEmpty()) {
					int index = -1;
					Section section;
					List<Item> items = null;
					for (UserChatItem rci : list) {
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

					UserChatData data = new UserChatData();
//					data.setMessageKey(messageKey);
//					data.setContentId(contentId);

					data.setSendUser(sendUser);
					data.setReceiveUser(receiveUser);
					data.setContent(content);

					if (inverted) {
						contents.add(0, data);
					} else {
						contents.add(data);
					}
				}
			}
		}
		return contents;
	}
}
