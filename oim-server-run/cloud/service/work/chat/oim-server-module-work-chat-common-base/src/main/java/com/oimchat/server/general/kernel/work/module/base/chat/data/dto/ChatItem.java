package com.oimchat.server.general.kernel.work.module.base.chat.data.dto;

/**
 * 
 * Date 2019-02-17 18:42:41<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class ChatItem {

	private String type;//
	private String value;//
	private String filterValue;// 过滤后内容
	private int sort;// 排序
	private int section;// 段落

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getFilterValue() {
		return filterValue;
	}

	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}
}
