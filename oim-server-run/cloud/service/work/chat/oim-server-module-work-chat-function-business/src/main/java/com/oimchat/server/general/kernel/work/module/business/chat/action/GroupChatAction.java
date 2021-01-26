package com.oimchat.server.general.kernel.work.module.business.chat.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.util.KeyUtil;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.UserSimple;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Content;
import com.oimchat.server.general.kernel.work.module.business.chat.service.GroupChatService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.base.HeadImpl;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 
 * 群聊业务接口<br>
 * Date 2020-04-16 20:43:45<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 * @docModuleSuperKey 2.0.0
 */
@Component
@ActionMapping(value = "2.3.001")
public class GroupChatAction {

	@Resource
	GroupChatService groupChatService;

	/**
	 * 
	 * 群聊<br>
	 * Date 2019-02-17 12:26:38<br>
	 * 
	 * @param head
	 * @param userId
	 * @param groupId
	 * @param content
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0001")
	public void groupChat(HeadImpl head,
			@Define("body.userId") String userId,
			@Define("body.groupId") String groupId,
			@Define("body.user") UserSimple user,
			@Define("body.content") Content content) {
		String key = (null == head.getKey() || head.getKey().isEmpty()) ? KeyUtil.getKey() : head.getKey();
		groupChatService.groupChat(key, userId, groupId, user, content);
	}
}
