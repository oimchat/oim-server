package com.oimchat.server.general.kernel.work.module.business.contact.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.basic.common.util.KeyUtil;
import com.oimchat.server.general.kernel.work.module.base.contact.dao.ContactAddApplyDAO;
import com.oimchat.server.general.kernel.work.module.base.contact.dao.ContactAddVerifyAnswerDAO;
import com.oimchat.server.general.kernel.work.module.base.contact.dao.ContactAddVerifyQuestionDAO;
import com.oimchat.server.general.kernel.work.module.base.contact.dao.ContactHarassSettingDAO;
import com.oimchat.server.general.kernel.work.module.base.contact.dao.ContactRelationDAO;
import com.oimchat.server.general.kernel.work.module.base.contact.data.dto.ContactAddApplyData;
import com.oimchat.server.general.kernel.work.module.base.contact.data.dto.ContactAddHandleData;
import com.oimchat.server.general.kernel.work.module.base.contact.data.dto.ContactAddResultData;
import com.oimchat.server.general.kernel.work.module.base.contact.data.dto.ContactVerifySettingData;
import com.oimchat.server.general.kernel.work.module.base.contact.data.dto.ContactVerifySettingDataCase;
import com.oimchat.server.general.kernel.work.module.base.contact.data.dto.VerifyAnswer;
import com.oimchat.server.general.kernel.work.module.base.contact.data.dto.VerifyQuestion;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactAddApply;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactAddVerifyAnswer;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactHarassSetting;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactRelation;
import com.oimchat.server.general.kernel.work.module.base.contact.manager.ContactCategoryManager;
import com.oimchat.server.general.kernel.work.module.base.contact.manager.ContactHarassSettingManager;
import com.oimchat.server.general.kernel.work.module.base.contact.manager.ContactRelationManager;
import com.oimchat.server.general.kernel.work.module.base.contact.push.ContactPush;
import com.oimchat.server.general.kernel.work.module.base.contact.push.ContactRelationPush;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.common.utils.base.util.time.DateUtil;

/**
 * 
 * Date 2019-01-20 17:46:44<br>
 * Description 请问添加为联系人相关处理
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
@Transactional
public class ContactAddService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private ContactHarassSettingDAO contactHarassSettingDAO;
	@Resource
	private ContactAddVerifyQuestionDAO contactAddVerifyQuestionDAO;
	@Resource
	private ContactHarassSettingManager contactHarassSettingManager;
	@Resource
	private ContactRelationDAO contactCategoryMemberDAO;
	@Resource
	private ContactAddApplyDAO contactAddApplyDAO;
	@Resource
	private ContactAddVerifyAnswerDAO contactAddVerifyAnswerDAO;
	@Resource
	private ContactRelationPush contactRelationPush;
	@Resource
	private ContactCategoryManager contactCategoryManager;
	@Resource
	private ContactRelationManager contactRelationManager;
	@Resource
	private ContactPush contactPush;

	/**
	 * 
	 * Date 2019-01-20 17:55:07<br>
	 * Description 获取用户被添加为联系人的验证设置
	 * 
	 * @author XiaHui<br>
	 * @param targetUserId
	 * @return
	 * @since 1.0.0
	 */
	public ResultBodyMessage<ContactVerifySettingDataCase> getContactAddVerifySetting(String applyUserId, String targetUserId) {

		ResultBodyMessage<ContactVerifySettingDataCase> rm = new ResultBodyMessage<>();

		boolean isBlocked = contactRelationManager.isBlocked(targetUserId, applyUserId);
		if (isBlocked) {
			rm.addWarning("001", "对方拒绝添加！");
			return rm;
		}

		List<VerifyQuestion> questionList = null;
		ContactVerifySettingData setting = contactHarassSettingDAO.getByUserId(targetUserId, ContactVerifySettingData.class);

		if (setting == null) {
			setting = new ContactVerifySettingData();
			setting.setUserId(targetUserId);
			setting.setVerifyType(ContactHarassSetting.verify_type_auth);
		}

		String type = setting.getVerifyType();
		// 防骚扰设置为回答问题并亲自验证时，获取设置的问题列表
		if (ContactHarassSetting.verify_type_confirm.equals(type)) {
			questionList = contactAddVerifyQuestionDAO.getListByUserId(targetUserId, VerifyQuestion.class);
		}

		if (null == questionList) {
			questionList = new ArrayList<VerifyQuestion>();
		}

		rm.setBody(new ContactVerifySettingDataCase(setting, questionList));
		return rm;
	}

	/**
	 * 
	 * Date 2019-01-20 17:58:09<br>
	 * Description 处理添加为好友的请求
	 * 
	 * @author XiaHui<br>
	 * @param key
	 * @param apply
	 * @param answerList ：回答问题列表
	 * @return
	 * @since 1.0.0
	 */
	public ResultMessage userAddApply(String key, ContactAddApplyData apply, List<VerifyAnswer> answerList) {
		ResultMessage rm = new ResultMessage();

		String applyUserId = apply.getApplyUserId();
		String applyCategoryId = apply.getCategoryId();
		String applyRemark = apply.getRemark();

		String targetUserId = apply.getTargetUserId();

		String applyAnswer = apply.getAnswer();

		// 先判断是否在对方黑名单中
		boolean isBlocked = contactRelationManager.isBlocked(targetUserId, applyUserId);
		if (isBlocked) {
			rm.addWarning("001", "对方拒绝添加！");
			return rm;
		}

		ContactRelation cr = contactCategoryMemberDAO.getByContactUserId(applyUserId, targetUserId);
		if (null != cr) {
			rm.addWarning("001", "已经添加对方为好友了！");
			return rm;
		}

		List<ContactAddApply> list = contactAddApplyDAO.getListByTargetUserId(applyUserId, targetUserId);
		if (null != list && !list.isEmpty()) {
			for (ContactAddApply a : list) {
				if (ContactAddApply.handle_type_untreated.equals(a.getHandleType())) {
					rm.addPrompt("001", "请求已发送！");
					return rm;
				}
			}
		}

		// 先获取对方的安全设置
		ContactHarassSetting setting = contactHarassSettingManager.getByUserId(targetUserId);

		String verifyType = setting.getVerifyType();
		String settingAnswer = null == setting.getAnswer() ? "" : setting.getAnswer();

		String handleType = ContactAddApply.handle_type_untreated;

		if (ContactHarassSetting.verify_type_any.equals(verifyType)) {
			// 如果对方允许任何人添加为好友，那么直接将2人互相添加为好友
			String targetCategoryId = contactCategoryManager.getOrCreateDefaultCategoryId(targetUserId);
			String targetRemark = "";

			handleType = ContactAddApply.handle_type_accept;
			ContactAddApply addApply = addContactAddApply(handleType, apply, answerList, setting);

			bothContact(key, applyUserId, applyCategoryId, applyRemark, targetUserId, targetCategoryId, targetRemark);
			handleUserAddResponse(KeyUtil.getKey(), addApply, "");

		} else if (ContactHarassSetting.verify_type_answer.equals(verifyType)) {
			// 如果是回答问题，那么回答正确后直接将2人互相添加为好友
			if (null == applyAnswer || applyAnswer.isEmpty()) {
				rm.addWarning("002", "请回答问题！");
				return rm;
			}

			String ra = applyAnswer.toLowerCase().trim();
			String sa = settingAnswer.toLowerCase().trim();

			if (!ra.equals(sa)) {
				rm.addWarning("003", "回答不正确！");
				return rm;
			}

			handleType = ContactAddApply.handle_type_accept;
			ContactAddApply addApply = addContactAddApply(handleType, apply, answerList, setting);

			String targetCategoryId = contactCategoryManager.getOrCreateDefaultCategoryId(targetUserId);
			String targetRemark = "";
			bothContact(key, applyUserId, applyCategoryId, applyRemark, targetUserId, targetCategoryId, targetRemark);
			handleUserAddResponse(KeyUtil.getKey(), addApply, "");

		} else if (ContactHarassSetting.verify_type_auth.equals(verifyType)) {
			// 如果需要验证，那么将请求信息保存，待用户自己验证
			ContactAddApply addApply = addContactAddApply(handleType, apply, answerList, setting);

			String applyId = addApply.getId();// 请求记录id

			// 推送添加请信息
			contactPush.pushAddApply(targetUserId, key, applyId);

		} else if (ContactHarassSetting.verify_type_confirm.equals(verifyType)) {
			ContactAddApply addApply = addContactAddApply(handleType, apply, answerList, setting);

			String applyId = addApply.getId();// 请求记录id
			// 推送添加请信息
			contactPush.pushAddApply(targetUserId, key, applyId);
		}
		return rm;
	}

	private boolean bothContact(
			String key,
			String applyUserId,
			String requestCategoryId,
			String requestRemark,
			String targetUserId,
			String addCategoryId,
			String addRemark) {

		boolean mark = true;

		key = KeyUtil.getKey();
		contactRelationManager.bothContact(applyUserId, requestCategoryId, requestRemark, targetUserId, addCategoryId, addRemark);
		// 推送添加成功消
		ContactRelation applyMember = new ContactRelation();
		applyMember.setOwnerUserId(applyUserId);
		applyMember.setContactUserId(targetUserId);
		applyMember.setRemark(requestRemark);
		applyMember.setCategoryId(requestCategoryId);
		contactRelationPush.pushAdd(applyUserId, key, targetUserId);

		ContactRelation addMember = new ContactRelation();
		addMember.setOwnerUserId(targetUserId);
		addMember.setContactUserId(applyUserId);
		addMember.setRemark(addRemark);
		addMember.setCategoryId(addCategoryId);
		contactRelationPush.pushAdd(targetUserId, key, applyUserId);
		return mark;
	}

	private ContactAddApply addContactAddApply(String handleType, ContactAddApplyData request, List<VerifyAnswer> answerList, ContactHarassSetting setting) {

		String applyUserId = request.getApplyUserId();
		String applyCategoryId = request.getCategoryId();
		String applyRemark = request.getRemark();

		String targetUserId = request.getTargetUserId();
		String applyAnswer = request.getAnswer();

		String applyMessage = request.getMessage();

		String verifyType = setting.getVerifyType();
		// String settingAnswer = setting.getAnswer();

		ContactAddApply apply = new ContactAddApply();
		apply.setApplyUserId(applyUserId);
		apply.setTargetUserId(targetUserId);
		apply.setCategoryId(applyCategoryId);
		apply.setRemark(applyRemark);
		apply.setVerifyType(verifyType);
		apply.setCreatedDateTime(DateUtil.getCurrentDateTime());
		apply.setQuestion(setting.getQuestion());
		apply.setAnswer(applyAnswer);
		apply.setHandleType(handleType);
		// apply.setHandleDateTime(LocalDateTime.now());
		apply.setApplyMessage(applyMessage);

		contactAddApplyDAO.save(apply);

		if (ContactHarassSetting.verify_type_confirm.equals(verifyType) && null != answerList && !answerList.isEmpty()) {
			Map<String, VerifyQuestion> questionMap = new HashMap<String, VerifyQuestion>();
			List<VerifyQuestion> questionList = contactAddVerifyQuestionDAO.getListByUserId(targetUserId, VerifyQuestion.class);
			if (null != questionList && !questionList.isEmpty()) {
				for (VerifyQuestion q : questionList) {
					questionMap.put(q.getId(), q);
				}
			}
			String applyId = apply.getId();// 请求消息的id(对应UserAddRequest中的id)

			List<ContactAddVerifyAnswer> list = new ArrayList<ContactAddVerifyAnswer>();
			for (VerifyAnswer a : answerList) {

				String questionId = a.getQuestionId();// 问题id(对应UserAddVerifyQuestion中的id)
				String question = "";// 问题
				String answer = a.getAnswer();// 答案
				VerifyQuestion q = questionMap.get(questionId);
				if (null != q) {
					question = q.getQuestion();
				}
				ContactAddVerifyAnswer bean = new ContactAddVerifyAnswer();
				bean.setApplyId(applyId);
				bean.setApplyUserId(applyUserId);
				bean.setTargetUserId(targetUserId);
				bean.setQuestionId(questionId);
				bean.setQuestion(question);
				bean.setAnswer(answer);
				bean.setCreatedDateTime(DateUtil.getCurrentDateTime());
				list.add(bean);
			}

			if (!list.isEmpty()) {
				contactAddVerifyAnswerDAO.saveList(list);
			}
		}
		return apply;
	}

	public ResultMessage applyHandle(String key, ContactAddHandleData response) {

		ResultMessage rm = new ResultMessage();

		List<String> applyIds = response.getApplyIds();// 请求记录id
		// String applyUserId = response.getApplyUserId();// 添加联系人的请求用户
		// String targetUserId = response.getTargetUserId();// 被添加的用户
		String targetCategoryId = response.geCategoryId();// 分组id
		String targetRemark = response.getRemark();// 备注

		String handleType = response.getHandleType();// 处理结果：0：未处、 1：同意、2：拒绝、3：忽略
		String message = response.getMessage();// 附加消息

		if (null != applyIds) {
			for (String applyId : applyIds) {
				ContactAddApply apply = contactAddApplyDAO.get(applyId);
				if (null != apply) {

					String applyUserId = apply.getApplyUserId();// 添加联系人的请求用户
					String targetUserId = apply.getTargetUserId();// 被添加的用户

					apply.setHandleType(handleType);
					apply.setHandleTimestamp(System.currentTimeMillis());
					contactAddApplyDAO.update(apply);

					if (ContactAddApply.handle_type_accept.equals(handleType)) {
						String requestCategoryId = apply.getCategoryId();
						String requestRemark = apply.getRemark();
						if (null == targetCategoryId || targetCategoryId.isEmpty()) {
							targetCategoryId = contactCategoryManager.getOrCreateDefaultCategoryId(targetUserId);
						}

						ContactRelation cr = contactCategoryMemberDAO.getByContactUserId(applyUserId, targetUserId);
						if (null == cr) {
							bothContact(key, applyUserId, requestCategoryId, requestRemark, targetUserId, targetCategoryId, targetRemark);
						}
					}
					handleUserAddResponse(key, apply, message);
				}
			}
		}
		return rm;
	}

	/**
	 * 
	 * Date 2019-01-20 17:53:38<br>
	 * Description 推送被添加为好友的响应消息
	 * 
	 * @author XiaHui<br>
	 * @param key
	 * @param userAddRequest
	 * @param message
	 * @since 1.0.0
	 */
	private void handleUserAddResponse(String key, ContactAddApply userAddRequest, String message) {
		String handleType = userAddRequest.getHandleType();
		String applyId = userAddRequest.getId();// 请求记录id
		String applyUserId = userAddRequest.getApplyUserId();// 添加联系人的请求用户
		String targetUserId = userAddRequest.getTargetUserId();// 被添加的用户
		ContactAddResultData result = new ContactAddResultData();

		result.setApplyId(applyId);
		result.setApplyUserId(applyUserId);
		result.setTargetUserId(targetUserId);
		result.setMessage(message);
		result.setHandleType(handleType);
		contactPush.pushApplyHandle(applyUserId, key, result);
	}
}
