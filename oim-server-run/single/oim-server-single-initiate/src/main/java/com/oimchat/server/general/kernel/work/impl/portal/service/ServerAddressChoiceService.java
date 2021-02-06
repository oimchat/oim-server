package com.oimchat.server.general.kernel.work.impl.portal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.impl.portal.manager.ServerAutoDiscoverManager;
import com.oimchat.server.general.kernel.work.impl.portal.manager.ServerConfigManager;
import com.oimchat.server.general.kernel.work.impl.portal.manager.ServerStoreManager;
import com.oimchat.server.general.kernel.work.module.base.portal.data.ServerAddressData;
import com.oimchat.server.general.kernel.work.module.base.portal.data.ServerData;

/**
 * Date 2019-01-15 22:10:39<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class ServerAddressChoiceService {

	@Autowired
	ServerStoreManager serverStoreManager;
	@Autowired
	ServerAutoDiscoverManager serverAutoDiscoverManager;
	@Autowired
	ServerConfigManager serverConfigManager;

	Random r = new Random();

	/**
	 * 
	 * Date 2019-01-15 22:19:51<br>
	 * Description 获取服务端信息列表
	 * 
	 * @author XiaHui<br>
	 * @return
	 * @since 1.0.0
	 */
	@Transactional(readOnly = true)
	public List<ServerData> getServerDataList() {
		List<ServerData> list = new ArrayList<>();
		// 数据库的配置
		List<ServerData> storeList = serverStoreManager.getServerDataList();
		// 配置文件的配置
		List<ServerData> configList = serverConfigManager.getServerDataList();
		// 自动发现
		List<ServerData> discoverList = serverAutoDiscoverManager.getServerDataList();

		if (null == storeList) {
			storeList = new ArrayList<>();
		}
		if (null == configList) {
			configList = new ArrayList<>();
		}
		if (null == discoverList) {
			discoverList = new ArrayList<>();
		}

		// host + "_" + serverTypeCode;
		Map<String, ServerData> serverConfigDataMap = new HashMap<>();

		for (ServerData scd : storeList) {
			String host = "";
			String serverTypeCode = scd.getCode();
			String key = host + "_" + serverTypeCode;

			serverConfigDataMap.put(key, scd);
		}

//		for (ServerData source : configList) {
//			String host = source.getHost();
//			String serverTypeCode = source.getCode();
//			String key = host + "_" + serverTypeCode;
//			
//			ServerData serverConfigDataMap.get(key);
//			
//			if (!serverConfigDataMap.containsKey(key)) {
//				serverConfigDataMap.put(key, scd);
//			}else {
//				serverAutoDiscoverManager.choiceCombine(scd, scd);
//			}
//		}

		for (ServerData scd : configList) {
			String host = "";
			String serverTypeCode = scd.getCode();
			String key = host + "_" + serverTypeCode;
			if (!serverConfigDataMap.containsKey(key)) {
				serverConfigDataMap.put(key, scd);
			}
		}

		for (ServerData s : discoverList) {
			String host = "";
			String serverTypeCode = s.getCode();
			String key = host + "_" + serverTypeCode;

			ServerData t = serverConfigDataMap.get(key);
			if (null == t) {
				serverConfigDataMap.put(key, s);
			} else {
				List<ServerAddressData> addresses = combine(s.getAddresses(), t.getAddresses());
				t.setAddresses(addresses);
			}
		}

		Map<String, ServerData> codeMap = new HashMap<>();
		for (ServerData source : serverConfigDataMap.values()) {
			String serverTypeCode = source.getCode();
			ServerData target = codeMap.get(serverTypeCode);
			if (null != target) {
				combine(target, source.getAddresses());
			} else {
				codeMap.put(serverTypeCode, source);
			}
		}
		list.addAll(codeMap.values());

		for (ServerData scd : list) {
			Map<String, List<ServerAddressData>> typeMap = new HashMap<>();
			List<ServerAddressData> addresses = scd.getAddresses();
			if (null != addresses) {
				for (ServerAddressData sd : addresses) {
					String key = sd.getAddressType() + "_" + sd.getProtocol();
					List<ServerAddressData> types = typeMap.get(key);
					if (null == types) {
						types = new ArrayList<>();
						typeMap.put(key, types);
					}
					types.add(sd);
				}
				scd.getAddresses().clear();
				typeMap.values().forEach(types -> {
					if (null != types) {
						int size = types.size();
						int index = r.nextInt(size);
						ServerAddressData d = types.get(index);
						scd.addAddress(d);
					}
				});
			}
		}
		return list;
	}

	public void combine(ServerData target, List<ServerAddressData> addresses) {
		if (null != target && null != addresses) {
			if (null == target.getAddresses()) {
				target.setAddresses(new ArrayList<>());
			}
			target.getAddresses().addAll(addresses);
		}
	}

	public List<ServerAddressData> combine(List<ServerAddressData> sourceAddresses, List<ServerAddressData> targetAddresses) {
		List<ServerAddressData> list = new ArrayList<>();
		if (null != sourceAddresses && null != targetAddresses) {
			Map<String, ServerAddressData> typeMap = new HashMap<>();
			for (ServerAddressData sad : sourceAddresses) {
				String key = sad.getAddressType() + "_" + sad.getProtocol();
				typeMap.put(key, sad);
			}
			for (ServerAddressData sad : targetAddresses) {
				String key = sad.getAddressType() + "_" + sad.getProtocol();
				typeMap.put(key, sad);
			}
			list.addAll(typeMap.values());
		}
		return list;
	}
}
