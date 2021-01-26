package com.oimchat.server.cloud.action.discover.client;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.oimchat.server.cloud.action.discover.data.ActionInfo;
import com.oimchat.server.cloud.action.discover.data.ActionInfoQuery;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * 
 * 
 * <br>
 * Date 2020-01-02 17:05:29<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
public interface DiscoverActionInfoClient {

	/**
	 * 
	 * 
	 * <br>
	 * Date 2020-07-20 17:15:28<br>
	 * 
	 * 
	 * @param page
	 * @param query
	 * @return
	 * @since 1.0.0
	 */
	@PostMapping(value = "/v1/action/server.action.info/list", consumes = "application/json;charset=UTF-8")
	public MessageValue<PageResult<List<ActionInfo>>> list(
			@PathVariable("page") Page page,
			@PathVariable("query") ActionInfoQuery query);
}
