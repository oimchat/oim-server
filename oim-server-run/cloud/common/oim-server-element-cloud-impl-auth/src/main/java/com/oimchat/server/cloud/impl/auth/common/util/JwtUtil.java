package com.oimchat.server.cloud.impl.auth.common.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * Description <br>
 * Date 2021-01-19 12:37:45<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class JwtUtil {

	/**
	 * 
	 * Description <br>
	 * Date 2021-01-19 15:37:25<br>
	 * 
	 * @param audience
	 * @param expireSecond
	 * @param map
	 * @param secretKey
	 * @return
	 * @since 1.0.0
	 */
	public static String build(
			String audience,
			int expireSecond,
			Map<String, String> map,
			String secretKey) {
		JWTCreator.Builder builder = JWT.create();

		// 设置JWT令牌的过期时间
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.SECOND, expireSecond);
		// 签发对象
		builder.withAudience(audience);
		builder.withExpiresAt(instance.getTime());
		// 将map内的信息传入JWT的payload中
		if (null != map) {
			map.forEach((k, v) -> {
				builder.withClaim(k, v);
			});
		}
		// 设置签名并返回token
		String token = builder.sign(Algorithm.HMAC256(secretKey)).toString();
		return token;
	}

	/**
	 * 
	 * Description <br>
	 * Date 2021-01-19 15:37:16<br>
	 * 
	 * @param token
	 * @param secretKey
	 * @return
	 * @since 1.0.0
	 */
	public static boolean verify(String token, String secretKey) {
		DecodedJWT jwt = null;
		try {
			if (null != token && null != secretKey) {
				jwt = JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jwt != null;
	}

	/**
	 * 获取签发对象
	 */
	public static String getAudience(String token) {
		String audience = null;
		try {
			DecodedJWT jwt = JWT.decode(token);
			if (null != jwt) {
				List<String> list = jwt.getAudience();
				audience = (null != list && !list.isEmpty()) ? list.get(0) : null;
			}
		} catch (JWTDecodeException e) {
			// 这里是token解析失败
		}
		return audience;
	}

	/**
	 * 通过载荷名字获取载荷的值
	 */
	public static Claim getClaimByName(String token, String name) {
		return JWT.decode(token).getClaim(name);
	}

	public static DecodedJWT getJwt(String token) {
		DecodedJWT jwt = null;
		try {
			if (null != token) {
				jwt = JWT.decode(token);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jwt;
	}

	public static DecodedJWT getJwt(String token, String secretKey) {
		DecodedJWT jwt = null;
		try {
			if (null != token && null != secretKey) {
				jwt = JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jwt;
	}

	public static boolean verify(DecodedJWT jwt, String secretKey) {
		DecodedJWT cjwt = null;
		try {
			if (null != jwt) {
				cjwt = JWT.require(Algorithm.HMAC256(secretKey)).build().verify(jwt);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cjwt != null;
	}

	public static String getAudience(DecodedJWT jwt) {
		String audience = null;
		try {
			if (null != jwt) {
				List<String> list = jwt.getAudience();
				audience = (null != list && !list.isEmpty()) ? list.get(0) : null;
			}
		} catch (JWTDecodeException e) {
			// 这里是token解析失败
		}
		return audience;
	}

	public static long getExpireTimestamp(DecodedJWT jwt) {
		long time = 0;
		if (null != jwt) {
			Date date = jwt.getExpiresAt();
			if (null != date) {
				time = date.getTime();
			}
		}
		return time;
	}

	public static Claim getClaimByName(DecodedJWT jwt, String name) {
		Claim claim = null;
		if (null != jwt) {
			claim = jwt.getClaim(name);
		}
		return claim;
	}

	public static String getClaimStringByName(DecodedJWT jwt, String name) {
		Claim claim = null;
		if (null != jwt) {
			claim = jwt.getClaim(name);
		}
		return null != claim ? claim.asString() : null;
	}
}
