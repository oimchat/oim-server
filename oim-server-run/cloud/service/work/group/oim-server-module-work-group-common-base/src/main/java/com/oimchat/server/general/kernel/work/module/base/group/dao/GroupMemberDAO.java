package com.oimchat.server.general.kernel.work.module.base.group.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupMemberQuery;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupMember;
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
 * Date 2019-01-21 12:52:29<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class GroupMemberDAO extends BaseEntityDAO<GroupMember> {

	public GroupMember getById(String id) {
		GroupMember data = this.get(GroupMember.class, id);
		return data;
	}

	/**
	 * Description 获取用户在在群中的权限信息<br>
	 * Date 2019-01-23 00:11:58<br>
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public GroupMember getByGroupIdUserId(String groupId, String userId) {
		QueryWrapper qw = new QueryWrapper();
		qw.put("groupId", groupId);
		qw.put("userId", userId);
		return this.get(qw);
	}

	/**
	 * 根据群id获取群成员
	 * 
	 * @param groupId
	 * @return
	 */
	public List<GroupMember> getListByGroupId(String groupId) {
		QueryWrapper qw = new QueryWrapper();
		qw.put("groupId", groupId);
		return (null == groupId || groupId.isEmpty()) ? new ArrayList<>() : list(qw);
	}

	/**
	 * 获取用户在群中的权限
	 * 
	 * @author XiaHui
	 * @date 2017年6月8日 下午3:29:42
	 * @param userId
	 * @return
	 */
	public List<GroupMember> getListByUserId(String userId) {
		QueryWrapper qw = new QueryWrapper();
		qw.put("userId", userId);
		return (null == userId || userId.isEmpty()) ? new ArrayList<>() : list(qw);
	}

//	/**
//	 * 
//	 * Date 2019-01-21 19:54:05<br>
//	 * Description 获取用户所在所有群的所有成员
//	 * 
//	 * @author XiaHui<br>
//	 * @param userId
//	 * @return
//	 * @since 1.0.0
//	 */
//	@SuppressWarnings("unchecked")
//	public List<GroupMember> getAllGroupMemberListOfUserInAllGroupsByUserId(String userId) {
//		StringBuilder hql = new StringBuilder();
//		hql.append("select gm from ");
//		hql.append(GroupMember.class.getName());
//		hql.append(" gm where gm.groupId in (");
//		hql.append(" select gmt.groupId from  ");
//		hql.append(GroupMember.class.getName());
//		hql.append(" gmt where gmt.userId= '");
//		hql.append(userId);
//		hql.append("'");
//		hql.append(")");
//		List<GroupMember> list = (List<GroupMember>) this.find(hql.toString());
//		return list;
//	}

	/**
	 * 
	 * Date 2019-01-23 00:11:19<br>
	 * Description 修改群成员显示备注名
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @param userId
	 * @param remark
	 * @return
	 * @since 1.0.0
	 */
	public boolean updateNickname(String groupId, String userId, String nickname) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(GroupMember.class) + " set nickname=:nickname ");
		sql.append(" where groupId=:groupId  and userId=:userId");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("groupId", groupId);
		queryWrapper.put("userId", userId);
		queryWrapper.put("nickname", nickname);
		int i = this.executeSql(sql.toString(), queryWrapper);
		return i > 0;
	}

	/**
	 * 
	 * Date 2019-01-23 00:11:08<br>
	 * Description 修改群角色
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @param userId
	 * @param position
	 * @return
	 * @since 1.0.0
	 */
	public boolean updatePosition(String groupId, String userId, String position) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update " + EntityUtil.getTableName(GroupMember.class) + " set position=:position ");
		sql.append(" where groupId=:groupId  and userId=:userId");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("groupId", groupId);
		queryWrapper.put("userId", userId);
		queryWrapper.put("position", position);
		int i = this.executeSql(sql.toString(), queryWrapper);
		return i > 0;
	}

	/**
	 * 
	 * Date 2019-01-27 09:34:59<br>
	 * Description 根据userId删除
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public boolean deleteByGroupIdUserId(String groupId, String userId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from " + EntityUtil.getTableName(GroupMember.class) + " ");
		sql.append(" where groupId=:groupId  and userId=:userId");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("groupId", groupId);
		queryWrapper.put("userId", userId);
		int i = this.executeSql(sql.toString(), queryWrapper);
		return i > 0;
	}

	/**
	 * 
	 * Date 2019-01-27 09:36:03<br>
	 * Description 删除userId以外的其他成员
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public boolean deleteOutUserIdByGroupId(String groupId, String userId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from " + EntityUtil.getTableName(GroupMember.class) + " ");
		sql.append(" where groupId=:groupId  and userId <>:userId");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("groupId", groupId);
		queryWrapper.put("userId", userId);
		int i = this.executeSql(sql.toString(), queryWrapper);
		return i > 0;
	}

	/**
	 * 
	 * 条件分页查询<br>
	 * Date 2020-04-12 18:05:15<br>
	 * 
	 * @param query
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	public List<GroupMember> queryList(GroupMemberQuery query, Page page) {
//		ValueOptionCase optionCase = ValueOptionCase.newInstance();
//		optionCase.add("nickname", ValueOptionType.likeAll);
//
//		QueryColumnCase columnCase = QueryColumnCase.newInstance();
//		columnCase.add("likeNickname", "nickname", EquationType.like);
		QueryHandleData queryHandleData = QueryHandleUtil.get(query);
		QueryWrapper queryWrapper = QueryUtil.getQueryWrapperType(query, queryHandleData.getOptions());
		QueryPage p = queryWrapper.setPage(page.getNumber(), page.getSize());
		List<GroupMember> list = this.list(queryWrapper, queryHandleData);
		page.setTotalCount(p.getTotalCount());
		page.setTotalPage(p.getTotalPage());
		return list;
	}
}
