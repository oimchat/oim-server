package com.oimchat.server.general.kernel.work.module.base.group.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupJoinVerifyQuestion;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.hibernate.util.EntityUtil;

/**
 * 
 * Date 2019-01-20 13:25:04<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class GroupJoinVerifyQuestionDAO extends BaseDAO {

	public GroupJoinVerifyQuestion get(String id) {
		return this.get(GroupJoinVerifyQuestion.class, id);
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
		this.deleteById(GroupJoinVerifyQuestion.class, id);
	}

	/**
	 * 
	 * Date 2019-01-20 13:25:15<br>
	 * Description
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @return
	 * @since 1.0.0
	 */
	public List<GroupJoinVerifyQuestion> getListByGroupId(String groupId) {

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("groupId", groupId);

		String sql = "select * from " + EntityUtil.getTableName(GroupJoinVerifyQuestion.class) + " where groupId=:groupId";
		List<GroupJoinVerifyQuestion> list = this.queryListBySql(sql, queryWrapper, GroupJoinVerifyQuestion.class, null);
		return list;
	}

	/**
	 * 
	 * Date 2019-01-20 13:26:16<br>
	 * Description
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @param clazz
	 * @return
	 * @since 1.0.0
	 */
	public <T> List<T> getListByGroupId(String groupId, Class<T> clazz) {

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("groupId", groupId);

		String sql = "select * from " + EntityUtil.getTableName(GroupJoinVerifyQuestion.class) + " where groupId=:groupId";
		List<T> list = this.queryListBySql(sql, queryWrapper, clazz, null);
		return list;
	}

	/**
	 * 
	 * Date 2019-01-20 13:25:58<br>
	 * Description
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @return
	 * @since 1.0.0
	 */
	public boolean deleteByGroupId(String groupId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from " + EntityUtil.getTableName(GroupJoinVerifyQuestion.class) + " where groupId=:groupId ");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("groupId", groupId);
		int i = this.executeSql(sql.toString(), queryWrapper);
		return i > 0;
	}
}
