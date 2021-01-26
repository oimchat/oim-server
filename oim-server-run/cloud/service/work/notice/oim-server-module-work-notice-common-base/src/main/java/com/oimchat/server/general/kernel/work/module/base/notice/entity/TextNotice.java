package com.oimchat.server.general.kernel.work.module.base.notice.entity;

import javax.persistence.Entity;

import com.onlyxiahui.aware.basic.bean.PrimaryStringEntity;

/**
 * @author: XiaHui
 * @date: 2017-08-17 2:54:20
 */
@Entity(name = "im_text_notice")
public class TextNotice extends PrimaryStringEntity {

	private String url;
	private String title;
	private String content;
	private long timestamp;
	private String openType;// 1:app 2：browser
	private String pushType;// 通知推送类型，1：所有用户都推送 2：指定用户推送

	public static String open_type_app = "1";
	public static String open_type_browser = "2";

	public static String push_type_all = "1";
	public static String push_type_part = "2";

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getOpenType() {
		return openType;
	}

	public void setOpenType(String openType) {
		this.openType = openType;
	}

	public String getPushType() {
		return pushType;
	}

	public void setPushType(String pushType) {
		this.pushType = pushType;
	}

}
