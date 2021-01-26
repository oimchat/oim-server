package com.oimchat.server.general.kernel.work.module.business.chat.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlyxiahui.extend.query.hibernate.parameter.ValueOptionInfo;
import com.onlyxiahui.extend.query.hibernate.parameter.ValueOptionType;
import com.oimchat.server.general.kernel.work.module.base.chat.dao.UserChatUnreadDAO;
import com.oimchat.server.general.kernel.work.module.base.chat.data.query.UserChatUnreadQuery;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.UserChatUnread;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.QueryUtil;
import com.onlyxiahui.extend.query.page.QueryPage;

/**
 * 
 * Description <br>
 * Date 2016-08-23 11:20:14<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Service
@Transactional
public class UserChatUnreadService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	UserChatUnreadDAO userChatUnreadDAO;

	public List<UserChatUnread> queryList(UserChatUnreadQuery query, Page page) {

		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage p = queryWrapper.setPage(page.getNumber(), page.getSize());

		List<ValueOptionInfo> queryOption = new ArrayList<ValueOptionInfo>();
		queryOption.add(new ValueOptionInfo("text", ValueOptionType.likeAll));
		QueryUtil.getQueryWrapperType(query, queryWrapper, queryOption);

		List<UserChatUnread> list = userChatUnreadDAO.list(queryWrapper);
		page.setTotalCount(p.getTotalCount());
		page.setTotalPage(p.getTotalPage());
		return list;
	}
}
