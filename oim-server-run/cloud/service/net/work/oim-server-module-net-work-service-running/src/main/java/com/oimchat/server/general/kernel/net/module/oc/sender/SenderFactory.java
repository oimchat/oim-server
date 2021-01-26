package com.oimchat.server.general.kernel.net.module.oc.sender;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.core.net.NetContext;
import com.oimchat.core.net.sender.builder.SendBuilder;

/**
 * Description <br>
 * Date 2021-01-13 17:36:29<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class SenderFactory {

	SendBuilder builder = new SendBuilder();
	Map<Class<?>, Object> map = new HashMap<>();

	@Autowired
	NetContext netContext;

	@PostConstruct
	private void afterPropertiesSet() {
		builder.setDataSendHandler((k, d, b) -> {
			netContext.getNetHandler().send(k, d, b);
		});
	}

	@SuppressWarnings("unchecked")
	public <T> T getObject(Class<T> type) {
		Object object = map.get(type);
		if (null == object) {
			object = builder.newInstance(type);
			map.put(type, object);
		}
		return (T) object;
	}
}
