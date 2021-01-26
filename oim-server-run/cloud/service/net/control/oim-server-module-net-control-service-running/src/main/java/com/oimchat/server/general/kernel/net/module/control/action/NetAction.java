package com.oimchat.server.general.kernel.net.module.control.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.oimchat.server.general.kernel.net.common.session.SocketSessionBoxComponent;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 
 * Description <br>
 * Date 2014年6月14日 下午9:31:55<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@RestController
@ActionMapping(value = "service.1.002")
public class NetAction {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SocketSessionBoxComponent socketSessionBox;

	@ActionMapping(value = "1.1.0001")
	public void heartbeat() {
		if (logger.isDebugEnabled()) {
			logger.debug("socket session size:" + socketSessionBox.getAllSet().size());
		}
	}
}
