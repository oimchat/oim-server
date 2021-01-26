package com.oimchat.server.general.kernel.work.module.manage.system.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.manage.system.entity.Function;
import com.onlyxiahui.aware.basic.dao.BaseEntityDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;

/**
 * 
 * date 2018-07-04 17:01:47<br>
 * description
 * 
 * @author XiaHui<br>
 * @since
 */
@Repository
public class FunctionDAO extends BaseEntityDAO<Function> {

	String namespace = "system.function";

	public int getMaxSortBySuperId(String superId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("entityName", this.getEntityName());
		queryWrapper.addParameter("superId", superId);
		Integer maxSort = this.queryObjectByName(namespace + ".getMaxSortBySuperId", queryWrapper, Integer.class);
		return (null == maxSort) ? -1 : maxSort;
	}

	public int updateSuperId(String id, String superId) {
		QueryWrapper map = new QueryWrapper();
		map.put("entityName", this.getEntityName());
		map.put("id", id);
		map.put("superId", superId);
		int i = this.executeByName(namespace + ".updateSuperId", map);
		return i;
	}

	public int updateSort(String id, int sort) {
		QueryWrapper map = new QueryWrapper();
		map.put("entityName", this.getEntityName());
		map.put("id", id);
		map.put("sort", sort);
		int i = this.executeByName(namespace + ".updateSort", map);
		return i;
	}

	public List<Function> getListByIds(List<String> ids) {
		if (null == ids || ids.isEmpty()) {
			return new ArrayList<>();
		}
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("entityName", this.getEntityName());
		queryWrapper.addParameter("ids", ids);
		List<Function> functionList = this.queryListByName(namespace + ".queryList", queryWrapper, Function.class);
		return functionList;
	}

	/**
	 * 获取所有菜单的实体信息
	 * 
	 * @return
	 */
	public List<Function> allList() {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("entityName", this.getEntityName());
		queryWrapper.put("orderBy", " order by sort ");
		List<Function> functionList = this.queryListByName(namespace + ".queryList", queryWrapper, Function.class);
		return functionList;
	}

	public List<Function> getListBySuperId(String superId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("entityName", this.getEntityName());
		queryWrapper.put("superId", superId);
		queryWrapper.put("orderBy", " order by sort ");
		List<Function> functionList = this.queryListByName(namespace + ".queryList", queryWrapper, Function.class);
		return functionList;
	}
}
