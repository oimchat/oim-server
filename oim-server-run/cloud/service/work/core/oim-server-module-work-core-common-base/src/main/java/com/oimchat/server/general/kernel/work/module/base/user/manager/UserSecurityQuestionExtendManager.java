package com.oimchat.server.general.kernel.work.module.base.user.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.user.dao.UserDAO;
import com.oimchat.server.general.kernel.work.module.base.user.dao.UserSecurityQuestionDAO;
import com.oimchat.server.general.kernel.work.module.base.user.entity.UserSecurityQuestion;
import com.onlyxiahui.common.utils.base.util.time.DateUtil;

@Service
@Transactional
public class UserSecurityQuestionExtendManager {

	@Resource
	UserDAO userDAO;
	@Resource
	UserSecurityQuestionDAO userSecurityQuestionDAO;

	/**
	 * 
	 * Date 2019-01-20 09:14:05<br>
	 * Description 保存密保问题
	 * 
	 * @author XiaHui<br>
	 * @param list
	 * @param userId
	 * @since 1.0.0
	 */
	public void save(List<UserSecurityQuestion> list, String userId) {
		if (null != list) {
			for (UserSecurityQuestion sq : list) {
				sq.setUserId(userId);
				sq.setCreatedDateTime(DateUtil.getCurrentDateTime());
				userSecurityQuestionDAO.save(sq);
			}
		}
	}

	/**
	 * 
	 * Date 2019-01-20 09:21:35<br>
	 * Description 检查密保问题是否正确
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @param answerList :回答列表
	 * @return
	 * @since 1.0.0
	 */
	public boolean check(String userId, List<UserSecurityQuestion> answerList) {
		boolean check = true;
		List<UserSecurityQuestion> questionList = userSecurityQuestionDAO.getListByUserId(userId);
		if (null != questionList && !questionList.isEmpty() && null != answerList && !answerList.isEmpty()) {
			int answerSize = answerList.size();
			int questionSize = questionList.size();
			// 如果回答数量和问题数量不一致，则回答错误
			if (answerSize == questionSize) {
				Map<String, String> map = new HashMap<String, String>();
				for (UserSecurityQuestion sq : answerList) {
					map.put(sq.getId(), sq.getAnswer());
				}
				for (UserSecurityQuestion sq : questionList) {
					String id = sq.getId();
					String answer = sq.getAnswer();
					// 如果其中一个回答错误，则回答错误
					if (null == answer || !answer.equals(map.get(id))) {
						check = false;
						break;
					}
				}
			} else {
				check = false;
			}

		} else {
			check = false;
		}
		return check;
	}
}
