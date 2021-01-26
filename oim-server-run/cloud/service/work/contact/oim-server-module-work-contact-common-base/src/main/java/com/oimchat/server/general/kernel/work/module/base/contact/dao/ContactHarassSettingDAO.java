package com.oimchat.server.general.kernel.work.module.base.contact.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactHarassSetting;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;

/**
 * 
 * Date 2019-01-20 13:28:56<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class ContactHarassSettingDAO extends BaseDAO {

	public ContactHarassSetting get(String id) {
		return this.get(ContactHarassSetting.class, id);
	}

	/**
	 * 
	 * Date 2019-01-20 13:28:39<br>
	 * Description 根据id删除
	 * 
	 * @author XiaHui<br>
	 * @param id
	 * @since 1.0.0
	 */
	public void delete(String id) {
		this.deleteById(ContactHarassSetting.class, id);
	}

	/**
	 * 
	 * Date 2019-01-20 13:28:33<br>
	 * Description 根据用户id获取防骚扰设置
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public ContactHarassSetting getByUserId(String userId) {
		ContactHarassSetting bean = null;

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("userId", userId);

		String sql = "select * from im_contact_harass_setting where userId=:userId";
		List<ContactHarassSetting> list = this.queryListBySql(sql, queryWrapper, ContactHarassSetting.class, null);

		if (null != list && !list.isEmpty()) {
			bean = list.get(0);
		}
		return bean;
	}

	public String getIdByUserId(String userId) {
		String id = null;

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("userId", userId);

		String sql = "select id from im_contact_harass_setting where userId=:userId";
		List<String> list = this.queryListBySql(sql, queryWrapper, String.class, null);

		if (null != list && !list.isEmpty()) {
			id = list.get(0);
		}
		return id;
	}

	/**
	 * 
	 * Date 2019-01-20 13:28:12<br>
	 * Description 根据用户id获取防骚扰设置
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param clazz
	 * @return
	 * @since 1.0.0
	 */
	public <T> T getByUserId(String userId, Class<T> clazz) {
		T bean = null;

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("userId", userId);

		String sql = "select * from im_contact_harass_setting where userId=:userId";
		List<T> list = this.queryListBySql(sql, queryWrapper, clazz, null);

		if (null != list && !list.isEmpty()) {
			bean = list.get(0);
		}
		return bean;
	}

	/**
	 * 
	 * Date 2019-01-20 13:27:36<br>
	 * Description 根据用户id删除防骚扰设置
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public boolean deleteByUserId(String userId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from im_contact_harass_setting where userId=:userId ");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("userId", userId);
		int i = this.executeSql(sql.toString(), queryWrapper);
		return i > 0;
	}
}
