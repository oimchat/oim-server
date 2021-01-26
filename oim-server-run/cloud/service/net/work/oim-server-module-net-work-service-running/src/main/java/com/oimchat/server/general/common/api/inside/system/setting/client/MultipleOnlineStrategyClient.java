package com.oimchat.server.general.common.api.inside.system.setting.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.oimchat.server.general.common.api.inside.system.setting.bean.MultipleCheck;
import com.onlyxiahui.aware.extend.spring.cloud.feign.codec.FeignConfiguration;
import com.onlyxiahui.common.data.common.value.MessageValue;

@FeignClient(contextId = "multipleOnlineStrategyClient", name = "system-setting", fallback = MultipleOnlineStrategyClientHystrix.class, configuration = FeignConfiguration.class)
public interface MultipleOnlineStrategyClient {

	@PostMapping(value = "/v1/setting/multiple.online.strategy/multiple.check", consumes = "application/json;charset=UTF-8")
	MessageValue<MultipleCheck> multipleCheck(@PathVariable("type") String type);

}
