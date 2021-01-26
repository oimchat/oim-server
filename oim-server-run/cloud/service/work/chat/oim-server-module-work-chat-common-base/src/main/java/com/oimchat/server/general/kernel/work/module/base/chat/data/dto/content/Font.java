package com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content;

/**
 * 
 * Date 2019-01-06 12:04:28<br>
 * Description 聊天内容的字体信息
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
public class Font {

	private boolean underline = false;
	private boolean bold = false;
	private boolean italic = false;
	private String color = "000000";
	private String name = "微软雅黑";
	private int size = 12;

	public boolean isUnderline() {
		return underline;
	}

	public void setUnderline(boolean underline) {
		this.underline = underline;
	}

	public boolean isBold() {
		return bold;
	}

	public void setBold(boolean bold) {
		this.bold = bold;
	}

	public boolean isItalic() {
		return italic;
	}

	public void setItalic(boolean italic) {
		this.italic = italic;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
