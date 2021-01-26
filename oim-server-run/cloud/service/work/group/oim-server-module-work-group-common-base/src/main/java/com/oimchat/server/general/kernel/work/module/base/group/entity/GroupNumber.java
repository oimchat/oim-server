package com.oimchat.server.general.kernel.work.module.base.group.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import com.onlyxiahui.extend.hibernate.annotation.Comment;
import com.onlyxiahui.extend.query.hibernate.annotation.CreatedDateTime;

/**
 * 
 * 生成数字账号<br>
 * Date 2019-01-21 11:24:11<br>
 * 
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity(name = "im_group_number")
public class GroupNumber {

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/**
	 * 创建时间
	 */
	@CreatedDateTime
	@Comment("创建时间（格式：2019-01-01 00:00:00）")
	@ColumnDefault("'0001-01-01 00:00:00'")
	@Column(nullable = false, length = 32, updatable = false)
	private String createdDateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(String createTime) {
		this.createdDateTime = createTime;
	}
}
