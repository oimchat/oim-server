package com.oimchat.server.cloud.action.discover.invoke;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.oimchat.server.cloud.action.discover.box.DiscoverActionInfoBox;
import com.oimchat.server.cloud.action.discover.common.client.DiscoverActionClientNameBuilder;
import com.onlyxiahui.common.data.common.value.MessageValue;
import com.onlyxiahui.common.message.request.RequestMessage;
import com.onlyxiahui.common.utils.base.lang.string.StringUtil;

/**
 * Description <br>
 * Date 2021-01-18 17:52:30<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class ActionInvoker {

	@Autowired
	DiscoverActionClientNameBuilder clientNameBuilder;
	@Autowired
	DiscoverActionInfoBox box;

	Map<String, ActionInvokerClient> map = new HashMap<>();

	public String invoke(String url, RequestMessage data) {
		ActionInvokerClient client = getClient(url);
		String v;
		if (null == client) {
			MessageValue<?> mv = new MessageValue<>();
			mv.addError("0.404", "接口不存在！");
			v = JSONObject.toJSONString(mv);
		} else {
			v = client.invoke(data);
		}
		return v;
	}

	private ActionInvokerClient getClient(String path) {
		ActionInvokerClient client = null;
		if (StringUtil.isNotBlank(path)) {

			String prefix = "/";
			boolean hasPrefix = path.startsWith("/");
			path = (hasPrefix) ? path : prefix + path;

			String serviceName = box.getServiceName(path);
			if (StringUtil.isNotBlank(serviceName)) {
				String url = "http://" + serviceName + path;
				client = map.get(url);
				if (null == client) {
					client = clientNameBuilder.target(ActionInvokerClient.class, url, new ActionInvokerHystrix());
					map.put(url, client);
				}
			}
		}
		return client;
	}
}
