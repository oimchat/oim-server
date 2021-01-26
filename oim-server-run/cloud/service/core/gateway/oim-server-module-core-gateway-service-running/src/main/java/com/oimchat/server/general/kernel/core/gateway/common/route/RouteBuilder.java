package com.oimchat.server.general.kernel.core.gateway.common.route;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.BooleanSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;

import com.alibaba.fastjson.JSONObject;
import com.oimchat.server.general.kernel.core.gateway.common.route.config.RouteManager;
import com.onlyxiahui.common.data.base.HeadImpl;
import com.onlyxiahui.common.lib.util.json.JsonUtil;
import com.onlyxiahui.framework.action.dispatcher.registry.ActionRegistry;

import reactor.core.publisher.Mono;

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
public class RouteBuilder {

	private final String route = "/**";

	@Autowired
	RouteManager routeManager;

	ActionRegistry actionRegistry = new ActionRegistry();

	@Bean
	public RouteLocator createRoutes(RouteLocatorBuilder builder) {

		RouteLocatorBuilder.Builder routes = builder.routes();
		RouteLocatorBuilder.Builder serviceProvider = routes.route("route",
				r -> {
					// r.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					// .and()
					// .method(HttpMethod.POST)
					// .and()
					String uri = "lb://work-portal";
					BooleanSpec b = r.readBody(String.class, data -> {
						return true;
					});
					return b.and()
							.predicate(e -> {
								return true;
							})
							.and()
							.path(route)
							.filters(f -> {
								// f.stripPrefix(1);
								f.hystrix(c -> {
									c.setName("fallbackcmd");
									c.setFallbackUri("forward:/fallback");
								});
								f.filters(gatewayFilter());
								return f;
							})
							.uri(uri);
				});
		RouteLocator routeLocator = serviceProvider.build();
		return routeLocator;
	}

	private GatewayFilter gatewayFilter() {
		return new GatewayFilter() {
			@Override
			public Mono<Void> filter(
					ServerWebExchange exchange,
					GatewayFilterChain chain) {

				String url = exchange.getRequest().getPath().value();
				Object requestBody = exchange.getAttribute(RouterConstant.CACHED_REQUEST_BODY);
				ServerHttpRequest req = exchange.getRequest();

//				addOriginalRequestUrl(exchange, req.getURI());
//				Map<String, String> uriVariables = getUriTemplateVariables(exchange);
				String serviceName = getServiceName(url, requestBody);
				if (null != serviceName && !serviceName.isEmpty()) {
					// String rawPath = req.getURI().getRawPath();
					String u = "lb://" + serviceName;
					// URI.create(u + rawPath);.fromHttpUrl(u + rawPath)
					URI uri = UriComponentsBuilder.fromHttpRequest(req).build().toUri();

					Route route = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
					Route newRoute = Route.async()
							.asyncPredicate(route.getPredicate())
							.filters(route.getFilters())
							.order(route.getOrder())
							.id(route.getId())
							.uri(u).build();

					ServerHttpRequest request = req.mutate().uri(uri).build();

					exchange.getAttributes().put(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR, newRoute);
					return chain.filter(exchange.mutate().request(request).build());
				} else {
					return chain.filter(exchange);
				}
			}
		};
	}

	private String getServiceName(String url, Object data) {
		String path = getPath(data);
		url = path == null ? url : path;
		String name = routeManager.getService(url);
		return name;
	}

	private String getPath(Object data) {
		String path = null;
		String message = (data instanceof String) ? data.toString() : "";
		if (JsonUtil.maybeJsonObject(message)) {
			JSONObject jo = JSONObject.parseObject(message);

			boolean hasHead = jo.containsKey(DataConstant.HEAD) && jo.get(DataConstant.HEAD) instanceof JSONObject;
			if (hasHead) {
				JSONObject headElement = jo.getJSONObject(DataConstant.HEAD);
				HeadImpl head = headElement.toJavaObject(HeadImpl.class);

				String classCode = (head.getAction() == null) ? "" : head.getAction();
				String methodCode = head.getMethod();
				if (null != methodCode && !methodCode.isEmpty()) {
					path = actionRegistry.getPath(classCode, methodCode);
				}
			}
		}
		return path;
	}
}
