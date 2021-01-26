package com.oimchat.server.general.kernel.work.module.base.chat.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.chat.entity.GroupChatItem;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;

/**
 * @author: XiaHui
 * @date: 2016年8月19日 下午1:56:03
 */
@Repository
public class GroupChatItemDAO extends BaseDAO {

	String space = "chat.GroupChatItem";

	public List<GroupChatItem> getListByContentIds(List<String> contentIds) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("contentIds", contentIds);
		List<GroupChatItem> list = this.queryListByName(space + ".getListByContentIds", queryWrapper, GroupChatItem.class);
		return list;
	}
}
