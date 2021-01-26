package com.oimchat.server.cloud.net.basic.message.data;

import java.util.List;

/**
 * @author: XiaHui
 * @date: 2018-03-02 14:29:24
 */
public class MessageData {

	private String key;
	private List<String> keyList;
	private String type;
	private String data;

	public static final String type_one = "1";
	public static final String type_list = "2";
	public static final String type_all = "3";
	public static final String type_without_one = "4";
	public static final String type_without_list = "5";

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<String> getKeyList() {
		return keyList;
	}

	public void setKeyList(List<String> keyList) {
		this.keyList = keyList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
