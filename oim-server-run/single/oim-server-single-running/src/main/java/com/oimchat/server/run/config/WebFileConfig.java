package com.oimchat.server.run.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import com.oimchat.server.general.kernel.support.file.module.common.config.FileServerConfig;

/**
 * 
 * Description <br>
 * Date 2020-04-20 11:07:05<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Configuration
public class WebFileConfig implements WebFluxConfigurer {

	@Resource
	private FileServerConfig fileServerConfig;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String filePath = fileServerConfig.getPath();
		String download = fileServerConfig.getDownloadPath();
		registry.addResourceHandler("/" + download + "/**").addResourceLocations("file:" + filePath + "/");
	}
}
