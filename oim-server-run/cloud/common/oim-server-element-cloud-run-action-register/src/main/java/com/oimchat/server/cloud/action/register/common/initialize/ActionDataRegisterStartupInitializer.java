package com.oimchat.server.cloud.action.register.common.initialize;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.oimchat.server.cloud.action.register.service.ActionDataRegisterService;

/**
 *
 * 容器启动后要初始化执行的操作 <br>
 * Date 2020-07-21 14:19:23<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class ActionDataRegisterStartupInitializer implements ApplicationRunner {

	protected final Logger logger = LogManager.getLogger(this.getClass());

	boolean run = false;

	@Autowired
	ActionDataRegisterService actionDataRegisterService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (!run) {
			run = true;
			if (logger.isInfoEnabled()) {
				logger.info(this.getClass() + "：系统初始化。");
			}
			actionDataRegisterService.register();
		}
	}
}
