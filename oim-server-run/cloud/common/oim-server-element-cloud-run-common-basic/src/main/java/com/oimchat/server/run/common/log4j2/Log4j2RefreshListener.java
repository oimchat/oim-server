package com.oimchat.server.run.common.log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.onlyxiahui.aware.run.common.log4j2.Log4j2Refresh;

/**
 * 
 * <br>
 * Date 2019-11-27 11:10:59<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class Log4j2RefreshListener {

	@Autowired
	private Log4j2Refresh log4j2Refresh;

	String key = "spring.aware.log4j2.loggers";

	@Autowired(required = false)
	private Environment environment;

	/**
	 * 监听配置变更事件，只处理关于日志的配置，其它忽略即可。
	 *
	 * <pre>
	 * [
	 *     {
	 *         "name": "com.onlyxiahui",
	 *         "level": "info"
	 *     },
	 *     {
	 *         "name": "root",
	 *         "level": "info"
	 *     }
	 * ]
	 * </pre>
	 */
	@org.springframework.context.event.EventListener
	public void envListener(EnvironmentChangeEvent event) {
		if (null != environment && null != event.getKeys() && event.getKeys().contains(key)) {
			String loggers = environment.getProperty(key);
			log4j2Refresh.refreshLoggingLevels(loggers);
		}
	}
}
