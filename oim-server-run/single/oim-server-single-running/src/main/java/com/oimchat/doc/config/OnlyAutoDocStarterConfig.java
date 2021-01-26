package com.oimchat.doc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * Description <br>
 * Date 2020-04-09 14:51:45<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Configuration
public class OnlyAutoDocStarterConfig {

	@Bean
	public OnlyDocumentConfigurerImpl onlyDocumentHandlerConfigurerImpl() {
		return new OnlyDocumentConfigurerImpl();
	}
}
