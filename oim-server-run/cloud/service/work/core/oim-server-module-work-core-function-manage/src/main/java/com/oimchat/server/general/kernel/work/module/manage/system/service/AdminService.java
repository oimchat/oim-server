package com.oimchat.server.general.kernel.work.module.manage.system.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.user.dao.UserDAO;
import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;
import com.oimchat.server.general.kernel.work.module.base.user.entity.User;
import com.oimchat.server.general.kernel.work.module.base.user.manager.UserExtendManager;
import com.oimchat.server.general.kernel.work.module.base.user.type.UserTypeEnum;
import com.oimchat.server.general.kernel.work.module.manage.system.dao.UserRoleDAO;
import com.oimchat.server.general.kernel.work.module.manage.system.data.Admin;
import com.oimchat.server.general.kernel.work.module.manage.system.data.AdminQuery;
import com.oimchat.server.general.kernel.work.module.manage.system.data.UserRoleInfo;
import com.oimchat.server.general.kernel.work.module.manage.system.entity.UserRole;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.message.bean.Info;

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
public class AdminService {

	@Resource
	UserDAO userDAO;
	@Resource
	UserRoleDAO userRoleDAO;
	@Resource
	UserExtendManager userManager;

	/**
	 * 根据id是否存在执行新增或者修改
	 * 
	 * @param user
	 */

	public Info addOrUpdate(User user, List<String> roleIds) {
		Info info = addOrUpdate(user);
		if (info.isSuccess()) {
			addOrUpdate(user.getId(), roleIds);
		}
		return info;
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

	public void addOrUpdate(String userId, List<String> roleIds) {
		List<UserRole> rmList = userRoleDAO.getListByUserId(userId);

		List<UserRole> deleteList = new ArrayList<UserRole>();

		Map<String, UserRole> map = new HashMap<String, UserRole>();
		for (UserRole ur : rmList) {
			if (map.containsKey(ur.getRoleId())) {
				deleteList.add(ur);
			}
			map.put(ur.getRoleId(), ur);
		}

		List<UserRole> addList = new ArrayList<UserRole>();
		for (String roleId : roleIds) {
			UserRole rm = map.remove(roleId);
			if (null == rm) {
				rm = new UserRole();
				rm.setRoleId(roleId);
				rm.setUserId(userId);
				addList.add(rm);
			}
		}
		deleteList.addAll(map.values());
		if (!addList.isEmpty()) {
			for (UserRole ur : addList) {
				userRoleDAO.save(ur);
			}
		}

		if (!deleteList.isEmpty()) {
			for (UserRole ur : deleteList) {
				userRoleDAO.delete(ur.getId());
			}
		}
	}

	/**
	 * 查询用户()
	 * 
	 * @param user
	 * @param page
	 * @return
	 */
	public List<Admin> queryList(AdminQuery query, Page page) {
		query.setType(UserTypeEnum.admin.getCode().toString());
		List<User> users = userDAO.list(query, page);

		List<Admin> list = new ArrayList<>();

		for (User u : users) {
			Admin a = new Admin();
			BeanUtils.copyProperties(u, a);
			list.add(a);
		}

		List<String> userIds = new ArrayList<String>();
		Map<String, Admin> map = new HashMap<String, Admin>();
		for (Admin ud : list) {
			userIds.add(ud.getId());
			map.put(ud.getId(), ud);
		}
		List<UserRoleInfo> urs = userRoleDAO.getUserRoleInfoListByUserIds(userIds);

		for (UserRoleInfo ur : urs) {
			Admin ud = map.get(ur.getUserId());
			if (null != ud) {
				List<UserRoleInfo> userRoleList = ud.getUserRoleInfos();
				if (null == userRoleList) {
					userRoleList = new ArrayList<UserRoleInfo>();
					ud.setUserRoleInfos(userRoleList);
				}
				userRoleList.add(ur);
			}
		}
		return list;
	}

	/**
	 * 获取系统用户的角色列表 date 2018-07-18 09:29:20<br>
	 * description
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since
	 */
	public List<UserRoleInfo> getUserRoleInfoListByUserId(String userId) {
		List<String> userIdList = new ArrayList<String>();
		userIdList.add(userId);
		List<UserRoleInfo> urs = userRoleDAO.getUserRoleInfoListByUserIds(userIdList);
		return urs;
	}

	public Admin getById(String id) {
		Admin a = null;
		UserData ud = userDAO.getUserDataById(id);
		if (null != ud) {
			a = new Admin();
			BeanUtils.copyProperties(ud, a);
			List<UserRoleInfo> userRoleInfos = getUserRoleInfoListByUserId(id);
			a.setUserRoleInfos(userRoleInfos);
		}
		return a;
	}
}
