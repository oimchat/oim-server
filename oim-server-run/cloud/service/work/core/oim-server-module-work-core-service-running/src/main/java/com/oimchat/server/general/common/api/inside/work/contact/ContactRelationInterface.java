package com.oimchat.server.general.common.api.inside.work.contact;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.general.common.api.inside.work.contact.bean.ContactRelation;
import com.oimchat.server.general.common.api.inside.work.contact.client.ContactRelationClient;
import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * Description <br>
 * Date 2021-01-22 18:23:05<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class ContactRelationInterface {

	@Autowired
	private ContactRelationClient contactRelationClient;

	public List<ContactRelation> getListByUserId(String userId) {
		MessageValue<List<ContactRelation>> mv = contactRelationClient.getListByUserId(userId);
		return null != mv && null != mv.getBody() ? mv.getBody() : new ArrayList<>();
	}
}
