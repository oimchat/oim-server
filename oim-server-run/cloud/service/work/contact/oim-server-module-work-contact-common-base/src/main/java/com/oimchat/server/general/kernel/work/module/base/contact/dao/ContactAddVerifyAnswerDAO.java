package com.oimchat.server.general.kernel.work.module.base.contact.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactAddVerifyAnswer;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;

/**
 * 
 * Date 2019-01-26 22:03:50<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class ContactAddVerifyAnswerDAO extends BaseDAO {

	public ContactAddVerifyAnswer get(String id) {
		return this.get(ContactAddVerifyAnswer.class, id);
	}

	/**
	 * 
	 * Date 2019-01-26 22:03:54<br>
	 * Description 根据id删除
	 * 
	 * @author XiaHui<br>
	 * @param id
	 * @since 1.0.0
	 */
	public void delete(String id) {
		this.deleteById(ContactAddVerifyAnswer.class, id);
	}

	/**
	 * 
	 * Date 2019-01-26 22:05:21<br>
	 * Description
	 * 
	 * @author XiaHui<br>
	 * @param targetUserId
	 * @param applyId
	 * @return
	 * @since 1.0.0
	 */
	public List<ContactAddVerifyAnswer> getListByApplyId(String targetUserId, String applyId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("targetUserId", targetUserId);
		queryWrapper.put("applyId", applyId);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from " + EntityUtil.getTableName(ContactAddVerifyAnswer.class) + " ");
		sql.append(" where ");
		sql.append(" targetUserId=:targetUserId ");
		sql.append(" and applyId=:applyId ");
		List<ContactAddVerifyAnswer> list = this.queryListBySql(sql.toString(), queryWrapper, ContactAddVerifyAnswer.class, null);
		return list;
	}

	public List<ContactAddVerifyAnswer> getListByApplyIds(String targetUserId, List<String> applyIds) {
		if (null == applyIds || applyIds.isEmpty()) {
			return new ArrayList<>();
		}
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("targetUserId", targetUserId);
		queryWrapper.put("applyIds", applyIds);

		StringBuilder sql = new StringBuilder();
		sql.append(" select *  from " + EntityUtil.getTableName(ContactAddVerifyAnswer.class) + " ");
		sql.append(" where ");
		sql.append(" targetUserId=:targetUserId ");
		sql.append(" and applyId in( :applyIds) ");
		List<ContactAddVerifyAnswer> list = this.queryListBySql(sql.toString(), queryWrapper, ContactAddVerifyAnswer.class, null);
		return list;
	}
}
