package com.oimchat.server.cloud.action.discover.data;

import com.onlyxiahui.common.action.description.annotation.DocTitle;

/**
 * Description <br>
 * Date 2021-01-12 14:50:55<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class ActionInfo {

	@DocTitle("Key")
	private String key;

	@DocTitle("上级Key")
	private String superKey;

	@DocTitle("地址")
	private String path;

	@DocTitle("名称")
	private String name;

	@DocTitle("功能描述")
	private String introduce;

	@DocTitle("权限通过类型")
	private String permissionType;
	/**
	 * 
	 */
	@DocTitle("isAction")
	private Integer isAction;

	/**
	 * 服务技术名
	 */
	@DocTitle("服务技术名")
	private String serviceName;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSuperKey() {
		return superKey;
	}

	public void setSuperKey(String superKey) {
		this.superKey = superKey;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}

	public Integer getIsAction() {
		return isAction;
	}

	public void setIsAction(Integer isAction) {
		this.isAction = isAction;
	}
}
