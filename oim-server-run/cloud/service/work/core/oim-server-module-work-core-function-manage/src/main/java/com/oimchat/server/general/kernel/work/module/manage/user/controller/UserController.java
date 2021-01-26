package com.oimchat.server.general.kernel.work.module.manage.user.controller;

import java.util.List;

import javax.annotation.Resource;

import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import org.springframework.stereotype.Controller;

import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;
import com.oimchat.server.general.kernel.work.module.base.user.data.query.UserQuery;
import com.oimchat.server.general.kernel.work.module.base.user.entity.User;
import com.oimchat.server.general.kernel.work.module.base.user.type.UserTypeEnum;
import com.oimchat.server.general.kernel.work.module.manage.user.service.UserService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.bean.ExistInfo;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 用户管理<br>
 * date 2018-07-19 09:29:16<br>
 * 
 * @author XiaHui<br>
 * @since
 */
@Controller
@ActionMapping("")
public class UserController {
	@Resource
	UserService userService;

	/**
	 * 列表<br>
	 * Date 2020-06-07 11:44:51<br>
	 * 
	 * @param query
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping("/v1/user/info/list")
	public PageResult<List<UserData>> list(
			@Define("body.query") UserQuery query,
			@Define("body.page") Page page) {
		List<UserData> list = userService.queryUserDataList(query, page);
		return new PageResult<>(page, list);
	}

	/**
	 * 
	 * 新增/更新<br>
	 * Date 2020-06-07 11:44:56<br>
	 * 
	 * @param user
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping("/v1/user/info/add.or.update")
	public ResultBodyMessage<User> addOrUpdate(
			@Define("body") User user) {
		ResultBodyMessage<User> rm = new ResultBodyMessage<>(user);
		user.setType(UserTypeEnum.general.getCode().toString());
		Info info = userService.addOrUpdate(user);
		rm.setInfo(info);
		return rm;
	}

	/**
	 * 
	 * 获取详情<br>
	 * Date 2020-06-07 11:45:33<br>
	 * 
	 * @param id
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping("/v1/user/info/get.by.id")
	public UserData getById(
			@Define("body.id") String id) {
		UserData user = userService.getById(id);
		return user;
	}

	/**
	 * 
	 * 是否已经存在<br>
	 * Date 2020-06-07 11:45:28<br>
	 * 
	 * @param id
	 * @param account
	 * @param email
	 * @param mobile
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping("/v1/user/info/is.exist")
	public ExistInfo isExist(
			@Define("body.id") String id,
			@Define("body.account") String account,
			@Define("body.email") String email,
			@Define("body.mobile") String mobile) {
		boolean isExist = false;

		if (StringUtil.isNotBlank(account)) {
			isExist = userService.isExistAccount(id, account);
		}
		if (!isExist && StringUtil.isNotBlank(email)) {
			isExist = userService.isExistEmail(id, email);
		}
		if (!isExist && StringUtil.isNotBlank(mobile)) {
			isExist = userService.isExistMobile(id, mobile);
		}
		return new ExistInfo(isExist);
	}

	/**
	 * 
	 * 加载详情<br>
	 * Date 2020-06-07 11:45:23<br>
	 * 
	 * @param id
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping("/v1/user/info/load.by.id")
	public UserData loadById(
			@Define("body.id") String id) {
		UserData user = userService.getById(id);
		return user;
	}

	/**
	 * 
	 * 修改密码<br>
	 * Date 2020-06-07 11:45:19<br>
	 * 
	 * @param userId
	 * @param password
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping("/v1/user/info/update.password")
	public ResultMessage updatePassword(
			@Define("body.id") String userId,
			@Define("body.password") String password) {
		ResultMessage rm = new ResultMessage();
		String text = "";
		boolean mark = true;
		if (null == password || "".equals(password)) {
			mark = false;
			text = ("密码不能为空！");
		}
		if (mark) {
			mark = userService.updatePassword(userId, password);
			text = mark ? ("修改成功！") : ("修改失败！");
		}
		if (!mark) {
			rm.addWarning("001", text);
		}
		return rm;
	}

	/**
	 * 
	 * 启用/禁用<br>
	 * Date 2020-06-07 11:45:13<br>
	 * 
	 * @param userId
	 * @param isDisable
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping("/v1/user/info/update.is.disable")
	public ResultMessage updateIsDisable(
			@Define("body.id") String userId,
			@Define("body.isDisable") Integer isDisable) {
		ResultMessage rm = new ResultMessage();
		String text = "";
		int count = userService.updateIsDisable(userId, isDisable);
		boolean mark = count > 0;
		text = mark ? ("修改成功！") : ("修改失败！");
		if (!mark) {
			rm.addWarning("001", text);
		}
		return rm;
	}

	/**
	 * 
	 * 设置为管理员<br>
	 * Date 2020-06-07 11:45:07<br>
	 * 
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping("/v1/user/info/set.to.admin")
	public ResultMessage setToAdmin(
			@Define("body.id") String userId) {
		ResultMessage rm = new ResultMessage();
		boolean mark = userService.updateType(userId, UserTypeEnum.admin.getCode().toString());
		String text = mark ? ("修改成功！") : ("修改失败！");
		if (!mark) {
			rm.addWarning("001", text);
		}
		return rm;
	}
}
