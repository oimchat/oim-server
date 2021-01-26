package com.oimchat.server.cloud.action.register.client;

import java.util.List;

import com.oimchat.server.cloud.action.register.data.ActionData;
import com.oimchat.server.cloud.action.register.data.ServerData;
import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * 
 * <br>
 * Date 2020-07-20 15:37:54<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class RegisterActionHandlerHystrix implements RegisterActionHandlerClient {

	@Override
	public MessageValue<Object> push(ServerData server, List<ActionData> items) {
		return new MessageValue<Object>();
	}
}
