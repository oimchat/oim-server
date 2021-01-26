package com.oimchat.server.run.initialize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.user.dao.UserDAO;
import com.oimchat.server.general.kernel.work.module.base.user.data.query.UserQuery;
import com.oimchat.server.general.kernel.work.module.base.user.entity.User;
import com.oimchat.server.general.kernel.work.module.base.user.type.UserTypeEnum;
import com.onlyxiahui.common.utils.base.security.Md5Util;

/**
 * Description <br>
 * Date 2020-05-29 17:33:43<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Service
@Transactional
public class InitializerUser {

	@Autowired
	UserDAO userDAO;

	public void initialize() {
		initRootUser();
	}

	/**
	 * 初始化超级管理员
	 */
	private void initRootUser() {
		UserQuery query = new UserQuery();
		query.setType(UserTypeEnum.root.getCode().toString());
		User u = userDAO.get(query);
		if (null == u) {
			u = new User();
			u.setNumber(-1L);
			u.setHead("1");
			u.setAccount("root");
			u.setPassword(Md5Util.lower32("123456"));
			u.setCreatedTimestamp(System.currentTimeMillis());
			u.setUpdatedTimestamp(System.currentTimeMillis());
			u.setName("超级管理员");
			u.setType(UserTypeEnum.root.getCode().toString());
			userDAO.save(u);
		}
	}
}
