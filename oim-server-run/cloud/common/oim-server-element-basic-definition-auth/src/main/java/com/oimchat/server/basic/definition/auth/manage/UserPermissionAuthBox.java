package com.oimchat.server.basic.definition.auth.manage;

import java.util.List;

/**
 * date 2018-06-13 10:41:23<br>
 * description
 *
 * @author XiaHui<br>
 * @since
 */

public interface UserPermissionAuthBox {

	/**
	 * @param userId
	 * @param permissionKey
	 * @return
	 */
	public boolean hasPermission(String userId, String permissionKey);

	/**
	 * @param userId
	 * @param permissionKeys
	 */
	public void setPermission(String userId, List<String> permissionKeys);

	/**
	 * @param token
	 */
	public void putRootUserId(String userId);

	/**
	 * @param token
	 * @return
	 */
	public boolean isRoot(String userId);
}
