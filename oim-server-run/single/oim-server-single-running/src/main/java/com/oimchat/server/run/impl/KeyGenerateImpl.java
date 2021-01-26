
package com.oimchat.server.run.impl;

import org.springframework.stereotype.Component;

import com.onlyxiahui.aware.basic.base.generate.KeyGenerate;
import com.onlyxiahui.aware.basic.base.util.IdUtil;

/**
 * Description <br>
 * Date 2020-04-17 09:54:34<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class KeyGenerateImpl implements KeyGenerate {

	@Override
	public String getId() {
		return String.valueOf(IdUtil.generateId());
	}
}
