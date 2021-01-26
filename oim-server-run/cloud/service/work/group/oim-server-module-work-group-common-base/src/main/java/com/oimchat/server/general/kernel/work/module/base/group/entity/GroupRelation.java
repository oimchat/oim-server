package com.oimchat.server.general.kernel.work.module.base.group.entity;

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
 * 群的备注、分组等相关的信息<br>
 * Date 2019-01-20 20:53:06<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "im_group_relation", indexes = {
		@Index(name = "index_userId", columnList = "userId", unique = false),
		@Index(name = "index_categoryId", columnList = "categoryId", unique = false),
		@Index(name = "index_groupId", columnList = "groupId", unique = false) })
@DynamicInsert
@DynamicUpdate
public class GroupRelation extends PrimaryStringEntity {

	/**
	 * 所属用户id
	 */
	@Comment("所属用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String userId;

	/**
	 * 群分组id
	 */
	@Comment("群分组id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String categoryId;

	/**
	 * 群id
	 */
	@Comment("群id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String groupId;

	/**
	 * 群备注名
	 */
	@Comment("群备注名")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String remark;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
