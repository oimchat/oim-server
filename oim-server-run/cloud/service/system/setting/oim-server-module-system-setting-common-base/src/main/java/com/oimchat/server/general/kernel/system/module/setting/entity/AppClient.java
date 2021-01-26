package com.oimchat.server.general.kernel.system.module.setting.entity;

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
 * 客户端信息<br>
 * Date 2020-04-13 17:23:35<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "setting_app_client", indexes = {
		@Index(name = "index_build", columnList = "build", unique = false),
		@Index(name = "index_version", columnList = "version", unique = false) })
@DynamicInsert
@DynamicUpdate
public class AppClient extends PrimaryStringEntity {

	/**
	 * 客户端名称
	 */
	@Comment("客户端名称")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String name;

	/**
	 * 内部构建版本（累增）
	 */
	@Comment("内部构建版本（累增）")
	@ColumnDefault("1")
	@Column(nullable = false)
	private Integer build;

	/**
	 * 发布版本号（主版本.功能版本.迭代版本）
	 */
	@Comment("发布版本号（主版本.功能版本.迭代版本）")
	@ColumnDefault("''")
	@Column(nullable = false, length = 50)
	private String version;

	/**
	 * type:客户端类型<br>
	 * 1:oim-fx(javafx客户端)<br>
	 * 2:oim-e(electron客户端)<br>
	 * 3:h5<br>
	 * 4:android<br>
	 * 5:ios<br>
	 */
	@Comment("客户端类型")
	@ColumnDefault("''")
	@Column(nullable = false, length = 10)
	private String type;

	/**
	 * platform:客户端平台<br>
	 */
	@Comment("客户端平台")
	@ColumnDefault("''")
	@Column(nullable = false, length = 50)
	private String platform;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the build
	 */
	public Integer getBuild() {
		return build;
	}

	/**
	 * @param build the build to set
	 */
	public void setBuild(Integer build) {
		this.build = build;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
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
}
