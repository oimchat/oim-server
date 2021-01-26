package com.oimchat.server.cloud.impl.auth.manage;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.definition.auth.manage.UserPermissionAuthBox;
import com.oimchat.server.basic.definition.auth.manage.UserPermissionCacheKey;
import com.oimchat.server.cloud.impl.auth.common.UserAuthCache;

/**
 * Description <br>
 * Date 2020-05-28 11:55:42<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class UserPermissionAuthImpl implements UserPermissionAuthBox {

	@Resource
	UserAuthCache userAuthCache;

	@Override
	public boolean hasPermission(String userId, String permissionKey) {
		return userAuthCache.hasInSet(userId, permissionKey);
	}

	@Override
	public void setPermission(String userId, List<String> permissionKeys) {
		if (null != userId && !userId.isEmpty() && null != permissionKeys) {
			Set<Serializable> cacheSet = userAuthCache.getSet(userId);
			Set<String> set = new HashSet<>();
			for (Serializable s : cacheSet) {
				if (null != s) {
					set.add(s.toString());
				}
			}
			for (String key : permissionKeys) {
				userAuthCache.addInSet(userId, key);
			}

			for (String key : set) {
				if (!permissionKeys.contains(key)) {
					userAuthCache.deleteSet(userId, key);
				}
			}
		}
	}

	@Override
	public boolean isRoot(String userId) {
		userId = (null == userId) ? "" : userId;
		String key = getRootKey(userId);
		String id = userAuthCache.get(key);
		return null != id && !id.isEmpty();
	}

	private String getRootKey(String token) {
		return UserPermissionCacheKey.root.key(token);
	}

	@Override
	public void putRootUserId(String userId) {
		userId = (null == userId) ? "" : userId;
		String key = getRootKey(userId);
		userAuthCache.put(key, userId);
	}
}
