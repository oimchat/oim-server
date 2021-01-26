
package com.oimchat.server.general.common.api.inside.net.control.client;

import org.springframework.web.bind.annotation.PathVariable;

import com.oimchat.server.general.common.api.inside.net.control.data.NetControl;
import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * Description <br>
 * Date 2020-05-15 19:04:37<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class NetControlPortalHystrix implements NetControlPortalClient {

	@Override
	public MessageValue<NetControl> config(@PathVariable("type") String type) {
		MessageValue<NetControl> mv = new MessageValue<>();
		mv.addError("0.500", "500");
		return mv;
	}
}
