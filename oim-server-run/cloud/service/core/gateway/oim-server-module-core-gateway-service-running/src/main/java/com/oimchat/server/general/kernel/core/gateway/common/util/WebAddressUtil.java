package com.oimchat.server.general.kernel.core.gateway.common.util;

import org.springframework.http.server.reactive.ServerHttpRequest;

/**
 * Date 2019-01-07 22:07:51<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class WebAddressUtil {

	/**
	 * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
	 *
	 * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
	 * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
	 *
	 * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130, 192.168.1.100
	 *
	 * 用户真实IP为： 192.168.1.110
	 *
	 * @param request
	 * @return
	 */
	public static String getIpAddress(ServerHttpRequest request) {
		String unknown = "unknown";
		String ip = null;
		if (null != request) {
			if (null != request.getHeaders()) {
				ip = request.getHeaders().getFirst("X-Real-IP");
				if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
					ip = request.getHeaders().getFirst("X-Forwarded-For");
				}
				if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
					ip = request.getHeaders().getFirst("Proxy-Client-IP");
				}
				if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
					ip = request.getHeaders().getFirst("WL-Proxy-Client-IP");
				}
				if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
					ip = request.getHeaders().getFirst("HTTP_CLIENT_IP");
				}
				if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
					ip = request.getHeaders().getFirst("HTTP_X_FORWARDED_FOR");
				}
			}
			if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
				ip = (null != request.getRemoteAddress() && null != request.getRemoteAddress().getAddress()) ? request.getRemoteAddress().getAddress().getHostAddress() : ip;
			}
		}
		return ip;
	}
}
