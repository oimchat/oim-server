package com.oimchat.server.general.kernel.work.module.business.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.define.portal.ServerConfigBox;
import com.oimchat.server.general.kernel.work.module.base.portal.dao.ServerTypeDAO;
import com.oimchat.server.general.kernel.work.module.base.portal.data.ServerData;
import com.oimchat.server.general.kernel.work.module.base.portal.entity.ServerType;

/**
 * Date 2019-01-15 22:10:39<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class ServerService {

	@Autowired
	private ServerTypeDAO serverTypeDAO;
	@Autowired
	private ServerConfigBox serverConfigBox;

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
		List<ServerData> list = serverConfigBox.getServerList();
		return list;
	}

	public void saveOrUpdate(ServerType serverType) {
		serverTypeDAO.saveOrUpdate(serverType);
	}
}
