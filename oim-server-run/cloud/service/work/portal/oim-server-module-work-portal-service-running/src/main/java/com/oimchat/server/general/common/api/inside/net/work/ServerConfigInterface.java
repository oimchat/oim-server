package com.oimchat.server.general.common.api.inside.net.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.general.common.api.inside.common.data.ServerConfigData;
import com.oimchat.server.general.common.api.inside.net.work.client.ServerConfigClient;
import com.oimchat.server.general.kernel.work.common.config.constant.ServerConstant;
import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * Description <br>
 * Date 2021-01-20 11:49:48<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class ServerConfigInterface {

	@Autowired
	ServerConfigClient serverConfigClient;

	public ServerConfigData getServerConfigData() {
		ServerConfigData data = null;
		MessageValue<ServerConfigData> mv = serverConfigClient.get("");
		if (null != mv && null != mv.getBody()) {
			data = mv.getBody();
			if (null != data) {
				String main = (ServerConstant.ServerType.main.value());
				data.setCode(main);
				data.setEnabled(true);
			}
		}
		return data;
	}
}
