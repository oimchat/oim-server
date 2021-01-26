
package com.oimchat.server.general.kernel.work.impl.chat.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.general.common.api.inside.work.user.client.UserDataClient;
import com.oimchat.server.general.kernel.work.define.chat.store.UserDataStore;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.UserSimple;
import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * Description <br>
 * Date 2020-04-16 20:52:28<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class UserDataStoreImpl implements UserDataStore {

	@Autowired
	UserDataClient userDataClient;

	@Override
	public UserSimple getUserSimpleById(String id) {
		MessageValue<UserSimple> mv = userDataClient.getUserSimpleById(id);
		UserSimple u = mv.getBody();
		return u;
	}
}
