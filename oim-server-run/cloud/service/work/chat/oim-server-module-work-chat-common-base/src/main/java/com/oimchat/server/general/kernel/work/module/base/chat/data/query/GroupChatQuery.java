package com.oimchat.server.general.kernel.work.module.base.chat.data.query;

/**
 * 
 * Description <br>
 * Date 2019-07-24 07:53:39<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
public class GroupChatQuery extends BaseChatQuery {

	private String groupId;
	private String userId;
	private String likeUserNickname;

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

	public String getLikeUserNickname() {
		return likeUserNickname;
	}

	public void setLikeUserNickname(String likeUserNickname) {
		this.likeUserNickname = likeUserNickname;
	}
}
