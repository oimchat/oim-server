package com.oimchat.server.cloud.action.discover.box;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.http.server.PathContainer;
import org.springframework.stereotype.Component;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

import com.oimchat.server.cloud.action.discover.data.ActionInfo;
import com.oimchat.server.cloud.action.discover.event.ActionInfoEvent;
import com.onlyxiahui.common.utils.base.compare.DifferentValueUtil;
import com.onlyxiahui.common.utils.base.compare.DifferentValueUtil.Different;
import com.onlyxiahui.common.utils.base.lang.string.StringUtil;

/**
 * 
 * <br>
 * Date 2020-07-20 15:40:59<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class DiscoverActionInfoBox {

	Set<ActionInfoEvent> addSet = new HashSet<>();
	Set<ActionInfoEvent> deleteSet = new HashSet<>();
	Set<ActionInfoEvent> updateSet = new HashSet<>();

	PathPatternParser parser = new PathPatternParser();
	Map<PathPattern, ActionInfo> patternMap = new ConcurrentHashMap<>();
	Map<String, PathPattern> pathMap = new ConcurrentHashMap<>();

	Map<String, Map<String, ActionInfo>> serviceMap = new ConcurrentHashMap<>();

	public Map<PathPattern, ActionInfo> getPatternMap() {
		return patternMap;
	}

	public Map<String, Map<String, ActionInfo>> getServiceMap() {
		return serviceMap;
	}

	public String getServiceName(String path) {
		String serviceName = path == null || path.isEmpty() ? null : getServiceName(PathContainer.parsePath(path));
		return serviceName;
	}

	public String getServiceName(PathContainer lookupPath) {
		String serviceName = null;
		ActionInfo data = this.getActionInfo(lookupPath);
		if (null != data) {
			serviceName = data.getServiceName();
		}
		return serviceName;
	}

	public ActionInfo getActionInfo(String path) {
		ActionInfo data = path == null || path.isEmpty() ? null : getActionInfo(PathContainer.parsePath(path));
		return data;
	}

	public ActionInfo getActionInfo(PathContainer lookupPath) {
		List<PathPattern> matches = patternMap.keySet().stream()
				.filter(key -> key.matches(lookupPath))
				.collect(Collectors.toList());

		if (matches.isEmpty()) {
			return null;
		}

		if (matches.size() > 1) {
			matches.sort(PathPattern.SPECIFICITY_COMPARATOR);
		}

		PathPattern pattern = matches.get(0);
		ActionInfo data = this.patternMap.get(pattern);
		return data;
	}

	public void put(List<ActionInfo> list) {
		if (null != list) {
			Map<String, Map<String, ActionInfo>> map = toMap(list);

			List<ActionInfo> addList = new ArrayList<>();
			List<ActionInfo> updateList = new ArrayList<>();
			List<ActionInfo> deleteList = new ArrayList<>();

			for (Map.Entry<String, Map<String, ActionInfo>> root : map.entrySet()) {
				String serviceName = root.getKey();
				Map<String, ActionInfo> newMap = root.getValue();
				Map<String, ActionInfo> oldMap = serviceMap.get(serviceName);
				if (null == oldMap) {
					oldMap = new HashMap<>();
				}

				List<ActionInfo> keepList = new ArrayList<>();
				for (Map.Entry<String, ActionInfo> node : newMap.entrySet()) {
					String k = node.getKey();
					ActionInfo oldData = oldMap.remove(k);
					ActionInfo newData = node.getValue();

					if (null == oldData) {
						addList.add(newData);
					} else {
						List<Different> ds = DifferentValueUtil.different(oldData, newData);
						if (ds.isEmpty()) {
							// 无差异
							keepList.add(oldData);
						} else {
							// 有差异
							updateList.add(newData);
						}
					}
				}
				deleteList.addAll(oldMap.values());
				for (ActionInfo data : keepList) {
					oldMap.put(data.getKey(), data);
				}
			}

			for (ActionInfo data : deleteList) {
				remove(data);
			}
			for (ActionInfo data : addList) {
				put(data);
			}
			for (ActionInfo data : updateList) {
				put(data);
			}
			this.onDelete(deleteList);
			this.onAdd(addList);
			this.onUpdate(updateList);
		}
	}

	public void remove(ActionInfo data) {
		if (null != data) {
			String key = data.getKey();
			String serviceName = data.getServiceName();
			String path = data.getPath();
			Map<String, ActionInfo> map = serviceMap.get(serviceName);
			if (null != map) {
				map.remove(key);
				if (map.isEmpty()) {
					serviceMap.remove(serviceName);
				}
			}
			remove(path);
		}
	}

	private void remove(String path) {
		if (StringUtil.isNotBlank(path)) {
			PathPattern pathPattern = pathMap.remove(path);
			if (null != pathPattern) {
				patternMap.remove(pathPattern);
			}
		}
	}

	private void put(ActionInfo data) {
		if (null != data) {
			String path = data.getPath();
			String serviceName = data.getServiceName();

			if (StringUtil.isNotBlank(path) && StringUtil.isNotBlank(serviceName)) {
				PathPattern pathPattern = parser.parse(path);
				patternMap.put(pathPattern, data);
				pathMap.put(path, pathPattern);
			}

			Map<String, ActionInfo> nodeMap = serviceMap.get(serviceName);
			if (null == nodeMap) {
				nodeMap = new HashMap<>();
				serviceMap.put(serviceName, nodeMap);
			}
			nodeMap.put(data.getKey(), data);
		}
	}

	public void addOnAdd(ActionInfoEvent e) {
		addSet.add(e);
	}

	public void addOnDelete(ActionInfoEvent e) {
		deleteSet.add(e);
	}

	public void addOnUpdate(ActionInfoEvent e) {
		updateSet.add(e);
	}

	private void onAdd(List<ActionInfo> list) {
		if (null != list && !list.isEmpty()) {
			for (ActionInfoEvent a : addSet) {
				a.list(list);
			}
		}
	}

	private void onDelete(List<ActionInfo> list) {
		if (null != list && !list.isEmpty()) {
			for (ActionInfoEvent a : deleteSet) {
				a.list(list);
			}
		}
	}

	private void onUpdate(List<ActionInfo> list) {
		if (null != list && !list.isEmpty()) {
			for (ActionInfoEvent a : updateSet) {
				a.list(list);
			}
		}
	}

	private Map<String, Map<String, ActionInfo>> toMap(List<ActionInfo> list) {
		Map<String, Map<String, ActionInfo>> map = new HashMap<>();
		if (null != list) {
			list.forEach((data) -> {
				String name = data.getServiceName();
				Map<String, ActionInfo> nodeMap = map.get(name);
				if (null == nodeMap) {
					nodeMap = new HashMap<>();
					map.put(name, nodeMap);
				}
				nodeMap.put(data.getKey(), data);
			});
		}
		return map;
	}
}
