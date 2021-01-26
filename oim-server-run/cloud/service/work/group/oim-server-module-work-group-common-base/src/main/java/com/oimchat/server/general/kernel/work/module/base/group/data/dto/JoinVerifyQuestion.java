package com.oimchat.server.general.kernel.work.module.base.group.data.dto;

/**
 * 
 * 加入群时验证问题<br>
 * Date 2018-04-22 10:12:27<br>
 * 
 * @author: XiaHui
 */

public class JoinVerifyQuestion {

	/**
	 * id
	 */
	private String id;
	/**
	 * 群
	 */
	private String groupId;
	/**
	 * 问题
	 */
	private String question;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
