package com.oimchat.server.general.kernel.work.module.base.group.data.query;

/**
 * 群信息搜索条件<br>
 * Date 2019-01-06 12:08:06<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class GroupQuery {

	/**
	 * 名称
	 */
	private String name;
	/**
	 * 模糊问本
	 */
	private String queryText;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}
}
