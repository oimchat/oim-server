package com.oimchat.server.general.common.cloud.discovery;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

/**
 * Description <br>
 * Date 2021-01-13 17:17:51<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class DiscoveryBox {

	@Autowired
	private DiscoveryClient discoveryClient;

	public List<ServiceInstance> getServiceInstanceList(String service) {
		List<ServiceInstance> list = discoveryClient.getInstances(service);
		return null == list ? new ArrayList<>() : list;
	}
}
