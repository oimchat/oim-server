package com.oimchat.server.general.kernel.work.module.business.group.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupMemberQuery;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupMember;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupMemberService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 
 * Description <br>
 * Date 2020-05-17 20:23:50<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Controller
@ActionMapping("")
public class GroupMemberController {

	@Resource
	GroupMemberService groupMemberService;

	@ActionMapping("/v1/group/group.member/list")
	public PageResult<List<GroupMember>> list(
			@Define("body.query") GroupMemberQuery query,
			@Define("body.page") Page page) {
		List<GroupMember> list = groupMemberService.queryList(query, page);
		return new PageResult<>(page, list);
	}

	@ActionMapping("/v1/group/group.member/list.by.group.id")
	public List<GroupMember> getListByGroupId(
			@Define("body.groupId") String groupId) {
		List<GroupMember> list = groupMemberService.getListByGroupId(groupId);
		return list;
	}

	@ActionMapping("/v1/group/group.member/list.by.user.id")
	public List<GroupMember> getListByUserId(
			@Define("body.userId") String userId) {
		List<GroupMember> list = groupMemberService.getListByUserId(userId);
		return list;
	}
}
