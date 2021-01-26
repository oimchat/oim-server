package com.oimchat.server.general.kernel.work.module.manage.group.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupQuery;
import com.oimchat.server.general.kernel.work.module.base.group.entity.Group;
import com.oimchat.server.general.kernel.work.module.manage.group.service.GroupService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 
 * date 2018-07-19 09:29:16<br>
 * description 群管理
 * 
 * @author XiaHui<br>
 * @since
 */
@Controller
@ActionMapping("")
public class GroupController {
	@Resource
	GroupService groupService;

	// @PermissionMapping(name = "群列表", superKey = "core", type =
	// PermissionMapping.Type.menu)
	@ActionMapping("/v1/system/core/group/list")
	public Object list(
			@Define("query") GroupQuery groupQuery,
			@Define("page") Page page) {
		ResultMessage rm = new ResultMessage();
		List<Group> list = groupService.queryGroupList(groupQuery, page);
		rm.bodyPut("list", list);
		rm.bodyPut("page", page);
		return rm;
	}
}
