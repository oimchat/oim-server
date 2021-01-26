package com.oimchat.server.general.kernel.net.common.session;

import java.util.List;

import org.springframework.stereotype.Component;

import com.onlyxiahui.common.lib.util.json.JsonUtil;
import com.onlyxiahui.wofa.server.net.core.session.SocketSessionBox;

/**
 * Description <br>
 * Date 2020-10-08 13:17:12<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class SocketSessionBoxComponent extends SocketSessionBox {

	public void push(Object data) {
		super.push((data instanceof String) ? data : JsonUtil.toJson(data));
	}

	public void push(String key, Object data) {
		super.push(key, (data instanceof String) ? data : JsonUtil.toJson(data));
	}

	public void push(List<String> keyList, Object data) {
		super.push(keyList, (data instanceof String) ? data : JsonUtil.toJson(data));
	}

	public void pushWithout(String key, Object data) {
		super.pushWithout(key, (data instanceof String) ? data : JsonUtil.toJson(data));
	}

	public void pushWithout(List<String> keyList, Object data) {
		super.pushWithout(keyList, (data instanceof String) ? data : JsonUtil.toJson(data));
	}
}
