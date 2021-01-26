
package com.oimchat.server.general.kernel.work.business.impl.chat.store;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.general.kernel.work.define.chat.store.UserDataStore;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.UserSimple;
import com.oimchat.server.general.kernel.work.module.base.user.dao.UserDAO;
import com.oimchat.server.general.kernel.work.module.base.user.entity.User;

/**
 * Description <br>
 * Date 2020-04-16 20:52:28<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class UserDataStoreImpl implements UserDataStore {

	@Autowired
	UserDAO userDAO;

	@Override
	public UserSimple getUserSimpleById(String id) {
		UserSimple u = null;
		User user = userDAO.get(id);
		if (null != user) {
			u = new UserSimple();
			BeanUtils.copyProperties(user, u);
			u.setRemark("");
		}
		return u;
	}
}
