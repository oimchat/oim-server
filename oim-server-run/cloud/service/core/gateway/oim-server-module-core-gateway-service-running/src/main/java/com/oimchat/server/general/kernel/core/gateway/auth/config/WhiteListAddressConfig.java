package com.oimchat.server.general.kernel.core.gateway.auth.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import com.oimchat.server.general.kernel.core.gateway.auth.cache.WhiteListCache;
import com.oimchat.server.general.kernel.core.gateway.common.util.IpUtil;

/**
 * 
 * <br>
 * Date 2019-11-27 14:16:49<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@RefreshScope
@Component
public class WhiteListAddressConfig {

	@Resource
	private WhiteListCache whiteListCache;

	@Value("${oim.server.config.gateway.auth.white.list.open}")
	private boolean whiteListAuth = true;

	private String[] whiteList = {};

	@Value("${oim.server.config.gateway.auth.white.list.address}")
	public void setWhiteList(String list) {
		if (null != list) {
			whiteList = list.split(",");
		} else {
			whiteList = new String[0];
		}
		whiteListCache.clear();
	}

	public boolean isIncluded(String address, String[] whiteList) {
		if (whiteListCache.has(address)) {
			return true;
		}
		if (null == whiteList || whiteList.length <= 0) {
			return false;
		}
		if (IpUtil.isIncludedInWhiteList(address, whiteList)) {
			whiteListCache.put(address);
			return true;
		}
		return false;
	}

	public boolean addressAuth(String address) {
		return !whiteListAuth || isIncluded(address, whiteList);
	}
}
