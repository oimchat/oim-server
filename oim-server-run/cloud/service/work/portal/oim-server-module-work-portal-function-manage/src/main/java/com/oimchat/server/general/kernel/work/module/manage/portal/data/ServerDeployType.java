package com.oimchat.server.general.kernel.work.module.manage.portal.data;

/**
 * 服务器部署类型<br>
 * Date 2020-06-06 20:52:48<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
public class ServerDeployType {

	/**
	 * 服务器部署类型: 1:单机 2:普通集群 3:微服务
	 */
	private String deployType;

	public ServerDeployType() {
	}

	public ServerDeployType(String deployType) {
		this.deployType = deployType;
	}

	public String getDeployType() {
		return deployType;
	}

	public void setDeployType(String deployType) {
		this.deployType = deployType;
	}
}
