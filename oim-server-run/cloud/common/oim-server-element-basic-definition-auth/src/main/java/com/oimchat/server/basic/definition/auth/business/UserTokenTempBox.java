package com.oimchat.server.basic.definition.auth.business;

/**
 * Date 2019-02-11 19:07:58<br>
 * Description
 *
 * @author XiaHui<br>
 * @since 1.0.0
 */

public interface UserTokenTempBox {

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
}
