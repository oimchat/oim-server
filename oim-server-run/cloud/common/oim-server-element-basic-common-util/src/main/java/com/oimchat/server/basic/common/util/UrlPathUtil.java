
package com.oimchat.server.basic.common.util;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

/**
 * Description <br>
 * Date 2020-04-20 17:01:06<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class UrlPathUtil {

	/**
	 * 
	 * 去掉前缀<br>
	 * Date 2020-04-20 17:02:52<br>
	 * 
	 * @param path
	 * @param parts
	 * @return
	 * @since 1.0.0
	 */
	public static String stripPrefix(String path, int parts) {
		String newPath = "/" + Arrays.stream(StringUtils.tokenizeToStringArray(path, "/"))
				.skip(parts).collect(Collectors.joining("/"));
		newPath += (newPath.length() > 1 && path.endsWith("/") ? "/" : "");
		return newPath;
	}
}
