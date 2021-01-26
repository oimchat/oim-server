package com.oimchat.server.general.kernel.work.module.base.user.push;

import java.util.List;

import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.wofa.server.net.push.annotation.DataKey;
import com.onlyxiahui.wofa.server.net.push.annotation.DataPush;
import com.onlyxiahui.wofa.server.net.push.annotation.WriteKey;

/**
 * 
 * 用户业务推送 <br>
 * Date 2020-04-09 18:59:25<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.1.0
 */
@DataPush
@ActionMapping("1.1.003")
public interface UserPush {

	/**
	 * 推送用户更新信息<br>
	 * Date 2019-01-26 10:57:37<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param userId    信息变更的用户id
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0001")
	public void pushUserUpdate(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("id") String userId);

	/**
	 * 推送用户头像修改信息<br>
	 * Date 2019-01-26 11:00:24<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param userId    用户id
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0002")
	public void pushUserUpdateHead(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("id") String userId);

	/**
	 * 
	 * 推送用户签名更新<br>
	 * Date 2019-01-26 09:50:00<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param userId    用户id
	 * @param signature 签名
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0003")
	public void pushUserUpdateSignature(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("id") String userId,
			@Define("signature") String signature);

	/**
	 * 推送用户在先状态变化<br>
	 * Date 2019-01-26 09:49:08<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param userId    状态变化用户id
	 * @param status    状态
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0004")
	public void pushUserStatus(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("id") String userId,
			@Define("status") String status);

	/**
	 * 
	 * 推送用户删除 <br>
	 * Date 2020-05-29 10:08:21<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param userId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0005")
	public void pushUserDelete(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("id") String userId);
}
