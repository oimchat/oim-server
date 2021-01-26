package com.oimchat.server.cloud.action.discover.event;

import java.util.List;

import com.oimchat.server.cloud.action.discover.data.ActionInfo;

/**
 * Description <br>
 * Date 2021-01-14 18:55:24<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public interface ActionInfoEvent {

	void list(List<ActionInfo> list);
}
