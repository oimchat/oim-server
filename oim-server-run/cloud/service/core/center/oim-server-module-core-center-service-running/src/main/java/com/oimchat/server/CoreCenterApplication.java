package com.oimchat.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * Description <br>
 * Date 2019-07-07 17:00:09<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class CoreCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreCenterApplication.class, args);
	}
}
