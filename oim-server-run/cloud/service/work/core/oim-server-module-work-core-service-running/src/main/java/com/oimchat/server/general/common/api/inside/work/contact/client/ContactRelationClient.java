package com.oimchat.server.general.common.api.inside.work.contact.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.oimchat.server.general.common.api.inside.work.contact.bean.ContactRelation;
import com.onlyxiahui.aware.extend.spring.cloud.feign.codec.FeignConfiguration;
import com.onlyxiahui.common.data.common.value.MessageValue;

@FeignClient(contextId = "ContactRelationClient", name = "work-contact", fallback = ContactRelationHystrix.class, configuration = FeignConfiguration.class)
public interface ContactRelationClient {

	@PostMapping(value = "/v1/contact/contact.relation/list.by.user.id", consumes = "application/json;charset=UTF-8")
	MessageValue<List<ContactRelation>> getListByUserId(@PathVariable("userId") String userId);

}
