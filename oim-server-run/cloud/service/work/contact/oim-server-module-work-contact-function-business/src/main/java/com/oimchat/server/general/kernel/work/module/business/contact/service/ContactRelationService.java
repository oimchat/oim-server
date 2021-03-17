package com.oimchat.server.general.kernel.work.module.business.contact.service;

import java.util.List;

import javax.annotation.Resource;

import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.contact.dao.ContactRelationDAO;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactRelation;
import com.oimchat.server.general.kernel.work.module.base.contact.push.ContactPush;
import com.oimchat.server.general.kernel.work.module.base.contact.push.ContactRelationPush;
import com.onlyxiahui.aware.basic.work.business.error.ErrorCode;
import com.onlyxiahui.common.message.result.ResultMessage;

/**
 * 
 * Date 2019-01-20 14:15:38<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
@Transactional
public class ContactRelationService {

	@Resource
	private ContactRelationDAO contactRelationDAO;
	@Resource
	private ContactRelationPush contactRelationPush;
	@Resource
	private ContactPush contactPush;

	public ContactRelation get(String id) {
		ContactRelation data = contactRelationDAO.get(ContactRelation.class, id);
		return data;
	}

	/**
	 * 
	 * Date 2019-01-20 17:31:47<br>
	 * Description 获取所属用户的联系人分组列表
	 * 
	 * @author XiaHui<br>
	 * @param ownerUserId
	 * @return
	 * @since 1.0.0
	 */
	public List<ContactRelation> getListByOwnerUserId(String ownerUserId) {
		List<ContactRelation> list = contactRelationDAO.getListByOwnerUserId(ownerUserId);
		return list;
	}

	public ContactRelation getByContactUserId(String ownerUserId, String contactUserId) {
		return contactRelationDAO.getByContactUserId(ownerUserId, contactUserId);
	}

	public List<ContactRelation> getListByContactUserId(String ownerUserId, String contactUserId) {
		return contactRelationDAO.getListByContactUserId(ownerUserId, contactUserId);
	}

	/**
	 * 
	 * Date 2019-01-20 14:15:50<br>
	 * Description 移动好友到其它分组
	 * 
	 * @author XiaHui<br>
	 * @param ownerUserId
	 * @param contactUserId
	 * @param categoryId
	 * @return
	 * @since 1.0.0
	 */
	public ResultMessage moveCategory(String key, String ownerUserId, List<String> contactUserIds, String categoryId) {
		ResultMessage message = new ResultMessage();
		try {
			if (null != contactUserIds && !contactUserIds.isEmpty()) {
				int count = contactRelationDAO.updateCategoryId(ownerUserId, contactUserIds, categoryId);
				if (count <= 0) {
					message.addWarning(ErrorCode.business.code("0001"), "移动失败！");
				} else {
					contactRelationPush.pushMoveCategory(ownerUserId, key, contactUserIds, categoryId);
				}
			} else {
				message.addWarning(ErrorCode.system.code("500"), "系统异常！");
			}
		} catch (Exception e) {
			message.addWarning(ErrorCode.system.code("500"), "系统异常！");
		}
		return message;
	}

	/**
	 * 
	 * Date 2019-01-20 14:17:03<br>
	 * Description 修改好友备注
	 * 
	 * @author XiaHui<br>
	 * @param ownerUserId
	 * @param contactUserId
	 * @param remark
	 * @return
	 * @since 1.0.0
	 */
	public ResultMessage updateRemark(String key, String ownerUserId, String contactUserId, String remark) {

		ResultMessage message = new ResultMessage();
		try {

			if (StringUtil.isNotBlank(contactUserId)) {
				
				
				int count = contactRelationDAO.updateRemark(ownerUserId, contactUserId, remark);
				if (count <= 0) {
					message.addWarning(ErrorCode.business.code(".0001"), "修改失败！");
				} else {
					contactRelationPush.pushUpdateRemark(ownerUserId, key, contactUserId, remark);
				}
			} else {
				message.addWarning(ErrorCode.system.code("500"), "系统异常！");
			}
		} catch (Exception e) {
			message.addWarning(ErrorCode.system.code("500"), "系统异常！");
		}
		return message;
	}

	/**
	 * 
	 * Date 2019-01-20 14:18:20<br>
	 * Description 删除好友
	 * 
	 * @author XiaHui<br>
	 * @param ownerUserId
	 * @param contactUserId
	 * @return
	 * @since 1.0.0
	 */
	public ResultMessage delete(String key, String ownerUserId, String contactUserId) {

		ResultMessage message = new ResultMessage();
		try {
			if (StringUtil.isNotBlank(ownerUserId) && StringUtil.isNotBlank(contactUserId)) {
				int count = contactRelationDAO.deleteByContactUserId(ownerUserId, contactUserId);
				if (count <= 0) {
					message.addWarning(ErrorCode.business.code("0001"), "删除失败！");
				} else {
					contactRelationPush.pushDelete(ownerUserId, key, contactUserId);
				}
			} else {
				message.addWarning(ErrorCode.system.code("500"), "系统异常！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.addWarning(ErrorCode.system.code("500"), "系统异常！");
		}
		return message;
	}

	public ResultMessage updateBlocked(String key, String ownerUserId, String contactUserId, String isBlocked) {

		ResultMessage message = new ResultMessage();
		try {
			if (StringUtil.isNotBlank(ownerUserId) && StringUtil.isNotBlank(contactUserId)) {

				int count = contactRelationDAO.updateIsBlocked(ownerUserId, contactUserId, isBlocked);
				if (count <= 0) {
					message.addWarning(ErrorCode.business.code("001"), "失败！");
				} else {

					// 删除在对方好友列表
					count = contactRelationDAO.deleteByContactUserId(contactUserId, ownerUserId);
					contactRelationPush.pushUpdateBlocked(ownerUserId, key, contactUserId, isBlocked);
					if (ContactRelation.is_blocked_yes.equals(isBlocked)) {
						contactPush.pushUpdateBlocked(contactUserId, key, ownerUserId, isBlocked);
					}
				}
			} else {
				message.addWarning(ErrorCode.system.code("500"), "系统异常！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.addWarning(ErrorCode.system.code("500"), "系统异常！");
		}
		return message;
	}

	public ContactRelation getById(String ownerUserId, String relationId) {
		return contactRelationDAO.get(ContactRelation.class, relationId);
	}

	public List<ContactRelation> getByContactUserIds(String ownerUserId, List<String> contactUserIds) {
		// TODO Auto-generated method stub
		return null;
	}
}
