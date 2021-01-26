package com.oimchat.doc.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oimchat.server.run.initialize.InitializerFunction;
import com.onlyxiahui.common.action.description.bean.ModuleData;
import com.onlyxiahui.general.doc.spring.boot.extend.DocActionFinish;

/**
 * Description <br>
 * Date 2020-06-02 13:50:37<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class DocActionFinishImpl implements DocActionFinish {

	@Autowired
	InitializerFunction initializerFunction;

	@Override
	public void finish(List<ModuleData> list) {
		if (null != list) {
			String sk = "manage";
			List<ModuleData> ms = new ArrayList<>();
			for (ModuleData m : list) {
				String key = m.getKey();
				String superKey = m.getSuperKey();
				boolean mark = sk.equals(superKey) || sk.equals(key);
				if (mark) {
					ms.add(m);
				}
			}
			initializerFunction.initializeModule(ms);
		}
	}
}
