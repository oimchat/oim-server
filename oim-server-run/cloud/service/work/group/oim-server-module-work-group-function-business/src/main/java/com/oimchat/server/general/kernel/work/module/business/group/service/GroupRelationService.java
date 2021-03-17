package com.oimchat.server.general.kernel.work.module.business.group.service;

import java.util.List;

import javax.annotation.Resource;

import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.basic.common.util.KeyUtil;
import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupRelationDAO;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupRelation;
import com.oimchat.server.general.kernel.work.module.base.group.push.GroupRelationPush;
import com.onlyxiahui.aware.basic.work.business.error.ErrorCode;
import com.onlyxiahui.common.message.result.ResultMessage;

/**
 * 
 * Date 2019-01-20 21:26:21<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
@Transactional
public class GroupRelationService {

	@Resource
	private GroupRelationDAO groupCategoryMemberDAO;
	@Resource
	private GroupRelationPush groupRelationPush;

	/**
	 * 
	 * Date 2019-01-20 17:31:47<br>
	 * Description 获取列表
	 * 
	 * @author XiaHui<br>
	 * @param ownerUserId
	 * @return
	 * @since 1.0.0
	 */
	public List<GroupRelation> getListByUserId(String userId) {
		List<GroupRelation> list = groupCategoryMemberDAO.getListByUserId(userId);
		return list;
	}

	/**
	 * 
	 * Date 2019-01-27 09:50:38<br>
	 * Description
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param groupId
	 * @return
	 * @since 1.0.0
	 */
	public GroupRelation getByGroupId(String userId, String groupId) {
		return groupCategoryMemberDAO.getByGroupId(userId, groupId);
	}

	/**
	 * 
	 * Date 2019-01-20 21:18:07<br>
	 * Description 移动群到其它分组
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param groupId
	 * @param categoryId
	 * @return
	 * @since 1.0.0
	 */
	public ResultMessage moveCategory(String key, String userId, List<String> groupIds, String categoryId) {
		ResultMessage message = new ResultMessage();
		try {

			if (null != groupIds && !groupIds.isEmpty()) {
				int count = 0;
				for (String groupId : groupIds) {
					count = count + groupCategoryMemberDAO.updateGroupCategoryId(userId, groupId, categoryId);
				}
				if (count <= 0) {
					message.addWarning(ErrorCode.business.code("001"), "移动失败！");
				} else {
					groupRelationPush.pushMoveCategory(userId, key, groupIds, categoryId);
				}
			}

		} catch (Exception e) {
			message.addWarning(ErrorCode.system.code("500"), "系统异常！");
		}
		return message;
	}

	/**
	 * 
	 * Date 2019-01-20 14:17:03<br>
	 * Description 修改备注
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param groupId
	 * @param remark
	 * @return
	 * @since 1.0.0
	 */
	public ResultMessage updateRemark(String key, String userId, String groupId, String remark) {

		ResultMessage message = new ResultMessage();
		try {

			if (StringUtil.isNotBlank(groupId)) {
				int count = groupCategoryMemberDAO.updateRemark(userId, groupId, remark);
				if (count <= 0) {
					message.addWarning(ErrorCode.business.code("001"), "修改失败！");
				} else {
					groupRelationPush.pushUpdateRemark(userId, KeyUtil.getKey(), groupId, remark);
				}
			} else {
				message.addWarning(ErrorCode.system.code("500"), "系统异常！");
			}
		} catch (Exception e) {
			message.addWarning(ErrorCode.system.code("500"), "系统异常！");
		}
		return message;
	}

	public List<GroupRelation> getListByGroupIds(String userId, List<String> groupIds) {
		return groupCategoryMemberDAO.getListByGroupIds(userId, groupIds);
	}
}
