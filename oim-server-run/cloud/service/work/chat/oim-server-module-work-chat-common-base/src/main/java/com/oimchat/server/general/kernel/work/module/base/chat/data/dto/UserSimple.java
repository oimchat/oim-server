
package com.oimchat.server.general.kernel.work.module.base.chat.data.dto;

/**
 * Description <br>
 * Date 2020-04-16 18:59:20<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class UserSimple {

	/**
	 * id
	 */
	private String id;
	/**
	 * 用户姓名
	 */
	private String name;
	/**
	 * 用户当时昵称
	 */
	private String nickname;
	/**
	 * 当时自定义头像
	 */
	private String avatar;
	/**
	 * 当时系统头像
	 */
	private String head;
	/**
	 * 当时对方备注名
	 */
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
