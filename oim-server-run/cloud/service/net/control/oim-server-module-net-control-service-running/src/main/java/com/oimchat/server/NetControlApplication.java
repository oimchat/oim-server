package com.oimchat.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 * Description <br>
 * Date 2019-07-07 17:00:09<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class NetControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetControlApplication.class, args);
	}
}
