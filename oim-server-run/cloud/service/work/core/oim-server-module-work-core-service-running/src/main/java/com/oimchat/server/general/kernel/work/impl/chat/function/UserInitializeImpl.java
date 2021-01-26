
package com.oimchat.server.general.kernel.work.impl.chat.function;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.general.common.api.inside.work.contact.client.ContactCategoryClient;
import com.oimchat.server.general.common.api.inside.work.group.client.GroupCategoryClient;
import com.oimchat.server.general.kernel.work.define.user.function.UserInitialize;

/**
 * Description <br>
 * Date 2020-04-09 19:13:43<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class UserInitializeImpl implements UserInitialize {

	@Resource
	private ContactCategoryClient contactCategoryClient;
	@Resource
	private GroupCategoryClient groupCategoryClient;

	@Override
	public void initialize(String userId) {
		contactCategoryClient.saveDefault(userId);
		groupCategoryClient.saveDefault(userId);
	}
}
