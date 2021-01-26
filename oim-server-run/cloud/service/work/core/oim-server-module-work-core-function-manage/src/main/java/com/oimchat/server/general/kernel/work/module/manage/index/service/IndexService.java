package com.oimchat.server.general.kernel.work.module.manage.index.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oimchat.server.basic.definition.auth.business.UserTokenAuthBox;
import com.oimchat.server.basic.definition.auth.business.UserTokenBuilder;
import com.oimchat.server.basic.definition.auth.manage.UserPermissionAuthBox;
import com.oimchat.server.general.kernel.work.module.base.personal.manager.PersonalManager;
import com.oimchat.server.general.kernel.work.module.base.user.dao.UserDAO;
import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;
import com.oimchat.server.general.kernel.work.module.base.user.entity.User;
import com.oimchat.server.general.kernel.work.module.base.user.type.UserTypeEnum;
import com.oimchat.server.general.kernel.work.module.manage.index.data.LoginResult;
import com.oimchat.server.general.kernel.work.module.manage.system.entity.Function;
import com.oimchat.server.general.kernel.work.module.manage.system.manager.UserFunctionManager;
import com.onlyxiahui.aware.basic.work.business.error.ErrorCode;
import com.onlyxiahui.aware.basic.work.type.lang.BooleanEnum;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.common.utils.base.lang.string.StringUtil;

/**
 * date 2018-06-13 10:27:23<br>
 * description
 * 
 * @author XiaHui<br>
 * @since
 */
@Service
public class IndexService {

	@Autowired
	PersonalManager personalManager;
	@Autowired
	UserPermissionAuthBox userPermissionAuth;
	@Autowired
	UserFunctionManager userFunctionManager;
	@Autowired
	UserDAO userDAO;
	@Autowired
	UserTokenBuilder userTokenBuilder;
	@Autowired
	UserTokenAuthBox userTokenAuthBox;

	public ResultBodyMessage<LoginResult> login(String account, String password) {
		ResultBodyMessage<LoginResult> m = new ResultBodyMessage<>();
		Info info = new Info();
		try {
			User user = null;
			if (StringUtil.isBlank(account) || StringUtil.isBlank(password)) {
				info.addWarning(ErrorCode.business.code("001"), "帐号和密码不能为空！");
			}

			if (info.isSuccess()) {
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

					String type = user.getType();
					if (UserTypeEnum.root.isEquals(type) || UserTypeEnum.admin.isEquals(type)) {
						if (password.equals(user.getPassword())) {
							String userId = user.getId();
							String token = userTokenBuilder.build(user.getId(), null);// TokenUtil.getToken(userId);
							userTokenAuthBox.put(token, userId);
							// 如果是超级管理员，则拥有所有权限
							if (UserTypeEnum.root.isEquals(type)) {
								userPermissionAuth.putRootUserId(userId);
							}
							UserData userData = new UserData();
							BeanUtils.copyProperties(user, userData);
							m.setBody(new LoginResult(token, userData));
						} else {
							info.addWarning(ErrorCode.business.code("003"), "密码错误！");
						}
					} else {
						info.addWarning(ErrorCode.business.code("002"), "账号不存在！");
					}
				} else {
					info.addWarning(ErrorCode.business.code("005"), "帐号不存在或者密码错误！");
				}
			}
			m.setInfo(info);
		} catch (Exception e) {
			e.printStackTrace();
			info.addError(ErrorCode.system.code("500"), "系统异常");
		}
		return m;
	}

	public List<Function> getFunctionList(String userId, String token) {
		List<Function> list = null;
		User user = userDAO.getById(userId);
		if (null != user) {
			String type = user.getType();
			// 如果是超级管理员，则拥有所有权限
			if (UserTypeEnum.root.isEquals(type)) {
				list = userFunctionManager.getAllFunctionList();
			} else {
				list = userFunctionManager.getFunctionListByUserId(userId);
				List<String> keyList = new ArrayList<String>();

				for (Function m : list) {
					String service = m.getService();
					String path = m.getPath();
					keyList.add(service + path);
				}
				userPermissionAuth.setPermission(userId, keyList);
			}
		}
		return list == null ? new ArrayList<>() : list;
	}
}
