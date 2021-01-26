package com.oimchat.server.general.kernel.core.gateway.auth.service;

import javax.annotation.Resource;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.core.gateway.auth.config.BlackListAddressConfig;
import com.oimchat.server.general.kernel.core.gateway.auth.config.WhiteListAddressConfig;

/**
 * 
 * <br>
 * Date 2019-07-24 16:16:31<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Service
@RefreshScope
public class AddressAuthService {

	@Resource
	private WhiteListAddressConfig whiteListAddressConfig;
	@Resource
	private BlackListAddressConfig blackListAddressConfig;

	public boolean addressAuth(String address) {
		boolean blackAuth = blackListAddressConfig.addressAuth(address);
		boolean whiteAuth = whiteListAddressConfig.addressAuth(address);
		return blackAuth && whiteAuth;
	}
}
