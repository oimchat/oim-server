package com.oimchat.server.general.kernel.work.module.business.group.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupCommonDAO;
import com.oimchat.server.general.kernel.work.module.base.group.entity.Group;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupHead;

/**
 * 
 * Date 2019-01-23 22:01:34<br>
 * Description 群通用的一些功能，主要是以来其他模块的，比如用户模块，之所以单独分离这个通用功能，<br>
 * 是因为与用户模块有耦合，所有将这块集中到此
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
@Transactional
public class GroupCommonService {

	@Resource
	private GroupCommonDAO groupCommonDAO;

	/**
	 * 
	 * Date 2019-01-21 11:33:35<br>
	 * Description 获取用户加入或者拥有的群
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public List<Group> getGroupListByGroupMemberUserId(String userId) {
		List<Group> list = groupCommonDAO.getGroupListByGroupMemberUserId(userId);
		return list;
	}

	/**
	 * 
	 * Date 2019-01-21 11:48:20<br>
	 * Description 获取用户已加入群的所有头像
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public List<GroupHead> getGroupHeadListByGroupMemberUserId(String userId) {
		List<GroupHead> list = groupCommonDAO.getGroupHeadListByGroupMemberUserId(userId);
		return list;
	}

//	/**
//	 * 
//	 * Date 2019-01-27 09:17:20<br>
//	 * Description 获取群的所有成员
//	 * 
//	 * @author XiaHui<br>
//	 * @param groupId
//	 * @return
//	 * @since 1.0.0
//	 */
//	public List<UserData> getUserDataListByGroupMemberGroupId(String groupId) {
//		List<UserData> userList = groupCommonDAO.getUserDataListByGroupMemberGroupId(groupId);
//		return userList;
//	}

//	/**
//	 * 
//	 * Date 2019-01-27 09:17:56<br>
//	 * Description 获取用户已经加入群的所有成员
//	 * 
//	 * @author XiaHui<br>
//	 * @param userId
//	 * @return
//	 * @since 1.0.0
//	 */
//	public List<UserData> getUserDataListOfAllUserInGroupByGroupMemberUserId(String userId) {
//		List<UserData> userList = groupCommonDAO.getUserDataListOfAllUserInGroupByGroupMemberUserId(userId);
//		return userList;
//	}
}
