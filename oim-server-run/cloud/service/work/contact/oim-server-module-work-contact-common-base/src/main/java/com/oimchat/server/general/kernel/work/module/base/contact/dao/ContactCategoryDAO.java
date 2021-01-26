package com.oimchat.server.general.kernel.work.module.base.contact.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactCategory;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;

/**
 * 
 * Date 2019-01-20 11:35:07<br>
 * Description 联系人分组DAO
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class ContactCategoryDAO extends BaseDAO {

	public List<ContactCategory> getListByUserId(String userId) {
		StringBuilder hql = new StringBuilder();
		hql.append("select cc from ");
		hql.append(ContactCategory.class.getName());
		hql.append(" cc where cc.userId=:userId ");
		hql.append(" order by cc.sort ");

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("userId", userId);
		List<ContactCategory> list = this.queryListByHql(hql.toString(), queryWrapper, ContactCategory.class);

		return list;
	}

	/**
	 * 
	 * Date 2019-01-20 11:39:03<br>
	 * Description 获取联系人分组数量
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public long getContactCategoryCount(String userId) {
		String sql = "select count(id) from " + EntityUtil.getTableName(ContactCategory.class) + " where userId='" + userId + "'";
		Long count = this.queryObjectBySql(sql, null, Long.class, null);
		return count == null ? 0 : count;
	}

	public int updateSort(String id, int sort) {
		ContactCategory bean = new ContactCategory();
		bean.setId(id);
		bean.setSort(sort);
		int count = this.updateSelective(bean);
		return count;
	}

	/**
	 * 
	 * Date 2019-01-26 22:21:09<br>
	 * Description 获取默认联系人分组
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public ContactCategory getDefaultContactCategory(String userId) {
		StringBuilder hql = new StringBuilder();
		hql.append("select cc from ");
		hql.append(ContactCategory.class.getName());
		hql.append(" cc where cc.userId=:userId ");
		hql.append(" and cc.type=");
		hql.append(ContactCategory.type_default);
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("userId", userId);

		List<ContactCategory> list = this.queryListByHql(hql.toString(), queryWrapper, ContactCategory.class);
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
}
