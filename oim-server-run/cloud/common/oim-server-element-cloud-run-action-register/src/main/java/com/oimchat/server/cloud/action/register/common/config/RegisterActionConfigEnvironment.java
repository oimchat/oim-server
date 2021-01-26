package com.oimchat.server.cloud.action.register.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 
 * <br>
 * Date 2020-01-02 15:09:09<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class RegisterActionConfigEnvironment {

	@Autowired
	private Environment environment;

	private String serviceKey = "spring.application.name";

	public String getServiceName() {
		return environment.getProperty(serviceKey);
	}
}
