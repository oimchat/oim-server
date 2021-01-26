package com.oimchat.server.general.kernel.work.module.base.chat.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlyxiahui.extend.query.hibernate.parameter.ValueOptionInfo;
import com.onlyxiahui.extend.query.hibernate.parameter.ValueOptionType;
import com.oimchat.server.general.kernel.work.module.base.chat.data.query.GroupChatQuery;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.GroupChatContent;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.QueryUtil;
import com.onlyxiahui.extend.query.page.QueryPage;

/**
 * @author: XiaHui
 * @date: 2016年8月19日 下午1:56:03
 */
@Repository
public class GroupChatDAO extends BaseDAO {

	String space = "chat.GroupChat";

	public List<GroupChatContent> getGroupChatContentList(
			String groupId,
			String outId,
			String outMessageKey,
			boolean after,
			long timestamp,
			Page page) {

		// before||after
		String compare = after ? ">=" : "<=";

		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage p = queryWrapper.setPage(page.getNumber(), page.getSize());

		queryWrapper.put("groupId", groupId);
		queryWrapper.put("outId", outId);
		queryWrapper.put("outMessageKey", outMessageKey);
		queryWrapper.put("timestamp", timestamp);
		queryWrapper.put("compare", compare);

		List<GroupChatContent> list = this.queryListByName(space + ".queryGroupChatContentList", queryWrapper, GroupChatContent.class);

		page.setTotalCount(p.getTotalCount());
		page.setTotalPage(p.getTotalPage());
		return list;
	}

	public List<GroupChatContent> queryGroupChatContentList(GroupChatQuery query, Page page) {

		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage p = queryWrapper.setPage(page.getNumber(), page.getSize());

		List<ValueOptionInfo> queryOption = new ArrayList<ValueOptionInfo>();
		queryOption.add(new ValueOptionInfo("text", ValueOptionType.likeAll));
		queryOption.add(new ValueOptionInfo("likeUserNickname", ValueOptionType.likeAll));
		
		QueryUtil.getQueryWrapperType(query, queryWrapper, queryOption);

		List<GroupChatContent> list = this.queryListByName(space + ".queryGroupChatContentList", queryWrapper, GroupChatContent.class);
		page.setTotalCount(p.getTotalCount());
		page.setTotalPage(p.getTotalPage());
		return list;
	}
}
