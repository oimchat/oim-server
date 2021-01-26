package com.oimchat.server.general.kernel.work.module.manage.group.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupCategoryDAO;
import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupDAO;
import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupMemberDAO;
import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupNumberDAO;
import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupRelationDAO;
import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupQuery;
import com.oimchat.server.general.kernel.work.module.base.group.entity.Group;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupCategory;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupMember;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupNumber;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupRelation;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.common.utils.base.util.time.DateUtil;

/**
 * 描述：
 * 
 * @author XiaHui
 * @date 2014年3月31日 上午11:45:15 version 0.0.1
 */
@Service
@Transactional
public class GroupService {

	@Resource
	private GroupDAO groupDAO;
	@Resource
	private GroupMemberDAO groupMemberDAO;
	@Resource
	private GroupCategoryDAO groupCategoryDAO;
	@Resource
	private GroupRelationDAO groupCategoryMemberDAO;
	@Resource
	private GroupNumberDAO groupNumberDAO;

	public Group getGroupById(String id) {
		Group group = groupDAO.get(Group.class, id);
		return group;
	}

	public Group getGroupByNumber(String number) {
		Group group = groupDAO.getByNumber(number);
		return group;
	}

	public List<GroupCategory> getGroupCategoryListByUserId(String userId) {
		List<GroupCategory> list = groupCategoryDAO.getListByUserId(userId);
		return list;
	}

	public List<GroupRelation> getGroupCategoryMemberListByUserId(String userId) {
		List<GroupRelation> list = groupCategoryMemberDAO.getListByUserId(userId);
		return list;
	}

	public List<GroupMember> getGroupMemberListByGroupId(String groupId) {
		List<GroupMember> list = groupMemberDAO.getListByGroupId(groupId);
		return list;
	}

	public List<Group> queryGroupList(GroupQuery groupQuery, Page page) {
		List<Group> groupList = groupDAO.queryList(groupQuery, page);
		return groupList;
	}

	public ResultMessage add(String key, String userId, Group group, GroupRelation groupCategoryMember) {
		// 生成数子账号
		Long number = groupNumberDAO.getNumber();
		GroupNumber groupNumber = new GroupNumber();// 生成数子账号
		groupNumber.setCreatedDateTime(DateUtil.getCurrentDateTime());

		group.setNumber(number);
		group.setCreatedDateTime(DateUtil.getCurrentDateTime());
		if (null == group.getHead() || "".equals(group.getHead())) {
			int i = new Random().nextInt(3);
			i = i + 1;
			group.setHead(i + "");
		}
		groupDAO.save(group);

		if (null == groupCategoryMember) {
			groupCategoryMember = new GroupRelation();
		}
		groupCategoryMember.setUserId(userId);
		groupCategoryMember.setGroupId(group.getId());
		if (null == groupCategoryMember.getCategoryId() || "".equals(groupCategoryMember.getCategoryId())) {
			GroupCategory groupCategory = getOrAddDefaultGroupCategory(userId);
			groupCategoryMember.setCategoryId(groupCategory.getId());
		}

		groupCategoryMemberDAO.save(groupCategoryMember);

		GroupMember groupMember = new GroupMember();
		groupMember.setUserId(userId);
		groupMember.setGroupId(group.getId());
		groupMember.setPosition(GroupMember.position_owner);
		groupMemberDAO.save(groupMember);

		ResultMessage message = new ResultMessage();
		message.bodyPut("group", group);
		message.bodyPut("groupCategoryMember", groupCategoryMember);
		message.bodyPut("groupMember", groupMember);

		List<String> userIdList = new ArrayList<String>();
		userIdList.add(userId);
		// groupPush.addGroup(key, group, groupCategoryMember, groupMember, userIdList);
		return message;
	}

	public Info update(Group group) {
		Info info = new Info();
		groupDAO.update(group);
		return info;
	}

	private GroupCategory getOrAddDefaultGroupCategory(String userId) {
		GroupCategory groupCategory = groupCategoryDAO.getDefaultGroupCategory(userId);
		if (null == groupCategory) {
			groupCategory = new GroupCategory();// 生成默认分组信息
			groupCategory.setUserId(userId);
			groupCategory.setName("我的聊天群");
			groupCategory.setType(GroupCategory.type_default);
			groupCategoryDAO.save(groupCategory);
		}
		return groupCategory;
	}

	/**
	 * 获取用户在各个群中的权限
	 * 
	 * @author XiaHui
	 * @date 2017年6月8日 下午3:32:39
	 * @param userId
	 * @return
	 */
	public List<GroupMember> getUserInGroupMemberList(String userId) {
		List<GroupMember> list = groupMemberDAO.getListByUserId(userId);
		return list;
	}
}
