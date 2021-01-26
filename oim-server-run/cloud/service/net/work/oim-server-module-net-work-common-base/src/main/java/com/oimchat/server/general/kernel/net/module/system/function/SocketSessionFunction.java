
package com.oimchat.server.general.kernel.net.module.system.function;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.general.kernel.net.module.system.data.OnlineInfo;
import com.oimchat.server.general.kernel.net.module.system.push.SystemAuthPush;
import com.onlyxiahui.framework.net.session.SocketSession;
import com.onlyxiahui.wofa.server.net.core.session.SocketSessionBox;

/**
 * Description <br>
 * Date 2020-04-13 23:23:50<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class SocketSessionFunction {

	@Resource
	SocketSessionBox socketSessionBox;

	@Resource
	SystemAuthPush systemAuthPush;

	public void otherOnline(String userId, String offlineTag, String onlineId, OnlineInfo onlineInfo) {
		offlineTag = null == offlineTag || offlineTag.isEmpty() ? "0" : offlineTag;
		Set<SocketSession> offlineSet = new HashSet<>();
		Set<SocketSession> onlineSet = new HashSet<>();

		Set<SocketSession> allSet = socketSessionBox.getSet(userId);
		if (allSet != null && !allSet.isEmpty()) {
			for (SocketSession ss : allSet) {
				String id = ss.getId();
				String tag = null == ss.getTag() ? "" : ss.getTag();
				boolean mark = !id.equals(onlineId);
				if (mark && tag.equals(offlineTag)) {
					offlineSet.add(ss);
				} else {
					onlineSet.add(ss);
				}
			}
		}
		onlineInfo.setCurrentOffline(false);
		systemAuthPush.pushOtherOnline(onlineSet, onlineInfo);

		onlineInfo.setCurrentOffline(true);
		systemAuthPush.pushOtherOnline(offlineSet, onlineInfo);

		close(offlineSet);
	}

	public Set<SocketSession> getOffline(String userId, String offlineTag, String onlineId) {
		offlineTag = null == offlineTag || offlineTag.isEmpty() ? "0" : offlineTag;
		Set<SocketSession> offlineSet = new HashSet<>();
		Set<SocketSession> set = socketSessionBox.getSet(userId);
		if (set != null && !set.isEmpty()) {
			for (SocketSession ss : set) {
				String id = ss.getId();
				boolean mark = !id.equals(onlineId);
				if (mark && offlineTag.equals(ss.getTag())) {
					offlineSet.add(ss);
				}
			}
		}
		return offlineSet;
	}

	public void close(Set<SocketSession> set) {
		for (SocketSession ss : set) {
			try {
				socketSessionBox.remove(ss);
				ss.close();
			} catch (Exception e) {
			}
		}
	}
}
