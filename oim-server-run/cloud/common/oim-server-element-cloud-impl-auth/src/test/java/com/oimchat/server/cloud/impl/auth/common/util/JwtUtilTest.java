package com.oimchat.server.cloud.impl.auth.common.util;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Description <br>
 * Date 2021-01-19 14:09:31<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class JwtUtilTest {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();

		String key = "123456";
		String userId = "user001";
		String token = JwtUtil.build(userId, 1, null, key);
		String token2 = JwtUtil.build(userId, 1, null, key);

		System.out.println(JwtUtil.verify(token2, key));
		System.out.println(JwtUtil.verify(token2, "444"));

		System.out.println(token);
		String audience = JwtUtil.getAudience(token);
		System.out.println(audience);

		try {
			DecodedJWT jwt = JwtUtil.getJwt(token);

			System.out.println(mapper.writeValueAsString(JwtUtil.verify(token, key)));
			System.out.println(JwtUtil.verify(jwt, key));
			jwt = JwtUtil.getJwt(token);
			System.out.println(JwtUtil.verify(jwt, key));
			System.out.println("333333333333333");
			Thread.sleep(1000);
			System.out.println(mapper.writeValueAsString(JwtUtil.getJwt(token)));
			System.out.println(mapper.writeValueAsString(JwtUtil.verify(token, key)));
			System.out.println(JwtUtil.verify(jwt, key));
			jwt = JwtUtil.getJwt(token);
			System.out.println(JwtUtil.verify(jwt, key));
			System.out.println("222222222");
			token = "asxsad";
			System.out.println(mapper.writeValueAsString(JwtUtil.getJwt(token)));

			token = "ayJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJ1c2VyMDAxIiwiZXhwIjoxNjExMDQ1NDA4fQ.Nk_EGZB4l_kJgmPHyvjaVubO37SNiKHyQjeu5dqZuxE";
			System.out.println(mapper.writeValueAsString(JwtUtil.getJwt(token)));
			audience = JwtUtil.getAudience(token);
			System.out.println(audience);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
