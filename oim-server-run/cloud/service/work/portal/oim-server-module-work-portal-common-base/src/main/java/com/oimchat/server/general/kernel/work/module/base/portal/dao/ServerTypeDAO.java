package com.oimchat.server.general.kernel.work.module.base.portal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.portal.entity.ServerType;
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
public class ServerTypeDAO extends BaseDAO {

	public ServerType get(String id) {
		return this.get(ServerType.class, id);
	}

	public List<ServerType> getAllList() {
		QueryWrapper queryWrapper = new QueryWrapper();
		StringBuilder sb = new StringBuilder();
		sb.append(" from ");
		sb.append(ServerType.class.getName());
		return this.queryListByHql(sb.toString(), queryWrapper, ServerType.class);
	}
}
