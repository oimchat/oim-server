package com.oimchat.server.general.kernel.work.module.business.account.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;
import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserSecurityQuestionDataCase;
import com.oimchat.server.general.kernel.work.module.base.user.entity.User;
import com.oimchat.server.general.kernel.work.module.base.user.entity.UserSecurityQuestion;
import com.oimchat.server.general.kernel.work.module.business.account.service.AccountService;
import com.oimchat.server.general.kernel.work.module.business.user.service.UserSecurityQuestionService;
import com.onlyxiahui.aware.basic.work.business.error.SystemError;
// import com.onlyxiahui.common.annotation.action.MethodMapping;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.bean.ExistInfo;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

import com.onlyxiahui.aware.common.auth.annotation.PermissionMapping;
import com.onlyxiahui.aware.common.auth.type.PermissionType;

/**
 * 账号业务接口<br>
 * Date 2019-01-20 08:38:14<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.1.0
 */
@Component
@ActionMapping(value = "1.1.001")
public class AccountAction {

	@Resource
	private UserSecurityQuestionService securityQuestionService;
	@Resource
	private AccountService accountService;

	/**
	 * 
	 * 注册 <br>
	 * Date 2020-04-09 19:48:57<br>
	 * 
	 * @param user
	 * @param questions
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.skip)
	// @MethodMapping(value = "", isIntercept = false)
	@ActionMapping(value = "1.1.0001")
	public ResultBodyMessage<UserData> register(
			@Define("body.user") User user,
			@Define("body.questions") List<UserSecurityQuestion> questions) {
		ResultBodyMessage<UserData> message = new ResultBodyMessage<>();
		try {
			Info info = accountService.register(user, questions);
			UserData userData = new UserData();
			BeanUtils.copyProperties(user, userData);
			message.setBody(userData);
			message.setInfo(info);
		} catch (Exception e) {
			e.printStackTrace();
			message.addError(SystemError.SYSTEM_EXCEPTIONS.value(), "系统异常！");
			message.addWarning(SystemError.SYSTEM_EXCEPTIONS.value(), "注册失败");
		}
		return message;
	}

	/**
	 * 
	 * 获取密保问题 <br>
	 * Date 2019-04-20 17:33:25<br>
	 * 
	 * @param account
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.skip)
	// @MethodMapping(value = "", isIntercept = false)
	@ActionMapping(value = "1.1.0002")
	public ResultBodyMessage<UserSecurityQuestionDataCase> getSecurityQuestionList(@Define("body.account") String account) {
		ResultBodyMessage<UserSecurityQuestionDataCase> message = securityQuestionService.getSecurityQuestionDataListByAccount(account);
		return message;
	}

	/**
	 * 
	 * 密保问题修改密码 <br>
	 * Date 2019-04-27 09:05:50<br>
	 * 
	 * @param userId
	 * @param password
	 * @param list
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.skip)
	// @MethodMapping(value = "", isIntercept = false)
	@ActionMapping(value = "1.1.0003")
	public Info updatePassword(
			@Define("body.userId") String userId,
			@Define("body.password") String password,
			@Define("body.answers") List<UserSecurityQuestion> list) {
		Info message = securityQuestionService.updatePassword(userId, password, list);
		return message;
	}

	/**
	 * 
	 * 账号是否已经存在 <br>
	 * Date 2019-04-28 00:23:46<br>
	 * 
	 * @param account
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.skip)
	// @MethodMapping(value = "", isIntercept = false)
	@ActionMapping(value = "1.1.0006")
	public ResultBodyMessage<ExistInfo> isExistAccount(
			UserSession userSession,
			@Define("body.userId") String userId,
			@Define("body.account") String account) {
		userId = userSession.getUserId();
		boolean exist = accountService.isExistAccount(userId, account);
		return new ResultBodyMessage<>(new ExistInfo(exist));
	}

	/**
	 * 
	 * 邮箱是否已经存在 <br>
	 * Date 2019-04-28 00:27:49<br>
	 * 
	 * @param email
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.skip)
	// @MethodMapping(value = "", isIntercept = false)
	@ActionMapping(value = "1.1.0007")
	public ResultBodyMessage<ExistInfo> isExistEmail(
			UserSession userSession,
			@Define("body.userId") String userId,
			@Define("body.email") String email) {
		userId = userSession.getUserId();
		boolean exist = accountService.isExistEmail(userId, email);
		return new ResultBodyMessage<>(new ExistInfo(exist));
	}

	/**
	 * 
	 * 手机是否已经存在 <br>
	 * Date 2019-04-28 00:29:11<br>
	 * 
	 * @param mobile
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.skip)
	// @MethodMapping(value = "", isIntercept = false)
	@ActionMapping(value = "1.1.0008")
	public ResultBodyMessage<ExistInfo> isExistMobile(
			UserSession userSession,
			@Define("body.userId") String userId,
			@Define("body.mobile") String mobile) {
		userId = userSession.getUserId();
		boolean exist = accountService.isExistMobile(userId, mobile);
		return new ResultBodyMessage<>(new ExistInfo(exist));
	}
}
