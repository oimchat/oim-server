package com.oimchat.server.general.kernel.work.module.base.contact.push;

import com.oimchat.server.general.kernel.work.module.base.contact.data.dto.ContactAddResultData;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.wofa.server.net.push.annotation.DataKey;
import com.onlyxiahui.wofa.server.net.push.annotation.DataPush;
import com.onlyxiahui.wofa.server.net.push.annotation.WriteKey;

/**
 * 联系人业务推送<br>
 * Date 2019-01-27 21:43:21<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.2.0
 */
@DataPush
@ActionMapping("1.2.001")
public interface ContactPush {

	/**
	 * 推送收到请求被添加为联系人消息<br>
	 * Date 2019-01-27 19:24:21<br>
	 * 
	 * @author XiaHui<br>
	 * @param key
	 * @param applyId
	 * @param userId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0001")
	public void pushAddApply(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("applyId") String applyId);

	/**
	 * 
	 * 推送请求添加为联系人，被添加人处理后推送给请求人 <br>
	 * Date 2019-05-12 15:29:07<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0002")
	public void pushApplyHandle(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define() ContactAddResultData data);

	/**
	 * 
	 * 推送被拉黑/移除黑名单<br>
	 * Date 2020-04-10 22:44:30<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @param contactUserId 联系人
	 * @param isBlocked     是否被拉黑
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0003")
	public void pushUpdateBlocked(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("contactUserId") String contactUserId,
			@Define("isBlocked") String isBlocked);
}
