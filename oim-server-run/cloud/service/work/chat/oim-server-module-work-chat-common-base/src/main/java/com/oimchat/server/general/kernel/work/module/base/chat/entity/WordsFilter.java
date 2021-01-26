package com.oimchat.server.general.kernel.work.module.base.chat.entity;

import javax.persistence.Entity;

import com.onlyxiahui.aware.basic.bean.PrimaryStringEntity;

/**
 * 聊天过滤的敏感词<br>
 * 
 * @author: Only
 * @date: 2016-08-15 14:59:51
 */
@Entity(name = "im_words_filter")
public class WordsFilter extends PrimaryStringEntity {

	private String words;
	private int level;

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
