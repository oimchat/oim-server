package com.oimchat.server.general.kernel.common.impl.auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.oimchat.server.basic.definition.auth.business.UserTokenBuilder;
import com.oimchat.server.general.kernel.common.impl.auth.util.JwtUtil;

/**
 * Description <br>
 * Date 2021-01-19 15:38:52<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class UserTokenBuilderImpl implements UserTokenBuilder {

	@Value("${system.work.core.user.token.secret-key:oim-~!@#$%^&*()_}")
	String secretKey;

	@Override
	public String build(String key, Map<String, String> dataMap) {
		return JwtUtil.build(key, 1000 * 60 * 60 * 24 * 7, dataMap, secretKey);
	}
}
