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
 * Date 2019-01-15 15:13:57<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "config_server_address", indexes = {
		@Index(name = "index_serverTypeCode", columnList = "serverTypeCode", unique = false) })
@DynamicInsert
@DynamicUpdate
public class ServerAddress extends PrimaryStringEntity {

	@Comment("内网地址")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String host;

	/**
	 * 服务类型编码
	 */
	@Comment("服务类型编码")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String serverTypeCode;
	
	/**
	 * 
	 * IPv4<br>
	 * IPv6 <br>
	 * URL<br>
	 * 
	 */
	@Comment("地址类型：IPv4、IPv6、URL")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String addressType;

	/**
	 * TCP<br>
	 * UDP<br>
	 * FTP<br>
	 * HTTP
	 */
	@Comment("协议类型：TCP、UDP、FTP、HTTP")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String protocol;

	/**
	 * 外网地址，通过内网地址找到外网配置返回给用户
	 */
	@Comment("外网地址，通过内网地址找到外网配置返回给用户")
	@ColumnDefault("''")
	@Column(nullable = false, length = 500)
	private String address;

	/**
	 * 端口
	 */
	@Comment("端口")
	@ColumnDefault("0")
	@Column(nullable = false)
	private Integer port;

	/**
	 * 是否启用：0：否、1：是
	 */
	@Comment("是否启用：0：否、1：是")
	@ColumnDefault("'1'")
	@Column(nullable = false, length = 2)
	private String isEnabled;

	/**
	 * 特征
	 */
	@Comment("特征")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String feature;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getServerTypeCode() {
		return serverTypeCode;
	}

	public void setServerTypeCode(String serverTypeCode) {
		this.serverTypeCode = serverTypeCode;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}
}
