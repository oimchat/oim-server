package com.oimchat.server.general.kernel.system.module.setting.dao;

import org.springframework.stereotype.Repository;

import java.util.*;

import com.oimchat.server.general.kernel.system.module.setting.entity.MultipleOnlineStrategy;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;

/**
 * 描述：
 * 
 * @author XiaHui
 * @version 1.0.0
 */
@Repository
public class MultipleOnlineStrategyDAO extends BaseDAO {

	public List<MultipleOnlineStrategy> getByPlatform(String platform) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("platform", platform);
		StringBuilder sb = new StringBuilder();
		sb.append(" from ");
		sb.append(MultipleOnlineStrategy.class.getName());
		sb.append(" where platform=:platform");
		List<MultipleOnlineStrategy> list = this.queryListByHql(sb.toString(), queryWrapper, MultipleOnlineStrategy.class);
		return list;
	}

	public List<MultipleOnlineStrategy> getByType(String type) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("type", type);
		StringBuilder sb = new StringBuilder();
		sb.append(" from ");
		sb.append(MultipleOnlineStrategy.class.getName());
		sb.append(" where type=:type");
		List<MultipleOnlineStrategy> list = this.queryListByHql(sb.toString(), queryWrapper, MultipleOnlineStrategy.class);
		return list;
	}
}
