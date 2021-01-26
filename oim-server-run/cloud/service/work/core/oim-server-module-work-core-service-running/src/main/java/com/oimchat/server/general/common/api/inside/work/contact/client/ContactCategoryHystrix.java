
package com.oimchat.server.general.common.api.inside.work.contact.client;

import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * Description <br>
 * Date 2020-05-15 19:04:37<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class ContactCategoryHystrix implements ContactCategoryClient {

	@Override
	public MessageValue<Object> saveDefault(String userId) {
		MessageValue<Object> mv = new MessageValue<>();
		mv.addError("0.500", "500");
		return mv;
	}
}
