package com.oimchat.server.general.kernel.work.module.business.contact.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.contact.dao.ContactAddVerifyQuestionDAO;
import com.oimchat.server.general.kernel.work.module.base.contact.dao.ContactHarassSettingDAO;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactAddVerifyQuestion;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactHarassSetting;
import com.oimchat.server.general.kernel.work.module.base.contact.manager.ContactHarassSettingManager;
import com.onlyxiahui.common.message.bean.Info;
import com.onlyxiahui.common.utils.base.util.time.DateUtil;

/**
 * Date 2019-01-20 18:21:27<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
@Transactional
public class ContactHarassSettingService {

	@Resource
	private ContactHarassSettingDAO contactHarassSettingDAO;
	@Resource
	private ContactAddVerifyQuestionDAO contactAddVerifyQuestionDAO;
	@Resource
	private ContactHarassSettingManager contactHarassSettingManager;

	/**
	 * 
	 * Date 2019-01-20 18:59:56<br>
	 * Description 获取用户防骚扰设置
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public ContactHarassSetting getByUserId(String userId) {
		ContactHarassSetting data = contactHarassSettingManager.getByUserId(userId);
		return data;
	}

	/**
	 * 
	 * Date 2019-01-20 19:01:54<br>
	 * Description 获取用户验证问题列表
	 * 
	 * @author XiaHui<br>
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	public List<ContactAddVerifyQuestion> getVerifyQuestionListByUserId(String userId) {
		List<ContactAddVerifyQuestion> list = contactAddVerifyQuestionDAO.getListByUserId(userId);
		return list;
	}

	public Info saveOrUpdate(ContactHarassSetting data, List<ContactAddVerifyQuestion> list) {
		Info info = new Info();
		try {
			if (ContactHarassSetting.verify_type_answer.equals(data.getVerifyType())) {
				if (null == data.getQuestion() || "".equals(data.getQuestion())) {
					info.addWarning("001", "问题不能为空！");
				}
				if (null == data.getAnswer() || "".equals(data.getAnswer())) {
					info.addWarning("002", "答案不能为空！");
				}
			}
			if (ContactHarassSetting.verify_type_confirm.equals(data.getVerifyType())) {
				if (null == list || list.isEmpty()) {
					info.addWarning("003", "问题不能为空！");
				} else {
					int i = 1;
					for (ContactAddVerifyQuestion d : list) {
						if (null == d.getQuestion() || "".equals(d.getQuestion())) {
							info.addWarning("001", "第" + i + "问题不能为空！");
						}
						i++;
					}
				}
			}
			if (info.isSuccess()) {
				saveOrUpdate(data);
				saveOrUpdate(data.getUserId(), list);
			}
		} catch (Exception e) {
			info.addWarning("000", "系统异常");
		}
		return info;
	}

	public void saveOrUpdate(ContactHarassSetting data) {

		String userId = data.getUserId();
		String id = contactHarassSettingDAO.getIdByUserId(userId);
		if (null == id) {
			data.setCreatedDateTime(DateUtil.getCurrentDateTime());
			contactHarassSettingDAO.save(data);
		} else {
			data.setId(id);
			contactHarassSettingDAO.update(data);
		}
	}

	public void saveOrUpdate(String userId, List<ContactAddVerifyQuestion> list) {
		contactAddVerifyQuestionDAO.deleteByUserId(userId);
		for (ContactAddVerifyQuestion data : list) {
			data.setUserId(userId);
			contactAddVerifyQuestionDAO.save(data);
		}
	}
}
