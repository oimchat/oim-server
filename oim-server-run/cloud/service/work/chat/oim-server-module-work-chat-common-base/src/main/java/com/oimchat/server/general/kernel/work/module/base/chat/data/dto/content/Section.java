package com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content;

import java.util.List;

/**
 * 
 * Date 2019-01-06 12:06:11<br>
 * Description 段落信息
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class Section {

	/**
	 * 段落中可能是有图片、文件、文本等信息混排
	 */
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
