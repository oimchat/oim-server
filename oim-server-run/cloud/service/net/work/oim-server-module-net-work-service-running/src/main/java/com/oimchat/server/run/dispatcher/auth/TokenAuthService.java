package com.oimchat.server.run.dispatcher.auth;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oimchat.server.basic.definition.auth.business.UserTokenAuthBox;
import com.oimchat.server.basic.definition.auth.business.UserTokenTempBox;
import com.oimchat.server.basic.definition.auth.business.type.TokenStatus;
import com.oimchat.server.basic.definition.auth.manage.UserPermissionAuthBox;

/**
 * 
 * <br>
 * Date 2019-07-19 18:12:01<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

@Service
public class TokenAuthService {

	@Resource
	private UserTokenAuthBox userTokenAuthBox;
	@Resource
	private UserTokenTempBox userTokenTempBox;
	@Autowired
	private UserPermissionAuthBox userPermissionAuthBox;

	public boolean isRoot(String userId) {
		return userPermissionAuthBox.isRoot(userId);
	}

	public boolean isAuth(String key, String token) {
		TokenStatus status = verify(key, token);
		return TokenStatus.available == status;
	}

	public TokenStatus verify(String key, String token) {
		return userTokenAuthBox.verify(key, token);
	}

	public boolean hasPermission(String key, String function) {
		return userPermissionAuthBox.hasPermission(key, function);
	}
}
