package com.oimchat.server.general.kernel.work.module.business.account.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.user.entity.User;
import com.oimchat.server.general.kernel.work.module.base.user.entity.UserSecurityQuestion;
import com.oimchat.server.general.kernel.work.module.base.user.manager.UserExtendManager;
import com.oimchat.server.general.kernel.work.module.base.user.manager.UserSecurityQuestionExtendManager;
import com.onlyxiahui.common.message.bean.Info;

/**
 * 
 * Date 2019-01-20 12:35:32<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class AccountService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserExtendManager userExtendManager;
	@Autowired
	private UserSecurityQuestionExtendManager userSecurityQuestionExtendManager;

	/**
	 * 注册
	 * 
	 * @param user
	 * @return
	 */
	@Transactional
	public Info register(User user, List<UserSecurityQuestion> list) {
		Info info = userExtendManager.add(user);
		if (info.isSuccess()) {
			userSecurityQuestionExtendManager.save(list, user.getId());
		}
		return info;
	}

	public boolean isExistAccount(String userId, String account) {
		return userExtendManager.isExistAccount(userId, account);
	}

	public boolean isExistEmail(String userId, String email) {
		return userExtendManager.isExistEmail(userId, email);
	}

	public boolean isExistMobile(String userId, String mobile) {
		return userExtendManager.isExistMobile(userId, mobile);
	}
}
