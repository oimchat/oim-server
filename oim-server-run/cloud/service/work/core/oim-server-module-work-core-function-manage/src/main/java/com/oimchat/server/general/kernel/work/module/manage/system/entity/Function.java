package com.oimchat.server.general.kernel.work.module.manage.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.onlyxiahui.aware.basic.bean.BaseEntity;
import com.onlyxiahui.extend.hibernate.annotation.Comment;

/**
 * 
 * date 2018-07-04 16:12:57<br>
 * description 菜单信息
 * 
 * @author XiaHui<br>
 * @since
 */
@Entity(name = "m_function")
@DynamicInsert
@DynamicUpdate
public class Function extends BaseEntity {

	@Comment("主键id")
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 40)
	private String id;

	@Comment("服务名")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String service;

	@Comment("菜单编码")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String code;

	@Comment("上级菜单id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String superId;

	@Comment("菜单名称")
	@ColumnDefault("''")
	@Column(nullable = false, length = 200)
	private String name;

	/**
	 * 是否禁用 0：启用 1：停用
	 */
	@Comment("是否禁用 0：启用 1：停用")
	@ColumnDefault("0")
	@Column(nullable = false)
	private Integer isDisable;

	@Comment("功能描述")
	@ColumnDefault("''")
	@Column(nullable = false, length = 1000)
	private String introduce;

	@Comment("菜单排序")
	@ColumnDefault("0")
	@Column(name = "`sort`", nullable = false)
	private Integer sort;

	@Comment("功能地址")
	@ColumnDefault("''")
	@Column(nullable = false, length = 500)
	private String path;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSuperId() {
		return superId;
	}

	public void setSuperId(String superId) {
		this.superId = superId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIsDisable() {
		return isDisable;
	}

	public void setIsDisable(Integer isDisable) {
		this.isDisable = isDisable;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
