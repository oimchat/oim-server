package com.oimchat.server.general.kernel.work.module.manage.user.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.user.dao.UserDAO;
import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;
import com.oimchat.server.general.kernel.work.module.base.user.data.query.UserQuery;
import com.oimchat.server.general.kernel.work.module.base.user.entity.User;
import com.oimchat.server.general.kernel.work.module.base.user.manager.UserExtendManager;
import com.oimchat.server.general.kernel.work.module.base.user.type.UserTypeEnum;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.utils.base.security.Md5Util;

/**
 * 
 * date 2018-07-17 22:39:50<br>
 * description
 * 
 * @author XiaHui<br>
 * @since
 */
@Service
@Transactional
public class UserService {

	@Resource
	UserDAO userDAO;
	@Resource
	UserExtendManager userManager;

	/**
	 * 跟据id获取用户实体
	 * 
	 * @param id
	 * @return
	 */
	public UserData getById(String id) {
		return userManager.getUserDataById(id);
	}

	public Info addOrUpdate(User user) {
		Info info;
		if (null == user.getId() || "".equals(user.getId())) {
			info = userManager.add(user);
		} else {
			info = userManager.update(user);
		}
		return info;
	}

	/**
	 * 查询用户<br>
	 * Date 2020-05-29 09:59:04<br>
	 * 
	 * @param query
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	public List<UserData> queryUserDataList(UserQuery query, Page page) {
		query.setType(UserTypeEnum.general.getCode().toString());
		List<User> users = userDAO.list(query, page);
		List<UserData> list = new ArrayList<>();
		for (User u : users) {
			UserData ud = new UserData();
			BeanUtils.copyProperties(u, ud);
			list.add(ud);
		}
		return list;
	}

	public User getUserByAccount(String account) {
		return userDAO.getByAccount(account);
	}

	public boolean updatePassword(String userId, String password) {
		// password = Md5Util.lower32(password);
		boolean mark = userDAO.updatePassword(userId, password);
		return mark;
	}

	/**
	 * 修改用户类型
	 * 
	 * @param userId
	 * @param type
	 * @return
	 */
	public boolean updateType(String userId, String type) {
		boolean mark = userDAO.updateType(userId, type);
		return mark;
	}

	public int updateIsDisable(String userId, Integer isDisable) {
		User u = new User();
		u.setId(userId);
		u.setIsDisable(isDisable);
		int mark = userDAO.updateSelective(u);
		return mark;
	}

	public boolean isExistAccount(String userId, String account) {
		return userManager.isExistAccount(userId, account);
	}

	public boolean isExistEmail(String userId, String email) {
		return userManager.isExistEmail(userId, email);
	}

	public boolean isExistMobile(String userId, String mobile) {
		return userManager.isExistMobile(userId, mobile);
	}
}
