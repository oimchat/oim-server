package com.oimchat.server.general.kernel.work.module.base.chat.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlyxiahui.extend.query.hibernate.parameter.ValueOptionInfo;
import com.onlyxiahui.extend.query.hibernate.parameter.ValueOptionType;
import com.oimchat.server.general.kernel.work.module.base.chat.data.query.UserChatQuery;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.UserChatContent;
import com.oimchat.server.general.kernel.work.module.base.chat.util.UserChatKeyUtil;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.QueryUtil;
import com.onlyxiahui.extend.query.page.QueryPage;

/**
 * 
 * Date 2019-02-17 18:54:48<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class UserChatDAO extends BaseDAO {

	String space = "chat.UserChat";

	public List<UserChatContent> getUserChatContentList(
			String receiveUserId,
			String sendUserId,
			String outId,
			String outMessageKey,
			boolean after,
			long timestamp,
			Page page) {

		// before||after
		String compare = after ? ">=" : "<=";

		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage p = queryWrapper.setPage(page.getNumber(), page.getSize());

		String ownKey = UserChatKeyUtil.getUserChatKey(sendUserId, receiveUserId);

		queryWrapper.put("ownKey", ownKey);
		queryWrapper.put("outId", outId);
		queryWrapper.put("outMessageKey", outMessageKey);
		queryWrapper.put("timestamp", timestamp);
		queryWrapper.put("compare", compare);

		List<UserChatContent> list = this.queryListByName(space + ".queryUserChatContentList", queryWrapper, UserChatContent.class);

		page.setTotalCount(p.getTotalCount());
		page.setTotalPage(p.getTotalPage());

		return list;
	}

	public List<UserChatContent> queryUserChatContentList(UserChatQuery query, Page page) {

		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage p = queryWrapper.setPage(page.getNumber(), page.getSize());

		List<ValueOptionInfo> queryOption = new ArrayList<ValueOptionInfo>();
		queryOption.add(new ValueOptionInfo("text", ValueOptionType.likeAll));
		QueryUtil.getQueryWrapperType(query, queryWrapper, queryOption);

		String ownKey = UserChatKeyUtil.getUserChatKey(query.getSendUserId(), query.getReceiveUserId());
		queryWrapper.put("ownKey", ownKey);

		queryWrapper.put("sendUserId", null);
		queryWrapper.put("receiveUserId", null);

		List<UserChatContent> list = this.queryListByName(space + ".queryUserChatContentList", queryWrapper, UserChatContent.class);
		page.setTotalCount(p.getTotalCount());
		page.setTotalPage(p.getTotalPage());
		return list;
	}
}
