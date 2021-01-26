package com.oimchat.server.general.kernel.work.module.base.personal.push;

import com.oimchat.server.basic.common.data.client.Client;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.wofa.server.net.push.annotation.DataKey;
import com.onlyxiahui.wofa.server.net.push.annotation.DataPush;
import com.onlyxiahui.wofa.server.net.push.annotation.WriteKey;

/**
 * 
 * 个人业务推送 <br>
 * Date 2020-04-09 20:34:28<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.1.0
 */
@DataPush
@ActionMapping("1.1.002")
public interface PersonalPush {

	/**
	 * 推送其他客户端登陆信息 <br>
	 * Date 2020-04-10 09:37:49<br>
	 * 
	 * @param writeKey
	 * @param client   上线的客户端信息
	 * @param offline  收到消息的客户端是否下线
	 * @since 1.0.0
	 */
	@ActionMapping()
	public void pushOtherOnline(
			@WriteKey String writeKey,
			@Define("client") Client client,
			@Define("offline") boolean offline);

	/**
	 * 
	 * 推送个人信息更新消息 <br>
	 * Date 2020-04-10 09:39:46<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0002")
	public void pushUpdate(
			@WriteKey String writeKey,
			@DataKey String key);

	/**
	 * 
	 * 推送个人密码更新消息<br>
	 * Date 2020-04-10 09:41:50<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0003")
	public void pushUpdatePassword(
			@WriteKey String writeKey,
			@DataKey String key);

	/**
	 * 
	 * 推送个人头像修改消息<br>
	 * Date 2020-04-10 09:41:46<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0004")
	public void pushUpdateHead(
			@WriteKey String writeKey,
			@DataKey String key);

	/**
	 * 
	 * 推送个人签名修改消息<br>
	 * Date 2020-04-10 09:41:43<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @param signature
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0005")
	public void pushUpdateSignature(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("signature") String signature);

	/**
	 * 
	 * 推送个人状态变更消息<br>
	 * Date 2020-04-10 09:41:39<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @param status
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0006")
	public void pushUpdateStatus(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("status") String status);
}
