package com.oimchat.server.cloud.net.extend.session.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.cloud.net.extend.session.cache.SocketSessionCache;
import com.oimchat.server.cloud.net.extend.session.cache.SocketSessionCacheKey;

/**
 * 
 * Description <br>
 * Date 2020-05-14 11:18:03<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class SocketSessionKeyManager {

	@Autowired
	SocketSessionCache sessionCache;

	public void put(String serverKey, String userKey) {
		if (null != serverKey && !serverKey.isEmpty() && null != userKey && !userKey.isEmpty()) {

			String userCacheKey = getUserIdKey(userKey);
			String serverCacheKey = getServerIdKey(serverKey);

			sessionCache.addInSet(userCacheKey, serverKey);
			sessionCache.addInSet(serverCacheKey, userKey);
		}
	}

	public boolean hasSession(String userKey) {
		String userCacheKey = getUserIdKey(userKey);
		Set<Serializable> set = sessionCache.getSet(userCacheKey);
		return (null != set && !set.isEmpty());

	}

	public void removeSession(String serverKey, String userKey) {
		if (null != userKey && !userKey.isEmpty() && null != serverKey && !serverKey.isEmpty()) {
			String userCacheKey = getUserIdKey(userKey);
			String serverCacheKey = getServerIdKey(serverKey);
			sessionCache.deleteSet(userCacheKey, serverKey);
			sessionCache.deleteSet(serverCacheKey, userKey);
		}
	}

	public void removeAllSession(String serverKey) {
		if (null != serverKey && !serverKey.isEmpty()) {
			String serverCacheKey = getServerIdKey(serverKey);

			List<String> userIds = getValues(serverCacheKey);
			for (String userKey : userIds) {
				String userCacheKey = getUserIdKey(userKey);
				sessionCache.deleteSet(userCacheKey, serverKey);
				sessionCache.deleteSet(serverCacheKey, userKey);
			}
		}
	}

	public Set<Serializable> getServerKeySet(String userKey) {
		String userCacheKey = getUserIdKey(userKey);
		return getValueSet(userCacheKey);
	}

	public List<String> getValues(String key) {
		List<String> list = new ArrayList<String>();
		Set<Serializable> resultSet = sessionCache.getSet(key);
		for (Object i : resultSet) {
			if (null != i) {
				list.add(i.toString());
			}
		}
		return list;
	}

	public Set<Serializable> getValueSet(String key) {
		Set<Serializable> resultSet = sessionCache.getSet(key);
		return null == resultSet ? new HashSet<>() : resultSet;
	}

	private String getServerIdKey(String id) {
		return SocketSessionCacheKey.SERVER_KEY.key(id);
	}

	private String getUserIdKey(String id) {
		return SocketSessionCacheKey.USER_KEY.key(id);
	}
}
