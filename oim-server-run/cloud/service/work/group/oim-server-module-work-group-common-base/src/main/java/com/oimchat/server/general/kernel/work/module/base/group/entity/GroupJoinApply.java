package com.oimchat.server.general.kernel.work.module.base.group.entity;

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
 * 加入群请求<br>
 * Date 2019-01-22 22:53:42<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "im_group_join_apply", indexes = {
		@Index(name = "index_applyUserId", columnList = "applyUserId", unique = false),
		@Index(name = "index_groupId", columnList = "groupId", unique = false),
		@Index(name = "index_handleUserId", columnList = "handleUserId", unique = false) })
@DynamicInsert
@DynamicUpdate
public class GroupJoinApply extends PrimaryStringEntity {

	/**
	 * 群id
	 */
	@Comment("群id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String groupId;

	/**
	 * 请求用户id
	 */
	@Comment("请求用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String applyUserId;

	/**
	 * 请求用户设定的群分组id
	 */
	@Comment("请求用户设定的群分组id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String categoryId;

	/**
	 * 请求用户设定的群备注名
	 */
	@Comment("请求用户设定的群备注名")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String remark;

	/**
	 * 附加消息
	 */
	@Comment("附加消息")
	@ColumnDefault("''")
	@Column(nullable = false, length = 500)
	private String applyMessage;

	/**
	 * 当时设定的验证方式
	 */
	@Comment("当时设定的验证方式")
	@ColumnDefault("'2'")
	@Column(nullable = false, length = 2)
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
	@ColumnDefault("'0'")
	@Column(nullable = false, length = 2)
	private String handleType;

	/**
	 * 处理时间(毫秒)
	 */
	@Comment("处理时间")
	@ColumnDefault("0")
	@Column(nullable = false)
	private Long handleTimestamp;

	/**
	 * 处理验证用户的id（群主/管理员）
	 */
	@Comment("处理验证用户的id（群主/管理员）")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String handleUserId;

	/**
	 * 处理验证用户的权限（群主/管理员）
	 */
	@Comment("处理验证用户的权限（群主/管理员）")
	@ColumnDefault("'1'")
	@Column(nullable = false, length = 2)
	private String handleUserPosition;

	/** 0:未处理 **/
	public static final String handle_type_untreated = "0";
	/** 1:同意 **/
	public static final String handle_type_accept = "1";
	/** 2:拒绝 **/
	public static final String handle_type_reject = "2";
	/** 3:忽略 **/
	public static final String handle_type_ignore = "3";

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(String applyUserId) {
		this.applyUserId = applyUserId;
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

	public String getApplyMessage() {
		return applyMessage;
	}

	public void setApplyMessage(String applyMessage) {
		this.applyMessage = applyMessage;
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

	public String getHandleUserId() {
		return handleUserId;
	}

	public void setHandleUserId(String handleUserId) {
		this.handleUserId = handleUserId;
	}

	public String getHandleUserPosition() {
		return handleUserPosition;
	}

	public void setHandleUserPosition(String handleUserPosition) {
		this.handleUserPosition = handleUserPosition;
	}
}
