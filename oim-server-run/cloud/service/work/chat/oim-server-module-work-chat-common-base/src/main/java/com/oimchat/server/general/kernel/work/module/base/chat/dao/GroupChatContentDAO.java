package com.oimchat.server.general.kernel.work.module.base.chat.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.chat.data.query.GroupChatContentQuery;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.GroupChatContent;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.parameter.ValueOptionInfo;
import com.onlyxiahui.extend.query.hibernate.parameter.ValueOptionType;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;
import com.onlyxiahui.extend.query.hibernate.util.QueryUtil;
import com.onlyxiahui.extend.query.page.QueryPage;

/**
 * 
 * Date 2019-03-08 14:13:13<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class GroupChatContentDAO extends BaseDAO {

	String space = "chat.GroupChatContent";

	public List<GroupChatContent> queryList(GroupChatContentQuery query, Page page) {
		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage queryPage = queryWrapper.setPage(page.getNumber(), page.getSize());
		List<ValueOptionInfo> optionList = new ArrayList<ValueOptionInfo>();
		optionList.add(new ValueOptionInfo("text", ValueOptionType.likeAll));
		QueryUtil.getQueryWrapperType(query, queryWrapper, optionList);

		List<GroupChatContent> list = this.queryListByName(space + ".queryList", queryWrapper, GroupChatContent.class);
		page.setTotalCount(queryPage.getTotalCount());
		page.setTotalPage(queryPage.getTotalPage());
		return list;
	}

	/**
	 * 根据id集合或者聊天列表
	 * 
	 * @param ids
	 * @return
	 */
	public List<GroupChatContent> getListByIds(List<String> ids) {
		if (null == ids || ids.isEmpty()) {
			return new ArrayList<GroupChatContent>();
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(" select * from " + EntityUtil.getTableName(GroupChatContent.class) + " where id in( :ids )");
			sb.append(" order by timestamp desc ");
			QueryWrapper queryWrapper = new QueryWrapper();
			queryWrapper.addParameter("ids", ids);
			List<GroupChatContent> list = this.queryListBySql(sb.toString(), queryWrapper, GroupChatContent.class, null);
			return list;
		}
	}

	public GroupChatContent getByMessageKey(String groupId, String messageKey) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from " + EntityUtil.getTableName(GroupChatContent.class) + "  ");
		sb.append(" where ");
		sb.append(" groupId = :groupId ");
		sb.append(" and messageKey = :messageKey ");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.setPage(1, 1);
		queryWrapper.addParameter("messageKey", messageKey);
		queryWrapper.addParameter("groupId", groupId);
		List<GroupChatContent> list = this.queryListBySql(sb.toString(), queryWrapper, GroupChatContent.class, null);
		return null == list || list.isEmpty() ? null : list.get(0);
	}
}
