
package com.oimchat.server.general.kernel.work.business.impl.user.function;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.general.kernel.work.define.user.function.UserInitialize;
import com.oimchat.server.general.kernel.work.module.base.contact.dao.ContactCategoryDAO;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactCategory;
import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupCategoryDAO;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupCategory;

/**
 * Description <br>
 * Date 2020-04-09 19:13:43<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class UserInitializeImpl implements UserInitialize {

	@Resource
	private ContactCategoryDAO contactCategoryDAO;
	@Resource
	private GroupCategoryDAO groupCategoryDAO;

	@Override
	public void initialize(String userId) {

		// 生成默认分组信息
		ContactCategory contactCategory = new ContactCategory();
		contactCategory.setUserId(userId);
		contactCategory.setName("我的好友");
		contactCategory.setSort(0);
		contactCategory.setType(ContactCategory.type_default);

		contactCategoryDAO.save(contactCategory);

		// 生成默认分组信息
		GroupCategory groupCategory = new GroupCategory();
		groupCategory.setUserId(userId);
		groupCategory.setName("我的聊天群");
		groupCategory.setSort(0);
		groupCategory.setType(GroupCategory.type_default);

		groupCategoryDAO.save(groupCategory);

	}
}
