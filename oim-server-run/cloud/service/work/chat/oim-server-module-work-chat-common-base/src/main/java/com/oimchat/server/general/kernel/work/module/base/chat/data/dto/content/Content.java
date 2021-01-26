package com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content;

import java.util.List;

/**
 * 聊天的消息内容,支持图文混排，文件，视频等多种类型<br>
 * Date 2019-01-06 12:00:48<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class Content {
	/**
	 * 消息Id,服务端生成
	 */
	private String id;
	/**
	 * 聊天消息的key
	 */
	private String key;
	/**
	 * 字体信息
	 */
	private Font font = new Font();
	/**
	 * 段落，段落是指聊天内容有换行分段
	 */
	private List<Section> sections;
	/**
	 * 发送的时间戳
	 */
	private long timestamp;

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
