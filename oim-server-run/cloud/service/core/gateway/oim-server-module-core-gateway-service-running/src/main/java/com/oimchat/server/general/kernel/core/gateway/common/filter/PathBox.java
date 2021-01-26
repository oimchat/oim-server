package com.oimchat.server.general.kernel.core.gateway.common.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.PathContainer;
import org.springframework.stereotype.Component;

import com.oimchat.server.cloud.action.discover.box.DiscoverActionInfoBox;
import com.oimchat.server.cloud.action.discover.data.ActionInfo;
import com.onlyxiahui.aware.common.auth.type.PermissionType;

/**
 * Description <br>
 * Date 2021-01-19 09:43:39<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class PathBox {

	@Autowired
	DiscoverActionInfoBox discoverActionDataBox;

	public boolean isSkip(String lookupPath) {
		boolean skip = false;
		ActionInfo info = discoverActionDataBox.getActionInfo(lookupPath);
		if (null != info) {
			skip = PermissionType.skip.toString().equals(info.getPermissionType());
		}
		return skip;
	}

	public boolean isSkip(PathContainer lookupPath) {
		boolean skip = false;
		ActionInfo info = discoverActionDataBox.getActionInfo(lookupPath);
		if (null != info) {
			skip = PermissionType.skip.toString().equals(info.getPermissionType());
		}
		return skip;
	}

	public boolean isGrant(String lookupPath) {
		boolean grant = false;
		ActionInfo info = discoverActionDataBox.getActionInfo(lookupPath);
		if (null != info) {
			grant = PermissionType.grant.toString().equals(info.getPermissionType());
		}
		return grant;
	}

	public boolean isGrant(PathContainer lookupPath) {
		boolean grant = false;
		ActionInfo info = discoverActionDataBox.getActionInfo(lookupPath);
		if (null != info) {
			grant = PermissionType.grant.toString().equals(info.getPermissionType());
		}
		return grant;
	}
}
