package com.oimchat.server.general.kernel.work.module.business.contact.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.contact.data.dto.ContactAddApplyData;
import com.oimchat.server.general.kernel.work.module.base.contact.data.dto.ContactAddApplyEntityCase;
import com.oimchat.server.general.kernel.work.module.base.contact.data.dto.ContactAddApplyQuery;
import com.oimchat.server.general.kernel.work.module.base.contact.data.dto.ContactAddHandleData;
import com.oimchat.server.general.kernel.work.module.base.contact.data.dto.ContactVerifySettingDataCase;
import com.oimchat.server.general.kernel.work.module.base.contact.data.dto.VerifyAnswer;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactAddApply;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactAddVerifyAnswer;
import com.oimchat.server.general.kernel.work.module.business.contact.service.ContactAddApplyService;
import com.oimchat.server.general.kernel.work.module.business.contact.service.ContactAddService;
import com.oimchat.server.general.kernel.work.module.business.contact.service.ContactAddVerifyAnswerService;
import com.oimchat.server.general.kernel.work.module.business.contact.service.ContactService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.base.HeadImpl;
import com.onlyxiahui.common.data.common.bean.CountInfo;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 联系人业务接口<br>
 * Date 2019-01-20 13:10:36<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.2.0
 */
@Component
@ActionMapping(value = "1.2.001")
public class ContactAction {

	@Resource
	private ContactService contactService;
	@Resource
	private ContactAddService contactAddService;
	@Resource
	private ContactAddApplyService contactAddRequestService;
	@Resource
	private ContactAddVerifyAnswerService contactAddVerifyAnswerService;

//	/**
//	 * 
//	 * 获取所有联系人数量<br>
//	 * Date 2020-04-10 19:35:48<br>
//	 * 
//	 * @param userSession
//	 * @return
//	 * @since 1.0.0
//	 */
//	@ActionMapping(value = "1.1.0001")
//	public CountInfo count(UserSession userSession) {
//		String ownerUserId = userSession.getUserId();
//		List<UserData> list = contactService.getUserDataListByContactCategoryMemberOwnerUserId(ownerUserId);
//		return new CountInfo(list.size());
//	}
//
//	/**
//	 * 获取所有联系人信息列表<br>
//	 * Date 2019-01-20 19:27:50<br>
//	 * 
//	 * @author XiaHui<br>
//	 * @param userSession
//	 * @return
//	 * @since 1.0.0
//	 */
//	@ActionMapping(value = "1.1.0002")
//	public PageResult<List<UserData>> list(
//			UserSession userSession,
//			@Define("body.page") Page page) {
//		String ownerUserId = userSession.getUserId();
//		List<UserData> list = contactService.getUserDataListByContactCategoryMemberOwnerUserId(ownerUserId);
//		userService.setUserStatus(list);
//		return new PageResult<>(page, list);
//	}
//
//	/**
//	 * 获取所有联系人在线状态<br>
//	 * Date 2019-01-20 19:27:33<br>
//	 * 
//	 * @author XiaHui<br>
//	 * @param userSession
//	 * @return
//	 * @since 1.0.0
//	 */
//	@ActionMapping(value = "1.1.0003")
//	public PageResult<List<UserStatus>> getUserDataStatusList(
//			UserSession userSession,
//			@Define("body.page") Page page) {
//		String ownerUserId = userSession.getUserId();
//		List<UserData> contactlist = contactService.getUserDataListByContactCategoryMemberOwnerUserId(ownerUserId);
//		userService.setUserStatus(contactlist);
//		List<UserStatus> list = new ArrayList<>();
//		for (UserData userData : contactlist) {
//			list.add(new UserStatus(userData.getId(), userData.getStatus()));
//		}
//		return new PageResult<>(page, list);
//	}

	/**
	 * 获取对方验证设置<br>
	 * Date 2019-01-20 18:17:16<br>
	 * 
	 * @param userSession
	 * @param targetUserId 目标用户id
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0006")
	public ResultBodyMessage<ContactVerifySettingDataCase> getContactAddVerifySetting(
			UserSession userSession,
			@Define("body.targetUserId") String targetUserId) {
		String applyUserId = userSession.getUserId();
		ResultBodyMessage<ContactVerifySettingDataCase> message = contactAddService.getContactAddVerifySetting(applyUserId, targetUserId);
		return message;
	}

	/**
	 * 请求添加为好友<br>
	 * Date 2019-01-20 18:17:43<br>
	 * 
	 * @param head
	 * @param apply   请求信息
	 * @param answers 答案列表
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0007")
	public ResultMessage sendAddApply(
			HeadImpl head,
			@Define("body.apply") ContactAddApplyData apply,
			@Define("body.answers") List<VerifyAnswer> answers) {
		ResultMessage message = contactAddService.userAddApply(head.getKey(), apply, answers);
		return message;
	}

	/**
	 * 
	 * 获取被添加请求数量<br>
	 * Date 2020-04-10 19:33:50<br>
	 * 
	 * @param userSession
	 * @param query
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0008")
	public CountInfo queryApplyReceiveCount(
			UserSession userSession,
			@Define("body.query") ContactAddApplyQuery query) {
		Page page = new Page();
		page.setSize(1);
		String ownerUserId = userSession.getUserId();

		contactAddRequestService.queryList(ownerUserId, query, page);
		return new CountInfo(page.getTotalCount());
	}

	/**
	 * 
	 * 获取被添加请求列表<br>
	 * Date 2020-04-12 13:42:45<br>
	 * 
	 * @param userSession
	 * @param query
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0009")
	public PageResult<List<ContactAddApply>> queryApplyReceiveList(
			UserSession userSession,
			@Define("body.query") ContactAddApplyQuery query,
			@Define("body.page") Page page) {
		String ownerUserId = userSession.getUserId();

		List<ContactAddApply> applys = contactAddRequestService.queryList(ownerUserId, query, page);
		return new PageResult<>(page, applys);
	}

	/**
	 * 
	 * 获取被添加请求详情列表<br>
	 * Date 2020-04-10 19:34:31<br>
	 * 
	 * @param userSession
	 * @param query
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0010")
	public PageResult<List<ContactAddApplyEntityCase>> queryApplyDataReceiveList(
			UserSession userSession,
			@Define("body.query") ContactAddApplyQuery query,
			@Define("body.page") Page page) {
		String ownerUserId = userSession.getUserId();

		List<String> userIds = new ArrayList<>();
		List<String> applyIds = new ArrayList<>();
		List<ContactAddApply> applys = contactAddRequestService.queryList(ownerUserId, query, page);
		for (ContactAddApply ap : applys) {
			userIds.add(ap.getApplyUserId());
			applyIds.add(ap.getId());
		}
//		Map<String, UserData> userMap = new HashMap<>();
		Map<String, List<ContactAddVerifyAnswer>> answerMap = new HashMap<>();
//
//		List<UserData> users = userService.getUserDataList(userIds);
		List<ContactAddVerifyAnswer> answers = contactAddVerifyAnswerService.getListByApplyIds(ownerUserId, applyIds);

//		for (UserData u : users) {
//			userMap.put(u.getId(), u);
//		}

		for (ContactAddVerifyAnswer a : answers) {
			String aid = a.getApplyId();
			List<ContactAddVerifyAnswer> list = answerMap.get(aid);
			if (null == list) {
				list = new ArrayList<>();
				answerMap.put(aid, list);
			}
			list.add(a);
		}

		List<ContactAddApplyEntityCase> list = new ArrayList<>();

		for (ContactAddApply ap : applys) {
			String aid = ap.getId();
//			String uid = ap.getApplyUserId();

//			UserData user = userMap.get(uid);
			List<ContactAddVerifyAnswer> answerList = answerMap.get(aid);
//			map.put("apply", ap);
//			map.put("user", user);
//			map.put("answerList", answerList);

			list.add(new ContactAddApplyEntityCase(ap, answerList));
		}

		return new PageResult<>(page, list);
	}

	/**
	 * 
	 * 获取被添加请求详情<br>
	 * Date 2020-04-10 19:34:50<br>
	 * 
	 * @param userSession
	 * @param applyId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0011")
	public ContactAddApplyEntityCase getRequest(
			UserSession userSession,
			@Define("body.applyId") String applyId) {
		String ownerUserId = userSession.getUserId();

		ContactAddApply request = contactAddRequestService.get(applyId);
		List<ContactAddVerifyAnswer> answerList = contactAddVerifyAnswerService.getListByApplyId(ownerUserId, applyId);

//		if (null != request) {
//			UserData user = userService.getUserDataById(request.getApplyUserId());
//			message.bodyPut("user", user);
//		}
		return new ContactAddApplyEntityCase(request, answerList);
	}

	/**
	 * 处理被添加请求(同意/拒绝)<br>
	 * Date 2019-01-20 18:18:03<br>
	 * 
	 * @param head
	 * @param handle 处理信息
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0012")
	public ResultMessage applyHandle(
			HeadImpl head,
			@Define("body.handle") ContactAddHandleData handle) {
		ResultMessage message = contactAddService.applyHandle(head.getKey(), handle);
		return message;
	}
}
