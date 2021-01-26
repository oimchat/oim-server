package com.oimchat.server.cloud.action.register.common.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.oimchat.server.cloud.action.register.config.RegisterActionProperties;

/**
 * 
 * 
 * <br>
 * Date 2020-01-02 15:22:16<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Configuration
@ComponentScan("com.oimchat.server.cloud.action.register")
@EnableConfigurationProperties(RegisterActionProperties.class)
public class RegisterActionStarterAutoConfig {
}
