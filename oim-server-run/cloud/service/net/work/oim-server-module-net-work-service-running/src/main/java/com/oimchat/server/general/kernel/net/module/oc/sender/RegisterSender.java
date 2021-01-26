package com.oimchat.server.general.kernel.net.module.oc.sender;

import com.oimchat.server.cloud.net.basic.bean.ServerInfo;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;
import com.onlyxiahui.framework.net.handler.data.action.DataBackAction;

/**
 * Description <br>
 * Date 2021-01-13 17:47:38<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@ActionMapping(value = "service.1.001")
public interface RegisterSender {

	@ActionMapping(value = "1.1.0001")
	public void auth(@Define("body") ServerInfo serverInfo, DataBackAction back);
}
