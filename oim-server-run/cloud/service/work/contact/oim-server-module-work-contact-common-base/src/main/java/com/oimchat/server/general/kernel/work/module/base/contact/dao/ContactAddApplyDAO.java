package com.oimchat.server.general.kernel.work.module.base.contact.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.contact.data.dto.ContactAddApplyQuery;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactAddApply;
import com.onlyxiahui.aware.basic.dao.BaseEntityDAO;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;
import com.onlyxiahui.extend.query.page.QueryPage;

/**
 * 
 * Date 2019-01-20 11:52:08<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class ContactAddApplyDAO extends BaseEntityDAO<ContactAddApply> {

	public ContactAddApply get(String id) {
		return this.get(ContactAddApply.class, id);
	}

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	public void delete(String id) {
		this.deleteById(ContactAddApply.class, id);
	}

	/**
	 * 
	 * Date 2019-01-26 22:26:52<br>
	 * Description 分页获取被请求添加为联系人信息列表
	 * 
	 * @author XiaHui<br>
	 * @param targetUserId
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	public List<ContactAddApply> getListByTargetUserId(String targetUserId, Page page) {
		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage qp = queryWrapper.setPage(page.getNumber(), page.getSize());
		queryWrapper.put("targetUserId", targetUserId);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from " + EntityUtil.getTableName(ContactAddApply.class) + " ");
		sql.append(" where ");
		sql.append(" targetUserId=:targetUserId ");
		List<ContactAddApply> list = this.queryListBySql(sql.toString(), queryWrapper, ContactAddApply.class, null);
		page.setTotalCount(qp.getTotalCount());
		page.setTotalPage(qp.getTotalPage());
		return list;
	}

	public List<ContactAddApply> queryList(String targetUserId, ContactAddApplyQuery query, Page page) {
		QueryWrapper queryWrapper = new QueryWrapper();
		QueryPage qp = queryWrapper.setPage(page.getNumber(), page.getSize());
		queryWrapper.put("targetUserId", targetUserId);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from " + EntityUtil.getTableName(ContactAddApply.class) + " ");
		sql.append(" where ");
		sql.append(" targetUserId=:targetUserId ");

		if (null != query) {
			queryWrapper.put("handleType", query.getHandleType());
			if (null != query.getHandleType() && !query.getHandleType().isEmpty()) {
				sql.append(" and handleType=:handleType ");
			}
		}

		List<ContactAddApply> list = this.queryListBySql(sql.toString(), queryWrapper, ContactAddApply.class, null);
		page.setTotalCount(qp.getTotalCount());
		page.setTotalPage(qp.getTotalPage());
		return list;
	}

	public List<ContactAddApply> getListByTargetUserId(String applyUserId, String targetUserId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("applyUserId", applyUserId);
		queryWrapper.put("targetUserId", targetUserId);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from " + EntityUtil.getTableName(ContactAddApply.class) + " ");
		sql.append(" where ");
		sql.append(" applyUserId=:applyUserId ");
		sql.append(" and targetUserId=:targetUserId ");
		List<ContactAddApply> list = this.queryListBySql(sql.toString(), queryWrapper, ContactAddApply.class, null);
		return list;
	}
}
