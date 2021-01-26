package com.oimchat.server.general.common.api.inside.work.group.bean;

/**
 * Description <br>
 * Date 2020-05-17 20:57:36<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class GroupMemberQuery {
	/**
	 * 
	 */
	private String groupId;
	/**
	 * 
	 */
	private String userId;
	/**
	 * 
	 */
	private String position;
	/**
	 * 
	 */
	private String nickname;
	/**
	 * 
	 */
	private String likeNickname;

	public String getLikeNickname() {
		return likeNickname;
	}

	public void setLikeNickname(String likeNickname) {
		this.likeNickname = likeNickname;
	}

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
