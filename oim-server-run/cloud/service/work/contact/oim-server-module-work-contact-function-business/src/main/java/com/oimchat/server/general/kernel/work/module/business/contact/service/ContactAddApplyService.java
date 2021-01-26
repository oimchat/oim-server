package com.oimchat.server.general.kernel.work.module.business.contact.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.contact.dao.ContactAddApplyDAO;
import com.oimchat.server.general.kernel.work.module.base.contact.dao.ContactAddVerifyAnswerDAO;
import com.oimchat.server.general.kernel.work.module.base.contact.data.dto.ContactAddApplyQuery;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactAddApply;
import com.onlyxiahui.common.data.common.data.Page;

/**
 * Date 2019-01-20 22:30:07<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
@Transactional
public class ContactAddApplyService {

	@Resource
	private ContactAddApplyDAO contactAddApplyDAO;
	@Resource
	private ContactAddVerifyAnswerDAO contactAddVerifyAnswerDAO;

	/**
	 * 
	 * Date 2019-01-20 22:32:52<br>
	 * Description 获取用户被请求添加的列表
	 * 
	 * @author XiaHui<br>
	 * @param targetUserId
	 * @return
	 * @since 1.0.0
	 */
	public List<ContactAddApply> getListByTargetUserId(String targetUserId, Page page) {
		List<ContactAddApply> list = contactAddApplyDAO.getListByTargetUserId(targetUserId, page);
		return list;
	}

	public List<ContactAddApply> queryList(String targetUserId, ContactAddApplyQuery query, Page page) {
		List<ContactAddApply> list = contactAddApplyDAO.queryList(targetUserId, query, page);
		return list;
	}

	public ContactAddApply get(String id) {
		ContactAddApply bean = contactAddApplyDAO.get(id);
		return bean;
	}
}
