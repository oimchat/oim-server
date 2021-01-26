package com.oimchat.server.general.kernel.work.module.manage.system.data;

import java.util.List;

import com.onlyxiahui.extend.query.hibernate.syntax.annotation.Like;
import com.onlyxiahui.extend.query.hibernate.syntax.annotation.OrderBy;

/**
 * date 2018-07-12 10:22:36<br>
 * description
 * 
 * @author XiaHui<br>
 * @since
 */
@OrderBy(value = { "sort" }, sort = "desc")
public class FunctionQuery {

	/**
	 * 菜单id
	 */
	private String id;

	/**
	 * 上级菜单id
	 */
	private String superId;

	/**
	 * 是否禁用 0：启用 1：停用
	 */
	private Integer isDisable;

	/**
	 * 名称模糊条件
	 */
	@Like(column = "name")
	private String likeName;

	/**
	 * 条件包含的id
	 */
	private List<String> ids;

	/**
	 * 条件排除的id
	 */
	private List<String> outIds;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSuperId() {
		return superId;
	}

	public void setSuperId(String superId) {
		this.superId = superId;
	}

	public String getLikeName() {
		return likeName;
	}

	public void setLikeName(String likeName) {
		this.likeName = likeName;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public List<String> getOutIds() {
		return outIds;
	}

	public void setOutIds(List<String> outIds) {
		this.outIds = outIds;
	}

	public Integer getIsDisable() {
		return isDisable;
	}

	public void setIsDisable(Integer isDisable) {
		this.isDisable = isDisable;
	}

}
