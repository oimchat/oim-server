package com.oimchat.server.general.kernel.work.module.manage.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.onlyxiahui.aware.basic.bean.PrimaryStringEntity;
import com.onlyxiahui.extend.hibernate.annotation.Comment;

/**
 * 
 * @author XiaHui
 */
@Entity(name = "m_role")
@DynamicInsert
@DynamicUpdate
public class Role extends PrimaryStringEntity {

	@Comment("角色名字")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String name;

	@Comment("角色描述")
	@ColumnDefault("''")
	@Column(nullable = false, length = 1000)
	private String introduce;

	/**
	 * 是否禁用 0：启用 1：停用
	 */
	@Comment("是否禁用 0：启用 1：停用")
	@ColumnDefault("0")
	@Column(nullable = false)
	private Integer isDisable;

	@Comment("角色级别 0:系统角色1：普通角色")
	@ColumnDefault("1")
	@Column(nullable = false)
	private Integer grade;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Integer getIsDisable() {
		return isDisable;
	}

	public void setIsDisable(Integer isDisable) {
		this.isDisable = isDisable;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

}
