package com.oimchat.doc.config;

import java.util.List;

import org.springframework.stereotype.Component;

import com.onlyxiahui.common.action.description.bean.ModuleData;
import com.onlyxiahui.general.doc.spring.boot.extend.DocActionHandler;

/**
 * Description <br>
 * Date 2020-06-02 09:43:17<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class DocActionHandlerImpl implements DocActionHandler {

	private String[] roots = { "1", "support" };

	@Override
	public void handle(List<ModuleData> list) {
		if (null != list) {
			String sk = "manage";
			for (ModuleData m : list) {
				String key = m.getKey();
				String superKey = m.getSuperKey();
				boolean isRoot = isRoot(key);
				boolean mark = !sk.equals(key) && (null == superKey || superKey.isEmpty());
				if (!isRoot && mark) {
					m.setSuperKey(sk);
				}
			}
		}
	}

	private boolean isRoot(String key) {
		for (String r : roots) {
			if (r.equals(key)) {
				return true;
			}
		}
		return false;
	}
}
