package com.oimchat.server.cloud.impl.auth.business;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.definition.auth.business.UserTokenCacheKey;
import com.oimchat.server.basic.definition.auth.business.UserTokenTempBox;
import com.oimchat.server.cloud.impl.auth.common.UserAuthCache;

/**
 * Date 2019-04-20 09:15:20<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Component
public class UserTokenTempBoxImpl implements UserTokenTempBox {

	@Resource
	UserAuthCache userAuthCache;

	@Override
	public void put(String token, String userId) {
		String tokenKey = getTokenKey(token);
		userAuthCache.put(tokenKey, userId, 60L);
	}

	@Override
	public String getUserId(String token) {
		String tokenKey = getTokenKey(token);
		return userAuthCache.get(tokenKey);
	}

	private String getTokenKey(String token) {
		return UserTokenCacheKey.temp.key(token);
	}
}
