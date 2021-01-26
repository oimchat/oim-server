package com.oimchat.server.general.kernel.work.module.base.group.manager;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupDAO;
import com.oimchat.server.general.kernel.work.module.base.group.entity.Group;

/**
 * 
 * Date 2019-01-26 23:33:41<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class GroupManager {

	@Resource
	private GroupDAO groupDAO;

	/**
	 * 
	 * Date 2019-01-26 23:35:50<br>
	 * Description 判断群是否存在
	 * 
	 * @author XiaHui<br>
	 * @param groupId
	 * @return
	 * @since 1.0.0
	 */
	public boolean has(String groupId) {
		groupId = null == groupId ? "0" : groupId;
		Group bean = groupDAO.get(groupId);
		return bean != null;
	}
}
