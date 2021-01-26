package com.oimchat.server.general.kernel.work.module.business.group.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.oimchat.server.general.kernel.work.module.business.group.service.GroupCategoryService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.message.bean.Info;
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
public class GroupCategoryController {

	@Resource
	GroupCategoryService groupCategoryService;

	@ActionMapping("/v1/group/group.category/save.default")
	public Info getListByUserId(
			@Define("body.userId") String userId) {
		groupCategoryService.saveDefault(userId);
		return new Info();
	}
}
