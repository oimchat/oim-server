package com.oimchat.server.general.kernel.work.module.business.contact.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactRelation;
import com.oimchat.server.general.kernel.work.module.business.contact.service.ContactRelationService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 
 * Description <br>
 * Date 2020-05-17 20:23:50<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Controller
@ActionMapping("")
public class ContactRelationController {

	@Resource
	private ContactRelationService contactRelationService;

	@ActionMapping("/v1/contact/contact.relation/list.by.user.id")
	public List<ContactRelation> getListByUserId(
			@Define("body.userId") String userId) {
		List<ContactRelation> list = contactRelationService.getListByOwnerUserId(userId);
		return list;
	}
}
