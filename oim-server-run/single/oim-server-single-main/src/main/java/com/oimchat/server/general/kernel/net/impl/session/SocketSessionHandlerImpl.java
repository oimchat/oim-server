
package com.oimchat.server.general.kernel.net.impl.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.oimchat.server.basic.common.work.app.SessionEnum;
import com.oimchat.server.basic.definition.auth.business.UserTokenAuthBox;
import com.oimchat.server.general.kernel.net.module.system.function.SocketSessionFunction;
import com.oimchat.server.general.kernel.work.module.business.user.service.UserService;
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
public class SocketSessionHandlerImpl implements SocketSessionHandler {

	@Autowired
	SocketSessionHandler socketSessionHandler;
	@Autowired
	SocketSessionBox socketSessionBox;

	@Autowired
	SocketSessionFunction socketSessionFunction;
	@Autowired
	UserTokenAuthBox userAuthBox;
	@Autowired
	UserService userService;

	@Override
	public void sessionPut(SocketSession socketSession) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean sessionHas(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sessionRemove(SocketSession socketSession) {
		socketSessionBox.remove(socketSession);
		String key = socketSession.getKey();

		if (null != key) {
			boolean has = socketSessionBox.hasSession(key);
			if (!has) {
				userService.removeUser(key);
			}
		}

		String token = socketSession.getAttribute(SessionEnum.token);
		userAuthBox.remove(token);
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
}
