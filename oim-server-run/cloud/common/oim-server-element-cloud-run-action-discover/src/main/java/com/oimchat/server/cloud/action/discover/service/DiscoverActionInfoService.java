package com.oimchat.server.cloud.action.discover.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.cloud.action.discover.manager.DiscoverActionInfoManager;

/**
 * 
 * <br>
 * Date 2020-07-20 15:58:47<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class DiscoverActionInfoService {

	@Autowired
	private DiscoverActionInfoManager discoverActionInfoManager;

	public void refresh() {
		discoverActionInfoManager.refresh();
	}
}
