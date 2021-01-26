package com.oimchat.server.general.kernel.work.module.business.group.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupDAO;
import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupQuery;
import com.oimchat.server.general.kernel.work.module.base.group.entity.Group;
import com.onlyxiahui.common.data.common.data.Page;

/**
 * 
 * Date 2019-01-21 11:39:20<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
@Transactional
public class GroupService {

	@Resource
	private GroupDAO groupDAO;

	public Group getById(String id) {
		Group group = groupDAO.get(Group.class, id);
		return group;
	}

	public Group getByNumber(String number) {
		Group group = groupDAO.getByNumber(number);
		return group;
	}

	public List<Group> queryList(GroupQuery query, Page page) {
		List<Group> list = groupDAO.queryList(query, page);
		return list;
	}

	public List<Group> getListByIds(List<String> ids) {
		return groupDAO.getListByIds(ids);
	}
}
