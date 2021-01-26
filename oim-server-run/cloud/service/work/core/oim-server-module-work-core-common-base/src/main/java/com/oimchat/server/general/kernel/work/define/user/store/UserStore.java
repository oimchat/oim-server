package com.oimchat.server.general.kernel.work.define.user.store;

import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;

/**
 * 
 * Date 2019-01-20 08:45:35<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public interface UserStore {

	public void put(UserData userData);
	
	public UserData get(String userId);

	public void putStatus(String userId, String status);

	public String getStatus(String userId);
}
