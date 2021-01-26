package com.oimchat.server.general.kernel.work.module.manage.system.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.manage.system.dao.FunctionDAO;
import com.oimchat.server.general.kernel.work.module.manage.system.data.FunctionQuery;
import com.oimchat.server.general.kernel.work.module.manage.system.entity.Function;

/**
 * date 2018-06-04 17:20:12<br>
 * description
 * 
 * @author XiaHui<br>
 * @since
 */
@Service
public class FunctionService {

	@Resource
	FunctionDAO functionDAO;

	public List<Function> getAllList() {
		return functionDAO.allList();
	}

	/**
	 * 修改菜单状态 <br>
	 * date 2018-07-12 11:11:35<br>
	 * description
	 * 
	 * @author XiaHui<br>
	 * @param id
	 * @param flag
	 * @return
	 * @since
	 */
	public boolean updateIsDisable(String id, Integer isDisable) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("isDisable", isDisable);
		int count = functionDAO.updateSelective(map);
		return count > 0;
	}

	/**
	 * date 2018-07-12 11:29:19<br>
	 * description 条件获取菜单
	 * 
	 * @author XiaHui<br>
	 * @param query
	 * @return
	 * @since
	 */
	public List<Function> list(FunctionQuery query) {
		List<Function> list = functionDAO.list(query);
		return list;
	}

	@Transactional
	public void saveOrUpdate(String serviceId, List<Function> list) {

		List<Function> deleteList = new ArrayList<>();
		List<Function> updateList = new ArrayList<>();
		List<Function> addList = new ArrayList<>();
		List<Function> dbList = getAllList();

		Map<String, Function> dbMap = getFunctionMap(dbList);
		if (null != list) {

			for (Function m : list) {
				m.setService(serviceId);
				String id = m.getId();
				Function menu = dbMap.remove(id);
				if (null == menu) {
					addList.add(m);
				} else {
//					menu.setSuperId(m.getSuperId());
//					menu.setName(m.getName());
					if (null == m.getSuperId()) {
						m.setSuperId("");
					}
					updateList.add(m);
				}
			}
		}

		deleteList.addAll(dbMap.values());

		if (!addList.isEmpty()) {
			for (Function menu : addList) {
				functionDAO.save(menu);
			}
		}

		if (!updateList.isEmpty()) {
			for (Function menu : updateList) {
				functionDAO.updateSelective(menu);
			}
		}

		if (!deleteList.isEmpty()) {
			for (Function menu : deleteList) {
				functionDAO.deleteById(menu.getId());
			}
		}
	}

	private Map<String, Function> getFunctionMap(List<Function> list) {
		Map<String, Function> map = new HashMap<String, Function>();
		for (Function menu : list) {
			map.put(menu.getId(), menu);
		}
		return map;
	}
}
