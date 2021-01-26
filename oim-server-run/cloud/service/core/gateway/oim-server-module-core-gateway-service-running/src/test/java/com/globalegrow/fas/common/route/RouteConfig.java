package com.globalegrow.fas.common.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

/**
 * 
 * 
 * <br>
 * Date 2019-08-27 14:46:17<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class RouteConfig {

	private static final String SERVICE = "/**";

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {

		/*
		 * route1 是get请求，get请求使用readBody会报错 route2
		 * 是post请求，Content-Type是application/x-www-form-urlencoded，readbody为String.class
		 * route3 是post请求，Content-Type是application/json,readbody为Object.class
		 */
		RouteLocatorBuilder.Builder routes = builder.routes();
		RouteLocatorBuilder.Builder serviceProvider = routes
				.route("route1",
						r -> r.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
								.and()
								.method(HttpMethod.POST)
								.and()
								.readBody(Object.class, readBody -> {
									if (readBody instanceof String) {
										System.out.println(readBody);
									}

									return true;
								}).and().predicate(e -> {
									return true;
								}).and()
								.path(SERVICE)
								.filters(f -> {
									f.stripPrefix(1);
									// f.modifyRequestBody(inClass, outClass, newContentType, rewriteFunction);
									// f.filter(requestFilter);
									return f;
								})
								.uri("lb://fas-validate"))
				.route("route2",
						r -> r.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
								.and()
								.method(HttpMethod.POST)
								.and()
								.readBody(Object.class, readBody -> {
									if (readBody instanceof String) {
										System.out.println(readBody);
									}

									return true;
								}).and().predicate(e -> {

									return true;
								})
								.and()
								.path(SERVICE)
								.filters(f -> {
									f.stripPrefix(1);
									// f.filter(requestFilter);
									return f;
								})
								.uri("lb://fas-auth"));
		RouteLocator routeLocator = serviceProvider.build();
		return routeLocator;
	}
}
