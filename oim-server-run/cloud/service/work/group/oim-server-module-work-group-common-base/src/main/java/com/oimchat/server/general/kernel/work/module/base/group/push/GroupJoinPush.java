package com.oimchat.server.general.kernel.work.module.base.group.push;

import java.util.List;

import com.oimchat.server.general.kernel.work.module.base.group.data.dto.GroupJoinResultData;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.wofa.server.net.push.annotation.DataKey;
import com.onlyxiahui.wofa.server.net.push.annotation.DataPush;
import com.onlyxiahui.wofa.server.net.push.annotation.WriteKey;

/**
 * 加入群业务推送<br>
 * Date 2019-01-27 21:43:21<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.3.0
 */
@DataPush
@ActionMapping("1.3.007")
public interface GroupJoinPush {

	/**
	 * 
	 * 推送加入申请(推送给群主/管理员)<br>
	 * Date 2020-04-11 15:30:42<br>
	 * 
	 * @param writeKeys
	 * @param key
	 * @param groupId
	 * @param applyId
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0001")
	public void pushJoinApply(
			@WriteKey List<String> writeKeys,
			@DataKey String key,
			@Define("groupId") String groupId,
			@Define("applyId") String applyId);

	/**
	 * 
	 * 推送申请处理结果(推送给申请者) <br>
	 * Date 2020-04-11 15:31:58<br>
	 * 
	 * @param writeKey
	 * @param key
	 * @param result
	 * @since 1.0.0
	 */
	@ActionMapping("1.2.0002")
	public void pushJoinHandle(
			@WriteKey String writeKey,
			@DataKey String key,
			@Define("") GroupJoinResultData result);
}
