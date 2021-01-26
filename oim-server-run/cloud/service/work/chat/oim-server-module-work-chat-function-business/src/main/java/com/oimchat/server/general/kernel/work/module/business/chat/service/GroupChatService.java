package com.oimchat.server.general.kernel.work.module.business.chat.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.oimchat.server.basic.common.util.KeyUtil;
import com.oimchat.server.general.kernel.work.define.chat.mq.GroupChatQueue;
import com.oimchat.server.general.kernel.work.define.chat.store.GroupMemberStore;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.ChatItem;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.GroupMemberSimple;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.UserSimple;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Content;
import com.oimchat.server.general.kernel.work.module.base.chat.manager.ChatManager;
import com.oimchat.server.general.kernel.work.module.base.chat.push.GroupChatPush;
import com.onlyxiahui.aware.basic.base.generate.KeyGenerate;

/**
 * 
 * Date 2019-02-17 12:14:31<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class GroupChatService {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private GroupChatPush groupChatPush;
	@Resource
	private GroupMemberStore groupMemberStore;
	@Resource
	private ChatManager chatManager;
	@Resource
	private GroupChatQueue groupChatQueue;
	@Resource
	private KeyGenerate keyGenerate;

	public void groupChat(String key,
			String userId,
			String groupId,
			UserSimple user,
			Content content) {
		if (null == content.getKey() || content.getKey().isEmpty()) {
			content.setKey(key);
		}

		String id = keyGenerate.getId();
		content.setId(id);

		List<ChatItem> chatItemList = chatManager.wordsFilter(content);
		groupMemberStore.allByGroupId(groupId, (page, list) -> {
			if (null != list) {
				List<String> ids = new ArrayList<String>();
				for (GroupMemberSimple m : list) {
					ids.add(m.getUserId());
				}
				groupChatPush.groupChat(ids, KeyUtil.getKey(), groupId, userId, user, content);
			}
		});
		groupChatQueue.add(groupId, userId, content, chatItemList);
	}
}
