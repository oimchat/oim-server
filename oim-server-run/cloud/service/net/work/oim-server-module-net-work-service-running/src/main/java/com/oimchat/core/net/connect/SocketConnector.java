package com.oimchat.core.net.connect;

import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oimchat.core.net.connect.codec.DataCodecFactory;
import com.onlyxiahui.common.lib.util.json.JsonUtil;
import com.onlyxiahui.common.message.Message;
import com.onlyxiahui.framework.net.handler.connect.Connector;
import com.onlyxiahui.framework.net.handler.connect.data.ConnectData;
import com.onlyxiahui.framework.net.handler.connect.type.IdleStatus;
import com.onlyxiahui.framework.net.handler.data.handler.MessageHandler;

/**
 * date 2012-9-14 17:40:54
 * 
 * @author XiaHui
 */
public class SocketConnector implements Connector {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	private Set<MessageHandler> set = new HashSet<MessageHandler>();

	private IoSession session;
	private IoConnector ioConnector;
	private IoHandlerAdapter handler = new SocketHandler(set);

	public SocketConnector() {
		initConnector();
	}

	private void initConnector() {
		ioConnector = new NioSocketConnector();
		ioConnector.getFilterChain().addLast("mis", new ProtocolCodecFilter(new DataCodecFactory()));// 添加过滤器
		ioConnector.getFilterChain().addLast("threadPool", new ExecutorFilter(Executors.newCachedThreadPool()));
		ioConnector.setHandler(handler);// 添加业务逻辑处理类
	}

	@Override
	public boolean connect(ConnectData connectData) {
		boolean mark = true;
		try {
			ConnectFuture connect = ioConnector.connect(new InetSocketAddress(connectData.getAddress(), connectData.getPort()));// 创建连接
			connect.awaitUninterruptibly(connectData.getTimeOut());// 30000//
			session = connect.getSession();// 获取session
			mark = null != session;
		} catch (Exception e) {
			mark = false;
		}
		return mark;
	}

	public IoSession getSession() {
		return session;
	}

	@Override
	public boolean isConnected() {
		return (null != session && session.isConnected() && !session.isClosing());
	}

	@Override
	public boolean write(Object o) {
		boolean mark = isConnected();
		if (mark) {
			if (o instanceof String) {
				session.write(o);
				session.setAttribute(String.class, o);
			} else {
				String json = JsonUtil.toJson(o);
				session.write(json);
				session.setAttribute(Message.class, o);
			}
		}
		return mark;
	}

	@Override
	public void close() {
		if (null != session) {
			session.closeNow();
			session = null;
		}
	}

	@Override
	public void addMessageHandler(MessageHandler handler) {
		set.add(handler);
	}

	@Override
	public IdleStatus getIdleStatus() {
		IdleStatus status = IdleStatus.no;
		if (null != session) {
			if (session.isBothIdle()) {
				status = IdleStatus.all;
			} else if (session.isWriterIdle()) {
				status = IdleStatus.write;
			} else if (session.isReaderIdle()) {
				status = IdleStatus.read;
			}
		}
		return status;
	}
}
