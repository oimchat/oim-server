
package com.oimchat.server.general.kernel.work.define.chat.store;

import java.util.List;

import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.GroupMemberSimple;
import com.onlyxiahui.common.data.common.data.Page;

/**
 * Description <br>
 * Date 2020-04-16 20:38:22<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public interface GroupMemberSimpleStream {

	void list(Page page, List<GroupMemberSimple> list);
}
