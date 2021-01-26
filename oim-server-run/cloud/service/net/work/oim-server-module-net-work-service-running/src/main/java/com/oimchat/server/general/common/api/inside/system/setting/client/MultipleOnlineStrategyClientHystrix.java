
package com.oimchat.server.general.common.api.inside.system.setting.client;

import com.oimchat.server.general.common.api.inside.system.setting.bean.MultipleCheck;
import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * Description <br>
 * Date 2020-05-15 19:04:37<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class MultipleOnlineStrategyClientHystrix implements MultipleOnlineStrategyClient {

	@Override
	public MessageValue<MultipleCheck> multipleCheck(String userId) {
		MessageValue<MultipleCheck> mv = new MessageValue<>();
//		mv.addError("0.500", "500");
		mv.setBody(new MultipleCheck());
		return mv;
	}
}
