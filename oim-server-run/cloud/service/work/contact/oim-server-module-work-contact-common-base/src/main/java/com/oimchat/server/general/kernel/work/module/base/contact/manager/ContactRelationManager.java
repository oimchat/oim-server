package com.oimchat.server.general.kernel.work.module.base.contact.manager;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.module.base.contact.dao.ContactRelationDAO;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactRelation;
import com.onlyxiahui.common.utils.base.util.time.DateUtil;

/**
 * 
 * Date 2019-01-27 08:45:57<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class ContactRelationManager {

	@Resource
	private ContactRelationDAO contactRelationDAO;

	/**
	 * 
	 * Date 2019-01-20 17:44:16<br>
	 * Description 相互添加为联系人
	 * 
	 * @author XiaHui<br>
	 * @param applyUserId
	 * @param applyCategoryId
	 * @param applyRemark
	 * @param targetUserId
	 * @param targetCategoryId
	 * @param targetRemark
	 * @return boolean
	 * @since 1.0.0
	 */
	public boolean bothContact(
			String applyUserId,
			String applyCategoryId,
			String applyRemark,
			String targetUserId,
			String targetCategoryId,
			String targetRemark) {
		boolean mark = true;
		if (!hasContact(applyUserId, targetUserId)) {
			add(applyUserId, targetUserId, applyCategoryId, applyRemark);
		}
		if (!hasContact(targetUserId, applyUserId)) {
			add(targetUserId, applyUserId, targetCategoryId, targetRemark);
		}
		return mark;
	}

	/**
	 * 
	 * Description 新增 <br>
	 * Date 2019-05-08 23:20:55<br>
	 * 
	 * @param ownerUserId
	 * @param contactUserId
	 * @param categoryId
	 * @param remark
	 * @return ContactRelation
	 * @since 1.0.0
	 */
	public ContactRelation add(
			String ownerUserId, // 拥有者id
			String contactUserId, // 成员id
			String categoryId, // 分组id
			String remark) {
		String isBlocked = ContactRelation.is_blocked_no;
		ContactRelation bean = new ContactRelation();
		bean.setOwnerUserId(ownerUserId);
		bean.setContactUserId(contactUserId);
		bean.setCategoryId(categoryId);
		bean.setRemark(remark);
		bean.setIsBlocked(isBlocked);

		bean.setCreatedDateTime(DateUtil.getCurrentDateTime());
		bean.setCreatedTimestamp(System.currentTimeMillis());
		contactRelationDAO.save(bean);
		return bean;
	}

	/**
	 * 
	 * Description 是否在黑名单中 <br>
	 * Date 2019-05-08 23:20:34<br>
	 * 
	 * @param ownerUserId
	 * @param contactUserId
	 * @return boolean
	 * @since 1.0.0
	 */
	public boolean isBlocked(String ownerUserId, String contactUserId) {
		ContactRelation bean = contactRelationDAO.getByContactUserId(ownerUserId, contactUserId);
		boolean isBlocked = null != bean && ContactRelation.is_blocked_yes.equals(bean.getIsBlocked());
		return isBlocked;
	}

	/**
	 * 
	 * Description 是否存在 <br>
	 * Date 2019-05-31 14:48:52<br>
	 * 
	 * @param ownerUserId
	 * @param contactUserId
	 * @return boolean
	 * @since 1.0.0
	 */
	public boolean hasContact(String ownerUserId, String contactUserId) {
		ContactRelation bean = contactRelationDAO.getByContactUserId(ownerUserId, contactUserId);
		return bean != null;
	}
}
