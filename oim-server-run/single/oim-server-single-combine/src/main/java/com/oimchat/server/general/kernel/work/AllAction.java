package com.oimchat.server.general.kernel.work;

import org.springframework.stereotype.Component;

import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 通配所有接口<br>
 * Date 2019-01-20 20:49:52<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.3.0
 */
@Component
@ActionMapping()
public class AllAction {


	/**
	 * @docIgnore
	 */
	// @ActionMapping(value = "/**")
	public Info main(@Define String data) {
		Info info = new Info();
		info.addError("0.404", "接口不存在！");
		return info;
	}
}
