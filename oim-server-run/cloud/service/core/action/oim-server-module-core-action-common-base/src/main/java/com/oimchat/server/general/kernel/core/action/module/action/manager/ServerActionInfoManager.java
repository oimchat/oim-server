package com.oimchat.server.general.kernel.core.action.module.action.manager;

import org.springframework.stereotype.Service;

import com.onlyxiahui.aware.basic.manager.BaseManager;

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
public class ServerActionInfoManager extends BaseManager<ServerActionInfo> {

	/**
	 * 根据id更新不为空的字段
	 * 
	 * @param data
	 * @since 1.0.0
	 */
	@Override
	public int updateSelective(ServerActionInfo data) {
		if (null != data) {
			data.setUpdatedTimestamp(System.currentTimeMillis());
		}
		return super.updateSelective(data);
	}

	/**
	 * 根据id删除<br>
	 * 
	 * @param id
	 * @param updatedUserId
	 * @since 1.0.0
	 */
	public int deleteById(String id, String updatedUserId) {
		ServerActionInfo data = new ServerActionInfo();
		data.setId(id);
		data.setIsDeleted(1);
		data.setUpdatedUserId(updatedUserId);
		data.setUpdatedTimestamp(System.currentTimeMillis());
		return this.updateSelective(data);
	}
}