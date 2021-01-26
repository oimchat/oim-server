package com.oimchat.server.run.initialize;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 *
 * Description容器启动后要初始化执行的操作 <br>
 * Date 2020-08-06 20:53:17<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class AppInitializer implements ApplicationRunner {

	protected final Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private InitializerService initializerService;
	@Autowired
	private InitializerUser initializerUser;
	@Autowired
	private InitializerFunction initializerFunction;
	boolean run = false;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (!run) {
			run = true;
			if (logger.isInfoEnabled()) {
				logger.info(this.getClass() + "：系统初始化。");
			}
			init();
		}
	}

	@PostConstruct
	public void laodAuthFunction() {
		initializerFunction.laodAuthFunction();
	}

	void init() {
		initializerUser.initialize();
		initializerService.initialize();
	}
}
