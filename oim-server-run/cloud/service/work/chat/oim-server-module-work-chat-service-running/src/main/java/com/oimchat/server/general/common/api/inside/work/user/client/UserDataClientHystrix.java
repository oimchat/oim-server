
package com.oimchat.server.general.common.api.inside.work.user.client;

import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.UserSimple;
import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * Description <br>
 * Date 2020-05-15 19:04:37<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class UserDataClientHystrix implements UserDataClient {

	@Override
	public MessageValue<UserSimple> getUserSimpleById(String id) {
		MessageValue<UserSimple> mv = new MessageValue<>();
		mv.addError("0.500", "500");
		return mv;
	}
}
