package com.oimchat.server.general.common.api.inside.system.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.general.common.api.inside.system.setting.bean.MultipleCheck;
import com.oimchat.server.general.common.api.inside.system.setting.client.MultipleOnlineStrategyClient;
import com.onlyxiahui.common.data.common.value.MessageValue;

/**
 * Description <br>
 * Date 2020-05-18 12:17:11<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class MultipleOnlineStrategyInterface {

	@Autowired
	MultipleOnlineStrategyClient multipleOnlineStrategyClient;

	public boolean isMultiple(String type) {
		MessageValue<MultipleCheck> mv = multipleOnlineStrategyClient.multipleCheck(type);
		MultipleCheck mc = null != mv ? mv.getBody() : null;
		return null == mc ? false : mc.isMultiple();
	}
}
