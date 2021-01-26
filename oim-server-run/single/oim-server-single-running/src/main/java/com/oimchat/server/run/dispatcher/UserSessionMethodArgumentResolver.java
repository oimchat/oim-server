
package com.oimchat.server.run.dispatcher;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.oimchat.server.basic.common.work.app.SessionEnum;
import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.util.WebAddressUtil;
import com.onlyxiahui.framework.action.dispatcher.ActionContext;
import com.onlyxiahui.framework.action.dispatcher.extend.ActionRequest;
import com.onlyxiahui.framework.action.dispatcher.extend.ActionResponse;
import com.onlyxiahui.framework.action.dispatcher.extend.ArgumentBox;
import com.onlyxiahui.framework.action.dispatcher.extend.MethodArgumentResolver;
import com.onlyxiahui.framework.net.session.SocketSession;

/**
 * Description <br>
 * Date 2020-04-14 22:08:25<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class UserSessionMethodArgumentResolver implements MethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		Class<?> clazz = parameter.getParameterType();
		return clazz == UserSession.class;
	}

	@Override
	public Object resolveArgument(ActionContext actionContext, MethodParameter parameter, ActionRequest request, ActionResponse response, ArgumentBox argumentBox) {
		UserSession us = new UserSession();
		SocketSession ss = argumentBox.get(SocketSession.class);
		ServerWebExchange swe = argumentBox.get(ServerWebExchange.class);
		if (null != ss) {
			String token = ss.getAttribute(SessionEnum.token);

			us.setRemote4Address(ss.getRemoteAddress());
			us.setToken(token);
			us.setUserId(ss.getKey());
		} else if (null != swe) {
			String ip = WebAddressUtil.getIpAddress(swe.getRequest());
			String token = swe.getRequest().getHeaders().getFirst(SessionEnum.token.getName());
			String key = swe.getRequest().getHeaders().getFirst(SessionEnum.key.getName());

			us.setRemote4Address(ip);
			us.setToken(token);
			us.setUserId(key);
		}
		return us;
	}
}
