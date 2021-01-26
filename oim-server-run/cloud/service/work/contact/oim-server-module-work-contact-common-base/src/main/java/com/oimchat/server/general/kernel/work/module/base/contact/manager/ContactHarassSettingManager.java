package com.oimchat.server.general.kernel.work.module.base.contact.manager;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.module.base.contact.dao.ContactHarassSettingDAO;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactHarassSetting;

/**
 * 
 * Date 2019-01-20 13:37:17<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class ContactHarassSettingManager {

	@Resource
	private ContactHarassSettingDAO contactHarassSettingDAO;

	public ContactHarassSetting getByUserId(String userId) {
		ContactHarassSetting uhs = contactHarassSettingDAO.getByUserId(userId);
		if (null == uhs) {
			uhs = new ContactHarassSetting();
			uhs.setVerifyType(ContactHarassSetting.verify_type_auth);
		}
		return uhs;
	}
}
