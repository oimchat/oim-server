package com.oimchat.server.general.kernel.work.module.base.chat.function;

import java.util.List;
import java.util.Vector;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.general.kernel.work.module.base.chat.dao.WordsFilterDAO;
import com.oimchat.server.general.kernel.work.module.base.chat.entity.WordsFilter;
import com.oimchat.server.general.kernel.work.module.base.chat.util.WordsParser;

/**
 * 
 * 聊天相关的一些方法功能
 * 
 * @author XiaHui
 * @date 2017-11-23 13:42:43
 */
@Component
public class ChatFunction {

	WordsParser wordsParser = new WordsParser();

	List<WordsFilter> wordsFilterList = null;
	@Resource
	WordsFilterDAO wordsFilterDAO;

	/**
	 * 敏感词汇过滤
	 * 
	 * @author: XiaHui
	 * @createDate: 2016年8月19日 下午3:28:49
	 * @update: XiaHui
	 * @updateDate: 2016年8月19日 下午3:28:49
	 */
	public String wordsFilter(String text) {
		if (null == text || "".equals(text)) {
			return text;
		}
		if (null == wordsFilterList) {
			reload();
		}
		Vector<Integer> levelSet = new Vector<Integer>();
		return wordsParser.parse(text, levelSet);
	}

	public void reload() {
		wordsFilterList = wordsFilterDAO.getAllWordsFilterList();
		wordsParser.clear();
		for (WordsFilter wf : wordsFilterList) {
			wordsParser.addFilterKeyWord(wf.getWords(), wf.getLevel());
		}
	}
}
