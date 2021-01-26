package com.oimchat.server.general.kernel.work.module.business.contact.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.basic.common.util.KeyUtil;
import com.oimchat.server.general.kernel.work.module.base.contact.dao.ContactCategoryDAO;
import com.oimchat.server.general.kernel.work.module.base.contact.dao.ContactRelationDAO;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactCategory;
import com.oimchat.server.general.kernel.work.module.base.contact.manager.ContactCategoryManager;
import com.oimchat.server.general.kernel.work.module.base.contact.push.ContactCategoryPush;
import com.onlyxiahui.aware.basic.work.business.error.ErrorCode;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import com.onlyxiahui.common.utils.base.util.time.DateUtil;

/**
 * 
 * Date 2019-01-20 14:01:41<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
@Transactional
public class ContactCategoryService {

	@Resource
	private ContactCategoryDAO contactCategoryDAO;
	@Resource
	private ContactCategoryPush contactCategoryPush;
	@Resource
	private ContactRelationDAO contactRelationDAO;
	@Resource
	private ContactCategoryManager contactCategoryManager;

	/**
	 * 
	 * Date 2019-01-20 14:09:57<br>
	 * Description 获取所有分组
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public List<ContactCategory> getListByUserId(String userId) {
		List<ContactCategory> list = contactCategoryDAO.getListByUserId(userId);
		return list;
	}

	public ContactCategory getById(String userId, String id) {
		ContactCategory category = contactCategoryDAO.get(ContactCategory.class, id);
		return category;
	}

	/**
	 * 
	 * Date 2019-01-20 14:04:32<br>
	 * Description 新增好友分组
	 * 
	 * @author XiaHui<br>
	 * @param contactCategory
	 * @return
	 * @since 1.0.0
	 */
	public ResultBodyMessage<ContactCategory> add(ContactCategory contactCategory) {
		ResultBodyMessage<ContactCategory> message = new ResultBodyMessage<>();
		if (null != contactCategory) {
			try {

				int maxCount = 30;
				String userId = contactCategory.getUserId();
				long count = contactCategoryDAO.getContactCategoryCount(userId);
				if (count >= maxCount) {
					message.addWarning(ErrorCode.business.code("0001"), "分组已经达到最大上限！");
				} else {
					int sort = (int) count;
					contactCategory.setSort(sort);
					contactCategory.setType(ContactCategory.type_custom);
					contactCategory.setCreatedDateTime(DateUtil.getCurrentDateTime());
					contactCategory.setCreatedTimestamp(System.currentTimeMillis());
					contactCategoryDAO.save(contactCategory);
					message.setBody(contactCategory);
					contactCategoryPush.pushAdd(userId, KeyUtil.getKey(), contactCategory.getId());
				}
			} catch (Exception e) {
				e.printStackTrace();
				message.addWarning(ErrorCode.system.code("500"), "系统异常！");
			}
		} else {
			message.addWarning(ErrorCode.system.code("500"), "系统异常！");
		}
		return message;
	}

	/**
	 * 
	 * Date 2019-01-20 14:06:12<br>
	 * Description 修改分组名称
	 * 
	 * @author XiaHui<br>
	 * @param id
	 * @param name
	 * @return
	 * @since 1.0.0
	 */
	public ResultMessage updateName(String userId, String id, String name) {
		ResultMessage message = new ResultMessage();
		try {
			if (StringUtil.isNotBlank(id)) {
				ContactCategory contactCategory = contactCategoryDAO.get(ContactCategory.class, id);
				contactCategory.setName(name);
				contactCategoryDAO.update(contactCategory);
				message.bodyPut("category", contactCategory);

				contactCategoryPush.pushUpdateName(userId, KeyUtil.getKey(), id, name);
			} else {
				message.addWarning(ErrorCode.system.code("500"), "系统异常！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.addWarning(ErrorCode.system.code("500"), "系统异常！");
		}
		return message;
	}

	/**
	 * 
	 * Date 2019-01-20 17:26:21<br>
	 * Description 修改排序
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param id
	 * @param sort
	 * @return
	 * @since 1.0.0
	 */
	public ResultMessage updateSort(String userId, String id, int sort) {
		ResultMessage message = new ResultMessage();
		try {
			if (StringUtil.isNotBlank(id)) {
				List<ContactCategory> list = contactCategoryDAO.getListByUserId(userId);
				int size = list.size();

				if (sort < size) {

					int temp = 0;

					for (int i = 0; i < size; i++) {
						ContactCategory m = list.get(i);
						if (!m.getId().equals(id)) {
							if (temp == sort) {
								temp++;
							}
							contactCategoryDAO.updateSort(m.getId(), temp);
							temp++;
						}
					}
					contactCategoryDAO.updateSort(id, sort);
				}

				contactCategoryPush.pushUpdateSort(userId, KeyUtil.getKey());
			} else {
				message.addWarning(ErrorCode.system.code("500"), "系统异常！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.addWarning(ErrorCode.system.code("500"), "系统异常！");
		}
		return message;
	}

	/**
	 * 
	 * Date 2019-01-20 16:56:33<br>
	 * Description
	 * 
	 * @author XiaHui<br>
	 * @param id
	 * @return
	 * @since 1.0.0
	 */
	public ResultMessage delete(String userId, String id) {
		ResultMessage message = new ResultMessage();
		ContactCategory category = contactCategoryDAO.get(ContactCategory.class, id);
		if (null != category) {
			if (ContactCategory.type_default == category.getType()) {
				message.addWarning(ErrorCode.business.code("001"), "不能删除默认分组！");
			} else {
				contactCategoryDAO.deleteById(ContactCategory.class, id);
				String newCategoryId = contactCategoryManager.getOrCreateDefaultCategoryId(userId);
				contactRelationDAO.updateChangeCategoryId(userId, id, newCategoryId);
				contactCategoryPush.pushDelete(userId, KeyUtil.getKey(), id);
			}
		}
		return message;
	}

	public void saveDefault(String userId) {

		ContactCategory bean = contactCategoryDAO.getDefaultContactCategory(userId);
		if (null == bean) {
			ContactCategory contactCategory = new ContactCategory();// 生成默认分组信息
			contactCategory.setUserId(userId);
			contactCategory.setName("我的好友");
			contactCategory.setSort(0);
			contactCategory.setType(ContactCategory.type_default);

			contactCategoryDAO.save(contactCategory);
		}
	}
}
