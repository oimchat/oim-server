package com.oimchat.server.basic.common.data.client;

/**
 * Date 2019-01-06 09:49:06<br>
 * Description 客户端的相关信息
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */

public class Client {

	/**
	 * 内部构建版本（累增）
	 */
	private int build;
	/**
	 * 发布版本号（主版本.功能版本.迭代版本）
	 */
	private String version;
	/**
	 * type:客户端类型<br>
	 * 1:oim-fx(javafx客户端)<br>
	 * 2:oim-e(electron客户端)<br>
	 * 3:h5-web<br>
	 * 4:android<br>
	 * 5:ios<br>
	 * 6:h5-app<br>
	 * 7:h5-wap<br>
	 */
	private String type;

	/**
	 * platform:客户端平台 名称<br>
	 */
	private String platform;

	public int getBuild() {
		return build;
	}

	public void setBuild(int build) {
		this.build = build;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

}
