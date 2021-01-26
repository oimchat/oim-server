package com.oimchat.server.general.kernel.work.module.base.contact.data.dto;

import java.util.List;

/**
 * 被添加时处理信息<br>
 * Date 2019-01-06 12:12:11<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class ContactAddHandleData {

	/**
	 * 请求记录id
	 */
	private List<String> applyIds;
	/**
	 * 添加联系人的请求用户
	 */
	private String applyUserId;
	/**
	 * 分组id
	 */
	private String categoryId;
	/**
	 * 备注名
	 */
	private String remark;
	/**
	 * 处理结果：0:未处理 1:同意 2:拒绝 3:忽略
	 */
	private String handleType;
	/**
	 * 附加消息
	 */
	private String message;

	public List<String> getApplyIds() {
		return applyIds;
	}

	public void setApplyIds(List<String> applyIds) {
		this.applyIds = applyIds;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public String getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(String applyUserId) {
		this.applyUserId = applyUserId;
	}

	public String geCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String userCategoryId) {
		this.categoryId = userCategoryId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getHandleType() {
		return handleType;
	}

	public void setHandleType(String handleType) {
		this.handleType = handleType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
