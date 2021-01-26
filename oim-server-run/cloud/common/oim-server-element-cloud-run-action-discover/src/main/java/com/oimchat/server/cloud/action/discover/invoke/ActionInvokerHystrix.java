package com.oimchat.server.cloud.action.discover.invoke;

import com.alibaba.fastjson.JSONObject;
import com.onlyxiahui.common.data.common.value.MessageValue;
import com.onlyxiahui.common.message.Message;

/**
 * Description <br>
 * Date 2021-01-18 18:18:29<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class ActionInvokerHystrix implements ActionInvokerClient {

	@Override
	public String invoke(Message<?, ?> m) {
		MessageValue<Object> mv = new MessageValue<>();
		mv.addError("0.500", "调用失败！");
		return JSONObject.toJSONString(mv);
	}
}
