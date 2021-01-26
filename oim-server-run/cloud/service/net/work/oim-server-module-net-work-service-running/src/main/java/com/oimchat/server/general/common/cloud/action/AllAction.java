package com.oimchat.server.general.common.cloud.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.SessionEnum;
import com.oimchat.server.general.common.cloud.net.InvokeSide;
import com.oimchat.server.general.kernel.net.module.work.router.RouteManager;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.value.MessageValue;
import com.onlyxiahui.common.message.base.HeadImpl;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.framework.action.dispatcher.registry.ActionRegistry;
import com.onlyxiahui.framework.net.session.SocketSession;

/**
 * 通配所有接口<br>
 * Date 2019-01-20 20:49:52<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.3.0
 */
@Component
@ActionMapping()
public class AllAction {

	@Autowired
	InvokeSide invokeSide;
	@Autowired
	RouteManager routeManager;

	ActionRegistry actionRegistry = new ActionRegistry();

	/**
	 * @docIgnore
	 */
	@ActionMapping(value = "/**")
	public MessageValue<Object> all(HeadImpl head, @Define String data, SocketSession socketSession) {

		String actionCode = (head.getAction() == null) ? "" : head.getAction();
		String methodCode = (head.getMethod() == null) ? "" : head.getMethod();

		String path = actionRegistry.getPath(actionCode, methodCode);
		String service = routeManager.getService(path);

		String token = socketSession.getAttribute(SessionEnum.token);
		String key = socketSession.getKey();
		String remoteAddress = socketSession.getRemoteAddress();

		MessageValue<Object> mv = null;
		if (null == service) {
			mv = invokeSide.invokeError(null, data, key, token, remoteAddress);
			Info info = new Info();
			info.addError("0.404", "接口不存在！");

			mv.setInfo(info);
		} else {
			String url = "http://" + service + path;
			mv = invokeSide.invoke(url, data, key, token, remoteAddress);
		}
		return mv;
	}

//	/**
//	 * @docIgnore
//	 */
//	@ActionMapping(value = "/**")
//	public Info main(@Define String data) {
//		Info info = new Info();
//		info.addError("0.404", "接口不存在！");
//		return info;
//	}
}
