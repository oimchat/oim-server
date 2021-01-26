package com.oimchat.server.general.common.cloud.net;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.onlyxiahui.common.data.common.value.MessageValue;
import com.onlyxiahui.common.lib.util.json.JsonUtil;
import com.onlyxiahui.common.message.base.ResultHead;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.message.util.HeadUtil;
import com.onlyxiahui.framework.action.dispatcher.general.constant.DataConstant;

/**
 * 
 * Description <br>
 * Date 2020-05-13 21:13:01<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
public class InvokeClientHystrix implements InvokeClient {

	@Override
	public MessageValue<Object> invoke(String data) {
		ResultHead head = null;
		if (null != data && JsonUtil.maybeJsonObject(data)) {
			Object o = JSONPath.read(data, DataConstant.HEAD);
			if (o instanceof JSONObject) {
				head = HeadUtil.toHead((JSONObject) o);
			}
		}
		MessageValue<Object> mv = new MessageValue<>();
		mv.setHead(head);
		Info info = mv.getInfo();
		info.addError("0.500", "请求失败");
		info.addWarning("0.500", "请求失败");
		return mv;
	}
}
