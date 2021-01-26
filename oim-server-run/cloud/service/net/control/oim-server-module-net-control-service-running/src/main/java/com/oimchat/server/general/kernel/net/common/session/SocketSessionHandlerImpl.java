
package com.oimchat.server.general.kernel.net.common.session;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.onlyxiahui.aware.basic.work.business.error.SystemError;
import com.onlyxiahui.common.lib.util.json.JsonUtil;
import com.onlyxiahui.common.message.base.ResultHead;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.common.message.util.HeadUtil;
import com.onlyxiahui.framework.action.dispatcher.general.constant.DataConstant;
import com.onlyxiahui.framework.net.session.SocketSession;
import com.onlyxiahui.wofa.server.net.core.session.SocketSessionBox;
import com.onlyxiahui.wofa.server.net.core.session.SocketSessionHandler;

/**
 * Description <br>
 * Date 2020-04-13 11:23:46<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class SocketSessionHandlerImpl implements SocketSessionHandler, SocketSessionStore {

	@Autowired
	SocketSessionBox socketSessionBox;

	@Autowired
	SocketSessionListener socketSessionListener;

	@Override
	public void sessionPut(SocketSession socketSession) {
		String key = socketSession.getKey();
		Set<SocketSession> set = socketSessionBox.remove(key);

		socketSessionBox.put(socketSession);
		if (null == set || set.isEmpty()) {
			socketSessionListener.online(socketSession);
		}
	}

	@Override
	public boolean sessionHas(String key) {
		return socketSessionBox.hasSession(key);
	}

	@Override
	public void sessionRemove(SocketSession socketSession) {
		String key = socketSession.getKey();
		socketSessionBox.remove(socketSession);

		socketSessionListener.close(socketSession);

		if (null != key) {
			if (!sessionHas(key)) {
				// 通知下线
				socketSessionListener.offline(socketSession);
			}
		}
	}

	@Override
	public void dataException(SocketSession socketSession, Object data, Exception e) {
		String message = e.getMessage();
		ResultMessage r = new ResultMessage();
		if (data instanceof String) {
			String body = data.toString();
			if (JsonUtil.maybeJsonObject(body)) {
				JSONObject jo = JSONObject.parseObject(body);
				boolean hasHead = jo.containsKey(DataConstant.HEAD) && jo.get(DataConstant.HEAD) instanceof JSONObject;
				if (hasHead) {
					JSONObject headElement = jo.getJSONObject(DataConstant.HEAD);
					ResultHead resultHead = HeadUtil.toHead(headElement);
					r.setHead(resultHead);
				}
			}
		}
		r.addError(SystemError.PARAMETER_ERROR.value(), null == message || message.isEmpty() ? SystemError.PARAMETER_ERROR.message() : message);
		dataWrite(socketSession, r);

	}

	@Override
	public void dataWrite(SocketSession socketSession, Object data) {
		if (null != socketSession && null != data) {
			if (data instanceof String) {
				socketSession.write(data);
			} else {
				socketSession.write(JsonUtil.toJson(data));
			}
		}
	}

	@Override
	public boolean has(String key) {
		return sessionHas(key);
	}
}
