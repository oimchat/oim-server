package com.oimchat.server.general.kernel.net.module.oc.sender;

import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * Description <br>
 * Date 2021-01-13 17:47:38<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@ActionMapping(value = "service.1.002")
public interface NetSender {

	@ActionMapping(value = "1.1.0001")
	public void heartbeat();
}
