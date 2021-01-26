
package com.oimchat.server.general.kernel.work.define.chat.store;

import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.UserSimple;

/**
 * Description <br>
 * Date 2020-04-16 20:33:12<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public interface UserDataStore {

	public UserSimple getUserSimpleById(String id);
}
