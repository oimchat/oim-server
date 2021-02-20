package com.oimchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.onlyxiahui.aware.basic.extend.spring.context.annotation.AnnotationBeanFullNameGenerator;
import com.onlyxiahui.wofa.server.net.push.starter.EnableDataPush;

@EnableTransactionManagement
@SpringBootApplication(exclude = {
		DruidDataSourceAutoConfigure.class })
@EnableDataPush
@ComponentScan(nameGenerator = AnnotationBeanFullNameGenerator.class)
public class SingleApplication {
	public static void main(String[] args) {
		SpringApplication.run(SingleApplication.class, args);
	}
}
