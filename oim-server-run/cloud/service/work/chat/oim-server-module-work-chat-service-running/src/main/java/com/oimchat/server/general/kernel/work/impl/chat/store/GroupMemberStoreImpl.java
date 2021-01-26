
package com.oimchat.server.general.kernel.work.impl.chat.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.general.common.api.inside.work.group.bean.GroupMember;
import com.oimchat.server.general.common.api.inside.work.group.bean.GroupMemberQuery;
import com.oimchat.server.general.common.api.inside.work.group.client.GroupMemberClient;
import com.oimchat.server.general.kernel.work.define.chat.store.GroupMemberSimpleStream;
import com.oimchat.server.general.kernel.work.define.chat.store.GroupMemberStore;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.GroupMemberSimple;
import com.onlyxiahui.common.data.common.data.ListPageBody;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.value.MessageValue;

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
	GroupMemberClient groupMemberClient;

	@Override
	public int allByGroupId(String groupId, GroupMemberSimpleStream stream) {
		int pageNumber = 2;
		int totalPage = 1;
		int totalCount = 0;
		Page logisticsInfoPage = new Page();
		logisticsInfoPage.setSize(30);

		GroupMemberQuery query = new GroupMemberQuery();
		query.setGroupId(groupId);

		MessageValue<ListPageBody<List<GroupMember>>> mv = groupMemberClient.list(query, logisticsInfoPage);

		if (mv != null) {
			ListPageBody<List<GroupMember>> pb = mv.getBody();
			if (null != pb) {
				Page page = pb.getPage();
				if (null != page) {
					// 获取总的页数
					totalPage = page.getTotalPage();
					totalCount = page.getTotalCount();
					List<GroupMember> list = pb.getItems();
					if (null != list && null != stream) {
						List<GroupMemberSimple> members = new ArrayList<>();
						for (GroupMember m : list) {
							GroupMemberSimple data = new GroupMemberSimple();
							BeanUtils.copyProperties(m, data);
							members.add(data);
						}
						stream.list(page, members);
					}
				}
			}

			for (; pageNumber <= totalPage; pageNumber++) {
				logisticsInfoPage.setNumber(pageNumber);
				mv = groupMemberClient.list(query, logisticsInfoPage);
				if (mv != null) {
					pb = mv.getBody();
					if (null != pb) {
						Page page = pb.getPage();
						List<GroupMember> list = pb.getItems();
						if (null != list && null != stream) {
							List<GroupMemberSimple> members = new ArrayList<>();
							for (GroupMember m : list) {
								GroupMemberSimple data = new GroupMemberSimple();
								BeanUtils.copyProperties(m, data);
								members.add(data);
							}
							stream.list(page, members);
						}
					}
				}
			}
		}
		return totalCount;
	}
}
