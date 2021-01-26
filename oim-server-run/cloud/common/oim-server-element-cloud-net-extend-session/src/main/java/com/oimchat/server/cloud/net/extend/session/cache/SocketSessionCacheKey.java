package com.oimchat.server.cloud.net.extend.session.cache;

/**
 * 
 * Description <br>
 * Date 2019-07-09 09:35:52<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
public enum SocketSessionCacheKey {

	SERVER_KEY("oim:business:session:server:key"),

	USER_KEY("oim:business:session:user:key");

	private String key;

	private SocketSessionCacheKey(String key) {
		this.key = key;
	}

	public String key(String code) {
		StringBuilder sb = new StringBuilder(key);
		sb.append(":");
		sb.append(code);
		return sb.toString();
	}
}
