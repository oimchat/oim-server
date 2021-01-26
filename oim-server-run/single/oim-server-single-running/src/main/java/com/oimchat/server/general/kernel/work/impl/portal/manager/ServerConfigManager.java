package com.oimchat.server.general.kernel.work.impl.portal.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.module.base.portal.data.ServerData;
import com.oimchat.server.run.g.ServerDataProperties;

/**
 * Date 2019-01-15 22:10:39<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class ServerConfigManager {

	@Autowired
	ServerDataProperties serverDataProperties;

	/**
	 * 
	 * Date 2019-01-15 22:19:51<br>
	 * Description 获取服务端信息列表
	 * 
	 * @author XiaHui<br>
	 * @return
	 * @since 1.0.0
	 */
	public List<ServerData> getServerDataList() {
		List<ServerData> list = serverDataProperties.getServerInfos();
		return list;
	}
}
