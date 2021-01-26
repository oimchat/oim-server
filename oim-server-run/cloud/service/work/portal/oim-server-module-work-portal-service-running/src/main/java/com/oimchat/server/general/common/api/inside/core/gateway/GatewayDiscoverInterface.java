package com.oimchat.server.general.common.api.inside.core.gateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import com.netflix.loadbalancer.IRule;
import com.oimchat.server.general.common.api.inside.common.data.ServerConfigData;
import com.oimchat.server.general.kernel.work.common.config.constant.ServerConstant;
import com.oimchat.server.general.kernel.work.module.base.portal.data.ServerAddressData;
import com.onlyxiahui.aware.basic.work.type.net.AddressType;
import com.onlyxiahui.aware.basic.work.type.net.Protocol;

/**
 * Description <br>
 * Date 2020-05-18 10:15:07<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class GatewayDiscoverInterface {

	protected final Logger log = LogManager.getLogger(this.getClass());

	@Autowired
	DiscoveryClient discoveryClient;

	@Autowired
	IRule robinRule;

	Random r = new Random();

	public ServiceInstance getService() {
		String service = "core-gateway";
		ServiceInstance instance = null;
		List<ServiceInstance> instances = discoveryClient.getInstances(service);
		if (null != instances && !instances.isEmpty()) {
			int size = instances.size();
			if (size > 1) {
				instance = instances.get(r.nextInt(size));
			} else {
				instance = instances.get(0);
			}
		}
		return instance;
	}

	public ServerConfigData getServerConfigData() {

		// RoundRobinRule roundRobinRule;
//		String key = "lb://core-gateway";
		ServerConfigData scd = null;
		try {
			ServiceInstance server = getService();
			if (null != server) {
				scd = new ServerConfigData();

				// Server server = robinRule.choose(key);// robinRule.chooseServer(key);//
				String url = "http://" + server.getHost() + ":" + server.getPort();
				ServerAddressData sa = new ServerAddressData();
				sa.setProtocol(Protocol.HTTP.value());
				sa.setAddressType(AddressType.URL.value());
				sa.setEnabled(true);
				sa.setAddress(url);
				sa.setPort(server.getPort());

				List<ServerAddressData> addresses = new ArrayList<>();
				addresses.add(sa);

				String main = (ServerConstant.ServerType.main.value());
				scd.setCode(main);
				scd.setEnabled(true);
				scd.setAddresses(addresses);
				scd.setHost(server.getHost());
			}
		} catch (Exception e) {
			log.error("", e);
		}
		return scd;
	}
}
