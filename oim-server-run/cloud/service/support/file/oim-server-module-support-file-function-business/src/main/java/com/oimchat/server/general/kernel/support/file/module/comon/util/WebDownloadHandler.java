package com.oimchat.server.general.kernel.support.file.module.comon.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.oimchat.server.general.kernel.support.file.common.util.FilePathUtil;
import com.oimchat.server.general.kernel.support.file.module.common.entity.FileBaseData;
import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ZeroCopyHttpOutputMessage;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * Description <br>
 * Date 2020-07-17 09:12:41<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class WebDownloadHandler {

	protected static final Logger logger = LoggerFactory.getLogger(WebDownloadHandler.class);

	public static Mono<Void> download(FileBaseData fd, ServerWebExchange exchange) {
		if (null != fd) {
			String rootPath = fd.getRootPath();
			String nodePath = fd.getNodePath();
			String saveFullName = fd.getSaveFullName();

			String fullPath = FilePathUtil.getFullPath(rootPath, nodePath);
			String saveFullPathName = FilePathUtil.getFullPathName(fullPath, saveFullName);

			String fileName = fd.getOriginalFullName();

			File file = new File(saveFullPathName);
			if (file.exists()) {
				ServerHttpRequest request = exchange.getRequest();
				ServerHttpResponse response = exchange.getResponse();

				long length = file.length();
				String agent = request.getHeaders().getFirst("USER-AGENT");
				String java = "java";
				try {
					if (StringUtil.isNotBlank(agent)) {
						// IE下载乱码处理
						if (useUtf8(agent)) {
							fileName = URLEncoder.encode(fileName, "UTF-8");
							// 处理空格变“+”的问题
							String t = "%20";
							fileName = fileName.replace("+", t);
							// FF
						} else if (agent.toLowerCase().indexOf(java) > 0) {
						} else {
							fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
						}
					} else {
						fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
					}
				} catch (UnsupportedEncodingException e) {
					logger.error(e.getMessage(), e);
				}

				ZeroCopyHttpOutputMessage zeroCopyResponse = (ZeroCopyHttpOutputMessage) response;

				response.getHeaders().set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");
				response.getHeaders().setContentType(MediaType.APPLICATION_OCTET_STREAM);
				response.getHeaders().setContentLength(length);
//				try {
//					fdh.downloadByIO(response.writeWith(body), file);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

//				response.setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY);
//				response.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
//				response.writeWith(Mono.just(buffer));

				return zeroCopyResponse.writeWith(file, 0L, length);
			}
		}
		return Mono.empty();
	}

	private static boolean useUtf8(String agent) {
		String lowerCase = null == agent ? "" : agent.toLowerCase();
		// IE下载乱码处理
		String msie = "msie";
		String ie11 = "rv:11";
		String edge = "edge";
		if (lowerCase.indexOf(msie) > 0 || lowerCase.indexOf(ie11) > 0 || lowerCase.indexOf(edge) > 0) {
			return true;
		} else {
			return false;
		}
	}
}
