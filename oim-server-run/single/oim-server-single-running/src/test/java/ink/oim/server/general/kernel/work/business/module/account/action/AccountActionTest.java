
package ink.oim.server.general.kernel.work.business.module.account.action;

import org.junit.Test;

import com.oimchat.server.general.kernel.work.module.base.user.entity.User;
import com.onlyxiahui.common.data.common.builder.PushMessageBuilder;
import com.onlyxiahui.common.lib.util.http.HttpClient4Util;
import com.onlyxiahui.common.lib.util.json.JsonUtil;
import com.onlyxiahui.common.message.push.PushMessage;
import com.onlyxiahui.common.utils.base.security.Md5Util;

/**
 * Description <br>
 * Date 2020-05-07 12:11:07<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class AccountActionTest {

	String baseUrl = "http://10.32.1.80:10000";

	@Test
	public void add() {
		String url = baseUrl + "/main/";

		int baseSize = 10000;
		String password = Md5Util.lower32("123456");

		for (int i = 0; i < 100000; i++) {
			User user = new User();
//			user.setId("444444");
//			user.setNumber(0L);
			user.setNickname(baseSize + "");
			user.setAccount("o" + (baseSize + i));
			user.setPassword(password);
//			user.setType("1");

			String action = "1.1.001";
			String method = "1.1.0001";
			PushMessage rm = PushMessageBuilder.build(action, method);
			rm.bodyPut("user", user);

			String data = JsonUtil.toJson(rm);
			String json = HttpClient4Util.doPost(url, data);
			System.out.println(json);
		}
	}

	public static void main(String[] arg) {
		AccountActionTest ac = new AccountActionTest();
		ac.add();
	}
}
