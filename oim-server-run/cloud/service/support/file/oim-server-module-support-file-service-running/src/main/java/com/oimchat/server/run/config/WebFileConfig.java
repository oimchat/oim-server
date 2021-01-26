package com.oimchat.server.run.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
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

	/**
	 * webflux中的reactive的拦截器
	 * 
	 * @return
	 */
	@Bean
	public CorsWebFilter corsWebFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true); // 允许cookies跨域
		config.addAllowedOrigin("*");// #允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin
		config.addAllowedHeader("*");// #允许访问的头信息,*表示全部
		config.setMaxAge(18000L);// 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
		config.addAllowedMethod("*");// 允许提交请求的方法，*表示全部允许
		source.registerCorsConfiguration("/**", config);
		return new CorsWebFilter(source);
	}

	@Resource
	private FileServerConfig fileServerConfig;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String filePath = fileServerConfig.getPath();
		String download = fileServerConfig.getDownloadPath();
		registry.addResourceHandler("/" + download + "/**").addResourceLocations("file:" + filePath + "/");
	}
}
