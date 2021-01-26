package com.oimchat.server.cloud.action.discover.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.cloud.action.discover.box.DiscoverActionInfoBox;
import com.oimchat.server.cloud.action.discover.client.DiscoverActionInfoInvokeSide;
import com.oimchat.server.cloud.action.discover.data.ActionInfo;
import com.oimchat.server.cloud.action.discover.data.ActionInfoQuery;

/**
 * 
 * <br>
 * Date 2020-07-20 15:58:47<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class DiscoverActionInfoManager {

	@Autowired
	private DiscoverActionInfoInvokeSide discoverActionInfoInvokeSide;
	@Autowired
	private DiscoverActionInfoBox discoverActionInfoBox;

	public void refresh() {
		ActionInfoQuery query = new ActionInfoQuery();
		List<ActionInfo> allList = new ArrayList<>();
		discoverActionInfoInvokeSide.allList(query, (page, list) -> {
			if (null != list) {
				allList.addAll(list);
			}
		});
		discoverActionInfoBox.put(allList);
	}
}
