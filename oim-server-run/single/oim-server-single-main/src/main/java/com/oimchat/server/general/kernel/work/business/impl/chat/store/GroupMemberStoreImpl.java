
package com.oimchat.server.general.kernel.work.business.impl.chat.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.general.kernel.work.define.chat.store.GroupMemberSimpleStream;
import com.oimchat.server.general.kernel.work.define.chat.store.GroupMemberStore;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.GroupMemberSimple;
import com.oimchat.server.general.kernel.work.module.base.group.dao.GroupMemberDAO;
import com.oimchat.server.general.kernel.work.module.base.group.data.query.GroupMemberQuery;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupMember;
import com.onlyxiahui.common.data.common.data.Page;

/**
 * Description <br>
 * Date 2020-04-16 20:52:55<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class GroupMemberStoreImpl implements GroupMemberStore {

	@Autowired
	GroupMemberDAO groupMemberDAO;

	@Override
	public int allByGroupId(String groupId, GroupMemberSimpleStream stream) {

		GroupMemberQuery query = new GroupMemberQuery();
		query.setGroupId(groupId);
		Page page = new Page();
		groupMemberDAO.queryList(query, page);

		int totalPage = page.getTotalPage();

		for (int i = 0; i < totalPage; i++) {
			page.setNumber(i + 1);
			List<GroupMember> list = groupMemberDAO.queryList(query, page);

			List<GroupMemberSimple> members = new ArrayList<>();
			for (GroupMember m : list) {
				GroupMemberSimple data = new GroupMemberSimple();
				BeanUtils.copyProperties(m, data);
				members.add(data);
			}
			stream.list(page, members);
		}
		return page.getTotalCount();
	}
}
