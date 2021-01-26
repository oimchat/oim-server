package com.oimchat.server.general.kernel.core.gateway.common.util;

import com.oimchat.server.general.kernel.core.gateway.common.constant.LocalIP;

/**
 * 
 * <br>
 * Date 2019-07-24 16:21:28<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class IpUtil {

	/**
	 * 检测调用者IP地址（IPV4）是否在白名单内
	 *
	 * @param ip        客户端IP
	 * @param whiteList 白名单IP地址
	 * @return 返回true表示调用者ip在白名单内
	 */
	public static boolean isIncludedInWhiteList(String ip, String[] whiteList) {
		// 本地访问一律通过
		if (LocalIP.IP1.get().equals(ip) || LocalIP.IP2.get().equals(ip)) {
			return true;
		}
		return isIncluded(ip, whiteList);
	}

	public static boolean isIncluded(String ip, String[] list) {
		// 记录匹配状态，默认未匹配
		boolean isMatched = false;
		String[] segments = ip.split("\\.");
		// 拿规则循环匹配客户端IP，有符合的则中止，否则遍历完所有规则
		for (String ipValue : list) {
			String[] ipValueSegments = ipValue.split("\\.");
			// 如果两个ip段数量不相同则不用继续比较了，因为肯定不符合
			if (segments.length != ipValueSegments.length) {
				continue;
			}

			int numberOfMatches = 0;
			for (int i = 0; i < ipValueSegments.length; i++) {
				// 如果规则中的当前段为*号，则肯定通过，不用再后续比较了
				if ("*".equals(ipValueSegments[i])) {
					++numberOfMatches;
					continue;
				}
				// 只要有一个段不匹配则不用后续比较
				if (!ipValueSegments[i].equals(segments[i])) {
					break;
				}
				++numberOfMatches;
			}
			// 判断是否匹配成功，如果已经匹配到则不用继续了
			if (numberOfMatches == ipValueSegments.length) {
				isMatched = true;
				break;
			}
		}
		return isMatched;
	}
}
