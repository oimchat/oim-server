
package com.oimchat.server.basic.definition.auth.business;

/**
 * Description <br>
 * Date 2020-05-15 15:04:12<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public enum UserTokenCacheKey {
	/**
	 * 临时认证
	 */
	temp("work:core:user:auth:temp"),
	/**
	 * token缓存
	 */
	token("work:core:user:auth:token");

	private String key;

	private UserTokenCacheKey(String key) {
		this.key = key;
	}

	public String key(String code) {
		StringBuilder sb = new StringBuilder(key);
		sb.append(":");
		sb.append(code);
		return sb.toString();
	}
}
