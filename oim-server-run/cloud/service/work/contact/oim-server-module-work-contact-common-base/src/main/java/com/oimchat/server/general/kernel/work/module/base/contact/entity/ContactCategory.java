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
 * 好友分组信息<br>
 * Date 2019-01-17 23:47:26<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "im_contact_category", indexes = {
		@Index(name = "index_userId", columnList = "userId", unique = false) })
@DynamicInsert
@DynamicUpdate
public class ContactCategory extends PrimaryStringEntity {
	/**
	 * 所属用户id
	 */
	@Comment("所属用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String userId;
	/**
	 * 排序
	 */
	@Comment("排序")
	@ColumnDefault("0")
	@Column(name = "`sort`", nullable = false)
	private Integer sort;
	/**
	 * 类型：1、系统默认生成的 2、用户自己新增的
	 */
	@Comment("类型：1、系统默认生成的 2、用户自己新增的")
	@ColumnDefault("2")
	@Column(nullable = false)
	private Integer type;
	/**
	 * 分组名字
	 */
	@Comment("分组名字")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String name;

	public static final int type_default = 1;
	public static final int type_custom = 2;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
