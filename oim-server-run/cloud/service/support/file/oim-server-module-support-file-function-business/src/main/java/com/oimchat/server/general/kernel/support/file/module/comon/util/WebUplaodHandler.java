package com.oimchat.server.general.kernel.support.file.module.comon.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.codec.multipart.Part;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * Description <br>
 * Date 2020-07-17 09:12:41<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class WebUplaodHandler {

	protected static final Logger logger = LoggerFactory.getLogger(WebUplaodHandler.class);

	public static <T> Mono<T> upload(ServerWebExchange exchange, UploadHandler<T> handler) {

		Mono<MultiValueMap<String, Part>> multipartData = exchange.getMultipartData();
		Mono<T> then = multipartData.map(map -> {
			List<FilePart> fs = new ArrayList<>();
			for (List<Part> list : map.values()) {
				if (null != list) {
					for (Part p : list) {
						if (p instanceof FilePart) {
							FilePart fp = (FilePart) p;
							fs.add(fp);
						}
					}
				}
			}
			return fs;
		}).flatMap(parts -> {
			T t = handler.handle(parts);
			return Mono.just(t);
		});// .then(Mono.just("OK"));
//	    Mono<String> then = exchange.getMultipartData().map(it -> it.get("files"))
//	        .flatMapMany(Flux::fromIterable)
//	        .cast(FilePart.class)
//	        .flatMap(it -> it.transferTo())
//	        .then(Mono.just("OK"));
		return then;
	}
}
