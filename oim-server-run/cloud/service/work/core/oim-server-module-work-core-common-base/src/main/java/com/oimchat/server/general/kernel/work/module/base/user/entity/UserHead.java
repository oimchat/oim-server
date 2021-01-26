package com.oimchat.server.general.kernel.work.module.base.user.entity;

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
 * 
 * 用户头像 <br>
 * Date 2019-05-20 08:14:12<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Entity(name = "im_user_head")
@Table(name = "im_user_head", indexes = {
		@Index(name = "index_userId", columnList = "userId", unique = false) })
@DynamicInsert
@DynamicUpdate
public class UserHead extends PrimaryStringEntity {

	/**
	 * 用户id
	 */
	@Comment("用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String userId;
	/**
	 * 选择系统头像时，系统头像的编码
	 */
	@Comment("选择系统头像时，系统头像的编码")
	@ColumnDefault("'1'")
	@Column(nullable = false, length = 40)
	private String headId;
	/**
	 * 自定义头像的文件名
	 */
	@Comment("自定义头像的文件名")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String fileName;
	/**
	 * 头像类型： 1：系统头像 2：自定义头像
	 */
	@Comment("头像类型： 1：系统头像 2：自定义头像")
	@ColumnDefault("'1'")
	@Column(nullable = false, length = 2)
	private String type;
	/**
	 * 用户自定义头像地址
	 */
	@Comment("用户自定义头像地址")
	@ColumnDefault("''")
	@Column(nullable = false, length = 500)
	private String url;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHeadId() {
		return headId;
	}

	public void setHeadId(String headId) {
		this.headId = headId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
