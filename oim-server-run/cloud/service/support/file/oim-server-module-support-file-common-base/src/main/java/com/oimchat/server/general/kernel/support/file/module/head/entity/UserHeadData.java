package com.oimchat.server.general.kernel.support.file.module.head.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.oimchat.server.general.kernel.support.file.module.common.entity.FileBaseData;
import com.onlyxiahui.extend.hibernate.annotation.Comment;

/**
 * 文件信息
 * 
 * @author XiaHui
 * @date 2014-12-25 11:09:32
 */
@Entity(name = "base_user_head_data")
@DynamicInsert
@DynamicUpdate
public class UserHeadData extends FileBaseData {

	@Comment("上传用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
