package com.oimchat.server.general.kernel.work.module.business.group.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupQuery;
import com.oimchat.server.general.kernel.work.module.base.group.entity.Group;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.data.ListBody;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 群信息业务接口<br>
 * Date 2019-01-20 20:49:52<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.3.0
 */
@Component
@ActionMapping(value = "1.3.001")
public class GroupInfoAction {

	@Resource
	private GroupService groupService;

	/**
	 * 条件分页搜索群<br>
	 * Date 2019-01-26 14:36:56<br>
	 * 
	 * @author XiaHui<br>
	 * @param query
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0001")
	public PageResult<List<Group>> queryList(
			@Define("body.query") GroupQuery query,
			@Define("body.page") Page page) {
		List<Group> groupList = groupService.queryList(query, page);
		return new PageResult<>(page, groupList);
	}

	/**
	 * 获取群信息<br>
	 * Date 2019-01-26 14:37:13<br>
	 * 
	 * @param userSession
	 * @param id          群id
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0002")
	public Group getById(
			UserSession userSession,
			@Define("body.id") String id) {
		Group group = groupService.getById(id);
		return group;
	}

	/**
	 * 
	 * 批量获取群信息<br>
	 * Date 2019-05-05 08:39:53<br>
	 * 
	 * @param ids 群id数组
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0003")
	public ListBody<List<Group>> getListByIds(
			@Define("body.ids") List<String> ids) {
		List<Group> groupList = groupService.getListByIds(ids);
		return new ListBody<>(groupList);
	}
}
