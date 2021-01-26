
package com.oimchat.server.basic.definition.auth.manage;

/**
 * Description <br>
 * Date 2020-05-15 15:04:12<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public enum UserPermissionCacheKey {

	/**
	 * root
	 */
	root("work:core:user:auth:root"),
	/**
	 * permission
	 */
	permission("work:core:user:auth:permission");

	private String key;

	private UserPermissionCacheKey(String key) {
		this.key = key;
	}

	public String key(String code) {
		StringBuilder sb = new StringBuilder(key);
		sb.append(":");
		sb.append(code);
		return sb.toString();
	}
}
