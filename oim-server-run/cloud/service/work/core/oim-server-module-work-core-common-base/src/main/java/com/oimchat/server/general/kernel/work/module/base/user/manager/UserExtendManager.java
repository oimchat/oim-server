package com.oimchat.server.general.kernel.work.module.base.user.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oimchat.server.basic.common.util.business.BusinessStringUtil;
import com.oimchat.server.general.kernel.work.define.user.store.UserStore;
import com.oimchat.server.general.kernel.work.module.base.user.dao.UserDAO;
import com.oimchat.server.general.kernel.work.module.base.user.dao.UserHeadDAO;
import com.oimchat.server.general.kernel.work.module.base.user.dao.UserNumberDAO;
import com.oimchat.server.general.kernel.work.module.base.user.data.dto.UserData;
import com.oimchat.server.general.kernel.work.module.base.user.entity.User;
import com.oimchat.server.general.kernel.work.module.base.user.type.UserStatusEnum;
import com.onlyxiahui.aware.basic.work.business.error.ErrorCode;
import com.onlyxiahui.aware.basic.work.event.DataEvent;
import com.onlyxiahui.aware.basic.work.event.UpdateEvent;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.utils.base.lang.string.StringUtil;

/**
 * Date 2019-01-20 10:21:23<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class UserExtendManager {

	@Resource
	private UserDAO userDAO;
	@Resource
	private UserHeadDAO userHeadDAO;
	@Resource
	private UserStore userStore;

	@Resource
	private UserNumberDAO userNumberDAO;
//	@Resource
//	private UserCache userCache;
	/**
	 * 这是用户新建后需要初始化的一些事件，这样是为了方便解耦和再不修改代码的情况下添加代码
	 */
	private List<DataEvent<String>> userInitializeDataEventList = new ArrayList<>();
	private List<DataEvent<String>> userDeleteDataEventList = new ArrayList<>();

	private List<DataEvent<String>> userUpdateDataEventList = new ArrayList<>();
	private List<DataEvent<String>> userUpdateHeadEventList = new ArrayList<>();
	private List<UpdateEvent<String, String>> userUpdateStatusEventList = new ArrayList<>();
	private List<UpdateEvent<String, String>> userUpdateSignatureEventList = new ArrayList<>();

	public void addInitializeDataEvent(DataEvent<String> de) {
		userInitializeDataEventList.add(de);
	}

	public void addDeleteDataEvent(DataEvent<String> de) {
		userDeleteDataEventList.add(de);
	}

	public void addUpdateDataEvent(DataEvent<String> de) {
		userUpdateDataEventList.add(de);
	}

	public void addUpdateHeadEvent(DataEvent<String> de) {
		userUpdateHeadEventList.add(de);
	}

	public void addUpdateStatusEvent(UpdateEvent<String, String> de) {
		userUpdateStatusEventList.add(de);
	}

	public void addUpdateSignatureEvent(UpdateEvent<String, String> de) {
		userUpdateSignatureEventList.add(de);
	}

	private void initialize(String userId) {
		for (DataEvent<String> de : userInitializeDataEventList) {
			de.event(userId);
		}
	}

	private void deleteUser(String userId) {
		for (DataEvent<String> de : userDeleteDataEventList) {
			de.event(userId);
		}
	}

	public void updateData(String userId) {
		for (DataEvent<String> de : userUpdateDataEventList) {
			de.event(userId);
		}
	}

	public void updateHead(String userId) {
		for (DataEvent<String> de : userUpdateHeadEventList) {
			de.event(userId);
		}
	}

	public void updateStatus(String userId, String status) {
		for (UpdateEvent<String, String> de : userUpdateStatusEventList) {
			de.event(userId, status);
		}
	}

	public void updateSignature(String userId, String signature) {
		for (UpdateEvent<String, String> de : userUpdateSignatureEventList) {
			de.event(userId, signature);
		}
	}

	/**
	 * 
	 * Description 新增用户 <br>
	 * Date 2019-04-27 15:46:11<br>
	 * 
	 * @param user
	 * @return Info
	 * @since 1.0.0
	 */
	public Info add(User user) {
		Info info = check(user);
		addCheck(info, user);
		if (info.isSuccess()) {
			Long number = userNumberDAO.getNumber();
			int i = new Random().nextInt(10);
			i = i + 1;

			user.setNumber(number);
			user.setHead(i + "");
//			user.setCreatedDateTime(DateUtil.getCurrentDateTime());
//			user.setCreatedTimestamp(System.currentTimeMillis());
			userDAO.save(user);
			initialize(user.getId());
		}
		return info;
	}

	public Info update(User user) {
		Info info = check(user);
		if (info.isSuccess()) {
			updateHandle(user);
			int mark = userDAO.updateSelective(user);
			if (mark <= 0) {
				info.addWarning(ErrorCode.business.code("0001"), "修改失败！");
			} else {
				updateData(user.getId());
			}
		}
		return info;
	}

	public int delete(String id) {
		int count = userDAO.deleteById(id);
		if (count > 0) {
			deleteUser(id);
		}
		return count;
	}

	private void addCheck(Info info, User user) {
		String account = user.getAccount();
		String password = user.getPassword();
		if (StringUtil.isBlank(account)) {
			info.addWarning(ErrorCode.business.code("0103"), "账号不能为空！");
		}
		if (StringUtil.isBlank(password)) {
			info.addWarning(ErrorCode.business.code("0401"), "密码不能为空！");
		}
	}

	private Info check(User user) {
		Info info = new Info();
		String account = user.getAccount();
		String email = user.getEmail();
		String mobile = user.getMobile();
		String userId = user.getId() == null ? "" : user.getId();

		if (StringUtil.isNotBlank(account)) {
			if (!BusinessStringUtil.isAccount(account)) {
				info.addWarning(ErrorCode.business.code("0101"), BusinessStringUtil.PROMPT_ACCOUNT);
			}
			if (info.isSuccess()) {
				if (isExistAccount(userId, account)) {
					info.addWarning(ErrorCode.business.code("0102"), "账号已经存在！");
				}
			}
		}

		if (StringUtil.isNotBlank(email)) {
			if (!BusinessStringUtil.isEmail(email)) {
				info.addWarning(ErrorCode.business.code("0201"), "邮件格式不对");
			} else {
				if (this.isExistEmail(userId, email)) {
					info.addWarning(ErrorCode.business.code("0202"), "邮件已存在");
				}
			}
		}

		if (StringUtil.isNotBlank(mobile)) {
			if (!BusinessStringUtil.isMobile(mobile)) {
				info.addWarning(ErrorCode.business.code("0301"), "手机格式不对");
			} else {
				if (this.isExistMobile(userId, mobile)) {
					info.addWarning(ErrorCode.business.code("0302"), "手机已存在");
				}
			}
		}
		return info;
	}

	private void updateHandle(User user) {
		if (null != user) {
			user.setNumber(null);
			user.setPassword(null);

			user.setHead(null);
			user.setAvatar(null);
			user.setCreatedDateTime(null);
			user.setCreatedTimestamp(null);

			if (StringUtil.isBlank(user.getAccount())) {
				user.setAccount(null);
			}
		}
	}

	/**
	 * 
	 * Date 2019-01-20 13:07:08<br>
	 * Description 获取用户信息
	 * 
	 * @author XiaHui<br>
	 * @param id
	 * @return
	 * @since 1.0.0
	 */
	public UserData getUserDataById(String id) {
		// UserData userData = userCache.get(id);
		// if (null == userData) {
		UserData userData = userDAO.getUserDataById(id);
		// userCache.put(id, userData);
		// }
		return userData;
	}

	public boolean isExistAccount(String userId, String account) {
		User u = userDAO.getByAccount(account);
		return null != u && (!u.getId().equals(userId));
	}

	public boolean isExistEmail(String userId, String email) {
		User u = userDAO.getByEmail(email);
		return null != u && (!u.getId().equals(userId));
	}

	public boolean isExistMobile(String userId, String mobile) {
		User u = userDAO.getByMobile(mobile);
		return null != u && (!u.getId().equals(userId));
	}

	public void offline(String userId) {
		userStore.putStatus(userId, UserStatusEnum.offline.getCode().toString());
		sendUserStatus(userId, UserStatusEnum.offline.getCode().toString());
	}

	public void sendUserStatus(String userId, String status) {
		this.updateStatus(userId, status);
	}
}
