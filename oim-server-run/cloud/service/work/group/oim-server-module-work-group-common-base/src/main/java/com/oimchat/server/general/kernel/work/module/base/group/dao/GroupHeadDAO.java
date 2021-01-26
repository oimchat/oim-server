package com.oimchat.server.general.kernel.work.module.base.group.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupHead;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;
import com.onlyxiahui.extend.query.page.DefaultPage;

/**
 * 描述：<br>
 * Date 2016年1月4日 下午9:48:59<br>
 * 
 * @author XiaHui
 * @version 0.0.1
 */
@Repository
public class GroupHeadDAO extends BaseDAO {

	/**
	 * 
	 * @author XiaHui
	 * @param groupId
	 * @param headId
	 * @param type
	 * @return
	 */
	public GroupHead get(String groupId, String headId, String type) {

		StringBuilder sb = new StringBuilder();
		sb.append(" select * from " + EntityUtil.getTableName(GroupHead.class) + " where groupId=:groupId");
		sb.append(" and headId=:headId ");
		sb.append(" and type=:type ");
		sb.append(" desc ");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("groupId", groupId);
		queryWrapper.addParameter("headId", headId);
		queryWrapper.addParameter("type", type);

		DefaultPage page = new DefaultPage();
		page.setPageSize(1);
		page.setPageNumber(1);
		queryWrapper.setPage(page);

		List<GroupHead> list = this.queryListBySql(sb.toString(), queryWrapper, GroupHead.class, null);
		GroupHead bean = null;
		if (null != list && !list.isEmpty()) {
			list.get(0);
		}
		return bean;
	}

	/**
	 * 获取群的头像
	 * 
	 * @author: XiaHui
	 * @param userId
	 * @return
	 */
	public GroupHead getLastByGroupId(String groupId) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from " + EntityUtil.getTableName(GroupHead.class) + " where groupId=:groupId");
		sb.append(" order by createTime desc ");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("groupId", groupId);

		DefaultPage page = new DefaultPage();
		page.setPageSize(1);
		page.setPageNumber(1);
		queryWrapper.setPage(page);

		List<GroupHead> list = this.queryListBySql(sb.toString(), queryWrapper, GroupHead.class, null);
		GroupHead bean = null;
		if (null != list && !list.isEmpty()) {
			list.get(0);
		}
		return bean;
	}

	public List<GroupHead> getGroupHeadListByGroupIds(List<String> ids) {

		if (null == ids || ids.isEmpty()) {
			return new ArrayList<GroupHead>();
		}

		StringBuilder sql = new StringBuilder();
		sql.append("select gh.* from ");
		sql.append(" " + EntityUtil.getTableName(GroupHead.class) + " ");
		sql.append(" gh where gh.groupId in ");
		sql.append("( :ids )");
		sql.append(" and not exists ( select 1 from " + EntityUtil.getTableName(GroupHead.class) + " b where b.groupId = gh.groupId and b.createTime > gh.createTime )");

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("ids", ids);
		List<GroupHead> list = this.queryListBySql(sql.toString(), queryWrapper, GroupHead.class, null);
		return list;
	}
}
