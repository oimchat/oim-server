package com.oimchat.server.general.kernel.work.module.base.user.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.util.KeyUtil;
import com.oimchat.server.general.kernel.work.define.user.function.CorrelationUser;
import com.oimchat.server.general.kernel.work.define.user.function.CorrelationUserIdStream;
import com.oimchat.server.general.kernel.work.module.base.user.manager.UserExtendManager;
import com.oimchat.server.general.kernel.work.module.base.user.push.UserPush;

/**
 * Date 2019-01-20 10:28:51<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Component
public class UserUpdateFunction {

	@Autowired
	private CorrelationUser correlationUser;
	@Autowired
	private UserPush userPush;

	@Autowired
	public void setUserExtendManager(UserExtendManager manager) {
		// this.userManager = userManager;
		manager.addUpdateDataEvent(userId -> {
			updateData(userId);
		});

		manager.addUpdateHeadEvent(userId -> {
			updateHead(userId);
		});

		manager.addUpdateStatusEvent((userId, status) -> {
			updateStatus(userId, status);
		});

		manager.addUpdateSignatureEvent((userId, signature) -> {
			updateSignature(userId, signature);
		});
	}

	/**
	 * 
	 * Description 用户修改信息后推送给所在群和联系人 <br>
	 * Date 2019-04-30 17:50:16<br>
	 * 
	 * @param userId void
	 * @since 1.0.0
	 */
	private void updateData(String userId) {
		if (null != userId) {
			String key = KeyUtil.getKey();
			getCorrelationUserIds(userId, (list) -> {
				userPush.pushUserUpdate(list, key, userId);
			});
		}
	}

	private void updateHead(String userId) {
		if (null != userId) {
			String key = KeyUtil.getKey();
			getCorrelationUserIds(userId, (list) -> {
				userPush.pushUserUpdateHead(list, key, userId);
			});
		}
	}

	private void updateStatus(String userId, String status) {
		if (null != userId) {
			String key = KeyUtil.getKey();
			getCorrelationUserIds(userId, (list) -> {
				userPush.pushUserStatus(list, key, userId, status);
			});
		}
	}

	private void updateSignature(String userId, String signature) {
		if (null != userId) {
			String key = KeyUtil.getKey();
			getCorrelationUserIds(userId, (list) -> {
				userPush.pushUserUpdateSignature(list, key, userId, signature);
			});

		}
	}

	private void getCorrelationUserIds(String userId, CorrelationUserIdStream stream) {
		correlationUser.loadCorrelationUserIds(userId, stream);
//		Set<String> set = correlationUser.getCorrelationUserIds(userId);
//		return new ArrayList<>(set);
	}
}
