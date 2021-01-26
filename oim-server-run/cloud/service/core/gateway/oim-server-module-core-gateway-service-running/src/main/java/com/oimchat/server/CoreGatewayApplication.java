package com.oimchat.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 
 * 
 * <br>
 * Date 2019-09-04 11:48:58<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@EnableHystrix
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class CoreGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreGatewayApplication.class, args);
	}
}
