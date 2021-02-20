
package com.oimchat.server.general.kernel.work.impl.portal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.general.kernel.work.define.portal.ServerConfigBox;
import com.oimchat.server.general.kernel.work.impl.portal.service.ServerAddressChoiceService;
import com.oimchat.server.general.kernel.work.module.base.portal.data.ServerData;

/**
 * Description <br>
 * Date 2020-05-15 17:46:44<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class ServerConfigBoxImpl implements ServerConfigBox {

	@Autowired
	ServerAddressChoiceService serverAddressChoiceService;

	@Override
	public List<ServerData> getServerList() {
		return serverAddressChoiceService.getServerDataList();
	}
}
