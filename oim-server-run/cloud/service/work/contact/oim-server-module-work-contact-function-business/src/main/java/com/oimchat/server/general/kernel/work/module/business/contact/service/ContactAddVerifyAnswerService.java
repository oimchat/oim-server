package com.oimchat.server.general.kernel.work.module.business.contact.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.contact.dao.ContactAddVerifyAnswerDAO;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactAddVerifyAnswer;

/**
 * Date 2019-01-20 22:30:07<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
@Transactional
public class ContactAddVerifyAnswerService {

	@Resource
	private ContactAddVerifyAnswerDAO contactAddVerifyAnswerDAO;

	public List<ContactAddVerifyAnswer> getListByApplyId(String targetUserId, String applyId) {
		List<ContactAddVerifyAnswer> list = contactAddVerifyAnswerDAO.getListByApplyId(targetUserId, applyId);
		return list;
	}

	public List<ContactAddVerifyAnswer> getListByApplyIds(String targetUserId, List<String> applyIds) {
		List<ContactAddVerifyAnswer> list = contactAddVerifyAnswerDAO.getListByApplyIds(targetUserId, applyIds);
		return list;
	}
}
