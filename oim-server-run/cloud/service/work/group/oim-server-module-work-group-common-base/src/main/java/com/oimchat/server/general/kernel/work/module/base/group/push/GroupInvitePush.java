package com.oimchat.server.general.kernel.work.module.base.group.push;

import java.util.List;

import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.wofa.server.net.push.annotation.DataKey;
import com.onlyxiahui.wofa.server.net.push.annotation.DataPush;
import com.onlyxiahui.wofa.server.net.push.annotation.WriteKey;

/**
 * 群邀请业务推送<br>
 * Date 2019-01-27 21:43:21<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.3.0
 */
@DataPush
@ActionMapping("1.3.008")
public interface GroupInvitePush {

	/**
	 * 推送邀请申请(群主/管理员)<br>
	 * Date 2020-04-11 15:28:24<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param groupId
	 * @param applyId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0001")
	public void pushInviteApply(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("groupId") String groupId,
			@Define("applyId") String applyId);

	/**
	 * 
	 * 推送邀请(被邀请者)<br>
	 * Date 2020-04-12 21:24:03<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @param groupId
	 * @param applyId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0003")
	public void pushInvite(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("groupId") String groupId,
			@Define("applyId") String applyId);
}
