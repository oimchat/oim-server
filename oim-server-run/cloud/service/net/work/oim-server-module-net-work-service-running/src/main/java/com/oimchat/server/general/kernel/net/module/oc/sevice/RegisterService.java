package com.oimchat.server.general.kernel.net.module.oc.sevice;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oimchat.core.net.NetContext;
import com.oimchat.core.net.back.annotation.Back;
import com.oimchat.server.cloud.net.basic.bean.ServerInfo;
import com.oimchat.server.general.common.api.inside.net.control.NetControlInterface;
import com.oimchat.server.general.common.api.inside.net.control.data.NetControl;
import com.oimchat.server.general.kernel.net.module.oc.sender.NetSender;
import com.oimchat.server.general.kernel.net.module.oc.sender.RegisterSender;
import com.oimchat.server.general.kernel.net.module.oc.sender.SenderFactory;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.framework.net.handler.connect.action.ConnectBackAction;
import com.onlyxiahui.framework.net.handler.connect.action.ConnectStatusAction;
import com.onlyxiahui.framework.net.handler.connect.data.ConnectData;
import com.onlyxiahui.framework.net.handler.connect.type.IdleStatus;
import com.onlyxiahui.framework.net.handler.data.action.DataBackAction;

/**
 * Description <br>
 * Date 2021-01-13 17:34:16<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Service
public class RegisterService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SenderFactory senderFactory;
	@Autowired
	NetContext netContext;
	@Autowired
	NetControlInterface netControlInterface;
	@Autowired
	ServerInfo serverInfo;

	boolean register = false;

	@PostConstruct
	public void init() {
		netContext.getNetHandler().addConnectStatusAction(new ConnectStatusAction() {

			@Override
			public void onStatusChange(boolean isConnected) {
				if (register && !isConnected) {
					logger.info("断开连接");
				}
			}

			@Override
			public void onIdle(IdleStatus idleStatus) {
				if (IdleStatus.all == idleStatus) {
					heartbeat();
				}
			}

			@Override
			public void onAfterAutoConnect(boolean connected) {
				if (!connected) {
					logger.info("断开连接，重新连接");
					startRegister();
				}
			}
		});
	}

	public void startRegister() {
		NetControl nc = netControlInterface.getData();
		if (null != nc) {
			logger.info("开始连接：" + nc.getHost() + ":" + nc.getPort());
			ConnectData connectData = new ConnectData();
			connectData.setAddress(nc.getHost());
			connectData.setPort(nc.getPort());
			startRegister(connectData);
		}
	}

	public void startRegister(ConnectData connectData) {

		ConnectBackAction cba = new ConnectBackAction() {

			@Override
			public void connectBack(boolean success) {
				if (!success) {
					logger.info("连接失败，请检查网络是否正常。");
				} else {
					auth();
					logger.info("连接成功。");
				}
			}
		};
		if (!netContext.getNetHandler().getConnectHandler().isConnected()) {
			// 因为负责连接服务器的和负责发送消息的线程不同，在执行登录之前是没有连接的，所以在这里先添加个连接后回掉的action
			// 当连接成功后再把登陆消息发出去，不然先把消息发了，再连接就没有执行登陆操作了
			netContext.connect(connectData, cba);
		}
	}

	public void auth() {
		RegisterSender registerSender = senderFactory.getObject(RegisterSender.class);
		final DataBackAction action = new DataBackAction() {// 这是消息发送后回掉
			@Override
			public void lost() {
			}

			@Override
			public void timeOut() {
			}

			@Back
			public void back(@Define("info") Info info) {
				logger.info("注册：" + info.isSuccess());
				if (info.isSuccess()) {
					register = true;
				}
			}
		};
		registerSender.auth(serverInfo, action);
	}

	public void heartbeat() {
		NetSender ns = senderFactory.getObject(NetSender.class);
		ns.heartbeat();
	}
}
