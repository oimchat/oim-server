package com.oimchat.server.general.kernel.system.module.setting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.onlyxiahui.aware.basic.bean.PrimaryStringEntity;
import com.onlyxiahui.extend.hibernate.annotation.Comment;

/**
 * 
 * 多设备在线策略<br>
 * Date 2020-04-13 17:05:58<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "setting_multiple_online_strategy")
@DynamicInsert
@DynamicUpdate
public class MultipleOnlineStrategy extends PrimaryStringEntity {

	/**
	 * type:客户端类型<br>
	 * 1:oim-fx(javafx客户端)<br>
	 * 2:oim-e(electron客户端)<br>
	 * 3:h5<br>
	 * 4:android<br>
	 * 5:ios<br>
	 */
	@Comment("客户端类型：1:oim-fx(javafx客户端) 2:oim-e(electron客户端) 3:h5 ......")
	@ColumnDefault("''")
	@Column(nullable = false, length = 5)
	private String type;

	/**
	 * platform:客户端平台<br>
	 */
	@Comment("客户端平台（操作系统名称）")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String platform;

	/**
	 * 是否可以多设备同时在线：0：否、1：是
	 */
	@Comment("是否可以多设备同时在线：0：否、1：是")
	@ColumnDefault("1")
	@Column(nullable = false)
	private Integer isMultiple;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * @return the isMultiple
	 */
	public Integer getIsMultiple() {
		return isMultiple;
	}

	/**
	 * @param isMultiple the isMultiple to set
	 */
	public void setIsMultiple(Integer isMultiple) {
		this.isMultiple = isMultiple;
	}
}