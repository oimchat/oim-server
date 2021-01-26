package com.oimchat.server.general.kernel.work.module.base.chat.push;

import java.util.List;

import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.Motion;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Content;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.wofa.server.net.push.annotation.DataKey;
import com.onlyxiahui.wofa.server.net.push.annotation.DataPush;
import com.onlyxiahui.wofa.server.net.push.annotation.WriteKey;

/**
 * 
 * 私聊业务推送<br>
 * Date 2016年8月26日 上午9:21:41<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 * @docModuleSuperKey 2.0.0
 */
@DataPush
@ActionMapping("2.2.001")
public interface UserChatPush {

	/**
	 * 
	 * 动作<br>
	 * Date 2020-04-16 20:25:47<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param sendUserId
	 * @param receiveUserId
	 * @param motion
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0000")
	public void motion(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("sendUserId") String sendUserId,
			@Define("receiveUserId") String receiveUserId,
			@Define("motion") Motion motion);

	/**
	 * 
	 * 推送私聊信息<br>
	 * Date 2020-04-16 20:25:17<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param sendUserId
	 * @param receiveUserId
	 * @param content
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0001")
	public void pushUserChat(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("sendUserId") String sendUserId,
			@Define("receiveUserId") String receiveUserId,
			@Define("content") Content content);

	/**
	 * 
	 * 输入中<br>
	 * Date 2020-04-21 10:10:25<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @param sendUserId
	 * @param receiveUserId
	 * @param content
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0003")
	public void pushInput(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("sendUserId") String sendUserId,
			@Define("receiveUserId") String receiveUserId);
}
