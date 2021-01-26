
package com.oimchat.server.general.common.api.inside.net.work.client;

import com.oimchat.server.general.common.api.inside.common.data.ServerConfigData;
import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * Description <br>
 * Date 2020-05-15 19:04:37<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class ServerConfigHystrix implements ServerConfigClient {

	@Override
	public MessageValue<ServerConfigData> get(String temp) {
		MessageValue<ServerConfigData> mv = new MessageValue<>();
		return mv;
	}
}
