package com.oimchat.server.general.kernel.work.module.base.chat.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.chat.data.query.RecentChatQuery;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.RecentChat;
import com.onlyxiahui.aware.basic.dao.BaseEntityDAO;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;
import com.onlyxiahui.extend.query.hibernate.util.QueryUtil;
import com.onlyxiahui.extend.query.page.DefaultPage;
import com.onlyxiahui.extend.query.page.QueryPage;

/**
 * 
 * Date 2019-03-08 08:57:20<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class RecentChatDAO extends BaseEntityDAO<RecentChat> {

	String space = "chat.RecentChat";

	/**
	 * 
	 * Date 2019-03-08 08:57:27<br>
	 * Description 删除最近聊天记录
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param chatId
	 * @param type
	 * @return
	 * @since 1.0.0
	 */
	public int deleteBy(String userId, String chatId, String type) {
		StringBuilder sb = new StringBuilder();
		sb.append(" delete from " + EntityUtil.getTableName(RecentChat.class) + " where userId=:userId");
		sb.append(" and chatId=:chatId");
		sb.append(" and type=:type");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("userId", userId);
		queryWrapper.addParameter("chatId", chatId);
		queryWrapper.addParameter("type", type);
		int count = this.executeSql(sb.toString(), queryWrapper);
		return count;
	}

	/**
	 * 
	 * Date 2019-03-08 09:10:16<br>
	 * Description 更新最近聊天时间
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param chatId
	 * @param type
	 * @param timestamp
	 * @return
	 * @since 1.0.0
	 */
	public int updateTimestamp(String userId, String chatId, String type, long timestamp) {
		StringBuilder sb = new StringBuilder();
		sb.append(" update " + EntityUtil.getTableName(RecentChat.class) + " ");
		sb.append(" set timestamp=:timestamp,dateTime=:dateTime ");
		sb.append(" where ");
		sb.append(" userId=:userId");
		sb.append(" and chatId=:chatId");
		sb.append(" and type=:type");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("dateTime", new Timestamp(timestamp));
		queryWrapper.addParameter("timestamp", timestamp);

		queryWrapper.addParameter("userId", userId);
		queryWrapper.addParameter("chatId", chatId);
		queryWrapper.addParameter("type", type);
		int count = this.executeSql(sb.toString(), queryWrapper);
		return count;
	}

	/**
	 * 
	 * Date 2019-03-08 09:00:57<br>
	 * Description 获取用户最近聊天对象记录
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param chatId
	 * @param type
	 * @return
	 * @since 1.0.0
	 */
	public RecentChat getLastRecentChat(String userId, String chatId, String type) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from " + EntityUtil.getTableName(RecentChat.class) + " where userId=:userId");
		sb.append(" and chatId=:chatId");
		sb.append(" and type=:type ");
		sb.append(" order by timestamp desc ");

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("userId", userId);
		queryWrapper.addParameter("chatId", chatId);
		queryWrapper.addParameter("type", type);

		DefaultPage page = new DefaultPage();
		page.setPageSize(1);
		page.setPageNumber(1);
		queryWrapper.setPage(page);

		List<RecentChat> list = this.queryListBySql(sb.toString(), queryWrapper, RecentChat.class, null);
		RecentChat bean = null;
		if (null != list && !list.isEmpty()) {
			bean = list.get(0);
		}
		return bean;
	}

	/**
	 * 
	 * Date 2019-03-08 09:04:29<br>
	 * Description 获取用户最后聊天记录
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param count
	 * @return
	 * @since 1.0.0
	 */
	public List<RecentChat> getList(String userId, int count) {
		return getList(userId, count, null);
	}

	public List<RecentChat> getList(String userId, int count, String type) {
		count = (30 < count || count <= 0) ? 30 : count;
		DefaultPage page = new DefaultPage();
		page.setPageSize(count);
		page.setPageNumber(1);

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("userId", userId);
		queryWrapper.setPage(page);

		StringBuilder sb = new StringBuilder();
		sb.append(" select * from " + EntityUtil.getTableName(RecentChat.class) + " where userId=:userId");

		if (null != type && !type.isEmpty()) {
			sb.append(" and type=:type ");
			queryWrapper.addParameter("type", type);
		}
		sb.append(" order by timestamp desc ");
		List<RecentChat> list = this.queryListBySql(sb.toString(), queryWrapper, RecentChat.class, null);
		return list;
	}

	public List<RecentChat> queryList(Page page, RecentChatQuery query) {
		QueryWrapper queryWrapper = QueryUtil.getQueryWrapper(query);
		QueryPage p = queryWrapper.setPage(page.getNumber(), page.getSize());
		List<RecentChat> list = this.queryListByName(space + ".queryList", queryWrapper, RecentChat.class);
		page.setTotalCount(p.getTotalCount());
		return list;
	}
}
