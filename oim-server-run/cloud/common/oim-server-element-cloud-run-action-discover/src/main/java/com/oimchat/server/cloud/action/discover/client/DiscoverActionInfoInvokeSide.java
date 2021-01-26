package com.oimchat.server.cloud.action.discover.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.cloud.action.discover.common.client.DiscoverActionClientNameBuilder;
import com.oimchat.server.cloud.action.discover.data.ActionInfo;
import com.oimchat.server.cloud.action.discover.data.ActionInfoQuery;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * 
 * <br>
 * Date 2020-07-20 16:40:26<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class DiscoverActionInfoInvokeSide {

	@Autowired
	private DiscoverActionClientNameBuilder clientNameBuilder;
	private DiscoverActionInfoClient client;

	private DiscoverActionInfoClient getClient() {
		if (null == client) {
			String url = "http://core-action";
			client = clientNameBuilder.target(DiscoverActionInfoClient.class, url, new DiscoverActionInfoHystrix());
//			client = clientNameBuilder.target(DiscoverActionInfoClient.class, url);
		}
		return client;
	}

	public int allList(ActionInfoQuery query, DiscoverActionInfoStream stream) {
		int pageNumber = 2;
		int totalPage = 1;
		int totalCount = 0;
		Page p = new Page();
		p.setSize(500);
		DiscoverActionInfoClient actionInfoClient = getClient();
		MessageValue<PageResult<List<ActionInfo>>> mv = actionInfoClient.list(p, query);

		if (mv != null && mv.isSuccess()) {
			PageResult<List<ActionInfo>> pb = mv.getBody();
			if (null != pb) {
				Page page = pb.getPage();
				if (null != page) {
					// 获取总的页数
					totalPage = page.getTotalPage();
					totalCount = page.getTotalCount();
					List<ActionInfo> dataList = pb.getItems();
					if (null != dataList && null != stream) {
						stream.handle(page, dataList);
					}
				}
			}

			if (null != stream) {
				for (; pageNumber <= totalPage; pageNumber++) {
					p.setNumber(pageNumber);
					mv = actionInfoClient.list(p, query);
					if (mv != null) {
						pb = mv.getBody();
						if (null != pb) {
							Page page = pb.getPage();
							List<ActionInfo> dataList = pb.getItems();
							if (null != dataList && null != stream) {
								stream.handle(page, dataList);
							}
						}
					}
				}
			}
		}
		return totalCount;
	}
}
