package com.oimchat.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * 
 * Description <br>
 * Date 2020-05-15 09:18:06<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@EnableAdminServer
@SpringBootApplication
@EnableDiscoveryClient
public class CoreAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreAdminApplication.class, args);
	}
}
