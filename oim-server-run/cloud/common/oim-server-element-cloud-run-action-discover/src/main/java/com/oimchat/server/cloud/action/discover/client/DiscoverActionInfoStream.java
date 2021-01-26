package com.oimchat.server.cloud.action.discover.client;

import java.util.List;

import com.oimchat.server.cloud.action.discover.data.ActionInfo;
import com.onlyxiahui.common.data.common.data.Page;

/**
 * <br>
 * Date 2019-11-22 09:59:26<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public interface DiscoverActionInfoStream {

	/**
	 * 
	 * 
	 * 结果回调<br>
	 * Date 2020-07-21 12:03:37<br>
	 * 
	 * @param page
	 * @param list
	 * @since 1.0.0
	 */
	void handle(Page page, List<ActionInfo> list);
}
