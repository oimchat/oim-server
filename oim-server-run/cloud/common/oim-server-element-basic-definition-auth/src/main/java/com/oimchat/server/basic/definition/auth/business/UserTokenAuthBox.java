package com.oimchat.server.basic.definition.auth.business;

import com.oimchat.server.basic.definition.auth.business.type.TokenStatus;

/**
 * Date 2019-02-11 21:25:56<br>
 * Description
 *
 * @author XiaHui<br>
 * @since 1.0.0
 */

public interface UserTokenAuthBox {

	/**
	 * @param token
	 * @param userId
	 */
	public void put(String token, String userId);

	/**
	 * @param token
	 * @return
	 */
	public String getUserId(String token);

	/**
	 * @param token
	 * @return
	 */
	public String remove(String token);

	/**
	 * @param token
	 * @return TokenStatus
	 */
	public TokenStatus verify(String userId, String token);
}
