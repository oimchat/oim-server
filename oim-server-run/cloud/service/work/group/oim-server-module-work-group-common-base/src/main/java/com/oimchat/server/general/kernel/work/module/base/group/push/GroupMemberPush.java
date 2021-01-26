package com.oimchat.server.general.kernel.work.module.base.group.push;

import java.util.List;

import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.wofa.server.net.push.annotation.DataKey;
import com.onlyxiahui.wofa.server.net.push.annotation.DataPush;
import com.onlyxiahui.wofa.server.net.push.annotation.WriteKey;

/**
 * 群成员业务推送<br>
 * Date 2019-01-27 21:43:21<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.3.0
 */
@DataPush
@ActionMapping("1.3.004")
public interface GroupMemberPush {

	/**
	 * 
	 * 推送新增成员<br>
	 * Date 2020-04-12 17:14:42<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param groupId
	 * @param userId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0001")
	public void pushAdd(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("groupId") String groupId,
			@Define("userId") String userId);

	/**
	 * 
	 * 推送成员信息更新<br>
	 * Date 2020-04-12 17:14:59<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param groupId
	 * @param userId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0002")
	public void pushUpdate(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("groupId") String groupId,
			@Define("userId") String userId);

	/**
	 * 
	 * 推送成员权限变更<br>
	 * Date 2020-04-12 17:15:20<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param groupId
	 * @param userId
	 * @param position
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0003")
	public void pushUpdatePosition(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("groupId") String groupId,
			@Define("userId") String userId,
			@Define("position") String position);

	/**
	 * 
	 * 推送删除成员<br>
	 * Date 2020-04-12 17:15:41<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param groupId
	 * @param userId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0004")
	public void pushDelete(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("groupId") String groupId,
			@Define("userId") String userId);

	/**
	 * 
	 * 推送信息更新<br>
	 * Date 2020-05-14 19:30:00<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param groupId
	 * @param userId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0005")
	public void pushInfoUpdate(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("groupId") String groupId,
			@Define("userId") String userId);
}
