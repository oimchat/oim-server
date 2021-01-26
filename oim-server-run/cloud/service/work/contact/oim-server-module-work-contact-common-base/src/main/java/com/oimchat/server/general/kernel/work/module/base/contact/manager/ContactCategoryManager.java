package com.oimchat.server.general.kernel.work.module.base.contact.manager;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.module.base.contact.dao.ContactCategoryDAO;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactCategory;

/**
 * 
 * Date 2019-01-20 17:50:07<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class ContactCategoryManager {

	@Resource
	ContactCategoryDAO contactCategoryDAO;

	/**
	 * 
	 * Date 2019-01-20 17:48:44<br>
	 * Description 获取默认的联系人分组，没有则创建
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public ContactCategory getOrCreateDefault(String userId) {
		ContactCategory bean = contactCategoryDAO.getDefaultContactCategory(userId);
		if (null == bean) {
			bean = new ContactCategory();
			bean.setUserId(userId);
			bean.setName("我的好友");
			bean.setSort(0);
			bean.setType(ContactCategory.type_default);
			contactCategoryDAO.save(bean);
		}
		return bean;
	}

	/**
	 * 
	 * Date 2019-01-20 17:51:28<br>
	 * Description 获取默认分组id
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public String getOrCreateDefaultCategoryId(String userId) {
		ContactCategory bean = getOrCreateDefault(userId);
		return null != bean ? bean.getId() : "";
	}
}
