package com.oimchat.server.general.kernel.core.action.module.action.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.core.action.module.action.dao.ServerActionInfoDAO;
import com.oimchat.server.general.kernel.core.action.module.action.data.dto.ServerData;
import com.oimchat.server.general.kernel.core.action.module.action.entity.ServerActionInfo;
import com.oimchat.server.general.kernel.core.action.module.action.manager.ServerActionInfoExtendManager;

/**
 * 
 * 服务的Action信息<br>
 * Date 2020-11-08 18:55:40<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]
 * @since 1.0.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ServerActionInfoExtendService {

	@Autowired
	ServerActionInfoDAO serverActionInfoDAO;
	@Autowired
	ServerActionInfoExtendManager serverActionInfoExtendManager;

	public void register(ServerData serverData, List<ServerActionInfo> items) {
		if (null != serverData && null != items) {

			String serviceName = serverData.getServiceName();

			List<ServerActionInfo> existList = serverActionInfoExtendManager.getListByServiceName(serviceName);
			List<ServerActionInfo> addList = new ArrayList<>();
			List<ServerActionInfo> updateList = new ArrayList<>();
			List<ServerActionInfo> deleteList = new ArrayList<>();
			Set<String> allPublishServiceNames = new HashSet<>();

			Map<String, ServerActionInfo> map = existList.stream().collect(Collectors.toMap(ServerActionInfo::getKey, a -> a, (k1, k2) -> k1));

			for (ServerActionInfo v : items) {
				String key = v.getKey();
				v.setServiceName(serviceName);
				v.setServiceTitle(serverData.getServiceTitle());

				ServerActionInfo o = map.remove(key);
				if (null != o) {
					v.setId(o.getId());
					updateList.add(v);
				} else {
					addList.add(v);
				}
				allPublishServiceNames.add(key);
			}

			deleteList.addAll(map.values());

			for (ServerActionInfo v : deleteList) {
				serverActionInfoDAO.deleteById(v.getId());
			}

			for (ServerActionInfo v : updateList) {
				serverActionInfoExtendManager.updateSelective(v);
			}

			for (ServerActionInfo v : addList) {
				serverActionInfoExtendManager.add(v);
			}
		}
	}
}