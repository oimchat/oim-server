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
 * 群信息<br>
 * Date 2019-01-20 20:50:45<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "im_group", indexes = {
		@Index(name = "index_number", columnList = "number", unique = true),
		@Index(name = "index_name", columnList = "name", unique = false) })
@DynamicInsert
@DynamicUpdate
public class Group extends PrimaryStringEntity {

	/**
	 * 群号码
	 */
	@Comment("群号码")
	@ColumnDefault("0")
	@Column(nullable = false, updatable = false)
	private Long number;

	/**
	 * 群名称
	 */
	@Comment("群名称")
	@ColumnDefault("''")
	@Column(nullable = false, length = 200)
	private String name;

	/**
	 * 系统头像
	 */
	@Comment("系统头像")
	@ColumnDefault("''")
	@Column(nullable = false, length = 5)
	private String head;

	/**
	 * 自定义头像，（当用户选择系统头像时为空）
	 */
	@Comment("自定义头像，（当用户选择系统头像时为空）")
	@ColumnDefault("''")
	@Column(nullable = false, length = 500)
	private String avatar;

	/**
	 * 分类
	 */
	@Comment("分类")
	@ColumnDefault("''")
	@Column(nullable = false, length = 50)
	private String classification;

	/**
	 * 介绍
	 */
	@Comment("介绍")
	@ColumnDefault("''")
	@Column(nullable = false, length = 1000)
	private String introduce;

	/**
	 * 群位置
	 */
	@Comment("群位置")
	@ColumnDefault("''")
	@Column(nullable = false, length = 500)
	private String location;

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
