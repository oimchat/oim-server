
package com.oimchat.server.basic.common.work.app;

/**
 * Description <br>
 * Date 2020-04-14 22:36:30<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public enum SessionEnum {

	/**
	 * key
	 */
	key("source"),
	/**
	 * token
	 */
	token("token");

	private String name;

	private SessionEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
