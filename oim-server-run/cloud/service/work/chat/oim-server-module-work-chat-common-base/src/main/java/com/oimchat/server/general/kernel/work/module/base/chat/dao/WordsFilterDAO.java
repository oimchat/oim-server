package com.oimchat.server.general.kernel.work.module.base.chat.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.chat.entity.WordsFilter;
import com.onlyxiahui.aware.basic.dao.BaseDAO;

/**
 * 
 * Date 2019-01-20 19:46:20<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Repository
public class WordsFilterDAO extends BaseDAO {

	@SuppressWarnings("unchecked")
	public List<WordsFilter> getAllWordsFilterList() {
		List<WordsFilter> list = (List<WordsFilter>) this.find("from " + WordsFilter.class.getName());
		return list;
	}
}
