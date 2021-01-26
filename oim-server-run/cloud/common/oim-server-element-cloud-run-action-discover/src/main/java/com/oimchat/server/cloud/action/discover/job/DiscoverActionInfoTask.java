package com.oimchat.server.cloud.action.discover.job;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.cloud.action.discover.service.DiscoverActionInfoService;

/**
 * Description <br>
 * Date 2019-12-23 18:24:27<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class DiscoverActionInfoTask {

	@Autowired
	private DiscoverActionInfoService discoverActionInfoService;

	private ScheduledExecutorService executor;

	/**
	 * --Scheduled(cron = "0/5 * * * * ?")<br>
	 * --PostConstruct<br>
	 * Description <br>
	 * Date 2019-12-23 18:25:16<br>
	 * 
	 * @since 1.0.0
	 */
	public void task() {
		discoverActionInfoService.refresh();
		executor = Executors.newScheduledThreadPool(1, new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				t.setName(DiscoverActionInfoTask.class.getName());
				t.setDaemon(true);
				return t;
			}
		});
		executor.scheduleWithFixedDelay(() -> {
			try {
				discoverActionInfoService.refresh();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, 1, 5, TimeUnit.SECONDS);
	}
}
