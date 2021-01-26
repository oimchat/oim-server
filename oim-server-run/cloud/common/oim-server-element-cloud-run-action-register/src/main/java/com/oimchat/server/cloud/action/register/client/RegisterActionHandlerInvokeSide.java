package com.oimchat.server.cloud.action.register.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.cloud.action.register.common.client.RegisterActionClientNameBuilder;
import com.oimchat.server.cloud.action.register.data.ActionData;
import com.oimchat.server.cloud.action.register.data.ServerData;

/**
 * 
 * <br>
 * Date 2020-07-20 16:40:26<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class RegisterActionHandlerInvokeSide {

	@Autowired
	private RegisterActionClientNameBuilder clientNameBuilder;

	private RegisterActionHandlerClient client;

	private RegisterActionHandlerClient getClient() {
		if (null == client) {
			String url = "http://core-action";
			client = clientNameBuilder.target(RegisterActionHandlerClient.class, url, new RegisterActionHandlerHystrix());
		}
		return client;
	}

	public void push(ServerData server, List<ActionData> items) {
		RegisterActionHandlerClient client = getClient();
		client.push(server, items);
	}
}
