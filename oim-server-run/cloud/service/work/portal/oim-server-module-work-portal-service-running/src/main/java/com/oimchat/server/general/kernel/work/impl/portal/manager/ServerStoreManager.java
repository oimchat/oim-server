package com.oimchat.server.general.kernel.work.impl.portal.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.common.api.inside.common.data.ServerConfigData;
import com.oimchat.server.general.kernel.work.module.base.portal.dao.ServerAddressDAO;
import com.oimchat.server.general.kernel.work.module.base.portal.dao.ServerTypeDAO;
import com.oimchat.server.general.kernel.work.module.base.portal.data.ServerAddressData;
import com.oimchat.server.general.kernel.work.module.base.portal.entity.ServerAddress;
import com.oimchat.server.general.kernel.work.module.base.portal.entity.ServerType;
import com.onlyxiahui.aware.basic.work.type.lang.BooleanEnum;

/**
 * Date 2019-01-15 22:10:39<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class ServerStoreManager {
	@Resource
	private ServerTypeDAO serverTypeDAO;
	@Resource
	private ServerAddressDAO serverAddressDAO;

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
	public List<ServerConfigData> getServerDataList() {
		List<ServerConfigData> list = new ArrayList<>();
		List<ServerType> serverTypelist = serverTypeDAO.getAllList();
		List<ServerAddress> serverAddresslist = serverAddressDAO.getAllList();

		// host List<ServerAddressData>
		Map<String, List<ServerAddressData>> map = new HashMap<>();
		for (ServerAddress sa : serverAddresslist) {
			boolean enabled = BooleanEnum.TRUE.isEquals(sa.getIsEnabled());
			if (enabled) {
				String host = sa.getHost();

				String serverTypeCode = sa.getServerTypeCode();
				String addressType = sa.getAddressType();
				String protocol = sa.getProtocol();
				String address = sa.getAddress();
				Integer port = sa.getPort();

				ServerAddressData data = new ServerAddressData();
				data.setAddress(address);
				data.setAddressType(addressType);
				data.setEnabled(enabled);
				data.setPort(port);
				data.setProtocol(protocol);
				data.setServerTypeCode(serverTypeCode);

				List<ServerAddressData> addAddress = map.get(host);
				if (null == addAddress) {
					addAddress = new ArrayList<>();
					map.put(host, addAddress);
				}
				addAddress.add(data);
			}
		}

		Map<String, ServerType> serverTypeMap = new HashMap<>();
		for (ServerType st : serverTypelist) {
			String code = st.getCode();
			serverTypeMap.put(code, st);
		}

		Map<String, ServerConfigData> serverConfigDataMap = new HashMap<>();

		for (Map.Entry<String, List<ServerAddressData>> e : map.entrySet()) {
			String host = e.getKey();
			List<ServerAddressData> addAddress = e.getValue();
			if (null != addAddress) {
				for (ServerAddressData d : addAddress) {
					String serverTypeCode = d.getServerTypeCode();
					String key = host + "_" + serverTypeCode;
					ServerConfigData scd = serverConfigDataMap.get(key);
					if (null == scd) {
						scd = new ServerConfigData();
						ServerType st = serverTypeMap.get(serverTypeCode);
						if (null != st) {
							scd.setAddresses(new ArrayList<>());
							boolean enabled = BooleanEnum.TRUE.isEquals(st.getIsEnabled());
							scd.setName(st.getName());
							scd.setCode(st.getCode());
							scd.setDescription(st.getDescription());
							scd.setEnabled(enabled);
						} else {
							scd.setName("");
							scd.setCode(serverTypeCode);
							scd.setDescription("");
							scd.setEnabled(true);
						}
						serverConfigDataMap.put(key, scd);
					}
					scd.addAddress(d);
				}
			}
		}
		list.addAll(serverConfigDataMap.values());
		return list;
	}
}
