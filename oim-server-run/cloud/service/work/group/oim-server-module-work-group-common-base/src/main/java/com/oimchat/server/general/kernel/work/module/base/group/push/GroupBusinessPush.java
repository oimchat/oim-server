package com.oimchat.server.general.kernel.work.module.base.group.push;

import java.util.List;

import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.wofa.server.net.push.annotation.DataKey;
import com.onlyxiahui.wofa.server.net.push.annotation.DataPush;
import com.onlyxiahui.wofa.server.net.push.annotation.WriteKey;

/**
 * 群业务推送<br>
 * Date 2019-01-27 21:43:21<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.3.0
 */
@DataPush
@ActionMapping("1.3.005")
public interface GroupBusinessPush {

//	/**
//	 * 
//	 * 推送群主变更(推送给所有成员)<br>
//	 * Date 2020-04-11 13:41:44<br>
//	 * 
//	 * @param writeKeys
//	 * @param key
//	 * @param groupId
//	 * @param oldOwnerUserId
//	 * @param newOwnerUserId
//	 * @since 1.0.0
//	 */
//	@ActionMapping("1.2.0001")
//	public void pushChangeGroupOwner(
//			@WriteKey List<String> writeKeys,
//			@DataKey String key,
//			@Define("groupId") String groupId,
//			@Define("oldOwnerUserId") String oldOwnerUserId,
//			@Define("newOwnerUserId") String newOwnerUserId);

	/**
	 * 
	 * 推送解散群<br>
	 * Date 2020-04-11 13:42:13<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @param groupId
	 * @param ownerUserId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0002")
	public void pushDisband(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("groupId") String groupId,
			@Define("ownerUserId") String ownerUserId);

//	/**
//	 * 
//	 * 推送解散群(推送给所有成员)<br>
//	 * Date 2020-04-11 13:42:13<br>
//	 * 
//	 * @param writeKeys
//	 * @param key
//	 * @param groupId
//	 * @param ownerUserId
//	 * @since 1.0.0
//	 */
//	@ActionMapping("1.2.0002")
//	public void pushDisband(
//			@WriteKey List<String> writeKeys,
//			@DataKey String key,
//			@Define("groupId") String groupId,
//			@Define("ownerUserId") String ownerUserId);

	/**
	 * 
	 * 推送退出群(通知管理员和群主)<br>
	 * Date 2020-04-11 13:43:17<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param groupId
	 * @param userId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0003")
	public void pushQuit(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("groupId") String groupId,
			@Define("userId") String userId);
}
