package com.oimchat.server.general.kernel.work.module.base.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;
import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserDataQuery;
import com.oimchat.server.general.kernel.work.module.base.user.entity.User;
import com.oimchat.server.general.kernel.work.module.base.user.type.UserTypeEnum;
import com.onlyxiahui.aware.basic.dao.BaseEntityDAO;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.syntax.data.QueryHandleData;
import com.onlyxiahui.extend.query.hibernate.syntax.data.QueryHandleUtil;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;
import com.onlyxiahui.extend.query.hibernate.util.QueryUtil;
import com.onlyxiahui.extend.query.page.QueryPage;

/**
 * 
 * Date 2016年1月4日 下午9:48:59<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class UserDAO extends BaseEntityDAO<User> {

	String space = "user.info";

	/**
	 * 根据id获取用户
	 * 
	 * @param id
	 */
	public User get(String id) {
		return this.get(User.class, id);
	}

	public User getByEmail(String email) {
		String hql = "select u from " + User.class.getName() + " u where email=:email";
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("email", email);
		List<User> list = this.queryListByHql(hql, queryWrapper, User.class);
		return (null == list || list.isEmpty()) ? null : list.get(0);
	}

	public User getByMobile(String mobile) {
		String hql = "select u from " + User.class.getName() + " u where mobile=:mobile";
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("mobile", mobile);
		List<User> list = this.queryListByHql(hql, queryWrapper, User.class);
		return (null == list || list.isEmpty()) ? null : list.get(0);
	}

	public User getByNumber(Long number) {
		String hql = "select u from " + User.class.getName() + " u where number=:number";
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("number", number);
		List<User> list = this.queryListByHql(hql, queryWrapper, User.class);
		return (null == list || list.isEmpty()) ? null : list.get(0);
	}

	/**
	 * 根据账号获取用户
	 * 
	 * @param account
	 * @return
	 */
	public User getByAccount(String account) {
		String hql = "select u from " + User.class.getName() + " u where account=:account";
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("account", account);
		List<User> list = this.queryListByHql(hql, queryWrapper, User.class);
		return (null == list || list.isEmpty()) ? null : list.get(0);
	}

	public UserData getUserDataById(String id) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("id", id);
		UserData userData = this.queryObjectByName(space + ".getById", queryWrapper, UserData.class);
		return userData;
	}

	public UserData getUserDataByAccount(String account) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("account", account);
		UserData userData = this.queryObjectByName(space + ".getByAccount", queryWrapper, UserData.class);
		return userData;
	}

	public String getIdByAccount(String account) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("account", account);
		String id = this.queryObjectByName(space + ".getIdByAccount", queryWrapper, String.class);
		return id;
	}

	public Long getUserAllCount() {
		Long count = this.queryObjectByName(space + ".getUserAllCount", null, Long.class);
		return count;
	}

	/**
	 * 条件查询用户列表
	 * 
	 * @param userQuery
	 * @param page
	 * @return
	 */
	public List<UserData> queryUserList(UserDataQuery query, Page page) {
		QueryHandleData queryHandleData = QueryHandleUtil.get(query);
		QueryWrapper queryWrapper = QueryUtil.getQueryWrapperType(query, queryHandleData.getOptions());
		QueryPage queryPage = queryWrapper.setPage(page.getNumber(), page.getSize());
		queryWrapper.addParameter("type", UserTypeEnum.general.getCode().toString());
		List<UserData> userList = this.queryListByName(space + ".queryUserList", queryWrapper, UserData.class);
		page.setTotalCount(queryPage.getTotalCount());
		page.setTotalPage(queryPage.getTotalPage());
		return userList;
	}

	public boolean updatePassword(String id, String password) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(User.class) + " set `password`=:password ");
		sql.append(" where id=:id ");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("id", id);
		queryWrapper.put("password", password);
		int i = this.executeSql(sql.toString(), queryWrapper);
		return i > 0;
	}

	public boolean updateType(String id, String type) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(User.class) + " set `type`=:type ");
		sql.append(" where id=:id ");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("id", id);
		queryWrapper.put("type", type);
		int i = this.executeSql(sql.toString(), queryWrapper);
		return i > 0;
	}

	/**
	 * 
	 * Date 2019-01-20 10:53:12<br>
	 * Description 修改头像
	 * 
	 * @author XiaHui<br>
	 * @param id
	 * @param avatar
	 * @return
	 * @since 1.0.0
	 */
	public boolean updateAvatar(String id, String avatar) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(User.class) + " set `avatar`=:avatar ");
		sql.append(" where id=:id ");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("id", id);
		queryWrapper.put("avatar", avatar);
		int i = this.executeSql(sql.toString(), queryWrapper);
		return i > 0;
	}

	public boolean updateHead(String id, String head) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(User.class) + " set `head`=:head ");
		sql.append(" where id=:id ");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("id", id);
		queryWrapper.put("head", head);
		int i = this.executeSql(sql.toString(), queryWrapper);
		return i > 0;
	}

	public List<UserData> getUserDataList(List<String> ids) {
		if (null == ids || ids.isEmpty()) {
			return new ArrayList<UserData>();
		}
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from " + EntityUtil.getTableName(User.class) + " where id in ( :ids )");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("ids", ids);
		List<UserData> list = this.queryListBySql(sb.toString(), queryWrapper, UserData.class, null);
		return list;
	}

//	/**
//	 * 条件查询用户 <br>
//	 * Date 2020-04-09 18:42:20<br>
//	 * 
//	 * @param <T>
//	 * @param userQuery
//	 * @param page
//	 * @param clazz
//	 * @return
//	 * @since 1.0.0
//	 */
//	public <T> List<T> queryList(UserDataQuery userQuery, Page page, Class<T> clazz) {
//		QueryWrapper queryWrapper = new QueryWrapper();
//		QueryPage queryPage = queryWrapper.setPage(page.getNumber(), page.getSize());
//		List<ValueOptionInfo> optionList = new ArrayList<ValueOptionInfo>();
//		// 设置查询条件为like
//		optionList.add(new ValueOptionInfo("name", ValueOptionType.likeAll));
//		optionList.add(new ValueOptionInfo("queryText", ValueOptionType.likeAll));
//		optionList.add(new ValueOptionInfo("homeAddress", ValueOptionType.likeAll));
//		optionList.add(new ValueOptionInfo("locationAddress", ValueOptionType.likeAll));
//		QueryUtil.getQueryWrapperType(userQuery, queryWrapper, optionList);
//		List<T> userList = this.queryListByName(space + ".queryUserList", queryWrapper, clazz);
//		page.setTotalCount(queryPage.getTotalCount());
//		page.setTotalPage(queryPage.getTotalPage());
//		return userList;
//	}
}
