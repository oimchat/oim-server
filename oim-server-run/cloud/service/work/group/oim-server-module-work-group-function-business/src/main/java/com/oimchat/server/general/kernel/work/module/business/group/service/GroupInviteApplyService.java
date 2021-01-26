package com.oimchat.server.general.kernel.work.module.business.group.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupInviteApplyDAO;
import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupInviteeApplyQuery;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupInviteApply;
import com.onlyxiahui.common.data.common.data.Page;

/**
 * Date 2019-01-26 15:06:33<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
@Transactional
public class GroupInviteApplyService {

	@Resource
	private GroupInviteApplyDAO groupInviteApplyDAO;

	/**
	 * 
	 * Date 2019-01-27 10:15:05<br>
	 * Description 获取个人被邀请加入群的信息列表（管理员/群主已经同意）
	 * 
	 * @author XiaHui<br>
	 * @param inviteeUserId
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	public List<GroupInviteApply> queryInviteeList(String inviteeUserId, GroupInviteeApplyQuery query, Page page) {
		List<GroupInviteApply> list = groupInviteApplyDAO.queryInviteeList(inviteeUserId, query, page);
		return list;
	}
}
