package com.oimchat.server.cloud.action.register.handler;

import java.util.List;

import com.oimchat.server.cloud.action.register.data.ActionData;

/**
 * Description <br>
 * Date 2021-01-12 17:26:09<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public interface ActionDataStream {

	void list(List<ActionData> list);
}
