package com.oimchat.server.general.kernel.work.module.business.chat.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.util.KeyUtil;
import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.Motion;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Content;
import com.oimchat.server.general.kernel.work.module.base.chat.push.UserChatPush;
import com.oimchat.server.general.kernel.work.module.business.chat.service.UserChatDataService;
import com.oimchat.server.general.kernel.work.module.business.chat.service.UserChatService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.base.HeadImpl;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 
 * 私聊业务接口<br>
 * Date 2020-04-16 19:34:29<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 * @docModuleSuperKey 2.0.0
 */
@Component
@ActionMapping(value = "2.2.001")
public class UserChatAction {

	@Resource
	UserChatService userChatService;
	@Resource
	UserChatPush userChatPush;
	@Resource
	UserChatDataService userChatDataService;

	/**
	 * 
	 * 向用户发送抖动 <br>
	 * Date 2019-05-22 17:57:32<br>
	 * 
	 * @param head
	 * @param userSession
	 * @param receiveUserId
	 * @param motion
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0000")
	public void userAction(
			HeadImpl head,
			UserSession userSession,
			@Define("body.receiveUserId") String receiveUserId,
			@Define("body.motion") Motion motion) {
		String sendUserId = userSession.getUserId();
		List<String> idList = new ArrayList<String>();
		idList.add(sendUserId);
		idList.add(receiveUserId);
		userChatPush.motion(idList, head.getKey(), sendUserId, receiveUserId, motion);
	}

	/**
	 * 发送私聊信息<br>
	 * Date 2019-02-17 17:51:26<br>
	 * 
	 * @author XiaHui<br>
	 * @param head
	 * @param sendUserId
	 * @param receiveUserId
	 * @param content
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0001")
	public void userChat(
			HeadImpl head,
			@Define("body.sendUserId") String sendUserId,
			@Define("body.receiveUserId") String receiveUserId,
			@Define("body.content") Content content) {
		String key = (null == head.getKey() || head.getKey().isEmpty()) ? KeyUtil.getKey() : head.getKey();
		userChatService.userChat(key, sendUserId, receiveUserId, content);
	}

	/**
	 * 
	 * Description <br>
	 * Date 2020-04-21 10:13:01<br>
	 * 
	 * @param head
	 * @param sendUserId
	 * @param receiveUserId
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0003")
	public void input(
			HeadImpl head,
			UserSession userSession,
			@Define("body.sendUserId") String sendUserId,
			@Define("body.receiveUserId") String receiveUserId) {
		sendUserId = userSession.getUserId();
		String key = (null == head.getKey() || head.getKey().isEmpty()) ? KeyUtil.getKey() : head.getKey();
		userChatPush.pushInput(receiveUserId, key, sendUserId, receiveUserId);
	}
}
