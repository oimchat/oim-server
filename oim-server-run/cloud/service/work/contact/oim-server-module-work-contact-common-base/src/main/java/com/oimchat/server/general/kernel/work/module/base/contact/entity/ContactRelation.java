package com.oimchat.server.general.kernel.work.module.base.contact.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.onlyxiahui.aware.basic.bean.PrimaryStringEntity;
import com.onlyxiahui.extend.hibernate.annotation.Comment;

/**
 * 联系人的相关信息<br>
 * Date 2019-01-17 23:48:58<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "im_contact_relation", indexes = {
		@Index(name = "index_ownerUserId", columnList = "ownerUserId", unique = false),
		@Index(name = "index_categoryId", columnList = "categoryId", unique = false),
		@Index(name = "index_contactUserId", columnList = "contactUserId", unique = false) })
@DynamicInsert
@DynamicUpdate
public class ContactRelation extends PrimaryStringEntity {
	/**
	 * 拥有者id
	 */
	@Comment("所属用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String ownerUserId;
	/**
	 * 联系人分组id
	 */
	@Comment("联系人分组id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String categoryId;
	/**
	 * 联系人用户id
	 */
	@Comment("联系人用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String contactUserId;
	/**
	 * 联系人备注名
	 */
	@Comment("联系人备注名")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String remark;

	/**
	 * 是否加入黑名单：0：否、1：是
	 */
	@Comment("是否加入黑名单：0：否、1：是")
	@Column(nullable = false, length = 2)
	@ColumnDefault("'0'")
	private String isBlocked;

	public static String is_blocked_no = "0";

	public static String is_blocked_yes = "1";

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(String isBlocked) {
		this.isBlocked = isBlocked;
	}
}
