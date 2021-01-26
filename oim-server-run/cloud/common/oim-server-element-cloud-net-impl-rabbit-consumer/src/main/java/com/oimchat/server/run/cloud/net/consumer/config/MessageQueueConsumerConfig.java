package com.oimchat.server.run.cloud.net.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.oimchat.server.cloud.net.basic.bean.ServerInfo;
import com.oimchat.server.run.cloud.net.consumer.impl.mq.task.MessageConsumer;
import com.oimchat.server.run.cloud.net.work.config.MessageQueueConfig;
import com.oimchat.server.run.cloud.net.work.impl.mq.message.MessageQueue;
import com.onlyxiahui.common.utils.base.net.AddressUtil;

/**
 * 
 * Description <br>
 * Date 2019-07-09 17:18:09<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Configuration
public class MessageQueueConsumerConfig {

	@Autowired
	private Environment environment;

	@Bean
	public ServerInfo serverInfo() {
		String key = "server.port";
		String portValue = environment.getProperty(key);

		String mac = AddressUtil.getLocalIpV4();
		String id = mac + ":" + (portValue == null || portValue.isEmpty() ? "8080" : portValue);

		ServerInfo bean = new ServerInfo();
		bean.setId(id);
		return bean;
	}

	@Autowired
	private MessageQueueConfig messageQueueConfig;

	/******************** direct **********************/
	@Bean
	public Queue messageDirectQueue() {
		ServerInfo info = serverInfo();
		Queue queue = new Queue(info.getId(), true, false, true);
		return queue;
	}

	@Bean
	public DirectExchange messageDirectExchange() {
		DirectExchange exchange = new DirectExchange(MessageQueue.MESSAGE_DIRECT, true, true);
//		ServerInfo info = serverInfo();

//		RabbitAdmin rabbitAdmin = rabbitAdmin();
//		rabbitAdmin.declareQueue(messageDirectQueue());
//		rabbitAdmin.declareExchange(messageDirectExchange());
//		rabbitAdmin.declareBinding(BindingBuilder.bind(messageDirectQueue()).to(messageDirectExchange()).with(info.getId()));
		return exchange;
	}

	@Bean
	public Binding messageDirectBinding() {
		ServerInfo info = serverInfo();
		Binding binding = BindingBuilder.bind(messageDirectQueue()).to(messageDirectExchange()).with(info.getId());
		return binding;
	}

	@Bean
	public SimpleMessageListenerContainer messageDirectListenerContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(messageQueueConfig.rabbitConnectionFactory());
		container.setMessageListener(messageDirectListenerAdapter());
		container.addQueues(messageDirectQueue());
		container.start();
		return container;
	}

	@Bean
	public MessageListenerAdapter messageDirectListenerAdapter() {
		MessageListenerAdapter adapter = new MessageListenerAdapter(messageConsumer());
		return adapter;
	}

	/******************** direct **********************/

	@Bean
	public MessageListener messageConsumer() {
		MessageConsumer consumer = (new MessageConsumer());
		return consumer;
	}

	/******************** fanout **********************/
	@Bean
	public Queue messageFanoutQueue() {
		ServerInfo info = serverInfo();
		Queue queue = new Queue(MessageQueue.MESSAGE_FANOUT_QUEUE + "." + info.getId(), true, false, true);
		return queue;
	}

	@Bean
	public FanoutExchange messageFanoutExchange() {
		FanoutExchange exchange = new FanoutExchange(MessageQueue.MESSAGE_FANOUT, true, true);
		return exchange;
	}

	@Bean
	public Binding messageFanoutBinding() {
		Binding binding = BindingBuilder.bind(messageFanoutQueue()).to(messageFanoutExchange());
		return binding;
	}

	@Bean
	public SimpleMessageListenerContainer messageFanoutListenerContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(messageQueueConfig.rabbitConnectionFactory());
		container.setMessageListener(messageFanoutListenerAdapter());
		container.addQueues(messageFanoutQueue());
		container.start();
		return container;
	}

	@Bean
	public MessageListenerAdapter messageFanoutListenerAdapter() {
		MessageListenerAdapter adapter = new MessageListenerAdapter(messageConsumer());
		return adapter;
	}

//	@Bean
//	public FanoutMessageConsumer fanoutMessageConsumer() {
//		FanoutMessageConsumer consumer = (new FanoutMessageConsumer());
//		return consumer;
//	}
	/******************** fanout **********************/
}
