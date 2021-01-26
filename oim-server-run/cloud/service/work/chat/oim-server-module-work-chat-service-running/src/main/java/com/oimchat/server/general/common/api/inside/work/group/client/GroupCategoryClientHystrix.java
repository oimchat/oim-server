
package com.oimchat.server.general.common.api.inside.work.group.client;

import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * Description <br>
 * Date 2020-05-15 19:04:37<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class GroupCategoryClientHystrix implements GroupCategoryClient {

	@Override
	public MessageValue<Object> saveDefault(String userId) {
		MessageValue<Object> mv = new MessageValue<>();
		mv.addError("0.500", "500");
		return mv;
	}
}
