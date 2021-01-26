package com.oimchat.server.cloud.action.discover.common.client;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.onlyxiahui.aware.extend.spring.cloud.feign.codec.DataDecoder;
import com.onlyxiahui.aware.extend.spring.cloud.feign.codec.DataEncoder;

import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.Target;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.hystrix.HystrixFeign;
import feign.hystrix.SetterFactory;

/**
 * 
 * <br>
 * Date 2019-07-25 19:41:46<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
@Import({ FeignClientsConfiguration.class })
public class DiscoverActionClientNameBuilder {

	private HystrixFeign.Builder nameBuilder;

	@Autowired
	public void initialize(Decoder decoder, Encoder encoder, Client client, Contract contract) {
		// nameBuilder直接使用client，它会使用负载均衡
//		commonClient = Feign.builder()
//				// .client(client)
//				.encoder(encoder)
//				.decoder(decoder)
//				.target(Target.EmptyTarget.create(CommonClient.class));
		// .contract(contract);

		// nameBuilder直接使用client，它会使用负载均衡
		// Feign.builder() 不启用Hystrix
		// 启用Hystrix

		encoder = new DataEncoder();
		decoder = new DataDecoder();
		nameBuilder = HystrixFeign.builder()
				.client(client)
				.encoder(encoder)
				.decoder(decoder)
				.contract(contract);
		// 重试4次
		nameBuilder.retryer(new Retryer.Default(100, 1000, 4));
		// 设置超时
		nameBuilder.options(new Request.Options());

		nameBuilder.setterFactory(new ClientSetterFactory());
	}

	public <T> T target(Class<T> apiType, String url, T fallback) {
		return nameBuilder.target(apiType, url, fallback);
	}

	public <T> T target(Class<T> apiType, String url) {
		return nameBuilder.target(apiType, url);
	}
	
	final class ClientSetterFactory implements SetterFactory {

		@Override
		public HystrixCommand.Setter create(Target<?> target, Method method) {
			String groupKey = target.name();
			String commandKey = Feign.configKey(target.type(), method);
			return HystrixCommand.Setter
					.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey))
					.andCommandKey(HystrixCommandKey.Factory.asKey(commandKey))
					.andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(10000));
		}
	}
}
