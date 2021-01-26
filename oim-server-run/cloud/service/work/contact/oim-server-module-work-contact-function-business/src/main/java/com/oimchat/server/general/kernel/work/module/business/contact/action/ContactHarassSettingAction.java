package com.oimchat.server.general.kernel.work.module.business.contact.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.contact.data.dto.ContactHarassSettingEntityCase;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactAddVerifyQuestion;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactHarassSetting;
import com.oimchat.server.general.kernel.work.module.business.contact.service.ContactHarassSettingService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 防骚扰设置<br>
 * Date 2019-01-20 11:55:08<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.2.0
 */
@Component
@ActionMapping(value = "1.2.004")
public class ContactHarassSettingAction {

	@Resource
	private ContactHarassSettingService contactHarassSettingService;

	/**
	 * 
	 * 获取防骚扰设置<br>
	 * Date 2020-04-10 20:09:16<br>
	 * 
	 * @param userSession
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0001")
	public ContactHarassSettingEntityCase get(
			UserSession userSession) {
		String userId = userSession.getUserId();
		ContactHarassSetting data = contactHarassSettingService.getByUserId(userId);
		List<ContactAddVerifyQuestion> list = contactHarassSettingService.getVerifyQuestionListByUserId(userId);
		return new ContactHarassSettingEntityCase(data, list);
	}

	/**
	 * 
	 * 更新防骚扰设置<br>
	 * Date 2020-04-10 20:09:56<br>
	 * 
	 * @param userSession
	 * @param data
	 * @param list
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0002")
	public Info update(
			UserSession userSession,
			@Define("body.setting") ContactHarassSetting data,
			@Define("body.questions") List<ContactAddVerifyQuestion> list) {
		String userId = userSession.getUserId();
		data.setUserId(userId);
		return contactHarassSettingService.saveOrUpdate(data, list);
	}
}
