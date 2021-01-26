package com.oimchat.server.general.common.api.inside.work.contact.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlyxiahui.aware.extend.spring.cloud.feign.codec.FeignConfiguration;
import com.onlyxiahui.common.data.common.value.MessageValue;

@FeignClient(contextId = "ContactCategoryClient", name = "work-contact", fallback = ContactCategoryHystrix.class, configuration = FeignConfiguration.class)
public interface ContactCategoryClient {

	@PostMapping(value = "/v1/contact/contact.category/save.default", consumes = "application/json;charset=UTF-8")
	MessageValue<Object> saveDefault(@PathVariable("userId") String userId);

}
