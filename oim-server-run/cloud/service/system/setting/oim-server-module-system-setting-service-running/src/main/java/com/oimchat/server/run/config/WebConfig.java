package com.oimchat.server.run.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.accept.HeaderContentTypeResolver;
import org.springframework.web.reactive.accept.RequestedContentTypeResolver;

/**
 * Description <br>
 * Date 2020-05-15 11:13:11<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Configuration
@ConditionalOnMissingBean({ RequestedContentTypeResolver.class })
public class WebConfig {

	@Bean
	RequestedContentTypeResolver requestedContentTypeResolver() {
		RequestedContentTypeResolver b = new HeaderContentTypeResolver();
		return b;
	}
}
