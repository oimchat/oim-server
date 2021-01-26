package com.oimchat.server.general.kernel.work.module.business.group.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupRelation;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupRelationService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.base.HeadImpl;
import com.onlyxiahui.common.data.common.bean.CountInfo;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 群分组关系业务接口<br>
 * Date 2019-01-20 21:46:46<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.3.0
 */
@Component
@ActionMapping(value = "1.3.003")
public class GroupRelationAction {

	@Resource
	private GroupRelationService groupRelationService;

	/**
	 * 
	 * 获取数量<br>
	 * 
	 * Date 2020-04-11 16:09:54<br>
	 * 
	 * @param userSession
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0001")
	public CountInfo count(UserSession userSession) {
		String userId = userSession.getUserId();
		List<GroupRelation> list = groupRelationService.getListByUserId(userId);
		return new CountInfo(list.size());
	}

	/**
	 * 
	 * 获取列表<br>
	 * Date 2020-04-11 16:10:12<br>
	 * 
	 * @param userSession
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0002")
	public PageResult<List<GroupRelation>> list(
			UserSession userSession,
			@Define("body.page") Page page) {
		String userId = userSession.getUserId();
		List<GroupRelation> list = groupRelationService.getListByUserId(userId);
		return new PageResult<>(page, list);
	}

	/**
	 * 获取详情<br>
	 * Date 2020-04-11 16:10:23<br>
	 * 
	 * @param userSession
	 * @param groupId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0004")
	public GroupRelation get(
			UserSession userSession,
			@Define("body.groupId") String groupId) {
		String ownerUserId = userSession.getUserId();
		GroupRelation data = groupRelationService.getByGroupId(ownerUserId, groupId);
		return data;
	}

	/**
	 * 修改群备注<br>
	 * Date 2019-01-20 17:37:06<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param groupId
	 * @param remark
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0005")
	public ResultMessage updateRemark(
			UserSession userSession,
			HeadImpl head,
			@Define("body.groupId") String groupId,
			@Define("body.remark") String remark) {
		String userId = userSession.getUserId();
		return groupRelationService.updateRemark(head.getKey(), userId, groupId, remark);
	}

	/**
	 * 移动群<br>
	 * Date 2019-01-20 17:37:33<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param contactUserId
	 * @param categoryId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0006")
	public ResultMessage moveCategory(
			UserSession userSession,
			HeadImpl head,
			@Define("body.groupIds") List<String> groupIds,
			@Define("body.categoryId") String categoryId) {
		String userId = userSession.getUserId();
		return groupRelationService.moveCategory(head.getKey(), userId, groupIds, categoryId);
	}
}
