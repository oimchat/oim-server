package com.oimchat.server.general.common.cloud.net;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * 
 * Description <br>
 * Date 2020-05-13 21:11:53<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
public interface InvokeClient {

	/**
	 * Description <br>
	 * Date 2020-05-13 21:11:58<br>
	 * 
	 * @param data
	 * @return
	 * @since 1.0.0
	 */
	@PostMapping(consumes = "application/json;charset=UTF-8")
	public MessageValue<Object> invoke(@RequestBody String data);
}
