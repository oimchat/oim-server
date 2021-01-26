package com.oimchat.server.general.kernel.work.module.business.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.personal.manager.PersonalManager;
import com.oimchat.server.general.kernel.work.module.base.user.dao.UserDAO;
import com.oimchat.server.general.kernel.work.module.base.user.dao.UserSecurityQuestionDAO;
import com.oimchat.server.general.kernel.work.module.base.user.data.UserSecurityQuestionData;
import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;
import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserSecurityQuestionDataCase;
import com.oimchat.server.general.kernel.work.module.base.user.entity.UserSecurityQuestion;
import com.oimchat.server.general.kernel.work.module.base.user.manager.UserSecurityQuestionExtendManager;
import com.onlyxiahui.aware.basic.work.business.error.ErrorCode;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.message.result.ResultBodyMessage;

@Service
@Transactional
public class UserSecurityQuestionService {

	@Autowired
	UserDAO userDAO;
	@Autowired
	UserSecurityQuestionDAO userSecurityQuestionDAO;
	@Autowired
	UserSecurityQuestionExtendManager userSecurityQuestionExtendManager;
	@Autowired
	PersonalManager personalManager;

	/**
	 * 
	 * Date 2019-01-20 09:43:30<br>
	 * Description 保存密保问题
	 * 
	 * @author XiaHui<br>
	 * @param list
	 * @param userId
	 * @since 1.0.0
	 */
	public void save(List<UserSecurityQuestion> list, String userId) {
		userSecurityQuestionExtendManager.save(list, userId);
	}

	/**
	 * 
	 * Description <br>
	 * Date 2019-04-27 09:06:19<br>
	 * 
	 * @param account
	 * @return ResultBodyMessage
	 * @since 1.0.0
	 */
	public ResultBodyMessage<UserSecurityQuestionDataCase> getSecurityQuestionDataListByAccount(String account) {
		ResultBodyMessage<UserSecurityQuestionDataCase> message = new ResultBodyMessage<>();
		UserData userData = userDAO.getUserDataByAccount(account);
		if (null != userData) {
			List<UserSecurityQuestionData> list = userSecurityQuestionDAO.getSecurityQuestionDataListByUserId(userData.getId());
			if (list.isEmpty()) {
				message.addWarning(ErrorCode.business.code("001"), "您未设置密保问题！");
			} else {
				UserSecurityQuestionDataCase data = new UserSecurityQuestionDataCase(userData.getId(), list);
				message.setBody(data);
			}
		} else {
			message.addWarning(ErrorCode.business.code("002"), "帐号不存在！");
		}
		return message;
	}

	/**
	 * 
	 * Date 2019-01-20 09:44:57<br>
	 * Description 根据保问题修改密码
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param password
	 * @param answerList
	 * @return
	 * @since 1.0.0
	 */
	public Info updatePassword(String userId, String password, List<UserSecurityQuestion> answerList) {
		Info info = new Info();
		boolean check = userSecurityQuestionExtendManager.check(userId, answerList);
		if (check) {
			boolean mark = personalManager.updatePassword(userId, password);
			if (!mark) {
				info.addWarning(ErrorCode.business.code("001"), "修改失败！");
			}
		} else {
			info.addWarning(ErrorCode.business.code("002"), "问题回答错误！");
		}
		return info;
	}
}
