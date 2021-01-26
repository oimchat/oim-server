package com.oimchat.server.basic.definition.auth.business;

import java.util.Map;

/**
 * Description <br>
 * Date 2021-01-19 11:30:26<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public interface UserTokenBuilder {

	String build(String key, Map<String, String> dataMap);
}
