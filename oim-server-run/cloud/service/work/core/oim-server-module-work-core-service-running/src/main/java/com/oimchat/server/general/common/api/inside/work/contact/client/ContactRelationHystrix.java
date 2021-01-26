
package com.oimchat.server.general.common.api.inside.work.contact.client;

import java.util.ArrayList;
import java.util.List;

import com.oimchat.server.general.common.api.inside.work.contact.bean.ContactRelation;
import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * Description <br>
 * Date 2020-05-15 19:04:37<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class ContactRelationHystrix implements ContactRelationClient {

	@Override
	public MessageValue<List<ContactRelation>> getListByUserId(String userId) {
		List<ContactRelation> b = new ArrayList<>();
		MessageValue<List<ContactRelation>> mv = new MessageValue<>();
		mv.setBody(b);
		return mv;
	}
}
