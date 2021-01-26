package com.oimchat.server.cloud.action.discover.client;

import java.util.List;

import com.oimchat.server.cloud.action.discover.data.ActionInfo;
import com.oimchat.server.cloud.action.discover.data.ActionInfoQuery;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * 
 * <br>
 * Date 2020-07-20 16:47:08<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class DiscoverActionInfoHystrix implements DiscoverActionInfoClient {

	@Override
	public MessageValue<PageResult<List<ActionInfo>>> list(Page page, ActionInfoQuery query) {
		return new MessageValue<PageResult<List<ActionInfo>>>();
	}
}
