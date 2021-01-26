
package com.oimchat.server.general.kernel.work.define.chat.store;

/**
 * Description <br>
 * Date 2020-04-16 20:37:19<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public interface GroupMemberStore {

	public int allByGroupId(String groupId, GroupMemberSimpleStream stream);
}
