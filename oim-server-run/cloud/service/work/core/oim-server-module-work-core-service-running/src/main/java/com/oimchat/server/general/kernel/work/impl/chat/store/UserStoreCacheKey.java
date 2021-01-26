
package com.oimchat.server.general.kernel.work.impl.chat.store;

/**
 * Description <br>
 * Date 2020-05-15 15:04:12<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public enum UserStoreCacheKey {
	/**
	 * 状态
	 */
	status("oim:server:work:user:status");

	private String key;

	private UserStoreCacheKey(String key) {
		this.key = key;
	}

	public String key(String code) {
		StringBuilder sb = new StringBuilder(key);
		sb.append(":");
		sb.append(code);
		return sb.toString();
	}
}
