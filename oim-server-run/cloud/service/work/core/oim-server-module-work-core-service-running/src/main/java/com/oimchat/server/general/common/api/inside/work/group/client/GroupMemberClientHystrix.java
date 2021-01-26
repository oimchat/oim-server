
package com.oimchat.server.general.common.api.inside.work.group.client;

import java.util.ArrayList;
import java.util.List;

import com.oimchat.server.general.common.api.inside.work.group.bean.GroupMember;
import com.oimchat.server.general.common.api.inside.work.group.bean.GroupMemberQuery;
import com.onlyxiahui.common.data.common.data.ListPageBody;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * Description <br>
 * Date 2020-05-15 19:04:37<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class GroupMemberClientHystrix implements GroupMemberClient {

	@Override
	public MessageValue<ListPageBody<List<GroupMember>>> list(GroupMemberQuery query, Page page) {
		ListPageBody<List<GroupMember>> b = new ListPageBody<>(new Page(), new ArrayList<>());
		MessageValue<ListPageBody<List<GroupMember>>> mv = new MessageValue<>();
		mv.setBody(b);
		return mv;
	}

	@Override
	public MessageValue<List<GroupMember>> getListByGroupId(String groupId) {
		List<GroupMember> b = new ArrayList<>();
		MessageValue<List<GroupMember>> mv = new MessageValue<>();
		mv.setBody(b);
		return mv;
	}

	@Override
	public MessageValue<List<GroupMember>> getListByUserId(String userId) {
		List<GroupMember> b = new ArrayList<>();
		MessageValue<List<GroupMember>> mv = new MessageValue<>();
		mv.setBody(b);
		return mv;
	}
}
