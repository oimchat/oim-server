package com.oimchat.server.general.kernel.work.module.base.chat.push;

import java.util.List;

import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.UserSimple;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Content;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.wofa.server.net.push.annotation.DataKey;
import com.onlyxiahui.wofa.server.net.push.annotation.DataPush;
import com.onlyxiahui.wofa.server.net.push.annotation.WriteKey;

/**
 * 群聊业务推送
 * 
 * @author: XiaHui
 * @date: 2016-08-26 9:21:41
 * @docModuleSuperKey 2.0.0
 */
@DataPush
@ActionMapping("2.3.001")
public interface GroupChatPush {

	/**
	 * 推送群聊信息<br>
	 * Date 2020-04-16 20:29:18<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param groupId
	 * @param userId
	 * @param content
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0001")
	public void groupChat(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("groupId") String groupId,
			@Define("userId") String userId,
			@Define("user") UserSimple user,
			@Define("content") Content content);
}
