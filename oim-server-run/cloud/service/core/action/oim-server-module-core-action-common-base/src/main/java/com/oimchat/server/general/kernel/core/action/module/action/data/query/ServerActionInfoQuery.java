package com.oimchat.server.general.kernel.core.action.module.action.data.query;

import java.util.Date;
import java.util.List;

import com.onlyxiahui.common.action.description.annotation.DocTitle;
import com.onlyxiahui.extend.query.hibernate.syntax.annotation.Condition;
import com.onlyxiahui.extend.query.hibernate.syntax.annotation.OrderBy;

/**
 * 
 * 服务的Action信息<br>
 * Date 2020-11-08 18:55:40<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]
 * @since 1.0.0
 */

@OrderBy(value = { "updatedTimestamp" }, sort = "desc")
public class ServerActionInfoQuery {

	@Condition(equation = "in", column = "id")
	private List<String> ids;

	@DocTitle("查询更新时间开始时间戳")
	@Condition(equation = ">=", column = "updatedTimestamp")
	private Long startUpdatedTimestamp;

	@DocTitle("查询更新时间结束时间戳")
	@Condition(equation = "<=", column = "updatedTimestamp")
	private Long stopUpdatedTimestamp;

	@DocTitle("查询创建时间开始时间戳")
	@Condition(equation = ">=", column = "createdTimestamp")
	private Long startCreatedTimestamp;

	@DocTitle("查询创建时间结束时间戳")
	@Condition(equation = "<=", column = "createdTimestamp")
	private Long stopCreatedTimestamp;

	/**
	 * 主键id
	 */
	@DocTitle("主键id")
	private String id;

	/**
	 * 创建时间（格式：2019-01-01 00:00:00）
	 */
	@DocTitle("创建时间（格式：2019-01-01 00:00:00）")
	private Date createdDateTime;

	/**
	 * 创建时间戳（毫秒）
	 */
	@DocTitle("创建时间戳（毫秒）")
	private Long createdTimestamp;

	/**
	 * 是否逻辑删除：0：否、1：是
	 */
	@DocTitle("是否逻辑删除：0：否、1：是")
	private Integer isDeleted;

	/**
	 * 修改时间（格式：2019-01-01 00:00:00）
	 */
	@DocTitle("修改时间（格式：2019-01-01 00:00:00）")
	private Date updatedDateTime;

	/**
	 * 修改时间戳（毫秒）
	 */
	@DocTitle("修改时间戳（毫秒）")
	private Long updatedTimestamp;

	/**
	 * 修改操作用户
	 */
	@DocTitle("修改操作用户")
	private String createdUserId;

	/**
	 * 创建操作用户
	 */
	@DocTitle("创建操作用户")
	private String updatedUserId;

	/**
	 * Key
	 */
	@DocTitle("Key")
	private String key;

	/**
	 * 上级Key
	 */
	@DocTitle("上级Key")
	private String superKey;

	/**
	 * Action地址
	 */
	@DocTitle("Action地址")
	private String path;

	/**
	 * 名称
	 */
	@DocTitle("名称")
	private String name;

	/**
	 * 说明
	 */
	@DocTitle("说明")
	private String introduce;

	/**
	 * 权限通过类型
	 */
	@DocTitle("权限通过类型")
	private String permissionType;

	/**
	 * 是否接口： 0：否 1：是
	 */
	@DocTitle("是否接口： 0：否 1：是")
	private Integer isAction;

	/**
	 * 服务技术名
	 */
	@DocTitle("服务技术名")
	private String serviceName;

	/**
	 * 服务显示名
	 */
	@DocTitle("服务显示名")
	private String serviceTitle;

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	
	public Long getStartUpdatedTimestamp() {
		return startUpdatedTimestamp;
	}

	public void setStartUpdatedTimestamp(Long startUpdatedTimestamp) {
		this.startUpdatedTimestamp = startUpdatedTimestamp;
	}

	public Long getStopUpdatedTimestamp() {
		return stopUpdatedTimestamp;
	}

	public void setStopUpdatedTimestamp(Long endUpdatedTimestamp) {
		this.stopUpdatedTimestamp = endUpdatedTimestamp;
	}

	public Long getStartCreatedTimestamp() {
		return startCreatedTimestamp;
	}

	public void setStartCreatedTimestamp(Long startCreatedTimestamp) {
		this.startCreatedTimestamp = startCreatedTimestamp;
	}

	public Long getStopCreatedTimestamp() {
		return stopCreatedTimestamp;
	}

	public void setStopCreatedTimestamp(Long endCreatedTimestamp) {
		this.stopCreatedTimestamp = endCreatedTimestamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Long getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Long createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public Long getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Long updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	public String getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}

	public String getUpdatedUserId() {
		return updatedUserId;
	}

	public void setUpdatedUserId(String updatedUserId) {
		this.updatedUserId = updatedUserId;
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

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceTitle() {
		return serviceTitle;
	}

	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}

}