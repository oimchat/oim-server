package com.oimchat.server.general.kernel.work.module.base.portal.entity;

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
 * Date 2019-01-15 16:31:29<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "config_server_type", indexes = {
		@Index(name = "index_code", columnList = "code", unique = true),
		@Index(name = "index_name", columnList = "name", unique = false) })
@DynamicInsert
@DynamicUpdate
public class ServerType extends PrimaryStringEntity {

	/**
	 * 服务名
	 */
	@Comment("服务名")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String name;
	/**
	 * 服务编码
	 */
	@Comment("服务编码")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String code;
	/**
	 * 服务描述
	 */
	@Comment("服务描述")
	@ColumnDefault("''")
	@Column(nullable = false, length = 1000)
	private String description;
	/**
	 * 是否启用：0：否、1：是
	 */
	@Comment("是否启用：0：否、1：是")
	@ColumnDefault("'1'")
	@Column(nullable = false, length = 2)
	private String isEnabled;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}
}
