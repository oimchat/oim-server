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
 * 群邀请请求<br>
 * Date 2019-01-22 22:53:42<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "im_group_invite_apply", indexes = {
		@Index(name = "index_inviteeUserId", columnList = "inviteeUserId", unique = false),
		@Index(name = "index_inviterUserId", columnList = "inviterUserId", unique = false),
		@Index(name = "index_groupId", columnList = "groupId", unique = false),
		@Index(name = "index_verifyUserId", columnList = "verifyUserId", unique = false) })
@DynamicInsert
@DynamicUpdate
public class GroupInviteApply extends PrimaryStringEntity {

	/**
	 * 群id
	 */
	@Comment("群id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String groupId;

	/**
	 * 受邀请人id
	 */
	@Comment("被邀请人id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String inviteeUserId;

	/**
	 * 处理结果：0:未处理 1:同意 2:拒绝 3:忽略
	 */
	@Comment("被邀请人处理结果：0:未处理 1:同意 2:拒绝 3:忽略")
	@ColumnDefault("'0'")
	@Column(nullable = false, length = 2)
	private String inviteeHandleType;

	/**
	 * 被邀请人处理时间(毫秒)
	 */
	@Comment("被邀请人处理时间")
	@ColumnDefault("0")
	@Column(nullable = false)
	private Long inviterHandleTimestamp;

	/**
	 * 邀请人id
	 */
	@Comment("发起邀请人id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String inviterUserId;

	/**
	 * 发起邀请人的群权限
	 */
	@Comment("发起邀请人的群权限")
	@ColumnDefault("3")
	@Column(nullable = false, length = 2)
	private String inviterUserPosition;

	/**
	 * 发起邀请人附加消息
	 */
	@Comment("发起邀请人附加消息")
	@ColumnDefault("''")
	@Column(nullable = false, length = 500)
	private String inviterMessage;

	/**
	 * 当时设定的验证方式
	 */
	@Comment("当时设定的验证方式")
	@ColumnDefault("'2'")
	@Column(nullable = false, length = 2)
	private String verifyType;

	/**
	 * 处理邀请的用户id（群主/管理员）
	 */
	@Comment("处理邀请的用户id（群主/管理员）")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String verifyUserId;

	/**
	 * 处理邀请的用户权限（群主/管理员）
	 */
	@Comment("处理邀请的用户权限（群主/管理员）")
	@ColumnDefault("'1'")
	@Column(nullable = false, length = 2)
	private String verifyUserPosition;

	/**
	 * 处理结果：0:未处理 1:同意 2:拒绝 3:忽略
	 */
	@Comment("群主/管理员处理结果：0:未处理 1:同意 2:拒绝 3:忽略")
	@ColumnDefault("'0'")
	@Column(nullable = false, length = 2)
	private String verifyHandleType;

	/**
	 * 群主/管理员验证处理时间(毫秒)
	 */
	@Comment("群主/管理员验证处理时间")
	@ColumnDefault("0")
	@Column(nullable = false)
	private Long verifyHandleTimestamp;

	/**
	 * 群主/管理员验证时附加消息
	 */
	@Comment("群主/管理员验证时附加消息")
	@ColumnDefault("''")
	@Column(nullable = false, length = 500)
	private String verifyMessage;

	/** 0:未处理 **/
	public static final String verify_handle_type_untreated = "0";
	/** 1:同意 **/
	public static final String verify_handle_type_accept = "1";
	/** 2:拒绝 **/
	public static final String verify_handle_type_reject = "2";
	/** 3:忽略 **/
	public static final String verify_handle_type_ignore = "3";

	/** 0:未处理 **/
	public static final String invitee_handle_type_untreated = "0";
	/** 1:同意 **/
	public static final String invitee_handle_type_accept = "1";
	/** 2:拒绝 **/
	public static final String invitee_handle_type_reject = "2";
	/** 3:忽略 **/
	public static final String invitee_handle_type_ignore = "3";

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getInviteeUserId() {
		return inviteeUserId;
	}

	public void setInviteeUserId(String inviteeUserId) {
		this.inviteeUserId = inviteeUserId;
	}

	public String getInviteeHandleType() {
		return inviteeHandleType;
	}

	public void setInviteeHandleType(String inviteeHandleType) {
		this.inviteeHandleType = inviteeHandleType;
	}

	public Long getInviterHandleTimestamp() {
		return inviterHandleTimestamp;
	}

	public void setInviterHandleTimestamp(Long inviterHandleTimestamp) {
		this.inviterHandleTimestamp = inviterHandleTimestamp;
	}

	public String getInviterUserId() {
		return inviterUserId;
	}

	public void setInviterUserId(String inviterUserId) {
		this.inviterUserId = inviterUserId;
	}

	public String getInviterUserPosition() {
		return inviterUserPosition;
	}

	public void setInviterUserPosition(String inviterUserPosition) {
		this.inviterUserPosition = inviterUserPosition;
	}

	public String getInviterMessage() {
		return inviterMessage;
	}

	public void setInviterMessage(String inviterMessage) {
		this.inviterMessage = inviterMessage;
	}

	public String getVerifyType() {
		return verifyType;
	}

	public void setVerifyType(String verifyType) {
		this.verifyType = verifyType;
	}

	public String getVerifyUserId() {
		return verifyUserId;
	}

	public void setVerifyUserId(String verifyUserId) {
		this.verifyUserId = verifyUserId;
	}

	public String getVerifyUserPosition() {
		return verifyUserPosition;
	}

	public void setVerifyUserPosition(String verifyUserPosition) {
		this.verifyUserPosition = verifyUserPosition;
	}

	public String getVerifyHandleType() {
		return verifyHandleType;
	}

	public void setVerifyHandleType(String verifyHandleType) {
		this.verifyHandleType = verifyHandleType;
	}

	public Long getVerifyHandleTimestamp() {
		return verifyHandleTimestamp;
	}

	public void setVerifyHandleTimestamp(Long verifyHandleTimestamp) {
		this.verifyHandleTimestamp = verifyHandleTimestamp;
	}

	public String getVerifyMessage() {
		return verifyMessage;
	}

	public void setVerifyMessage(String verifyMessage) {
		this.verifyMessage = verifyMessage;
	}
}
