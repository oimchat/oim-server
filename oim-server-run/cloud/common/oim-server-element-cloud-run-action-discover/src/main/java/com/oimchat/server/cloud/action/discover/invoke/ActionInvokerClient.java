package com.oimchat.server.cloud.action.discover.invoke;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.onlyxiahui.common.message.Message;

/**
 * Description <br>
 * Date 2021-01-18 18:17:42<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public interface ActionInvokerClient {

	@PostMapping(consumes = "application/json;charset=UTF-8")
	public String invoke(@RequestBody Message<?, ?> m);
}
