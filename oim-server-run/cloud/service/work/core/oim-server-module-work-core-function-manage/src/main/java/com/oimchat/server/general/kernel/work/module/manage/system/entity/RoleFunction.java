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
 * Date 2019-07-27 21:26:28<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Entity(name = "m_role_function")
@DynamicInsert
@DynamicUpdate
public class RoleFunction extends PrimaryStringEntity {

	@Comment("角色Id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String roleId;

	@Comment("菜单id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String functionId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
}
