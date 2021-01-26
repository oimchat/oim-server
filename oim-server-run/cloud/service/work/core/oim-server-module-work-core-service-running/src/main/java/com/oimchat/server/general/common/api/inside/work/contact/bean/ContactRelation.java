package com.oimchat.server.general.common.api.inside.work.contact.bean;

/**
 * Description <br>
 * Date 2021-01-22 18:16:52<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class ContactRelation {
	/**
	 * 拥有者id
	 */
	private String ownerUserId;
	/**
	 * 联系人分组id
	 */
	private String categoryId;
	/**
	 * 联系人用户id
	 */
	private String contactUserId;

	public String getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(String ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getContactUserId() {
		return contactUserId;
	}

	public void setContactUserId(String contactUserId) {
		this.contactUserId = contactUserId;
	}
}
