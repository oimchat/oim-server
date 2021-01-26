
package com.oimchat.server.run.dispatcher;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.oimchat.server.basic.definition.auth.business.UserTokenAuthBox;
import com.oimchat.server.run.dispatcher.auth.PathBox;
import com.oimchat.server.run.dispatcher.auth.ResultHead;
import com.oimchat.server.run.dispatcher.auth.TokenAuthService;
import com.onlyxiahui.aware.basic.work.business.error.SystemError;
import com.onlyxiahui.common.lib.util.json.JsonUtil;
import com.onlyxiahui.common.message.node.Head;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.framework.action.dispatcher.ActionContext;
import com.onlyxiahui.framework.action.dispatcher.common.ApplyInfo;
import com.onlyxiahui.framework.action.dispatcher.extend.ActionInterceptor;
import com.onlyxiahui.framework.action.dispatcher.extend.ActionRequest;
import com.onlyxiahui.framework.action.dispatcher.extend.ActionResponse;
import com.onlyxiahui.framework.action.dispatcher.extend.ArgumentBox;
import com.onlyxiahui.framework.net.session.SocketSession;

/**
 * Description <br>
 * Date 2020-05-15 19:57:12<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class SessionAuthActionInterceptor implements ActionInterceptor {

	@Autowired
	UserTokenAuthBox userTokenAuthBox;
	@Autowired
	TokenAuthService tokenAuthService;
	@Autowired
	PathBox pathBox;

	String headKey = "head";
	String key = "key";

	List<String> skipPaths = new ArrayList<>();

	public SessionAuthActionInterceptor() {
		skipPaths.add("/1.0.002/1.1.0001");
		skipPaths.add("/v1/config/server.config/get.data");
	}

	@Override
	public ApplyInfo previous(ActionContext actionContext, ActionRequest request, ActionResponse response, ArgumentBox argumentBox) {
		SocketSession ss = argumentBox.get(SocketSession.class);

		ApplyInfo applyInfo = new ApplyInfo();
		applyInfo.setApprove(true);

		String path = request.getPath();
		// 不用拦截
		if (isSkip(path)) {
			return applyInfo;
		}
		Object requestBody = request.getData();
		boolean isAuth = (null != ss) && ss.isAuth();
		if (isAuth) {
			// 超级管理员
			if (isRoot(key)) {
				return applyInfo;
			}

			if (isGrant(path)) {
				if (!hasPermission(key, path)) {
					ResultMessage r = get(requestBody, SystemError.ACCESS_DENIED.value(), SystemError.ACCESS_DENIED.message());
					applyInfo.setApprove(false);
					applyInfo.setValue(r);
					return applyInfo;
				}
			}
		} else {
			String code = SystemError.AUTHENTICATION_FAILED.value();
			String message = SystemError.AUTHENTICATION_FAILED.message();
			ResultMessage r = get(requestBody, code, message);
			applyInfo.setApprove(false);
			applyInfo.setValue(r);
			return applyInfo;
		}
		return applyInfo;
	}

	ResultMessage get(Object requestBody, String code, String message) {
		ResultMessage result = new ResultMessage();
		result.setHead(getResultHead(requestBody));
		result.addError(code, message);
		return result;
	}

	private Head getResultHead(Object data) {
		ResultHead head = new ResultHead();
		head.setKey(System.currentTimeMillis() + "");
		if (data instanceof Map) {
			Map<?, ?> map = (Map<?, ?>) data;
			Object h = map.get("head");
			if (head instanceof Map) {
				@SuppressWarnings("unchecked")
				Map<Object, Object> value = ((Map<Object, Object>) h);
				Object o = value.get(key);
				if (null != o) {
					head.setKey(o.toString());
				}
			}
		} else if (data instanceof String) {
			String json = data.toString();
			if (JsonUtil.maybeJsonObject(json)) {
				LinkedHashMap<String, Object> map = JSONObject.parseObject(json, new TypeReference<LinkedHashMap<String, Object>>() {
				});

				Object h = map.get("head");
				if (head instanceof Map) {
					@SuppressWarnings("unchecked")
					Map<Object, Object> value = ((Map<Object, Object>) h);
					Object o = value.get(key);
					if (null != o) {
						head.setKey(o.toString());
					}
				}
			}
		}
		head.setTimestamp(System.currentTimeMillis());
		return head;
	}

	/**
	 * 
	 * 无需拦截 <br>
	 * Date 2021-01-19 10:10:52<br>
	 * 
	 * @param lookupPath
	 * @return
	 * @since 1.0.0
	 */
	boolean isSkip(String lookupPath) {
		boolean has = pathBox.isSkip(lookupPath);
		return has || skipPaths.contains(lookupPath);
	}

	/**
	 * 
	 * 需要权限 <br>
	 * Date 2021-01-19 10:11:04<br>
	 * 
	 * @param lookupPath
	 * @return
	 * @since 1.0.0
	 */
	boolean isGrant(String lookupPath) {
		return pathBox.isGrant(lookupPath);
	}

	boolean isRoot(String key) {
		return tokenAuthService.isRoot(key);
	}

	boolean isAuth(String key, String token) {
		return tokenAuthService.isAuth(key, token);
	}

	boolean hasPermission(String key, String path) {
		return tokenAuthService.hasPermission(key, path);
	}
}
