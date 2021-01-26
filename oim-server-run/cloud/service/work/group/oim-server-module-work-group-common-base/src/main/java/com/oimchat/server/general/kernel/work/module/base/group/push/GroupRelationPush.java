package com.oimchat.server.general.kernel.work.module.base.group.push;

import java.util.List;

import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.wofa.server.net.push.annotation.DataKey;
import com.onlyxiahui.wofa.server.net.push.annotation.DataPush;
import com.onlyxiahui.wofa.server.net.push.annotation.WriteKey;

/**
 * 群分组关系业务推送<br>
 * Date 2019-01-27 21:43:21<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.3.0
 */
@DataPush
@ActionMapping("1.3.003")
public interface GroupRelationPush {

	/**
	 * 
	 * 推送成功添加群<br>
	 * Date 2020-04-12 21:09:45<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @param groupId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0001")
	public void pushAdd(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("groupId") String groupId);

	/**
	 * 
	 * 推送修改备注<br>
	 * Date 2020-04-12 21:10:10<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @param groupId
	 * @param remark
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0002")
	public void pushUpdateRemark(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("groupId") String groupId,
			@Define("remark") String remark);

	/**
	 * 
	 * 推送移动分组<br>
	 * Date 2020-04-12 21:10:21<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @param groupIds
	 * @param categoryId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0003")
	public void pushMoveCategory(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("groupIds") List<String> groupIds,
			@Define("categoryId") String categoryId);

//	/**
//	 * 
//	 * 推送删除<br>
//	 * 退出群的时候推送给不同客户端<br>
//	 * Date 2020-04-12 21:10:29<br>
//	 * 
//	 * @param writeKey
//	 * @param key
//	 * @param groupId
//	 * @since 1.0.0
//	 */
//	@ActionMapping("1.2.0004")
//	public void pushDelete(
//			@WriteKey String writeKey,
//			@DataKey String key,
//			@Define("groupId") String groupId);

	/**
	 * 
	 * 推送删除<br>
	 * 解散群的时候批量推送给用户/退出群的时候推送给不同客户端<br>
	 * Date 2020-04-12 21:10:38<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param groupId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0004")
	public void pushDelete(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("groupId") String groupId);
}
