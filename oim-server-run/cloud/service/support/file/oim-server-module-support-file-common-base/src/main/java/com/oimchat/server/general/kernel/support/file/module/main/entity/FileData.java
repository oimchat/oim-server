package com.oimchat.server.general.kernel.support.file.module.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.oimchat.server.general.kernel.support.file.module.common.entity.FileBaseData;
import com.onlyxiahui.extend.hibernate.annotation.Comment;

/**
 * Description 文件信息 <br>
 * Date 2019-07-06 14:02:30<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Entity(name = "base_file_data")
@DynamicInsert
@DynamicUpdate
public class FileData extends FileBaseData {

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
