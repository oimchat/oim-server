package com.oimchat.server.run.initialize;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.oimchat.server.general.kernel.net.module.oc.sevice.RegisterService;

/**
 *
 * 容器启动后要初始化执行的操作
 *
 */
@Component
public class AppInitializer implements ApplicationRunner {

	protected final Logger logger = LogManager.getLogger(this.getClass());

	boolean run = false;
	@Autowired
	private RegisterService registerService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (!run) {
			run = true;
			if (logger.isInfoEnabled()) {
				logger.info(this.getClass() + "：系统初始化。");
			}
			registerService.startRegister();
		}
	}
}
