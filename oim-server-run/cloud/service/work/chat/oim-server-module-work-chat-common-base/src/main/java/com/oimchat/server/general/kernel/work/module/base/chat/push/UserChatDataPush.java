package com.oimchat.server.general.kernel.work.module.base.chat.push;

import java.util.List;

import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.wofa.server.net.push.annotation.DataKey;
import com.onlyxiahui.wofa.server.net.push.annotation.DataPush;
import com.onlyxiahui.wofa.server.net.push.annotation.WriteKey;

/**
 * 
 * 私聊记录业务推送<br>
 * Date 2016年8月26日 上午9:21:41<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 * @docModuleSuperKey 2.0.0
 */
@DataPush
@ActionMapping("2.2.002")
public interface UserChatDataPush {

	/**
	 * 
	 * 推送私聊信息已读(userId)<br>
	 * Date 2020-04-16 20:25:17<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param sendUserId
	 * @param receiveUserId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0001")
	public void pushRead(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("sendUserId") String sendUserId,
			@Define("receiveUserId") String receiveUserId);

	/**
	 * 
	 * 推送私聊信息已读(contentId)<br>
	 * Date 2020-04-21 10:10:25<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param sendUserId
	 * @param receiveUserId
	 * @param contentId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0002")
	public void pushRead(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("sendUserId") String sendUserId,
			@Define("receiveUserId") String receiveUserId,
			@Define("contentId") String contentId);
}
