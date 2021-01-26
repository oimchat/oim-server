package com.oimchat.server.general.kernel.work.module.base.chat.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlyxiahui.extend.query.hibernate.parameter.ValueOptionInfo;
import com.onlyxiahui.extend.query.hibernate.parameter.ValueOptionType;
import com.oimchat.server.general.kernel.work.module.base.chat.data.query.UserChatContentQuery;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.UserChatContent;
import com.oimchat.server.general.kernel.work.module.base.chat.util.UserChatKeyUtil;
import com.onlyxiahui.aware.basic.dao.BaseEntityDAO;
import com.onlyxiahui.aware.basic.work.type.lang.BooleanEnum;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;
import com.onlyxiahui.extend.query.hibernate.util.QueryUtil;
import com.onlyxiahui.extend.query.page.QueryPage;

/**
 * 
 * Date 2019-02-17 18:18:44<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class UserChatContentDAO extends BaseEntityDAO<UserChatContent> {

	String space = "chat.UserChatContent";

	public List<UserChatContent> queryList(UserChatContentQuery query, Page page) {

		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage p = queryWrapper.setPage(page.getNumber(), page.getSize());

		List<ValueOptionInfo> queryOption = new ArrayList<ValueOptionInfo>();
		queryOption.add(new ValueOptionInfo("text", ValueOptionType.likeAll));
		QueryUtil.getQueryWrapperType(query, queryWrapper, queryOption);

		String ownKey = UserChatKeyUtil.getUserChatKey(query.getSendUserId(), query.getReceiveUserId());
		queryWrapper.put("ownKey", ownKey);

		List<UserChatContent> list = this.queryListByName(space + ".queryList", queryWrapper, UserChatContent.class);
		page.setTotalCount(p.getTotalCount());
		page.setTotalPage(p.getTotalPage());
		return list;
	}

	/**
	 * 
	 * Date 2019-02-17 18:13:35<br>
	 * Description 更新消息为已读
	 * 
	 * @author XiaHui<br>
	 * @param receiveUserId
	 * @param sendUserId
	 * @since 1.0.0
	 */
	public int updateToReadBySendUserId(String receiveUserId, String sendUserId) {
		StringBuilder sb = new StringBuilder();
		sb.append(" update " + EntityUtil.getTableName(UserChatContent.class) + " set  ");
		sb.append(" isSend = :setIsSend ,");
		sb.append(" isRead = :setIsRead ");
		sb.append("where ");
		sb.append(" receiveUserId = :receiveUserId");
		sb.append(" and sendUserId = :sendUserId");
		sb.append(" and isRead = :whereIsRead");

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("receiveUserId", receiveUserId);
		queryWrapper.addParameter("sendUserId", sendUserId);
		queryWrapper.addParameter("setIsSend", BooleanEnum.TRUE.getCode().toString());
		queryWrapper.addParameter("setIsRead", BooleanEnum.TRUE.getCode().toString());
		queryWrapper.addParameter("whereIsRead", BooleanEnum.FALSE.getCode().toString());
		return this.executeSql(sb.toString(), queryWrapper);
	}

	public int updateToReadById(String id, String receiveUserId) {
		StringBuilder sb = new StringBuilder();
		sb.append(" update " + EntityUtil.getTableName(UserChatContent.class) + " set  ");
		sb.append(" isSend = :isSend ,");
		sb.append(" isRead = :isRead ");
		sb.append("where ");
		sb.append(" id = :id");
		sb.append(" and receiveUserId = :receiveUserId");

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("id", id);
		queryWrapper.addParameter("receiveUserId", receiveUserId);
		queryWrapper.addParameter("isSend", BooleanEnum.TRUE.getCode().toString());
		queryWrapper.addParameter("isRead", BooleanEnum.TRUE.getCode().toString());
		return this.executeSql(sb.toString(), queryWrapper);
	}

	/**
	 * 根据id集合或者聊天列表
	 * 
	 * @param ids
	 * @return
	 */
	public List<UserChatContent> getListByIds(List<String> ids) {
		if (null == ids || ids.isEmpty()) {
			return new ArrayList<UserChatContent>();
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(" select * from " + EntityUtil.getTableName(UserChatContent.class) + " where id in( :ids )");
			sb.append(" order by timestamp desc ");
			QueryWrapper queryWrapper = new QueryWrapper();
			queryWrapper.addParameter("ids", ids);
			List<UserChatContent> list = this.queryListBySql(sb.toString(), queryWrapper, UserChatContent.class, null);
			return list;
		}
	}

	public UserChatContent getByMessageKey(String ownKey, String messageKey) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from " + EntityUtil.getTableName(UserChatContent.class) + "  ");
		sb.append(" where ");
		sb.append(" ownKey = :ownKey ");
		sb.append(" and messageKey = :messageKey ");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.setPage(1, 1);
		queryWrapper.addParameter("messageKey", messageKey);
		queryWrapper.addParameter("ownKey", ownKey);
		List<UserChatContent> list = this.queryListBySql(sb.toString(), queryWrapper, UserChatContent.class, null);
		return null == list || list.isEmpty() ? null : list.get(0);
	}
}
