package com.oimchat.server.general.kernel.work.module.manage.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.oimchat.server.general.kernel.work.module.manage.system.data.FunctionQuery;
import com.oimchat.server.general.kernel.work.module.manage.system.entity.Function;
import com.oimchat.server.general.kernel.work.module.manage.system.service.FunctionService;
import com.onlyxiahui.aware.common.auth.annotation.PermissionMapping;
import com.onlyxiahui.aware.common.auth.type.PermissionType;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.data.ListBody;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 功能信息<br>
 * date 2018-06-04 14:59:44<br>
 * 
 * @author XiaHui<br>
 * @since
 */
@RestController
@ActionMapping("/manage")
public class FunctionController {

	@Autowired
	FunctionService functionService;

	/**
	 * 
	 * 所有功能列表<br>
	 * Date 2020-06-07 11:38:06<br>
	 * 
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.grant)
	@ActionMapping("/v1/system/function/all.list")
	public ListBody<List<Function>> allList() {
		List<Function> list = functionService.getAllList();
		return new ListBody<>(list);
	}

	/**
	 * 
	 * 启用或者禁用<br>
	 * Date 2020-06-07 11:38:10<br>
	 * 
	 * @param id
	 * @param isDisable
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.grant)
	@ActionMapping("/v1/system/function/update.is.disable")
	public Info updateIsDisable(
			@Define("body.id") String id,
			@Define("body.isDisable") Integer isDisable) {
		functionService.updateIsDisable(id, isDisable);
		return new Info();
	}

	/**
	 * 
	 * 条件查询<br>
	 * Date 2020-06-07 11:38:20<br>
	 * 
	 * @param query
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.grant)
	@ActionMapping("/v1/system/function/get.list")
	public ListBody<List<Function>> getList(
			@Define("body.query") FunctionQuery query) {
		List<Function> list = functionService.list(query);
		return new ListBody<>(list);
	}
}
