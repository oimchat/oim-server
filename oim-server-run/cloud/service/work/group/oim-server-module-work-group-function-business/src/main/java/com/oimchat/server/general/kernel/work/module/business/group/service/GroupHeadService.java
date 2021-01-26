package com.oimchat.server.general.kernel.work.module.business.group.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.basic.common.util.KeyUtil;
import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupDAO;
import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupHeadDAO;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupHead;
import com.oimchat.server.general.kernel.work.module.base.group.manager.GroupMemberManager;
import com.oimchat.server.general.kernel.work.module.base.group.push.GroupInfoPush;
import com.onlyxiahui.aware.basic.work.business.error.ErrorCode;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.common.utils.base.util.time.DateUtil;

/**
 * 
 * Date 2019-01-21 14:15:31<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
@Transactional
public class GroupHeadService {

	@Resource
	private GroupHeadDAO groupHeadDAO;
	@Resource
	private GroupDAO groupDAO;
	@Resource
	private GroupMemberManager groupMemberManager;
	@Resource
	private GroupInfoPush groupInfoPush;

	public ResultBodyMessage<GroupHead> uploadHead(String userId, GroupHead groupHead) {
		ResultBodyMessage<GroupHead> message = new ResultBodyMessage<>();
		try {
			groupHead.setCreatedDateTime(DateUtil.getCurrentDateTime());
			groupHeadDAO.save(groupHead);

			String headId = groupHead.getHeadId();
			String groupId = groupHead.getGroupId();
			String type = groupHead.getType();
			String url = groupHead.getUrl();

			String inviterUserPosition = groupMemberManager.getPosition(groupId, userId);
			boolean isOwner = groupMemberManager.isOwner(inviterUserPosition);
			if (!isOwner) {
				return message;
			}
			// 用户自定义头像，则清除系统头像
			if (GroupHead.type_custom.equals(type)) {
				groupDAO.updateAvatar(groupId, url);
				// groupDAO.updateHead(groupId, "");
			} else {
				groupDAO.updateHead(groupId, headId);
				groupDAO.updateAvatar(groupId, "");
			}
			message.setBody(groupHead);
			List<String> userIds = groupMemberManager.getGroupMemberUserIdList(groupId);
			groupInfoPush.pushUpdateHead(userIds, KeyUtil.getKey(), groupId);
		} catch (Exception e) {
			message.addWarning(ErrorCode.business.code("0001"), "上传失败！");
		}
		return message;
	}

	public GroupHead getGroupHeadByGroupId(String groupId) {
		return groupHeadDAO.getLastByGroupId(groupId);
	}

	public List<GroupHead> getGroupHeadListByGroupIds(List<String> ids) {
		return groupHeadDAO.getGroupHeadListByGroupIds(ids);
	}
}
