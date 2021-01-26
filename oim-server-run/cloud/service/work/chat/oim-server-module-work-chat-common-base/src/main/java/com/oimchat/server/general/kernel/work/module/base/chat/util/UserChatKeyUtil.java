
package com.oimchat.server.general.kernel.work.module.base.chat.util;

import java.util.LinkedList;
import java.util.List;

/**
 * Description <br>
 * Date 2020-04-17 10:14:06<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class UserChatKeyUtil {

	public static String getUserChatKey(String sendUserId, String receiveUserId) {

		List<String> list = new LinkedList<>();
		list.add(sendUserId);
		list.add(receiveUserId);

		list.sort((v1, v2) -> {
			return v1.compareTo(v2);
		});

		StringBuilder sb = new StringBuilder();
		int size = list.size();
		int last = size - 1;
		for (int i = 0; i < size; i++) {
			String id = list.get(i);
			sb.append(id);
			if (i < last) {
				sb.append("_");
			}
		}
		return sb.toString();
	}
}
