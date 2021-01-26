package com.oimchat.server.general.common.api.inside.net.control.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.oimchat.server.general.common.api.inside.net.control.data.NetControl;
import com.onlyxiahui.aware.extend.spring.cloud.feign.codec.FeignConfiguration;
import com.onlyxiahui.common.data.common.value.MessageValue;

@FeignClient(contextId = "NetControlPortalClient", name = "net-control", fallback = NetControlPortalHystrix.class, configuration = FeignConfiguration.class)
public interface NetControlPortalClient {

	@PostMapping(value = "/v1/portal/server/get.config", consumes = "application/json;charset=UTF-8")
	MessageValue<NetControl> config(@PathVariable("type") String type);

}
