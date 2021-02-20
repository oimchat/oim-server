package com.oimchat.server.general.kernel.common.impl.auth;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.definition.auth.manage.UserPermissionAuthBox;

/**
 * Description <br>
 * Date 2020-05-28 11:55:42<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class UserPermissionAuthImpl implements UserPermissionAuthBox {

	Map<String, List<String>> permissionKeyListMap = new java.util.concurrent.ConcurrentHashMap<String, List<String>>();

	// 超级管理员
	Map<String, String> authMap = new java.util.concurrent.ConcurrentHashMap<String, String>();

	@Override
	public boolean hasPermission(String userId, String permissionKey) {
		userId = null == userId ? "" : userId;
		boolean has = false;
		List<String> permissionKeyList = permissionKeyListMap.get(userId);
		if (null != permissionKeyList) {
			has = permissionKeyList.contains(permissionKey);
		}
		return has;
	}

	@Override
	public void setPermission(String userId, List<String> permissionKeyList) {
		userId = null == userId ? "" : userId;
		permissionKeyListMap.put(userId, permissionKeyList);
	}

	@Override
	public boolean isRoot(String userId) {
		userId = (null == userId) ? "" : userId;
		String id = authMap.get(userId);
		return null != id && !id.isEmpty();
	}

	@Override
	public void putRootUserId(String userId) {
		if (null != userId) {
			authMap.put(userId, userId);
		}
	}
}
