package com.oimchat.server.general.kernel.work.module.base.user.data.query;

import java.util.Date;
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
public class UserSecurityQuestionQuery {

	@Condition(equation = "in", column = "id")
	private List<String> ids;

	/**
	 * 
	 */
	private String id;

	/**
	 * 
	 */
	private Date createdDateTime;

	/**
	 * 
	 */
	private Long createdTimestamp;

	/**
	 * 
	 */
	private Integer isDeleted;

	/**
	 * 
	 */
	private Date updatedDateTime;

	/**
	 * 
	 */
	private Long updatedTimestamp;

	/**
	 * 
	 */
	private String answer;

	/**
	 * 
	 */
	private String question;

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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}