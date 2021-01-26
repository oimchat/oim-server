package com.oimchat.server.cloud.action.register.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * <br>
 * Date 2020-07-22 18:03:34<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "system.action.register")
public class RegisterActionProperties {

	private String[] actionPackages;

	public String[] getActionPackages() {
		return actionPackages;
	}

	public void setActionPackages(String[] actionPackages) {
		this.actionPackages = actionPackages;
	}
}
