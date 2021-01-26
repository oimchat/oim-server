package com.oimchat.server.general.kernel.work.common.config.constant;

/**
 * Date 2019-01-16 11:42:49<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */

public class ServerConstant {

	/**
	 * 
	 * Date 2019-01-16 11:51:28<br>
	 * Description 服务类型
	 * 
	 * @author XiaHui<br>
	 * @since 1.0.0
	 */
	public enum ServerType {

		main("main"), file("file"), video("video"), voice("voice");

		private String value;

		private ServerType(String value) {
			this.value = value;
		}

		public String value() {
			return this.value;
		}
	}
}
