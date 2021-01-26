
package com.oimchat.server.cloud.run.common.work.dispatcher;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.oimchat.server.basic.common.work.app.SessionEnum;
import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.basic.common.work.key.RemoteAddressKey;
import com.oimchat.server.cloud.run.common.work.util.WebAddressUtil;
import com.onlyxiahui.framework.action.dispatcher.ActionContext;
import com.onlyxiahui.framework.action.dispatcher.extend.ActionRequest;
import com.onlyxiahui.framework.action.dispatcher.extend.ActionResponse;
import com.onlyxiahui.framework.action.dispatcher.extend.ArgumentBox;
import com.onlyxiahui.framework.action.dispatcher.extend.MethodArgumentResolver;

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
		ServerWebExchange swe = argumentBox.get(ServerWebExchange.class);
		if (null != swe) {
			String ip = WebAddressUtil.getIpAddress(swe.getRequest());
			String token = swe.getRequest().getHeaders().getFirst(SessionEnum.token.getName());
			String key = swe.getRequest().getHeaders().getFirst(SessionEnum.key.getName());
			String remoteAddress = swe.getRequest().getHeaders().getFirst(RemoteAddressKey.USER_REMOTE_ADDRESS_KEY);

			us.setRemote4Address((null != remoteAddress && !remoteAddress.isEmpty()) ? remoteAddress : ip);
			us.setToken(token);
			us.setUserId(key);
		}
		return us;
	}
}
