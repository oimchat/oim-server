package com.oimchat.server.general.kernel.work.module.business.group.service;

import java.util.List;

import javax.annotation.Resource;

import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.basic.common.util.KeyUtil;
import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupCategoryDAO;
import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupRelationDAO;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupCategory;
import com.oimchat.server.general.kernel.work.module.base.group.manager.GroupCategoryManager;
import com.oimchat.server.general.kernel.work.module.base.group.push.GroupCategoryPush;
import com.onlyxiahui.aware.basic.work.business.error.ErrorCode;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.common.utils.base.util.time.DateUtil;

/**
 * 
 * Date 2019-01-20 21:05:24<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
@Transactional
public class GroupCategoryService {

	@Resource
	private GroupCategoryDAO groupCategoryDAO;
	@Resource
	private GroupRelationDAO groupRelationDAO;
	@Resource
	private GroupCategoryManager groupCategoryManager;
	@Resource
	private GroupCategoryPush groupCategoryPush;

	/**
	 * 
	 * Date 2019-01-20 14:09:57<br>
	 * Description 获取所有分组
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */

	public List<GroupCategory> getListByUserId(String userId) {
		List<GroupCategory> list = groupCategoryDAO.getListByUserId(userId);
		return list;
	}

	public GroupCategory getById(String userId, String id) {
		GroupCategory category = groupCategoryDAO.get(GroupCategory.class, id);
		return category;
	}

	public void saveDefault(String userId) {
		GroupCategory bean = groupCategoryDAO.getDefaultGroupCategory(userId);
		if (null == bean) {
			GroupCategory groupCategory = new GroupCategory();// 生成默认分组信息
			groupCategory.setUserId(userId);
			groupCategory.setName("我的聊天群");
			groupCategory.setSort(0);
			groupCategory.setType(GroupCategory.type_default);

			groupCategoryDAO.save(groupCategory);
		}
	}

	/**
	 * 
	 * Date 2019-01-20 14:04:32<br>
	 * Description 新增分组
	 * 
	 * @author XiaHui<br>
	 * @param groupCategory
	 * @return
	 * @since 1.0.0
	 */
	public ResultBodyMessage<GroupCategory> add(String key, GroupCategory groupCategory) {
		ResultBodyMessage<GroupCategory> message = new ResultBodyMessage<>();
		if (null != groupCategory) {
			try {

				int maxCount = 30;
				String userId = groupCategory.getUserId();
				long count = groupCategoryDAO.getGroupCategoryCount(userId);
				if (count >= maxCount) {
					message.addWarning(ErrorCode.business.code("0001"), "分组已经达到最大上限！");
				} else {
					int sort = (int) count;
					groupCategory.setSort(sort);
					groupCategory.setType(GroupCategory.type_custom);
					groupCategory.setCreatedDateTime(DateUtil.getCurrentDateTime());
					groupCategory.setCreatedTimestamp(System.currentTimeMillis());
					groupCategoryDAO.save(groupCategory);
					message.setBody(groupCategory);

					groupCategoryPush.pushAdd(userId, key, groupCategory.getId());
				}
			} catch (Exception e) {
				e.printStackTrace();
				message.addWarning(ErrorCode.system.code("500"), "系统异常！");
			}
		} else {
			message.addWarning(ErrorCode.system.code("500"), "系统异常！");
		}
		return message;
	}

	/**
	 * 
	 * Date 2019-01-20 14:06:12<br>
	 * Description 修改分组名称
	 * 
	 * @author XiaHui<br>
	 * @param id
	 * @param name
	 * @return
	 * @since 1.0.0
	 */
	public ResultMessage updateName(String key, String userId, String id, String name) {
		ResultMessage message = new ResultMessage();
		try {
			if (StringUtil.isNotBlank(id)) {
				GroupCategory groupCategory = groupCategoryDAO.get(GroupCategory.class, id);
				groupCategory.setName(name);
				groupCategoryDAO.update(groupCategory);
				message.bodyPut("category", groupCategory);

				groupCategoryPush.pushUpdateName(userId, KeyUtil.getKey(), id, name);
			} else {
				message.addWarning(ErrorCode.system.code("500"), "系统异常！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.addWarning(ErrorCode.system.code("500"), "系统异常！");
		}
		return message;
	}

	/**
	 * 
	 * Date 2019-01-20 17:26:21<br>
	 * Description 修改排序
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param id
	 * @param sort
	 * @return
	 * @since 1.0.0
	 */
	public ResultMessage updateSort(String key, String userId, String id, int sort) {
		ResultMessage message = new ResultMessage();
		try {
			if (StringUtil.isNotBlank(id)) {
				List<GroupCategory> list = groupCategoryDAO.getListByUserId(userId);
				int size = list.size();

				if (sort < size) {

					int temp = 0;

					for (int i = 0; i < size; i++) {
						GroupCategory m = list.get(i);
						if (!m.getId().equals(id)) {
							if (temp == sort) {
								temp++;
							}
							groupCategoryDAO.updateSort(m.getId(), temp);
							temp++;
						}
					}
					groupCategoryDAO.updateSort(id, sort);
				}
				groupCategoryPush.pushUpdateSort(userId, KeyUtil.getKey());
			} else {
				message.addWarning(ErrorCode.system.code("500"), "系统异常！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.addWarning(ErrorCode.system.code("500"), "系统异常！");
		}
		return message;
	}

	/**
	 * 
	 * Date 2019-01-20 16:56:33<br>
	 * Description
	 * 
	 * @author XiaHui<br>
	 * @param id
	 * @return
	 * @since 1.0.0
	 */
	public ResultMessage delete(String key, String userId, String id) {
		ResultMessage message = new ResultMessage();

		GroupCategory category = groupCategoryDAO.get(GroupCategory.class, id);
		if (null != category) {
			if (GroupCategory.type_default == category.getType()) {
				message.addWarning(ErrorCode.business.code("001"), "不能删除默认分组！");
			} else {
				groupCategoryDAO.deleteById(GroupCategory.class, id);
				String newCategoryId = groupCategoryManager.getOrCreateDefaultCategoryId(userId);
				groupRelationDAO.updateChangeCategoryId(userId, id, newCategoryId);
				groupCategoryPush.pushDelete(userId, KeyUtil.getKey(), id);
			}
		}
		return message;
	}
}
