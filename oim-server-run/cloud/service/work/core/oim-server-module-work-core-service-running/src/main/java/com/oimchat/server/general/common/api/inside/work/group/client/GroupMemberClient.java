package com.oimchat.server.general.common.api.inside.work.group.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.oimchat.server.general.common.api.inside.work.group.bean.GroupMember;
import com.oimchat.server.general.common.api.inside.work.group.bean.GroupMemberQuery;
import com.onlyxiahui.aware.extend.spring.cloud.feign.codec.FeignConfiguration;
import com.onlyxiahui.common.data.common.data.ListPageBody;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.value.MessageValue;

@FeignClient(contextId = "groupMemberClient", name = "work-group", fallback = GroupMemberClientHystrix.class, configuration = FeignConfiguration.class)
public interface GroupMemberClient {

	@PostMapping(value = "/v1/group/group.member/list", consumes = "application/json;charset=UTF-8")
	MessageValue<ListPageBody<List<GroupMember>>> list(
			@PathVariable("query") GroupMemberQuery query,
			@PathVariable("page") Page page);

	@PostMapping(value = "/v1/group/group.member/list.by.group.id", consumes = "application/json;charset=UTF-8")
	MessageValue<List<GroupMember>> getListByGroupId(@PathVariable("groupId") String groupId);

	@PostMapping(value = "/v1/group/group.member/list.by.user.id", consumes = "application/json;charset=UTF-8")
	MessageValue<List<GroupMember>> getListByUserId(@PathVariable("userId") String userId);

}
