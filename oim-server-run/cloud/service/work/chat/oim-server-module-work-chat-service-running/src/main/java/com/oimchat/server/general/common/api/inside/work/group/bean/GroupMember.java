package com.oimchat.server.general.common.api.inside.work.group.bean;

/**
 * Description <br>
 * Date 2020-05-17 20:55:59<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class GroupMember {
	/**
	 * groupId
	 */
	private String groupId;

	/**
	 * 群成员用户id
	 */
	private String userId;

	/**
	 * 权限 1:群主 2:管理员 3:普通成员
	 */
	private String position;

	/**
	 * 备注名(群中显示昵称)
	 */
	private String nickname;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
