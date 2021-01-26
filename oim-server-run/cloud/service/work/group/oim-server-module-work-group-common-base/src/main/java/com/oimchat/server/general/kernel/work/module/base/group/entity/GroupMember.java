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
 * 群成员 <br>
 * Date 2019-07-27 16:22:59<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "im_group_member", indexes = {
		@Index(name = "index_groupId", columnList = "groupId", unique = false),
		@Index(name = "index_userId", columnList = "userId", unique = false) })
@DynamicInsert
@DynamicUpdate
public class GroupMember extends PrimaryStringEntity {

	/**
	 * 群id
	 */
	@Comment("群id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String groupId;

	/**
	 * 群成员用户id
	 */
	@Comment("群成员用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String userId;

	/**
	 * 权限 1:群主 2:管理员 3:普通成员
	 */
	@Comment("权限  1:群主 2:管理员 3:普通成员")
	@ColumnDefault("'3'")
	@Column(nullable = false, length = 2)
	private String position;

	/**
	 * 备注名(群中显示昵称)
	 */
	@Comment("备注名(群中显示昵称)")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String nickname;

	public static final String position_owner = "1";// 群主
	public static final String position_admin = "2";// 管理员
	public static final String position_normal = "3";// 普通成员

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
