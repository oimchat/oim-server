package com.oimchat.server.general.kernel.work.define.user.cache;

import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;

/**
 * Date 2019-02-11 22:11:13<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */

public interface UserCache {

	public void put(String userId, UserData ud);

	public UserData get(String userId);
}
