package com.oimchat.server.general.kernel.work.module.base.chat.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.chat.entity.UserChatItem;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;

/**
 * 
 * Date 2019-02-17 18:31:51<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class UserChatItemDAO extends BaseDAO {

	String space = "chat.UserChatItem";

	public List<UserChatItem> getListByContentIds(List<String> contentIds) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("contentIds", contentIds);
		List<UserChatItem> list = this.queryListByName(space + ".getListByContentIds", queryWrapper, UserChatItem.class);
		return list;
	}
}
