package com.oimchat.server.general.kernel.work.module.base.contact.push;

import java.util.List;

import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.wofa.server.net.push.annotation.DataKey;
import com.onlyxiahui.wofa.server.net.push.annotation.DataPush;
import com.onlyxiahui.wofa.server.net.push.annotation.WriteKey;

/**
 * 联系人分组关系业务推送<br>
 * Date 2019-01-27 21:43:21<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.2.0
 */
@DataPush
@ActionMapping("1.2.003")
public interface ContactRelationPush {

	/**
	 * 
	 * 推送新增联系人<br>
	 * Date 2020-04-10 22:13:36<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @param contactUserId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0001")
	public void pushAdd(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("contactUserId") String contactUserId);

	/**
	 * 推送修改联系人备注<br>
	 * Date 2020-04-10 22:14:02<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @param contactUserId
	 * @param remark
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0002")
	public void pushUpdateRemark(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("contactUserId") String contactUserId,
			@Define("remark") String remark);

	/**
	 * 
	 * 推送联系人移动分组<br>
	 * Date 2020-04-10 22:49:33<br>
	 * 
	 * @param key
	 * @param contactUserIds
	 * @param categoryId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0003")
	public void pushMoveCategory(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("contactUserIds") List<String> contactUserIds,
			@Define("categoryId") String categoryId);

	/**
	 * 
	 * 推送删除联系人<br>
	 * Date 2020-04-10 22:50:10<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @param contactUserId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0004")
	public void pushDelete(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("contactUserId") String contactUserId);

	/**
	 * 
	 * 推送联系人拉入黑名单<br>
	 * Date 2020-04-10 22:50:25<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @param contactUserId
	 * @param isBlocked
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0005")
	public void pushUpdateBlocked(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("contactUserId") String contactUserId,
			@Define("isBlocked") String isBlocked);
}
