package com.oimchat.server.general.common.api.inside.work.group.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlyxiahui.aware.extend.spring.cloud.feign.codec.FeignConfiguration;
import com.onlyxiahui.common.data.common.value.MessageValue;

@FeignClient(contextId = "groupCategoryClient", name = "work-group", fallback = GroupCategoryClientHystrix.class, configuration = FeignConfiguration.class)
public interface GroupCategoryClient {

	@PostMapping(value = "/v1/group/group.category/save.default", consumes = "application/json;charset=UTF-8")
	MessageValue<Object> saveDefault(@PathVariable("userId") String userId);

}
