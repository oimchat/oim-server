package com.oimchat.server.general.kernel.work.module.base.user.data.query;

import java.util.List;

import com.onlyxiahui.extend.query.hibernate.syntax.annotation.Condition;
import com.onlyxiahui.extend.query.hibernate.syntax.annotation.OrderBy;

/**
 * 
 * <br>
 * Date <br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]
 * @since 1.0.0
 */
@OrderBy(value = { "updatedTimestamp" }, sort = "desc")
public class UserHeadQuery {

	@Condition(equation = "in", column = "id")
	private List<String> ids;

	/**
	 * 
	 */
	private String id;

	/**
	 * 
	 */
	private Integer isDeleted;

	/**
	 * 
	 */
	private String fileName;

	/**
	 * 
	 */
	private String headId;

	/**
	 * 
	 */
	private String type;

	/**
	 * 
	 */
	private String userId;

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getHeadId() {
		return headId;
	}

	public void setHeadId(String headId) {
		this.headId = headId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}