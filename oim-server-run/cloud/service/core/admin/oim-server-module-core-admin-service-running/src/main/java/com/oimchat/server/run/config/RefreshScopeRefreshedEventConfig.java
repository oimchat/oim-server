package com.oimchat.server.run.config;

import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * 
 * Description <br>
 * Date 2020-05-15 09:18:23<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Configuration
public class RefreshScopeRefreshedEventConfig {

	@EventListener(RefreshScopeRefreshedEvent.class)
	public void onRefresh(RefreshScopeRefreshedEvent event) {
		// TODO Your code goes here...
		// System.out.println(event);
	}
}
