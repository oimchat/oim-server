package com.oimchat.server.general.common.api.inside.net.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.general.common.api.inside.net.control.client.NetControlPortalClient;
import com.oimchat.server.general.common.api.inside.net.control.data.NetControl;
import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * Description <br>
 * Date 2021-01-13 17:24:26<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class NetControlInterface {

	@Autowired
	NetControlPortalClient netControlPortalClient;

	public NetControl getData() {
		NetControl nc = null;
		MessageValue<NetControl> mv = netControlPortalClient.config("");
		if (null != mv && mv.isSuccess()) {
			nc = mv.getBody();
		}
		return nc;
	}
}
