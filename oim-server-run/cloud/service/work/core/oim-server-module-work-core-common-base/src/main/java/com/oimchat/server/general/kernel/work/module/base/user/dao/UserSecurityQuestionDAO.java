package com.oimchat.server.general.kernel.work.module.base.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.user.data.UserSecurityQuestionData;
import com.oimchat.server.general.kernel.work.module.base.user.entity.UserSecurityQuestion;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;

/**
 * 
 * Date 2019-01-20 09:50:44<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class UserSecurityQuestionDAO extends BaseDAO {

	/**
	 * 
	 * Date 2019-01-20 09:50:54<br>
	 * Description 获取密保问题列表
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public List<UserSecurityQuestion> getListByUserId(String userId) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from " + EntityUtil.getTableName(UserSecurityQuestion.class) + " where userId=:userId");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("userId", userId);
		List<UserSecurityQuestion> list = this.queryListBySql(sb.toString(), queryWrapper, UserSecurityQuestion.class, null);
		return list;
	}

	/**
	 * 
	 * Date 2019-01-20 09:52:34<br>
	 * Description 获取不带答案的问题列表
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return List<UserSecurityQuestionData>
	 * @since 1.0.0
	 */
	public List<UserSecurityQuestionData> getSecurityQuestionDataListByUserId(String userId) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from " + EntityUtil.getTableName(UserSecurityQuestion.class) + " where userId=:userId");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.addParameter("userId", userId);
		List<UserSecurityQuestionData> list = this.queryListBySql(sb.toString(), queryWrapper, UserSecurityQuestionData.class, null);
		return list;
	}
}
