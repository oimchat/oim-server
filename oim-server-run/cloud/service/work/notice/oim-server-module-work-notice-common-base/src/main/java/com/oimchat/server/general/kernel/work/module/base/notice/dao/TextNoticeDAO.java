package com.oimchat.server.general.kernel.work.module.base.notice.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.notice.entity.TextNotice;
import com.onlyxiahui.aware.basic.dao.BaseDAO;
import com.onlyxiahui.extend.query.hibernate.QueryWrapper;
import com.onlyxiahui.extend.query.page.QueryPage;

/**
 * 描述：
 * 
 * @author XiaHui
 * @date 2016年1月4日 下午9:48:59
 * @version 0.0.1
 */
@Repository
public class TextNoticeDAO extends BaseDAO {

	public void insertPush(String textNoticeId, List<String> outUserIds) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("textNoticeId", textNoticeId);
		if (null != outUserIds && !outUserIds.isEmpty()) {
			queryWrapper.put("outUserIds", outUserIds);
		}
		this.executeByName("notice.insertPush", queryWrapper);
	}

	public List<TextNotice> getTextNoticeList(String userId, QueryPage page) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.put("userId", userId);
		List<TextNotice> list = this.queryListByName("notice.getTextNoticeList", queryWrapper, TextNotice.class);
		return list;
	}
}
