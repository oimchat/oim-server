package com.oimchat.server.general.kernel.work.module.base.group.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlyxiahui.extend.query.hibernate.parameter.ValueOptionInfo;
import com.onlyxiahui.extend.query.hibernate.parameter.ValueOptionType;
import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupQuery;
import com.oimchat.server.general.kernel.work.module.base.group.entity.Group;
import com.onlyxiahui.aware.basic.dao.BaseEntityDAO;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;
import com.onlyxiahui.extend.query.hibernate.util.QueryUtil;
import com.onlyxiahui.extend.query.page.QueryPage;

/**
 * 描述：
 * 
 * @author XiaHui
 * @version 0.0.1
 */
@Repository
public class GroupDAO extends BaseEntityDAO<Group> {

	public Group get(String id) {
		return this.get(Group.class, id);
	}

	public String getIdByNumber(String number) {
		Group g = getByNumber(number);
		return g == null ? null : g.getId();
	}

	/**
	 * 根据群号码获取群信息
	 * 
	 * @param number
	 * @return
	 */
	public Group getByNumber(String number) {
		QueryWrapper qw = new QueryWrapper();
		qw.put("number", number);
		return this.get(qw);
	}

	public boolean updateAvatar(String id, String avatar) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(Group.class) + " set `avatar`=:avatar ");
		sql.append(" where id=:id ");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("id", id);
		queryWrapper.put("avatar", avatar);
		int i = this.executeSql(sql.toString(), queryWrapper);
		return i > 0;
	}

	public boolean updateHead(String id, String head) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(Group.class) + " set `head`=:head ");
		sql.append(" where id=:id ");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("id", id);
		queryWrapper.put("head", head);
		int i = this.executeSql(sql.toString(), queryWrapper);
		return i > 0;
	}

	public List<Group> queryList(GroupQuery query, Page page) {
		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage queryPage = queryWrapper.setPage(page.getNumber(), page.getSize());
		List<ValueOptionInfo> optionList = new ArrayList<ValueOptionInfo>();
		optionList.add(new ValueOptionInfo("queryText", ValueOptionType.likeAll));// 设置查询条件为like
		QueryUtil.getQueryWrapperType(query, queryWrapper, optionList);
		List<Group> list = this.queryListByName("group.queryGroupList", queryWrapper, Group.class);
		page.setTotalCount(queryPage.getTotalCount());
		page.setTotalPage(queryPage.getTotalPage());
		return list;
	}

	public List<Group> getListByIds(List<String> ids) {
		if (null == ids || ids.isEmpty()) {
			return new ArrayList<Group>();
		}
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from " + EntityUtil.getTableName(Group.class) + " where id in ( :ids )");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("ids", ids);
		List<Group> list = this.queryListBySql(sb.toString(), queryWrapper, Group.class, null);
		return list;
	}
}
