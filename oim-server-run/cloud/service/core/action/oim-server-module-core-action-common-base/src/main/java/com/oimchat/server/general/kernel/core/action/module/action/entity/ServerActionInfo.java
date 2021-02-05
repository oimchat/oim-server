package com.oimchat.server.general.kernel.core.action.module.action.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import com.onlyxiahui.aware.basic.bean.PrimaryStringEntity;
import com.onlyxiahui.common.action.description.annotation.DocTitle;
import com.onlyxiahui.extend.hibernate.annotation.Comment;

/**
 * 
 * 服务的Action信息<br>
 * Date 2020-11-08 18:55:40<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]
 * @since 1.0.0
 */
@Entity
@Table(name = "config_server_action_info", indexes = {
})
@DynamicInsert
@DynamicUpdate
public class ServerActionInfo extends PrimaryStringEntity {

	/**
	 * 修改操作用户
	 */
	@DocTitle("修改操作用户")
	@Length(min = 0, max = 40, message = "修改操作用户(createdUserId)长度不能超过{max}")
	@Comment("修改操作用户")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String createdUserId;

	/**
	 * 创建操作用户
	 */
	@DocTitle("创建操作用户")
	@Length(min = 0, max = 40, message = "创建操作用户(updatedUserId)长度不能超过{max}")
	@Comment("创建操作用户")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String updatedUserId;

	/**
	 * Key
	 */
	@DocTitle("Key")
	@Length(min = 0, max = 120, message = "Key(key)长度不能超过{max}")
	@Comment("Key")
	@ColumnDefault("''")
	@Column(name = "`Key`", nullable = false, length = 120)
	private String key;

	/**
	 * 上级Key
	 */
	@DocTitle("上级Key")
	@Length(min = 0, max = 120, message = "上级Key(superKey)长度不能超过{max}")
	@Comment("上级Key")
	@ColumnDefault("''")
	@Column(nullable = false, length = 120)
	private String superKey;

	/**
	 * Action地址
	 */
	@DocTitle("Action地址")
	@Length(min = 0, max = 512, message = "Action地址(path)长度不能超过{max}")
	@Comment("Action地址")
	@ColumnDefault("''")
	@Column(nullable = false, length = 512)
	private String path;

	/**
	 * 名称
	 */
	@DocTitle("名称")
	@Length(min = 0, max = 256, message = "名称(title)长度不能超过{max}")
	@Comment("名称")
	@ColumnDefault("''")
	@Column(nullable = false, length = 256, name = "`title`")
	private String title;

	/**
	 * 说明
	 */
	@DocTitle("说明")
	@Length(min = 0, max = 512, message = "说明(introduce)长度不能超过{max}")
	@Comment("说明")
	@ColumnDefault("''")
	@Column(nullable = false, length = 512)
	private String introduce;

	/**
	 * 权限通过类型
	 */
	@DocTitle("权限通过类型")
	@Length(min = 0, max = 32, message = "权限通过类型(permissionType)长度不能超过{max}")
	@Comment("权限通过类型")
	@ColumnDefault("''")
	@Column(nullable = false, length = 32)
	private String permissionType;

	/**
	 * 是否接口： 0：否 1：是
	 */
	@DocTitle("是否接口： 0：否 1：是")
	private Integer isAction;

	/**
	 * 服务技术名
	 */
	@DocTitle("服务技术名")
	@Length(min = 0, max = 256, message = "服务技术名(serviceName)长度不能超过{max}")
	@Comment("服务技术名")
	@ColumnDefault("''")
	@Column(nullable = false, length = 256)
	private String serviceName;

	/**
	 * 服务显示名
	 */
	@DocTitle("服务显示名")
	@Length(min = 0, max = 256, message = "服务显示名(serviceTitle)长度不能超过{max}")
	@Comment("服务显示名")
	@ColumnDefault("''")
	@Column(nullable = false, length = 256)
	private String serviceTitle;

	public String getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}

	public String getUpdatedUserId() {
		return updatedUserId;
	}

	public void setUpdatedUserId(String updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSuperKey() {
		return superKey;
	}

	public void setSuperKey(String superKey) {
		this.superKey = superKey;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}

	public Integer getIsAction() {
		return isAction;
	}

	public void setIsAction(Integer isAction) {
		this.isAction = isAction;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceTitle() {
		return serviceTitle;
	}

	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
}