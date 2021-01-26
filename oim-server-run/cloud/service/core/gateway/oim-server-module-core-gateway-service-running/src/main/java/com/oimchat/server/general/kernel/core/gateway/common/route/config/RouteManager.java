
package com.oimchat.server.general.kernel.core.gateway.common.route.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oimchat.server.cloud.action.discover.box.DiscoverActionInfoBox;

/**
 * Description <br>
 * Date 2020-05-15 18:02:47<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Service
public class RouteManager {

	@Autowired
	DiscoverActionInfoBox discoverActionDataBox;

	public String getService(String path) {
		return discoverActionDataBox.getServiceName(path);
	}
}
