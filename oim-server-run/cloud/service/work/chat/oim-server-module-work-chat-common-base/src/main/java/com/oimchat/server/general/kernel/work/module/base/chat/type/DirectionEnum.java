
package com.oimchat.server.general.kernel.work.module.base.chat.type;

/**
 * Description <br>
 * Date 2020-04-17 11:15:08<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public enum DirectionEnum {
	/**
	 * 之前
	 */
	before("before"),
	/**
	 * 之后
	 */
	after("after");

	String name;

	private DirectionEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEquals(String name) {
		return this.name.equals(name);
	}
}
