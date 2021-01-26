package com.oimchat.server.cloud.impl.auth.business;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.oimchat.server.basic.definition.auth.business.UserTokenAuthBox;
import com.oimchat.server.basic.definition.auth.business.type.TokenStatus;
import com.oimchat.server.cloud.impl.auth.common.util.JwtUtil;

/**
 * Date 2019-04-20 09:18:33<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Component
public class UserTokenAuthBoxImpl implements UserTokenAuthBox {

	@Value("${system.work.core.user.token.secret-key:oim-~!@#$%^&*()_}")
	String secretKey;

	@Override
	public void put(String token, String userId) {
	}

	@Override
	public String getUserId(String token) {
		token = (null == token) ? "" : token;
		String audience = JwtUtil.getAudience(token);
		return audience;
	}

	@Override
	public String remove(String token) {
		token = (null == token) ? "" : token;
		String audience = JwtUtil.getAudience(token);
		return audience;
	}

	@Override
	public TokenStatus verify(String userId, String token) {
		TokenStatus status = TokenStatus.none;
		DecodedJWT jwt = JwtUtil.getJwt(token);
		if (null != jwt) {
			boolean verify = JwtUtil.verify(jwt, secretKey);
			if (verify) {
				status = TokenStatus.available;
			} else {
				status = TokenStatus.expired;
			}
		}
		return status;
	}
}
