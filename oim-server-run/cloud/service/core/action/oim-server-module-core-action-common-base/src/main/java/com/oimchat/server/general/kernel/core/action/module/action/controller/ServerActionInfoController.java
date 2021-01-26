package com.oimchat.server.general.kernel.core.action.module.action.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.oimchat.server.basic.common.work.app.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.oimchat.server.general.kernel.core.action.module.action.entity.ServerActionInfo;
import com.oimchat.server.general.kernel.core.action.module.action.data.query.ServerActionInfoQuery;
import com.oimchat.server.general.kernel.core.action.module.action.service.ServerActionInfoService;

import com.onlyxiahui.aware.basic.work.business.error.ErrorCode;
import com.onlyxiahui.common.action.description.annotation.DocTitle;
import com.onlyxiahui.common.action.description.annotation.DocModule;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 
 * 服务的Action信息<br>
 * Date 2020-11-08 18:55:40<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]
 * @since 1.0.0
 * @docModuleSuperKey manage
 */
@DocTitle("服务的Action信息")
@DocModule(superKey = "manage")
@RestController
public class ServerActionInfoController {

	@Autowired
	ServerActionInfoService serverActionInfoService;

	/**
	 * 分页查询
	 * 
	 * @param query
	 * @param page
	 * @return PageResult<List<ServerActionInfo>>
	 * @since 1.0.0
	 */
	@DocTitle("分页查询")

	@ActionMapping("/v1/action/server.action.info/list")
	public PageResult<List<ServerActionInfo>> list(
			@Define("body.query") ServerActionInfoQuery query,
			@Define("body.page") Page page) {

		List<ServerActionInfo> list = serverActionInfoService.queryList(page, query);
		return new PageResult<List<ServerActionInfo>>(page, list);
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return ServerActionInfo
	 * @since 1.0.0
	 */
	@DocTitle("根据id查询")

	@ActionMapping("/v1/action/server.action.info/get.by.id")
	public ServerActionInfo get(@Validated @Define("body.id") String id) {
		ServerActionInfo data = serverActionInfoService.getById(id);
		return (data);
	}

	/**
	 * 新增
	 * 
	 * @param data
	 * @return ResultBodyMessage<ServerActionInfo>
	 * @since 1.0.0
	 */
	@DocTitle("新增")

	@ActionMapping("/v1/action/server.action.info/add")
	public ResultBodyMessage<ServerActionInfo> add(
			@Validated @Define("body") ServerActionInfo data,
			UserSession us) {

		data.setId(null);
		data.setCreatedUserId(us.getUserId());
		data.setUpdatedUserId(us.getUserId());
		data.setCreatedTimestamp(null);
		data.setCreatedDateTime(null);
		data.setUpdatedDateTime(null);
		data.setUpdatedTimestamp(null);
		serverActionInfoService.add(data);
		ResultBodyMessage<ServerActionInfo> rm = new ResultBodyMessage<>(data);
		return rm;
	}

	/**
	 * 修改
	 * 
	 * @param data
	 * @return ResultBodyMessage<ServerActionInfo>
	 * @since 1.0.0
	 */
	@DocTitle("修改")

	@ActionMapping("/v1/action/server.action.info/update.by.id")
	public ResultBodyMessage<ServerActionInfo> update(
			@Validated @Define("body") ServerActionInfo data,
			UserSession us) {

		data.setCreatedUserId(null);
		data.setUpdatedUserId(us.getUserId());
		data.setCreatedTimestamp(null);
		data.setCreatedDateTime(null);
		data.setUpdatedDateTime(null);
		data.setUpdatedTimestamp(null);
		int result = serverActionInfoService.update(data);
		ResultBodyMessage<ServerActionInfo> rm = new ResultBodyMessage<>(data);
		if (result < 0) {
			rm.addWarning(ErrorCode.business.code("001"), "修改失败！");
		}
		return rm;
	}

	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return Info
	 */
	@DocTitle("根据id删除")

	@ActionMapping("/v1/action/server.action.info/delete.by.id")
	public Info delete(
			@Valid @NotEmpty @Define("body.id") String id,
			UserSession us) {
		boolean mark = 0 < serverActionInfoService.deleteById(id, us.getUserId());
		Info info = new Info();
		if (!mark) {
			info.addWarning(ErrorCode.business.code("001"), "删除失败！");
		}
		return info;
	}
}