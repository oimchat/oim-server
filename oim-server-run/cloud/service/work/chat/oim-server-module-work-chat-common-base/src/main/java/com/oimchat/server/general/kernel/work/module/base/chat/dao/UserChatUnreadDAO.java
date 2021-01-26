package com.oimchat.server.general.kernel.work.module.base.chat.dao;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.chat.entity.UserChatUnread;
import com.onlyxiahui.aware.basic.dao.BaseEntityDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;

/**
 * 
 * Date 2019-02-17 18:54:48<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class UserChatUnreadDAO extends BaseEntityDAO<UserChatUnread> {

	public int updateUnreadCount(
			String receiveUserId,
			String sendUserId,
			String lastContentId,
			int unreadCount,
			long timestamp) {

		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(UserChatUnread.class));
		sql.append(" set ");
		sql.append(" `unreadCount`=:unreadCount ,");
		sql.append(" `lastContentId`=:lastContentId ,");
		sql.append(" `timestamp`=:timestamp ");

		sql.append(" where ");
		sql.append("  receiveUserId=:receiveUserId ");
		sql.append(" and sendUserId=:sendUserId ");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("receiveUserId", receiveUserId);
		queryWrapper.put("sendUserId", sendUserId);
		queryWrapper.put("lastContentId", lastContentId);
		queryWrapper.put("unreadCount", unreadCount);
		queryWrapper.put("timestamp", timestamp);
		int i = this.executeSql(sql.toString(), queryWrapper);
		return i;
	}
}
