package com.oimchat.server.general.kernel.work.module.base.personal.manager;

import javax.annotation.Resource;

import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import org.springframework.stereotype.Service;

import com.oimchat.server.basic.common.util.KeyUtil;
import com.oimchat.server.basic.common.util.business.BusinessStringUtil;
import com.oimchat.server.general.kernel.work.module.base.personal.push.PersonalPush;
import com.oimchat.server.general.kernel.work.module.base.user.dao.UserDAO;
import com.oimchat.server.general.kernel.work.module.base.user.entity.User;
import com.onlyxiahui.aware.basic.work.business.error.ErrorCode;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.utils.base.lang.number.NumberUtil;

/**
 * 
 * Description <br>
 * Date 2019-05-05 09:42:44<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Service
public class PersonalManager {

	@Resource
	private UserDAO userDAO;
	@Resource
	private PersonalPush personalPush;

	public boolean updatePassword(String id, String password) {
		boolean mark = userDAO.updatePassword(id, password);
		if (mark) {
			personalPush.pushUpdatePassword(id, KeyUtil.getKey());
		}
		return mark;
	}

	public User getByText(String text) {
		User user = null;
		if (StringUtil.isNotBlank(text)) {
			text = text.replace(" ", "").replace("'", "");
			if (BusinessStringUtil.isEmail(text)) {
				user = userDAO.getByEmail(text);
			} else if (BusinessStringUtil.isMobile(text)) {
				user = userDAO.getByMobile(text);
			} else if (NumberUtil.isInteger(text)) {
				user = userDAO.getByNumber(Long.parseLong(text));
			} else {
				user = userDAO.getByAccount(text);
			}
		}
		return user;
	}

	public void check(Info info, String account, String password) {
		if (StringUtil.isBlank(account)) {
			info.addWarning(ErrorCode.business.code("002"), "帐号不能为空！");
		}
		if (StringUtil.isBlank(password)) {
			info.addWarning(ErrorCode.business.code("003"), "密码不能为空！");
		}
	}
}
