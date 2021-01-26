package com.oimchat.server.general.kernel.work.module.base.chat.entity;

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
 * 群未读数<br>
 * Date 2019-02-17 11:58:41<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Entity()
@Table(name = "im_group_chat_unread", indexes = {
		@Index(name = "index_groupId", columnList = "groupId", unique = false),
		@Index(name = "index_userId", columnList = "userId", unique = false) })
@DynamicInsert
@DynamicUpdate
public class GroupChatUnread extends PrimaryStringEntity {

	@Comment("群id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String groupId;

	@Comment("收到消息用户id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String userId;

	@Comment("消息id")
	@ColumnDefault("''")
	@Column(nullable = false, length = 40)
	private String lastContentId;

	@Comment("未读数量")
	@ColumnDefault("0")
	@Column(nullable = false, length = 11)
	private Integer unreadCount;

	@Comment("时间戳（毫秒）")
	@ColumnDefault("0")
	@Column(nullable = false, length = 32)
	private Long timestamp;

}
