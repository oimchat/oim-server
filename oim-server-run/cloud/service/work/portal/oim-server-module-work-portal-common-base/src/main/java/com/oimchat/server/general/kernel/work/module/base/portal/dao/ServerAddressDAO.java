package com.oimchat.server.general.kernel.work.module.base.portal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.portal.entity.ServerAddress;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;

/**
 * Date 2019-01-15 21:55:29<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class ServerAddressDAO extends BaseDAO {

	public ServerAddress get(String id) {
		return this.get(ServerAddress.class, id);
	}

	public List<ServerAddress> getAllList() {
		QueryWrapper queryWrapper = new QueryWrapper();
		StringBuilder sb = new StringBuilder();
		sb.append(" from ");
		sb.append(ServerAddress.class.getName());
		return this.queryListByHql(sb.toString(), queryWrapper, ServerAddress.class);
	}

	/**
	 * Date 2019-01-15 22:04:31<br>
	 * Description 根据服务id（serverId）获取地址
	 * 
	 * @author XiaHui<br>
	 * @param serverId
	 * @return
	 * @since 1.0.0
	 */
	public List<ServerAddress> getListByServerTypeCode(String serverTypeCode) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("serverTypeCode", serverTypeCode);
		StringBuilder sb = new StringBuilder();
		sb.append("select sd from ");
		sb.append(ServerAddress.class.getName());
		sb.append(" sd ");
		sb.append("where serverTypeCode=:serverTypeCode ");
		String hql = " from " + ServerAddress.class.getName();
		return this.queryListByHql(hql, queryWrapper, ServerAddress.class);
	}
}
