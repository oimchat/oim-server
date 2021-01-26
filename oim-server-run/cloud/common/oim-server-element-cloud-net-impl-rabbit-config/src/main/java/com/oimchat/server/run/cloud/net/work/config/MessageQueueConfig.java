package com.oimchat.server.run.cloud.net.work.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 
 * Description <br>
 * Date 2019-07-09 17:18:09<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Configuration
public class MessageQueueConfig {
	


	@Autowired
	private Environment environment;

	/******************** init **********************/
	@Bean
	public ConnectionFactory rabbitConnectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setHost(environment.getProperty("rabbitmq.host"));
		connectionFactory.setPort(environment.getProperty("rabbitmq.port", Integer.class));
		connectionFactory.setVirtualHost(environment.getProperty("rabbitmq.virtual-host"));
		connectionFactory.setUsername(environment.getProperty("rabbitmq.username"));
		connectionFactory.setPassword(environment.getProperty("rabbitmq.password"));
		connectionFactory.setChannelCacheSize(environment.getProperty("rabbitmq.channel-cache-size", Integer.class));
		return connectionFactory;
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate bean = new RabbitTemplate();
		bean.setConnectionFactory(rabbitConnectionFactory());
		return bean;
	}

	@Bean
	public RabbitAdmin rabbitAdmin() {
		RabbitAdmin rabbitAdmin = new RabbitAdmin(rabbitConnectionFactory());
		// 只有设置为 true，spring 才会加载 RabbitAdmin 这个类
		// rabbitAdmin.setAutoStartup(true);
		return rabbitAdmin;
	}

	/******************** init **********************/
}
