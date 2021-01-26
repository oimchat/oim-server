package com.oimchat.server.general.kernel.work.module.business.notice.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.notice.dao.TextNoticeDAO;
import com.oimchat.server.general.kernel.work.module.base.notice.entity.TextNotice;
import com.oimchat.server.general.kernel.work.module.base.notice.entity.UserTextNotice;
import com.onlyxiahui.common.utils.base.util.time.DateUtil;
import com.onlyxiahui.extend.query.page.QueryPage;

/**
 * @author Only
 * @date 2016�?5�?20�? 上午11:45:04
 */
@Service
@Transactional
public class TextNoticeService {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private TextNoticeDAO textNoticeDAO;

	public void save(TextNotice textNotice, List<String> userIds, String pushType) {
		if (null != textNotice) {
//			textNotice.setCreatedDateTime(DateUtil.getCurrentDateTime());
			textNotice.setTimestamp(System.currentTimeMillis());
			if (null == userIds || userIds.isEmpty()) {
				textNotice.setPushType(TextNotice.push_type_all);
				textNoticeDAO.save(textNotice);
				String textNoticeId = textNotice.getId();
				textNoticeDAO.insertPush(textNoticeId, userIds);
			} else {
				textNotice.setPushType(TextNotice.push_type_part);
				textNoticeDAO.save(textNotice);

				String textNoticeId = textNotice.getId();
				if ("1".equals(pushType)) {
					for (String userId : userIds) {
						UserTextNotice utn = new UserTextNotice();
						utn.setUserId(userId);
						utn.setTextNoticeId(textNoticeId);
						utn.setCreatedDateTime(DateUtil.getCurrentDateTime());
						utn.setIsRead("0");
						textNoticeDAO.save(utn);
					}
				} else {
					textNoticeDAO.insertPush(textNoticeId, userIds);
				}
			}
		}
	}

	public List<TextNotice> getTextNoticeList(String userId, QueryPage page) {
		List<TextNotice> list = textNoticeDAO.getTextNoticeList(userId, page);
		return list;
	}
}
