package com.oimchat.server.general.common.api.inside.net.work.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.oimchat.server.general.common.api.inside.common.data.ServerConfigData;
import com.onlyxiahui.aware.extend.spring.cloud.feign.codec.FeignConfiguration;
import com.onlyxiahui.common.data.common.value.MessageValue;

@FeignClient(contextId = "serverConfigClient", name = "net-work", fallback = ServerConfigHystrix.class, configuration = FeignConfiguration.class)
public interface ServerConfigClient {

	@PostMapping(value = "/v1/config/server.config/get.data", consumes = "application/json;charset=UTF-8")
	MessageValue<ServerConfigData> get(@PathVariable("temp") String temp);

}
