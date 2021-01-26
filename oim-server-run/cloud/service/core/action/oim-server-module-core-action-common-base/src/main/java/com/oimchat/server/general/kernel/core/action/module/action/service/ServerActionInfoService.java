package com.oimchat.server.general.kernel.core.action.module.action.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlyxiahui.common.data.common.data.Page;

import com.oimchat.server.general.kernel.core.action.module.action.entity.ServerActionInfo;
import com.oimchat.server.general.kernel.core.action.module.action.data.query.ServerActionInfoQuery;
import com.oimchat.server.general.kernel.core.action.module.action.manager.ServerActionInfoManager;

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
public class ServerActionInfoService {

	@Autowired
	ServerActionInfoManager serverActionInfoManager;

	/**
	 * 添加<br>
	 * 
	 * @param data
	 * @since 1.0.0
	 */
	public void add(ServerActionInfo data) {
		serverActionInfoManager.add(data);
	}

	/**
	 * 修改<br>
	 * 
	 * @param data
	 * @return int
	 * @since 1.0.0
	 */
	public int update(ServerActionInfo data) {
		return serverActionInfoManager.updateSelective(data);
	}

	/**
	 * 根据id查询<br>
	 * 
	 * @param id
	 * @return ServerActionInfo
	 * @since 1.0.0
	 */
	public ServerActionInfo getById(String id) {
		return serverActionInfoManager.getById(id);
	}

	/**
	 * 根据id删除<br>
	 * 
	 * @param id
	 * @param updatedUserId
	 * @return int
	 * @since 1.0.0
	 */
	public int deleteById(String id, String updatedUserId) {
		int count = serverActionInfoManager.deleteById(id, updatedUserId);
		return count;
	}

	/**
	 * 分页查询 <br>
	 * 
	 * @param page
	 * @param query
	 * @return List<ServerActionInfo>
	 * @since 1.0.0
	 */
	public List<ServerActionInfo> queryList(Page page, ServerActionInfoQuery query) {
		return serverActionInfoManager.queryList(page, query);
	}
}