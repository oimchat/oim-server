package com.oimchat.server.general.kernel.core.gateway.auth.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import com.oimchat.server.general.kernel.core.gateway.auth.cache.BlackListCache;
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
public class BlackListAddressConfig {

	@Resource
	private BlackListCache blackListCache;

	@Value("${oim.server.config.gateway.auth.black.list.open}")
	private boolean blackListAuth = true;

	private String[] blackList = {};

	@Value("${oim.server.config.gateway.auth.black.list.address}")
	public void setBlackList(String list) {
		if (null != list) {
			blackList = list.split(",");
		} else {
			blackList = new String[0];
		}
		blackListCache.clear();
	}

	public boolean isIncludedBlackList(String address) {
		return isIncluded(address, blackList);
	}

	public boolean isIncluded(String address, String[] whiteList) {
		if (blackListCache.has(address)) {
			return true;
		}
		if (null == whiteList || whiteList.length <= 0) {
			return false;
		}
		if (IpUtil.isIncluded(address, whiteList)) {
			blackListCache.put(address);
			return true;
		}
		return false;
	}

	public boolean addressAuth(String address) {
		return !blackListAuth || !isIncluded(address, blackList);
	}
}
