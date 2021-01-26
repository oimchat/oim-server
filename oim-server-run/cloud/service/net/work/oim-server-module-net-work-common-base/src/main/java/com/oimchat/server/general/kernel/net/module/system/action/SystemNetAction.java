package com.oimchat.server.general.kernel.net.module.system.action;

import org.springframework.stereotype.Component;

import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 网络业务接口<br>
 * Date 2019-01-20 19:12:16<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey net
 */
@Component
@ActionMapping(value = "1.0.001")
public class SystemNetAction {

	/**
	 * 
	 * 心跳 <br>
	 * Date 2020-04-13 16:39:29<br>
	 * 
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0001")
	public void heartbeat() {
	}
}
