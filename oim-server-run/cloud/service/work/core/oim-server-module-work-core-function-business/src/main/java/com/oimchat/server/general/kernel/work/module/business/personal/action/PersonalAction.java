package com.oimchat.server.general.kernel.work.module.business.personal.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.personal.data.dto.LoginData;
import com.oimchat.server.general.kernel.work.module.base.personal.data.dto.LoginResult;
import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;
import com.oimchat.server.general.kernel.work.module.base.user.entity.User;
import com.oimchat.server.general.kernel.work.module.base.user.entity.UserHead;
import com.oimchat.server.general.kernel.work.module.business.personal.service.PersonalService;
import com.oimchat.server.general.kernel.work.module.business.user.service.UserService;
// import com.onlyxiahui.common.annotation.action.MethodMapping;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

import com.onlyxiahui.aware.common.auth.annotation.PermissionMapping;
import com.onlyxiahui.aware.common.auth.type.PermissionType;

/**
 * 个人业务接口<br>
 * Date 2019-01-20 08:38:14<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.1.0
 */
@Component
@ActionMapping(value = "1.1.002")
public class PersonalAction {

	@Resource
	private UserService userService;
	@Resource
	private PersonalService personalService;

	/**
	 * 登录<br>
	 * Date 2019-01-20 08:42:42<br>
	 * Description
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param clientHead
	 * @param loginData
	 * @return
	 * @since 1.0.0
	 */
	@PermissionMapping(type = PermissionType.skip)
	// @MethodMapping(value = "", isIntercept = false)
	@ActionMapping(value = "1.1.0005")
	public ResultBodyMessage<LoginResult> login(
			@Define("body") LoginData loginData) {
		ResultBodyMessage<LoginResult> message = personalService.login(loginData);
		return message;
	}

	/**
	 * 获取个人信息<br>
	 * Date 2019-01-20 08:48:32<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0007")
	public UserData getUserData(UserSession userSession) {
		UserData user = userService.getUserDataById(userSession.getUserId());
		return user;
	}

	/**
	 * 获取个人头像<br>
	 * Date 2020-04-09 20:57:23<br>
	 * 
	 * @param userSession
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0008")
	public UserHead getUserHead(UserSession userSession) {
		String userId = userSession.getUserId();
		UserHead head = personalService.getUserHeadByUserId(userId);
		return head;
	}

	/**
	 * 修改个人信息<br>
	 * Date 2019-01-20 08:48:56<br>
	 * 
	 * @author XiaHui<br>
	 * @param user
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0009")
	public Info updateUser(
			UserSession userSession,
			@Define("body") User user) {
		String userId = userSession.getUserId();
		user.setId(userId);
		return personalService.update(user);
	}

	/**
	 * 修改密码<br>
	 * Date 2019-01-20 08:50:08<br>
	 * Description
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0010")
	public ResultMessage updatePassword(
			UserSession userSession,
			@Define("body.oldPassword") String oldPassword,
			@Define("body.newPassword") String newPassword) {
		return personalService.updatePassword(userSession.getUserId(), oldPassword, newPassword);
	}

	/**
	 * 修改头像<br>
	 * Date 2019-01-20 08:51:01<br>
	 * 
	 * @author XiaHui<br>
	 * @param userHead
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0011")
	public ResultBodyMessage<UserHead> uploadHead(
			UserSession userSession,
			@Define("body") UserHead userHead) {
		String userId = userSession.getUserId();
		userHead.setUserId(userId);
		return personalService.uploadHead(userHead);
	}

	/**
	 * 修改签名<br>
	 * Date 2019-01-20 08:52:19<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param signature
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0012")
	public void updateSignature(UserSession userSession,
			@Define("body.signature") String signature) {
		personalService.updateSignature(userSession.getUserId(), signature);

	}

	/**
	 * 修改在线状态<br>
	 * Date 2019-01-20 10:01:00<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param status
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0013")
	public void updateStatus(UserSession userSession,
			@Define("body.status") String status) {
		personalService.updateStatus(userSession.getUserId(), status);
	}
}
