package com.oimchat.server.general.kernel.work.module.business.portal.config;

import org.springframework.stereotype.Component;

/**
 * Description <br>
 * Date 2021-01-20 11:09:26<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class ServerAddressDiscoverConfig {

	/**
	 * 是否自动发现服务
	 */
	private boolean autoDiscover = true;

	public boolean isAutoDiscover() {
		return autoDiscover;
	}

	public void setAutoDiscover(boolean autoDiscover) {
		this.autoDiscover = autoDiscover;
	}
}
