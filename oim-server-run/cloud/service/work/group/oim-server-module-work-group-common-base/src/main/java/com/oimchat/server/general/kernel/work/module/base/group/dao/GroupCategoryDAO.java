package com.oimchat.server.general.kernel.work.module.base.group.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupCategory;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;

/**
 * 
 * Date 2019-01-20 21:03:00<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class GroupCategoryDAO extends BaseDAO {

	/**
	 * 
	 * Date 2019-01-20 21:03:07<br>
	 * Description 根据用户id，获取用户下群分组信息
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public List<GroupCategory> getListByUserId(String userId) {
		StringBuilder hql = new StringBuilder();
		hql.append("select gc from ");
		hql.append(GroupCategory.class.getName());
		hql.append(" gc where gc.userId=:userId ");
		hql.append(" order by gc.sort ");

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("userId", userId);

		List<GroupCategory> list = this.queryListByHql(hql.toString(), queryWrapper, GroupCategory.class);
		return list;
	}

	public long getGroupCategoryCount(String userId) {
		String sql = "select count(id) from " + EntityUtil.getTableName(GroupCategory.class) + " where userId='" + userId + "'";
		Long count = this.queryObjectBySql(sql, null, Long.class, null);
		return count == null ? 0 : count;
	}

	public int updateSort(String id, int sort) {
		GroupCategory bean = new GroupCategory();
		bean.setId(id);
		bean.setSort(sort);
		int count = this.updateSelective(bean);
		return count;
	}

	/**
	 * 根据用户id，获取用户默认的群分组信息
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public GroupCategory getDefaultGroupCategory(String userId) {
		StringBuilder hql = new StringBuilder();
		hql.append("select gc from ");
		hql.append(GroupCategory.class.getName());
		hql.append(" gc where gc.userId= '");
		hql.append(userId);
		hql.append("' ");
		hql.append(" and gc.type=");
		hql.append(GroupCategory.type_default);
		List<GroupCategory> list = (List<GroupCategory>) this.find(hql.toString());
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
}
