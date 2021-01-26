package com.oimchat.server.general.kernel.work.module.base.contact.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactAddVerifyQuestion;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;

/**
 * 
 * Date 2019-01-20 13:25:04<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class ContactAddVerifyQuestionDAO extends BaseDAO {

	public ContactAddVerifyQuestion get(String id) {
		return this.get(ContactAddVerifyQuestion.class, id);
	}

	/**
	 * 
	 * Date 2019-01-20 13:26:29<br>
	 * Description 根据id删除
	 * 
	 * @author XiaHui<br>
	 * @param id
	 * @since 1.0.0
	 */
	public void delete(String id) {
		this.deleteById(ContactAddVerifyQuestion.class, id);
	}

	/**
	 * 
	 * Date 2019-01-20 13:25:15<br>
	 * Description 获取用户设置的被添加为联系人是验证问题列表
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public List<ContactAddVerifyQuestion> getListByUserId(String userId) {

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("userId", userId);

		String sql = "select * from " + EntityUtil.getTableName(ContactAddVerifyQuestion.class) + " where userId=:userId";
		List<ContactAddVerifyQuestion> list = this.queryListBySql(sql, queryWrapper, ContactAddVerifyQuestion.class, null);
		return list;
	}

	/**
	 * 
	 * Date 2019-01-20 13:26:16<br>
	 * Description 获取用户设置的被添加为联系人是验证问题列表
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param clazz
	 * @return
	 * @since 1.0.0
	 */
	public <T> List<T> getListByUserId(String userId, Class<T> clazz) {

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("userId", userId);

		String sql = "select * from " + EntityUtil.getTableName(ContactAddVerifyQuestion.class) + " where userId=:userId";
		List<T> list = this.queryListBySql(sql, queryWrapper, clazz, null);
		return list;
	}

	/**
	 * 
	 * Date 2019-01-20 13:25:58<br>
	 * Description 根据用户id删除问题
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public boolean deleteByUserId(String userId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from " + EntityUtil.getTableName(ContactAddVerifyQuestion.class) + " where userId=:userId ");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("userId", userId);
		int i = this.executeSql(sql.toString(), queryWrapper);
		return i > 0;
	}
}
