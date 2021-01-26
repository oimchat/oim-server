package com.oimchat.server.general.kernel.work.module.base.contact.entity;

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
 * 用添加联系人的请求信息<br>
 * Date 2019-01-20 13:20:49<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "im_contact_add_apply", indexes = {
		@Index(name = "index_applyUserId", columnList = "applyUserId", unique = false),
		@Index(name = "index_targetUserId", columnList = "targetUserId", unique = false) })
@DynamicInsert
@DynamicUpdate
public class ContactAddApply extends PrimaryStringEntity {

	/**
	 * 添加联系人的请求用户
	 */
	@Comment("请求用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String applyUserId;
	/**
	 * 被添加的用户id
	 */
	@Comment("被添加的用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String targetUserId;
	/**
	 * 分组id
	 */
	@Comment("分组id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String categoryId;
	/**
	 * 备注名
	 */
	@Comment("备注名")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String remark;
	/**
	 * 当时设定的验证方式
	 */
	@Comment("当时设定的验证方式")
	@ColumnDefault("'2'")
	@Column(nullable = false, length = 40)
	private String verifyType;
	/**
	 * 问题(当验证方式为回答问题时)
	 */
	@Comment("问题(当验证方式为回答问题时)")
	@ColumnDefault("''")
	@Column(nullable = false, length = 200)
	private String question;
	/**
	 * 答案(当验证方式为回答问题时)
	 */
	@Comment("答案(当验证方式为回答问题时)")
	@ColumnDefault("''")
	@Column(nullable = false, length = 200)
	private String answer;
	/**
	 * 处理结果：0:未处理 1:同意 2:拒绝 3:忽略
	 */
	@Comment("处理结果：0:未处理 1:同意 2:拒绝 3:忽略")
	@ColumnDefault("''")
	@Column(nullable = false, length = 2)
	private String handleType;
	/**
	 * 处理时间（毫秒时间戳）
	 */
	@Comment("处理时间（毫秒时间戳）")
	@ColumnDefault("0")
	@Column(nullable = false)
	private Long handleTimestamp;
	/**
	 * 附加消息
	 */
	@Comment("附加消息")
	@ColumnDefault("''")
	@Column(nullable = false, length = 500)
	private String applyMessage;

	/** 0:未处理 **/
	public static final String handle_type_untreated = "0";
	/** 1:同意 **/
	public static final String handle_type_accept = "1";
	/** 2:拒绝 **/
	public static final String handle_type_reject = "2";
	/** 3:忽略 **/
	public static final String handle_type_ignore = "3";

	public String getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(String applyUserId) {
		this.applyUserId = applyUserId;
	}

	public String getTargetUserId() {
		return targetUserId;
	}

	public void setTargetUserId(String targetUserId) {
		this.targetUserId = targetUserId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getVerifyType() {
		return verifyType;
	}

	public void setVerifyType(String verifyType) {
		this.verifyType = verifyType;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getHandleType() {
		return handleType;
	}

	public void setHandleType(String handleType) {
		this.handleType = handleType;
	}

	public Long getHandleTimestamp() {
		return handleTimestamp;
	}

	public void setHandleTimestamp(Long handleTimestamp) {
		this.handleTimestamp = handleTimestamp;
	}

	public String getApplyMessage() {
		return applyMessage;
	}

	public void setApplyMessage(String applyMessage) {
		this.applyMessage = applyMessage;
	}
}
