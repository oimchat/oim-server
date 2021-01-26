package com.oimchat.server.general.kernel.core.action.module.action.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlyxiahui.aware.basic.manager.BaseManager;
import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import com.oimchat.server.general.kernel.core.action.module.action.dao.ServerActionInfoDAO;
import com.oimchat.server.general.kernel.core.action.module.action.data.query.ServerActionInfoQuery;
import com.oimchat.server.general.kernel.core.action.module.action.entity.ServerActionInfo;

/**
 * 
 * 服务的Action信息<br>
 * Date 2020-11-08 18:55:40<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]
 * @since 1.0.0
 */
@Service
public class ServerActionInfoExtendManager extends BaseManager<ServerActionInfo> {

	@Autowired
	ServerActionInfoDAO serverActionInfoDAO;

	public List<ServerActionInfo> getListByServiceName(String serviceName) {
		List<ServerActionInfo> list = new ArrayList<>();
		if (StringUtil.isNotBlank(serviceName)) {
			ServerActionInfoQuery query = new ServerActionInfoQuery();
			query.setServiceName(serviceName);
			list = serverActionInfoDAO.list(query);
		}
		return list;
	}
}