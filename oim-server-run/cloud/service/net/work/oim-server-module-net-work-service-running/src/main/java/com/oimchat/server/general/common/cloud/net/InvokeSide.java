
package com.oimchat.server.general.common.cloud.net;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.TypeReference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.oimchat.server.basic.common.work.app.SessionEnum;
import com.oimchat.server.basic.common.work.key.RemoteAddressKey;
import com.onlyxiahui.common.data.common.value.MessageValue;
import com.onlyxiahui.common.lib.util.json.JsonUtil;
import com.onlyxiahui.common.message.base.ResultHead;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.message.util.HeadUtil;
import com.onlyxiahui.framework.action.dispatcher.general.constant.DataConstant;

/**
 * Description <br>
 * Date 2020-05-13 21:59:37<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

@Component
public class InvokeSide {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "invokeError")
	public MessageValue<Object> invoke(
			String url,
			String data,
			String key,
			String token,
			String remoteAddress) {

		// 创建请求头
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		headers.add(SessionEnum.key.getName(), key);
		headers.add(SessionEnum.token.getName(), token);
		headers.add(RemoteAddressKey.USER_REMOTE_ADDRESS_KEY, remoteAddress);

		MessageValue<Object> mv = null;
		HttpEntity<String> entity = new HttpEntity<String>(data, headers);
		try {
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, entity, String.class);
			String json = responseEntity.getBody();

			if (JsonUtil.maybeJsonObject(json)) {
				mv = JsonUtil.toObject(json, new TypeReference<MessageValue<Object>>() {
				});
			} else {
				mv = invokeError(url, data, key, token, remoteAddress);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	public MessageValue<Object> invokeError(
			String url,
			String data,
			String key,
			String token,
			String remoteAddress) {
		ResultHead head = null;
		if (null != data && JsonUtil.maybeJsonObject(data)) {
			Object o = JSONPath.read(data, DataConstant.HEAD);
			if (o instanceof JSONObject) {
				head = HeadUtil.toHead((JSONObject) o);
			}
		}
		MessageValue<Object> mv = new MessageValue<>();
		mv.setHead(head);
		Info info = mv.getInfo();
		info.addError("0.500", "请求失败");
		info.addWarning("0.500", "请求失败");
		return mv;
	}
}
