package com.oimchat.server.general.common.api.inside.work.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.UserSimple;
import com.onlyxiahui.aware.extend.spring.cloud.feign.codec.FeignConfiguration;
import com.onlyxiahui.common.data.common.value.MessageValue;

@FeignClient(contextId = "userDataClient", name = "work-core", fallback = UserDataClientHystrix.class, configuration = FeignConfiguration.class)
public interface UserDataClient {

	@PostMapping(value = "/v1/user/user.data/get.by.id", consumes = "application/json;charset=UTF-8")
	MessageValue<UserSimple> getUserSimpleById(@PathVariable("id") String id);

}
