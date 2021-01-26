package com.oimchat.server.general.kernel.work.module.base.group.push;

import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.wofa.server.net.push.annotation.DataKey;
import com.onlyxiahui.wofa.server.net.push.annotation.DataPush;
import com.onlyxiahui.wofa.server.net.push.annotation.WriteKey;

/**
 * 群分组业务推送<br>
 * Date 2019-01-27 21:43:21<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.3.0
 */
@DataPush
@ActionMapping("1.3.002")
public interface GroupCategoryPush {

	/**
	 * 
	 * 推送新增分组<br>
	 * Date 2020-04-11 15:24:45<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @param id
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0001")
	public void pushAdd(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("id") String id);

	/**
	 * 推送修改名称<br>
	 * Date 2020-04-11 15:25:14<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @param id
	 * @param name
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0003")
	public void pushUpdateName(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("id") String id,
			@Define("name") String name);

	/**
	 * 推送更新排序<br>
	 * Date 2020-04-11 15:25:31<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0004")
	public void pushUpdateSort(
			@WriteKey String writeKey,
			@DataKey String key);

	/**
	 * 推送删除分组<br>
	 * Date 2020-04-11 15:27:10<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @param id
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0005")
	public void pushDelete(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("id") String id);
}
