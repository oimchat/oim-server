package com.oimchat.server.general.kernel.net.module.control.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oimchat.server.general.kernel.net.common.session.SocketSessionBoxComponent;
import com.onlyxiahui.common.data.common.bean.CountInfo;
import com.onlyxiahui.common.message.result.ResultBodyMessage;

/**
 * date 2018-06-04 14:59:44<br>
 * description个人中心
 * 
 * @author XiaHui<br>
 * @since
 */
@RestController
public class SessionController {

	@Autowired
	SocketSessionBoxComponent socketSessionBox;

	@RequestMapping("/v1/portal/session/count")
	public ResultBodyMessage<CountInfo> count() {
		return new ResultBodyMessage<>(new CountInfo(socketSessionBox.getAllSet().size()));
	}
}
