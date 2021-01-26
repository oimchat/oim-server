
package com.oimchat.server.run.dispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlyxiahui.framework.action.dispatcher.ActionContext;
import com.onlyxiahui.framework.action.dispatcher.general.config.GeneralActionConfigurerAdapter;

/**
 * Description <br>
 * Date 2020-04-14 22:06:42<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class ServiceActionConfigurer extends GeneralActionConfigurerAdapter {

	@Autowired
	UserSessionMethodArgumentResolver userSessionMethodArgumentResolver;

	@Override
	public void addConfig(ActionContext actionContext) {
		actionContext.getMethodArgumentResolverRegistry().add(userSessionMethodArgumentResolver);
	}
}
