package com.oimchat.server.general.kernel.work.module.business.personal.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.basic.common.util.KeyUtil;
import com.oimchat.server.basic.definition.auth.business.UserTokenBuilder;
import com.oimchat.server.basic.definition.auth.business.UserTokenTempBox;
import com.oimchat.server.general.kernel.work.define.user.store.UserStore;
import com.oimchat.server.general.kernel.work.module.base.personal.data.dto.LoginData;
import com.oimchat.server.general.kernel.work.module.base.personal.data.dto.LoginResult;
import com.oimchat.server.general.kernel.work.module.base.personal.data.dto.LoginUser;
import com.oimchat.server.general.kernel.work.module.base.personal.manager.PersonalManager;
import com.oimchat.server.general.kernel.work.module.base.personal.push.PersonalPush;
import com.oimchat.server.general.kernel.work.module.base.user.dao.UserDAO;
import com.oimchat.server.general.kernel.work.module.base.user.dao.UserHeadDAO;
import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;
import com.oimchat.server.general.kernel.work.module.base.user.entity.User;
import com.oimchat.server.general.kernel.work.module.base.user.entity.UserHead;
import com.oimchat.server.general.kernel.work.module.base.user.manager.UserExtendManager;
import com.oimchat.server.general.kernel.work.module.base.user.type.UserHeadTypeEnum;
import com.onlyxiahui.aware.basic.work.business.error.ErrorCode;
import com.onlyxiahui.aware.basic.work.type.lang.BooleanEnum;
import com.onlyxiahui.common.data.base.HeadImpl;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.common.utils.base.util.time.DateUtil;

/**
 * 
 * Date 2019-01-20 09:40:46<br>
 * Description 个人业务处理service
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
@Transactional
public class PersonalService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserHeadDAO userHeadDAO;
	@Autowired
	private UserStore userStore;
	@Autowired
	private PersonalPush personalPush;
	@Autowired
	private UserExtendManager userExtendManager;

	@Autowired
	private PersonalManager personalManager;
	@Autowired
	private UserTokenTempBox userTokenTempBox;
	@Autowired
	private UserTokenBuilder userTokenBuilder;

	public PersonalService() {
	}

	public ResultMessage verify(HeadImpl head, String address, String account) {
		ResultMessage m = new ResultMessage();
		return m;
	}

	boolean isNeedVerify(String address, String account) {
		return false;
	}

	/**
	 * 
	 * Description 登录 <br>
	 * Date 2019-04-30 09:56:08<br>
	 * 
	 * @param loginData
	 * @return ResultMessage
	 * @since 1.0.0
	 */
	@Transactional(readOnly = true)
	public ResultBodyMessage<LoginResult> login(LoginData loginData) {
		ResultBodyMessage<LoginResult> m = new ResultBodyMessage<>();
		LoginUser loginUser = null;
		String account = null;
		String password = null;
		User user = null;
		Info info = new Info();
		if (null == loginData || null == loginData.getUser()) {
			info.addWarning(ErrorCode.business.code("001"), "帐号和密码不能为空！");
		}

		if (info.isSuccess()) {
			loginUser = loginData.getUser();
			account = loginUser.getAccount();
			password = loginUser.getPassword();
			personalManager.check(info, account, password);
		}

		if (info.isSuccess()) {
			user = personalManager.getByText(account);
			if (null == user) {
				info.addWarning(ErrorCode.business.code("004"), "帐号不存在或者密码错误！");
			}
		}

		if (info.isSuccess()) {
			if (BooleanEnum.TRUE.isEquals(user.getIsDisable())) {
				info.addWarning(ErrorCode.business.code("006"), "帐号不存在或者密码错误！");
			} else if (password.equals(user.getPassword())) {
				UserData userData = new UserData();
				BeanUtils.copyProperties(user, userData);

				String token = userTokenBuilder.build(user.getId(), null);//.getToken(user.getId());
				userTokenTempBox.put(token, user.getId());

				m.setBody(new LoginResult(token, userData));
			} else {
				info.addWarning(ErrorCode.business.code("005"), "帐号不存在或者密码错误！");
			}
		}
		m.setInfo(info);
		return m;
	}

	/**
	 * 
	 * Date 2019-01-20 11:21:08<br>
	 * Description 修改用户信息
	 * 
	 * @author XiaHui<br>
	 * @param user
	 * @return
	 * @since 1.0.0
	 */
	@Transactional
	public Info update(User user) {
		Info info = userExtendManager.update(user);
		if (info.isSuccess()) {
			personalPush.pushUpdate(user.getId(), KeyUtil.getKey());
		}
		return info;
	}

	/**
	 * 
	 * Date 2019-01-20 11:27:30<br>
	 * Description 修改密码
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @since 1.0.0
	 */
	@Transactional
	public ResultMessage updatePassword(String userId, String oldPassword, String newPassword) {
		ResultMessage message = new ResultMessage();
		try {
			User user = userDAO.get(userId);
			if (user.getPassword().equals(oldPassword)) {
				boolean mark = personalManager.updatePassword(userId, newPassword);
				if (!mark) {
					message.addWarning(ErrorCode.business.code("0002"), "修改失败！");
				}
			} else {
				message.addWarning(ErrorCode.business.code("0001"), "原密码不正确！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.addWarning(ErrorCode.business.code("0002"), "修改失败！");
		}
		return message;
	}

	/**
	 * 
	 * Date 2019-01-20 11:21:48<br>
	 * Description 用户上传图像
	 * 
	 * @author XiaHui<br>
	 * @param userHead
	 * @return
	 * @since 1.0.0
	 */
	@Transactional
	public ResultBodyMessage<UserHead> uploadHead(UserHead userHead) {
		ResultBodyMessage<UserHead> message = new ResultBodyMessage<>();
		try {
			userHead.setCreatedDateTime(DateUtil.getCurrentDateTime());
			userHeadDAO.save(userHead);

			String headId = userHead.getHeadId();
			String userId = userHead.getUserId();
			String type = userHead.getType();
			String url = userHead.getUrl();
			headId = (null == headId || headId.isEmpty()) ? "1" : headId;
			// 用户自定义头像，则清除系统头像
			if (UserHeadTypeEnum.custom.isEquals(type)) {
				userDAO.updateAvatar(userId, url);
				// userDAO.updateHead(userId, "");
			} else {
				userDAO.updateHead(userId, headId);
				userDAO.updateAvatar(userId, "");
			}
			message.setBody(userHead);

			personalPush.pushUpdateHead(userId, KeyUtil.getKey());
			userExtendManager.updateHead(userId);
		} catch (Exception e) {
			message.addWarning(ErrorCode.business.code("0001"), "上传失败！");
		}
		return message;
	}

	/**
	 * 
	 * Date 2019-01-20 11:26:52<br>
	 * Description 修改个性签名
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param signature
	 * @return
	 * @since 1.0.0
	 */
	@Transactional
	public boolean updateSignature(String userId, String signature) {
		Map<String, Object> user = new HashMap<>();
		user.put("id", userId);
		user.put("signature", signature);
		int i = userDAO.updateSelective(user);
		boolean mark = i > 0;
		if (mark) {
			userExtendManager.updateSignature(userId, signature);
		}
		return mark;
	}

	/**
	 * 
	 * Date 2019-01-20 11:27:05<br>
	 * Description 修改在线状态
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param status
	 * @since 1.0.0
	 */
	public void updateStatus(String userId, String status) {
		userStore.putStatus(userId, status);
		userExtendManager.updateStatus(userId, status);
		personalPush.pushUpdateStatus(userId, KeyUtil.getKey(), status);
	}

	public UserHead getUserHeadByUserId(String userId) {
		UserHead head = userHeadDAO.getLastByUserId(userId);
		return head;
	}
}
