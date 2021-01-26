package com.oimchat.server.general.kernel.work.module.manage.personal.service;

import javax.annotation.Resource;

import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.module.base.personal.manager.PersonalManager;
import com.oimchat.server.general.kernel.work.module.base.user.dao.UserDAO;
import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;
import com.oimchat.server.general.kernel.work.module.base.user.entity.User;
import com.oimchat.server.general.kernel.work.module.base.user.manager.UserExtendManager;
import com.onlyxiahui.aware.basic.work.business.error.ErrorCode;
import com.onlyxiahui.common.message.bean.Info;

/**
 * date 2018-06-13 10:27:23<br>
 * description
 * 
 * @author XiaHui<br>
 * @since
 */
@Service
public class PersonalService {

	@Resource
	UserDAO userDAO;

	@Autowired
	UserExtendManager userExtendManager;
	@Autowired
	PersonalManager personalManager;

	public UserData getUserDataById(String id) {
		return userExtendManager.getUserDataById(id);
	}

	public Info updatePassword(String id, String newPassword, String oldPassword) {
		Info info = new Info();
		try {

			User user = null;
			if (StringUtil.isBlank(id) || StringUtil.isBlank(newPassword)) {
				info.addWarning(ErrorCode.business.code("001"), "修改失败！");
			}

			if (info.isSuccess()) {
				user = userDAO.get(id);
				if (null == user) {
					info.addWarning(ErrorCode.business.code("002"), "修改失败！");
				}
			}

			if (info.isSuccess()) {
				if (user.getPassword().equals(oldPassword)) {
					personalManager.updatePassword(id, newPassword);
				} else {
					info.addWarning("003", "原密码错误！");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			info.addError(ErrorCode.system.code("500"), "系统异常");
		}
		return info;
	}
}
