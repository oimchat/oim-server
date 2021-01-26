package com.oimchat.server.general.kernel.work.module.base.chat.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.basic.common.util.KeyUtil;
import com.oimchat.server.general.kernel.work.module.base.chat.dao.UserChatDAO;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.ChatItem;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.UserSimple;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.UserChatContent;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.UserChatItem;
import com.oimchat.server.general.kernel.work.module.base.chat.util.UserChatKeyUtil;

/**
 * 
 * @author XiaHui
 * @date 2017-11-26 13:01:51
 *
 */
@Service
public class UserChatStorageManager {

	@Resource
	UserChatDAO userChatDAO;

	@Transactional
	public UserChatContent save(
			UserSimple sendUserData,
			UserSimple receiveUserData,
			String messageKey,
			String contentId,
			List<ChatItem> chatItems,
			long timestamp,
			boolean isSend) {
		messageKey = (null == messageKey || "".equals(messageKey)) ? KeyUtil.getKey() : messageKey;
		UserChatContent content = createUserChatContent(
				contentId,
				messageKey,
				sendUserData,
				receiveUserData,
				timestamp,
				isSend);
		userChatDAO.save(content);
		save(content, chatItems);
		return content;
	}

	private UserChatContent createUserChatContent(
			String contentId,
			String messageKey,
			UserSimple sendUserData,
			UserSimple receiveUserData,
			long timestamp,
			boolean isSend) {

		String key = UserChatKeyUtil.getUserChatKey(sendUserData.getId(), receiveUserData.getId());
		UserChatContent data = new UserChatContent();

		data.setId(contentId);

		data.setOwnKey(key);

		data.setMessageKey(messageKey);
		data.setIsDeleted(0);
		data.setIsSend(isSend ? "1" : "0");

		data.setReceiveUserHead(receiveUserData.getHead());
		data.setReceiveUserAvatar(receiveUserData.getAvatar());
		data.setReceiveUserId(receiveUserData.getId());
		data.setReceiveUserName(receiveUserData.getName());
		data.setReceiveUserNickname(receiveUserData.getNickname());

		data.setSendUserHead(sendUserData.getHead());
		data.setSendUserAvatar(sendUserData.getAvatar());
		data.setSendUserId(sendUserData.getId());
		data.setSendUserName(sendUserData.getName());
		data.setSendUserNickname(sendUserData.getNickname());
		data.setSendUserRemarkName("");

		data.setDateTime(LocalDateTime.now());
		data.setTimestamp(timestamp);
		return data;
	}

	public void save(UserChatContent content, List<ChatItem> chatItems) {
		List<UserChatItem> list = new ArrayList<UserChatItem>();
		for (ChatItem item : chatItems) {
			UserChatItem itemData = new UserChatItem();

			itemData.setContentId(content.getId());
			itemData.setOwnKey(content.getOwnKey());
			itemData.setMessageKey(content.getMessageKey());

			itemData.setSendUserId(content.getSendUserId());
			itemData.setReceiveUserId(content.getReceiveUserId());
			itemData.setSort(item.getSort());
			itemData.setSection(item.getSection());
			itemData.setType(item.getType());
			itemData.setOriginalValue(item.getValue());
			itemData.setFilterValue(item.getFilterValue());
			list.add(itemData);
		}
		userChatDAO.saveList(list);
	}
}
