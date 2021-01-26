package com.oimchat.server.general.kernel.work.module.base.group.manager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupMemberDAO;
import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupMemberQuery;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupMember;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.utils.base.util.time.DateUtil;

/**
 * 
 * Date 2019-01-26 19:32:01<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class GroupMemberManager {

	@Resource
	private GroupMemberDAO groupMemberDAO;

	/**
	 * 
	 * Date 2019-01-22 19:27:06<br>
	 * Description 判断用户是否管理员
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public boolean isAdmin(String groupId, String userId) {
		boolean is = false;
		GroupMember gm = groupMemberDAO.getByGroupIdUserId(groupId, userId);
		is = (null != gm && GroupMember.position_admin.equals(gm.getPosition()));
		return is;
	}

	/**
	 * 
	 * Date 2019-01-22 19:30:56<br>
	 * Description 判断是否群主
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public boolean isOwner(String groupId, String userId) {
		boolean is = false;
		GroupMember gm = groupMemberDAO.getByGroupIdUserId(groupId, userId);
		is = (null != gm && GroupMember.position_owner.equals(gm.getPosition()));
		return is;
	}

	/**
	 * 
	 * Date 2019-01-26 10:08:58<br>
	 * Description 获取用户在群中的权限
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public String getPosition(String groupId, String userId) {
		GroupMember gm = groupMemberDAO.getByGroupIdUserId(groupId, userId);
		String position = (null == gm) ? "" : (gm.getPosition());
		return position;
	}

	/**
	 * 
	 * Date 2019-01-26 10:09:17<br>
	 * Description 判断权限是否为管理员
	 * 
	 * @author XiaHui<br>
	 * @param position
	 * @return
	 * @since 1.0.0
	 */
	public boolean isAdmin(String position) {
		boolean is = GroupMember.position_admin.equals(position);
		return is;
	}

	/**
	 * 
	 * Date 2019-01-26 10:09:35<br>
	 * Description 判断权限是否为群主
	 * 
	 * @author XiaHui<br>
	 * @param position
	 * @return
	 * @since 1.0.0
	 */
	public boolean isOwner(String position) {
		boolean is = GroupMember.position_owner.equals(position);
		return is;
	}

	/**
	 * 
	 * Date 2019-01-26 23:42:20<br>
	 * Description 普通成员
	 * 
	 * @author XiaHui<br>
	 * @param position
	 * @return
	 * @since 1.0.0
	 */
	public boolean isNormal(String position) {
		boolean is = GroupMember.position_normal.equals(position);
		return is;
	}

	/**
	 * 
	 * Date 2019-01-27 09:30:51<br>
	 * Description 用户是否已经加入群
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public boolean inGroup(String groupId, String userId) {
		GroupMember gm = groupMemberDAO.getByGroupIdUserId(groupId, userId);
		boolean is = gm != null;
		return is;
	}

	/**
	 * 
	 * Date 2019-01-26 19:31:16<br>
	 * Description 加入群
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public GroupMember add(String groupId, String userId) {
		String position = GroupMember.position_normal;// 权限
		return add(groupId, userId, position);
	}

	/**
	 * 
	 * Date 2019-01-26 19:31:29<br>
	 * Description 加入群
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @param userId
	 * @param position
	 * @return
	 * @since 1.0.0
	 */
	public GroupMember add(String groupId, String userId, String position) {

		GroupMember bean = new GroupMember();
		bean.setGroupId(groupId);
		bean.setUserId(userId);
		bean.setPosition(position);
		bean.setCreatedDateTime(DateUtil.getCurrentDateTime());
		bean.setCreatedTimestamp(System.currentTimeMillis());
		groupMemberDAO.save(bean);
		return bean;
	}

	/**
	 * 
	 * Date 2019-01-28 23:04:53<br>
	 * Description 获取群成员id
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @return
	 * @since 1.0.0
	 */
	public List<String> getGroupMemberUserIdList(String groupId) {
		List<String> userIds = new ArrayList<String>();
		List<GroupMember> list = groupMemberDAO.getListByGroupId(groupId);
		for (GroupMember member : list) {
			userIds.add(member.getUserId());
		}
		return userIds;
	}

	/**
	 * 
	 * Date 2019-01-28 23:04:26<br>
	 * Description 获取群主和管理员id
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @return
	 * @since 1.0.0
	 */
	public List<String> getGroupAdminAndOwnerUserIdList(String groupId) {
		List<String> userIds = new ArrayList<String>();
		List<GroupMember> list = groupMemberDAO.getListByGroupId(groupId);
		for (GroupMember member : list) {
			if (GroupMember.position_admin.equals(member.getPosition())) {
				userIds.add(member.getUserId());
			}
			if (GroupMember.position_owner.equals(member.getPosition())) {
				userIds.add(member.getUserId());
			}
		}
		return userIds;
	}

	/**
	 * 
	 * Description 获取群主 <br>
	 * Date 2019-06-13 09:06:20<br>
	 * 
	 * @param groupId
	 * @return String
	 * @since 1.0.0
	 */
	public String getGroupOwnerUserId(String groupId) {
		String userId = "";
		List<GroupMember> list = groupMemberDAO.getListByGroupId(groupId);
		for (GroupMember member : list) {
			if (GroupMember.position_owner.equals(member.getPosition())) {
				userId = (member.getUserId());
				break;
			}
		}
		return userId;
	}

	/**
	 * 
	 * 分页条件查询<br>
	 * Date 2020-04-12 18:04:23<br>
	 * 
	 * @param query
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	public List<GroupMember> queryList(GroupMemberQuery query, Page page) {
		return groupMemberDAO.queryList(query, page);
	}
}
