package com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content;

/**
 * 
 * Date 2019-01-06 12:05:00<br>
 * Description 段落中的消息内容，如：文本、图片、文件等
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class Item {

	private String type;
	private String value;

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

	public static final String type_text = "text";
	public static final String type_face = "face";
	public static final String type_url = "url";
	public static final String type_image = "image";
	public static final String type_file = "file";
	public static final String type_audio = "audio";
	public static final String type_video = "video";
	public static final String type_position = "position";
	public static final String type_at = "at";
}
