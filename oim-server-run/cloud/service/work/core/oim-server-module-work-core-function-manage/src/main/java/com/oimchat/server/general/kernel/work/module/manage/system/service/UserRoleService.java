package com.oimchat.server.general.kernel.work.module.manage.system.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.user.dao.UserDAO;
import com.oimchat.server.general.kernel.work.module.manage.system.dao.UserRoleDAO;
import com.oimchat.server.general.kernel.work.module.manage.system.data.UserRoleInfo;
import com.oimchat.server.general.kernel.work.module.manage.system.entity.UserRole;;

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
public class UserRoleService {

	@Resource
	UserDAO userDAO;
	@Resource
	UserRoleDAO userRoleDAO;

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
	 * 获取系统用户的角色列表 date 2018-07-18 09:29:20<br>
	 * description
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since
	 */
	public List<UserRoleInfo> getUserRoleInfoListByUserId(String userId) {
		List<String> userIds = new ArrayList<String>();
		userIds.add(userId);
		List<UserRoleInfo> urs = userRoleDAO.getUserRoleInfoListByUserIds(userIds);
		return urs;
	}
}
