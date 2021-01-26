package com.oimchat.server.general.kernel.work.module.base.group.push;

import java.util.List;

import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.wofa.server.net.push.annotation.DataKey;
import com.onlyxiahui.wofa.server.net.push.annotation.DataPush;
import com.onlyxiahui.wofa.server.net.push.annotation.WriteKey;

/**
 * 群信息业务推送<br>
 * Date 2019-01-27 21:43:21<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.3.0
 */
@DataPush
@ActionMapping("1.3.001")
public interface GroupInfoPush {

	/**
	 * 推送群更新<br>
	 * Date 2020-04-11 15:27:32<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param id        群id
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0001")
	public void pushUpdate(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("id") String id);

	/**
	 * 推送群修改头像<br>
	 * Date 2020-04-11 15:27:48<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param id        群id
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0002")
	public void pushUpdateHead(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("id") String id);
}
