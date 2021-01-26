package com.oimchat.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;

/**
 * 
 * Description <br>
 * Date 2019-07-07 17:00:09<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

@EnableFeignClients
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication(exclude = {
		DruidDataSourceAutoConfigure.class })
public class WorkPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkPortalApplication.class, args);
	}
}
