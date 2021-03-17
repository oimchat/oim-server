package com.oimchat.server.general.kernel.work.module.base.contact.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactRelation;
import com.onlyxiahui.aware.basic.dao.BaseEntityDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;

/**
 * 
 * Date 2019-01-20 11:40:28<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class ContactRelationDAO extends BaseEntityDAO<ContactRelation> {

	/**
	 * 
	 * Date 2019-01-26 22:09:28<br>
	 * Description 根据用户id获取联系人关联关系信息
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public List<ContactRelation> getListByOwnerUserId(String ownerUserId) {
		StringBuilder hql = new StringBuilder();
		hql.append("select cr from ");
		hql.append(ContactRelation.class.getName());
		hql.append(" cr where cr.ownerUserId=:ownerUserId ");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("ownerUserId", ownerUserId);

		List<ContactRelation> list = this.queryListByHql(hql.toString(), queryWrapper, ContactRelation.class);
		return list;
	}

	/**
	 * 
	 * Date 2019-01-26 22:13:37<br>
	 * Description 获取联系人的相关信息
	 * 
	 * @author XiaHui<br>
	 * @param ownerUserId
	 * @param contactUserId
	 * @return
	 * @since 1.0.0
	 */
	public ContactRelation getByContactUserId(String ownerUserId, String contactUserId) {
		ContactRelation ccm = null;
		List<ContactRelation> list = getListByContactUserId(ownerUserId, contactUserId);
		if (null != list && !list.isEmpty()) {
			ccm = list.get(0);
		}
		return ccm;
	}

	public List<ContactRelation> getListByContactUserId(String ownerUserId, String contactUserId) {
		StringBuilder hql = new StringBuilder();
		hql.append("select cr from ");
		hql.append(ContactRelation.class.getName());
		hql.append(" cr where cr.ownerUserId=:ownerUserId ");
		hql.append(" and cr.contactUserId=:contactUserId ");

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("ownerUserId", ownerUserId);
		queryWrapper.put("contactUserId", contactUserId);

		List<ContactRelation> list = this.queryListByHql(hql.toString(), queryWrapper, ContactRelation.class);
		return list;
	}

	public List<ContactRelation> getListByContactUserIds(String ownerUserId, List<String> contactUserIds) {
		StringBuilder hql = new StringBuilder();
		hql.append("select cr from ");
		hql.append(ContactRelation.class.getName());
		hql.append(" cr where cr.ownerUserId=:ownerUserId ");
		if (null != contactUserIds && !contactUserIds.isEmpty()) {
			hql.append(" and cr.contactUserId in( :contactUserIds )");
		}

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("ownerUserId", ownerUserId);
		queryWrapper.put("contactUserIds", contactUserIds);
		List<ContactRelation> list = this.queryListByHql(hql.toString(), queryWrapper, ContactRelation.class);
		return list;
	}

	/**
	 * 
	 * Date 2019-01-26 22:15:38<br>
	 * Description 获取用户在别人的好友列表的集合
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public List<ContactRelation> getListByContactUserId(String contactUserId) {
		StringBuilder hql = new StringBuilder();
		hql.append("select ccm from ");
		hql.append(ContactRelation.class.getName());
		hql.append(" ccm where ccm.contactUserId=:contactUserId ");

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("contactUserId", contactUserId);

		List<ContactRelation> list = this.queryListByHql(hql.toString(), queryWrapper, ContactRelation.class);

		return list;
	}

	/**
	 * 
	 * Date 2019-01-20 11:46:02<br>
	 * Description 修改备注
	 * 
	 * @author XiaHui<br>
	 * @param ownerUserId
	 * @param contactUserId
	 * @param remark
	 * @return
	 * @since 1.0.0
	 */
	public int updateRemark(String ownerUserId, String contactUserId, String remark) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("ownerUserId", ownerUserId);
		queryWrapper.put("contactUserId", contactUserId);
		queryWrapper.put("remark", remark);

		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(ContactRelation.class) + " set ");
		sql.append(" remark=:remark ");
		sql.append(" where ");
		sql.append(" ownerUserId=:ownerUserId ");
		sql.append(" and contactUserId=:contactUserId ");
		int count = this.executeSql(sql.toString(), queryWrapper);
		return count;
	}

	public int updateRemark(String id, String ownerUserId, String contactUserId, String remark) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("id", id);
		queryWrapper.put("ownerUserId", ownerUserId);
		queryWrapper.put("contactUserId", contactUserId);
		queryWrapper.put("remark", remark);

		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(ContactRelation.class) + " set ");
		sql.append(" remark=:remark ");
		sql.append(" where ");
		sql.append(" id=:id ");
		sql.append(" and ownerUserId=:ownerUserId ");
		sql.append(" and contactUserId=:contactUserId ");
		int count = this.executeSql(sql.toString(), queryWrapper);
		return count;
	}

	/**
	 * 
	 * Date 2019-01-20 11:45:12<br>
	 * Description 移动用户所在分组
	 * 
	 * @author XiaHui<br>
	 * @param ownerUserId
	 * @param contactUserId
	 * @param categoryId
	 * @return
	 * @since 1.0.0
	 */
	public int updateCategoryId(String ownerUserId, String contactUserId, String categoryId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("ownerUserId", ownerUserId);
		queryWrapper.put("contactUserId", contactUserId);
		queryWrapper.put("categoryId", categoryId);

		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(ContactRelation.class) + " set ");
		sql.append(" categoryId=:categoryId ");
		sql.append(" where ");
		sql.append(" ownerUserId=:ownerUserId ");
		sql.append(" and contactUserId=:contactUserId ");
		int count = this.executeSql(sql.toString(), queryWrapper);
		return count;
	}

	public int updateCategoryId(String ownerUserId, List<String> contactUserIds, String categoryId) {
		if (null == contactUserIds || contactUserIds.isEmpty()) {
			return 0;
		}
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("ownerUserId", ownerUserId);
		queryWrapper.put("contactUserIds", contactUserIds);
		queryWrapper.put("categoryId", categoryId);

		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(ContactRelation.class) + " set ");
		sql.append(" categoryId=:categoryId ");
		sql.append(" where ");
		sql.append(" ownerUserId=:ownerUserId ");
		sql.append(" and contactUserId in ( :contactUserIds ) ");
		int count = this.executeSql(sql.toString(), queryWrapper);
		return count;
	}

	/**
	 * 
	 * Description 根据旧分组修改新分组 <br>
	 * Date 2019-05-08 17:41:28<br>
	 * 
	 * @param ownerUserId
	 * @param oldCategoryId
	 * @param newCategoryId
	 * @return int
	 * @since 1.0.0
	 */
	public int updateChangeCategoryId(String ownerUserId, String oldCategoryId, String newCategoryId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("ownerUserId", ownerUserId);
		queryWrapper.put("oldCategoryId", oldCategoryId);
		queryWrapper.put("newCategoryId", newCategoryId);

		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(ContactRelation.class) + " set ");
		sql.append(" categoryId=:newCategoryId ");
		sql.append(" where ");
		sql.append(" ownerUserId=:ownerUserId ");
		sql.append(" and categoryId=:oldCategoryId ");
		int count = this.executeSql(sql.toString(), queryWrapper);
		return count;
	}

	/**
	 * 
	 * Date 2019-01-20 11:43:21<br>
	 * Description 删除好友
	 * 
	 * @author XiaHui<br>
	 * @param ownerUserId
	 * @param contactUserId
	 * @return
	 * @since 1.0.0
	 */
	public int deleteByContactUserId(String ownerUserId, String contactUserId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("ownerUserId", ownerUserId);
		queryWrapper.put("contactUserId", contactUserId);

		StringBuilder sql = new StringBuilder();
		sql.append(" delete from " + EntityUtil.getTableName(ContactRelation.class) + " ");
		sql.append(" where ");
		sql.append(" ownerUserId=:ownerUserId ");
		sql.append(" and contactUserId=:contactUserId ");
		int count = this.executeSql(sql.toString(), queryWrapper);
		return count;
	}

	/**
	 * 
	 * Date 2019-01-26 22:08:24<br>
	 * Description 设置获取取消黑名单
	 * 
	 * @author XiaHui<br>
	 * @param ownerUserId
	 * @param contactUserId
	 * @param isBlocked
	 * @return
	 * @since 1.0.0
	 */
	public int updateIsBlocked(String ownerUserId, String contactUserId, String isBlocked) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("ownerUserId", ownerUserId);
		queryWrapper.put("contactUserId", contactUserId);
		queryWrapper.put("isBlocked", isBlocked);

		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(ContactRelation.class) + " set isBlocked=:isBlocked");
		sql.append(" where ");
		sql.append(" ownerUserId=:ownerUserId ");
		sql.append(" and contactUserId=:contactUserId ");
		int count = this.executeSql(sql.toString(), queryWrapper);
		return count;
	}
}
