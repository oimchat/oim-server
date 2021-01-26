/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * Description <br>
 * Date 2019-07-27 21:27:44<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Entity(name = "m_user_role")
@DynamicInsert
@DynamicUpdate
public class UserRole extends PrimaryStringEntity {

	@Comment("用户Id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String userId;

	@Comment("角色Id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String roleId;

	@Comment("排序")
	@ColumnDefault("0")
	@Column(name = "`sort`", nullable = false)
	private Integer sort;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
