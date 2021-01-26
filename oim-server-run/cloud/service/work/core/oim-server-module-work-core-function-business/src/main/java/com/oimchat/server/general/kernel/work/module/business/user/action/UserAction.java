package com.oimchat.server.general.kernel.work.module.business.user.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;
import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserDataQuery;
import com.oimchat.server.general.kernel.work.module.business.user.service.UserHeadService;
import com.oimchat.server.general.kernel.work.module.business.user.service.UserService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.data.ListBody;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 用户业务接口<br>
 * Date 2019-01-20 11:53:11<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.1.0
 */
@Controller
@ActionMapping(value = "1.1.003")
public class UserAction {

	@Resource
	private UserService userService;
	@Resource
	private UserHeadService userHeadService;

	/**
	 * 分页条件查询用户<br>
	 * Date 2019-01-20 12:29:19<br>
	 * 
	 * @author XiaHui<br>
	 * @param query
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0001")
	public PageResult<List<UserData>> queryUserDataList(
			@Define("body.query") UserDataQuery query,
			@Define("body.page") Page page) {
		List<UserData> userDataList = userService.queryUserDataList(query, page);
		userService.setUserStatus(userDataList);
		return new PageResult<List<UserData>>(page, userDataList);
	}

	/**
	 * 获取用户详情<br>
	 * Date 2019-01-20 12:29:06<br>
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0002")
	public UserData getUserDataById(@Define("body.id") String userId) {
		UserData userData = userService.getUserDataById(userId);
		userService.setUserStatus(userData);
		return userData;
	}

	/**
	 * 
	 * 批量获取用户详情 <br>
	 * Date 2019-05-05 08:35:50<br>
	 * 
	 * @param userIds
	 * @return ResultMessage
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0003")
	public ListBody<List<UserData>> getUserDataList(
			@Define("body.ids") List<String> userIds) {
		List<UserData> userDataList = userService.getUserDataList(userIds);
		userService.setUserStatus(userDataList);
		return new ListBody<List<UserData>>(userDataList);
	}

//	/**
//	 * 获取用户头像信息<br>
//	 * Date 2019-01-20 19:54:10<br>
//	 * 
//	 * @author XiaHui<br>
//	 * @param userId
//	 * @return
//	 * @since 1.0.0
//	 */
//	@ActionMapping(value = "1.1.0004")
//	public UserHead getUserHead(@Define("body.userId") String userId) {
//		UserHead userHead = userHeadService.getUserHeadByUserId(userId);
//		return userHead;
//	}
}
