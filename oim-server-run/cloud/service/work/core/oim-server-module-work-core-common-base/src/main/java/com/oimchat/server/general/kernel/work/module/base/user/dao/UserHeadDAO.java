package com.oimchat.server.general.kernel.work.module.base.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.user.entity.UserHead;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;
import com.onlyxiahui.extend.query.page.DefaultPage;

/**
 * 描述：
 * 
 * 2016年1月4日 下午9:48:59 <br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Repository
public class UserHeadDAO extends BaseDAO {

	/**
	 * 
	 * @param userId
	 * @param headId
	 * @param type
	 * @return
	 * @since 1.0.0
	 */
	public UserHead get(String userId, String headId, String type) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from " + EntityUtil.getTableName(UserHead.class) + " where userId=:userId ");
		sb.append(" and headId=:headId ");
		sb.append(" and type=:type ");
		sb.append(" desc ");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("userId", userId);
		queryWrapper.addParameter("headId", headId);
		queryWrapper.addParameter("type", type);

		DefaultPage page = new DefaultPage();
		page.setPageSize(1);
		page.setPageNumber(1);
		queryWrapper.setPage(page);

		List<UserHead> list = this.queryListBySql(sb.toString(), queryWrapper, UserHead.class, null);
		UserHead bean = null;
		if (null != list && !list.isEmpty()) {
			list.get(0);
		}
		return bean;
	}

	/**
	 * 获取用户的头像
	 * 
	 * Date: 2017年6月6日 上午11:55:23<br>
	 * 
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public UserHead getLastByUserId(String userId) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from " + EntityUtil.getTableName(UserHead.class) + " where userId=:userId");
		sb.append(" order by createdDateTime desc ");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("userId", userId);

		DefaultPage page = new DefaultPage();
		page.setPageSize(1);
		page.setPageNumber(1);
		queryWrapper.setPage(page);

		List<UserHead> list = this.queryListBySql(sb.toString(), queryWrapper, UserHead.class, null);
		UserHead bean = null;
		if (null != list && !list.isEmpty()) {
			list.get(0);
		}
		return bean;
	}

	public List<UserHead> getUserHeadListByUserIds(List<String> ids) {
		if (null == ids || ids.isEmpty()) {
			return new ArrayList<UserHead>();
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select uh.* from ");
		sql.append(" " + EntityUtil.getTableName(UserHead.class) + " ");
		sql.append(" uh where uh.userId in ");
		sql.append("( :ids )");
		sql.append(" and not exists ( select 1 from " + EntityUtil.getTableName(UserHead.class) + " b where b.userId = uh.userId and b.createdDateTime > uh.createdDateTime )");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("ids", ids);
		List<UserHead> userList = this.queryListBySql(sql.toString(), queryWrapper, UserHead.class, null);
		return userList;
	}
}
