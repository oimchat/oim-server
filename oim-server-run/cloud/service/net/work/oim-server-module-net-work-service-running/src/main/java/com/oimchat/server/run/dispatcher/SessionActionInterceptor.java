
package com.oimchat.server.run.dispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.oimchat.server.basic.common.work.app.SessionEnum;
import com.oimchat.server.basic.definition.auth.business.UserTokenAuthBox;
import com.oimchat.server.run.util.WebAddressUtil;
import com.onlyxiahui.framework.action.dispatcher.ActionContext;
import com.onlyxiahui.framework.action.dispatcher.common.ApplyInfo;
import com.onlyxiahui.framework.action.dispatcher.extend.ActionInterceptor;
import com.onlyxiahui.framework.action.dispatcher.extend.ActionRequest;
import com.onlyxiahui.framework.action.dispatcher.extend.ActionResponse;
import com.onlyxiahui.framework.action.dispatcher.extend.ArgumentBox;
import com.onlyxiahui.framework.net.session.SocketSession;

/**
 * Description <br>
 * Date 2020-05-15 19:57:12<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class SessionActionInterceptor implements ActionInterceptor {

	@Autowired
	UserTokenAuthBox userAuthBox;

	@Override
	public ApplyInfo previous(ActionContext actionContext, ActionRequest request, ActionResponse response, ArgumentBox argumentBox) {
		SocketSession ss = argumentBox.get(SocketSession.class);
		ServerWebExchange swe = argumentBox.get(ServerWebExchange.class);
		if (null == ss && null != swe) {

			ss = new SocketSession() {

				@Override
				public String getId() {
					return swe.getRequest().getId();
				}

				@Override
				public void setKey(String key) {
					// TODO Auto-generated method stub
				}

				@Override
				public String getKey() {
					String key = swe.getRequest().getHeaders().getFirst(SessionEnum.key.getName());
					return key;
				}

				@Override
				public void write(Object object) {
					response.write(object);
				}

				@Override
				public void close() {
					// TODO Auto-generated method stub

				}

				@Override
				public void addAttribute(Object key, Object value) {
					// TODO Auto-generated method stub

				}

				@SuppressWarnings("unchecked")
				@Override
				public <T> T getAttribute(Object key) {
					if (SessionEnum.token.getName().equals(key)) {
						String token = swe.getRequest().getHeaders().getFirst(SessionEnum.token.getName());
						return (T) token;
					}
					return null;
				}

				@Override
				public void setAuth(boolean auth) {
					// TODO Auto-generated method stub

				}

				@Override
				public boolean isAuth() {
					boolean auth = false;
					String token = swe.getRequest().getHeaders().getFirst(SessionEnum.token.getName());
					String key = swe.getRequest().getHeaders().getFirst(SessionEnum.key.getName());
					if (null != token) {
						String id = userAuthBox.getUserId(token);
						auth = (null != id && id.equals(key));
					}
					return auth;
				}

				@Override
				public String getRemoteAddress() {
					String ip = WebAddressUtil.getIpAddress(swe.getRequest());
					return ip;
				}

				@Override
				public void setTag(String tag) {

				}
			};
			argumentBox.put(SocketSession.class, ss);
		}
		ApplyInfo applyInfo = new ApplyInfo();
		applyInfo.setApprove(true);
		return applyInfo;
	}
}
