package com.oimchat.server.general.kernel.work.module.base.group.manager;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupRelationDAO;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupRelation;
import com.onlyxiahui.common.utils.base.util.time.DateUtil;

/**
 * 
 * Date 2019-01-26 19:32:58<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class GroupRelationManager {

	@Resource
	private GroupRelationDAO groupRelationDAO;

	/**
	 * 
	 * Date 2019-01-26 19:34:27<br>
	 * Description
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @param userId
	 * @param categoryId
	 * @param remark
	 * @return
	 * @since 1.0.0
	 */
	public GroupRelation add(
			String groupId,
			String userId,
			String categoryId,
			String remark) {
		GroupRelation bean = new GroupRelation();
		bean.setGroupId(groupId);
		bean.setUserId(userId);
		bean.setCategoryId(categoryId);
		bean.setRemark(remark);
		bean.setCreatedDateTime(DateUtil.getCurrentDateTime());
		bean.setCreatedTimestamp(System.currentTimeMillis());
		groupRelationDAO.save(bean);
		return bean;
	}

	public boolean has(String userId, String groupId) {
		GroupRelation bean = groupRelationDAO.getByGroupId(userId, groupId);
		return bean != null;
	}

	public GroupRelation getByGroupId(String userId, String groupId) {
		GroupRelation bean = groupRelationDAO.getByGroupId(userId, groupId);
		return bean;
	}
}
