package com.oimchat.server.general.kernel.work.module.base.group.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupJoinApply;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;
import com.onlyxiahui.extend.query.page.QueryPage;

/**
 * 
 * Date 2019-01-20 11:52:08<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class GroupJoinApplyDAO extends BaseDAO {

	public GroupJoinApply get(String id) {
		return this.get(GroupJoinApply.class, id);
	}

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	public void delete(String id) {
		this.deleteById(GroupJoinApply.class, id);
	}

	/**
	 * 
	 * Date 2019-01-27 09:10:21<br>
	 * Description
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	public List<GroupJoinApply> getListByGroupId(String groupId, Page page) {
		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage qp = queryWrapper.setPage(page.getNumber(), page.getSize());
		queryWrapper.put("groupId", groupId);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from " + EntityUtil.getTableName(GroupJoinApply.class) + " ");
		sql.append(" where ");
		sql.append(" groupId=:groupId ");
		List<GroupJoinApply> list = this.queryListBySql(sql.toString(), queryWrapper, GroupJoinApply.class, null);
		page.setTotalCount(qp.getTotalCount());
		page.setTotalPage(qp.getTotalPage());
		return list;
	}

	public List<GroupJoinApply> getUntreatedListByUserIds(String groupId, List<String> userIds) {
		if (null == userIds || userIds.isEmpty()) {
			return new ArrayList<>();
		}
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("groupId", groupId);
		queryWrapper.put("handleType", GroupJoinApply.handle_type_untreated);
		queryWrapper.put("userIds", userIds);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from " + EntityUtil.getTableName(GroupJoinApply.class) + " ");
		sql.append(" where ");
		sql.append(" groupId=:groupId ");
		sql.append(" and handleType=:handleType ");
		sql.append(" and applyUserId in ( :userIds ) ");
		List<GroupJoinApply> list = this.queryListBySql(sql.toString(), queryWrapper, GroupJoinApply.class, null);
		return list;
	}
}
