
package com.onlyxiahui.demo;

import com.onlyxiahui.extend.query.hibernate.QueryContext;
import com.onlyxiahui.extend.query.hibernate.handler.xml.QueryItemException;

/**
 * Description <br>
 * Date 2020-04-15 22:02:10<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class QueryContextTest {

	public static void main(String[] arg) {
		QueryContext bean = new QueryContext();
		String[] ls = { "classpath*:/dao/query/*/*.*", "classpath*:dao/**/*.*" };
		bean.setConfigLocations(ls);
		// bean.setConfigLocation("file:config/query/*.xml");
		try {
			bean.load();
		} catch (QueryItemException e) {
			e.printStackTrace();
		}
	}
}
