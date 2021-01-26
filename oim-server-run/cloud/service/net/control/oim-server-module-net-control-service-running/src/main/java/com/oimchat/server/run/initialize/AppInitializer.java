package com.oimchat.server.run.initialize;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * 容器启动后要初始化执行的操作
 *
 */
@Component
public class AppInitializer implements ApplicationListener<ContextRefreshedEvent> {

	protected final Logger logger = LogManager.getLogger(this.getClass());

	boolean run = false;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent e) {
		if (!run) {
			run = true;
			if (logger.isInfoEnabled()) {
				logger.info(this.getClass() + "：系统初始化。");
			}
		}
	}
}
