package com.oimchat.server.cloud.action.register.client;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.oimchat.server.cloud.action.register.data.ActionData;
import com.oimchat.server.cloud.action.register.data.ServerData;
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
public interface RegisterActionHandlerClient {

	/**
	 * 
	 * 
	 * 推送<br>
	 * Date 2020-07-23 14:28:45<br>
	 * 
	 * @param server
	 * @param items
	 * @return
	 * @since 1.0.0
	 */
	@PostMapping(value = "/v1/action/server.action.info/register", consumes = "application/json;charset=UTF-8")
	public MessageValue<Object> push(
			@PathVariable("server") ServerData server,
			@PathVariable("items") List<ActionData> items);
}
