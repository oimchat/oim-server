package com.oimchat.server.general.kernel.work.module.business.contact.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactRelation;
import com.oimchat.server.general.kernel.work.module.business.contact.service.ContactRelationService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.base.HeadImpl;
import com.onlyxiahui.common.data.common.bean.CountInfo;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 联系人分组关系业务接口<br>
 * Date 2019-01-20 17:39:11<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.2.0
 */
@Component
@ActionMapping(value = "1.2.003")
public class ContactRelationAction {

	@Resource
	private ContactRelationService contactRelationService;

	/**
	 * 
	 * 获取数量<br>
	 * Date 2020-04-10 20:06:50<br>
	 * 
	 * @param userSession
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0001")
	public CountInfo count(UserSession userSession) {
		String ownerUserId = userSession.getUserId();
		List<ContactRelation> list = contactRelationService.getListByOwnerUserId(ownerUserId);
		return new CountInfo(list.size());
	}

	/**
	 * 
	 * 获取列表<br>
	 * Date 2020-04-10 20:07:05<br>
	 * 
	 * @param userSession
	 * @param page
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0002")
	public PageResult<List<ContactRelation>> list(
			UserSession userSession,
			@Define("body.page") Page page) {
		String ownerUserId = userSession.getUserId();
		List<ContactRelation> list = contactRelationService.getListByOwnerUserId(ownerUserId);
		return new PageResult<>(page, list);
	}

	/**
	 * 
	 * 获取详情<br>
	 * Date 2020-04-10 20:07:21<br>
	 * 
	 * @param userSession
	 * @param contactUserId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0004")
	public ContactRelation getByContactUserId(
			UserSession userSession,
			@Define("body.contactUserId") String contactUserId) {
		String ownerUserId = userSession.getUserId();
		ContactRelation data = contactRelationService.getByContactUserId(ownerUserId, contactUserId);
		return data;
	}

	/**
	 * 修改备注<br>
	 * Date 2019-01-20 17:37:06<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param contactUserId
	 * @param remark
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0005")
	public ResultMessage updateContactRemark(
			UserSession userSession,
			HeadImpl head,
			@Define("body.contactUserId") String contactUserId,
			@Define("body.remark") String remark) {
		String ownerUserId = userSession.getUserId();
		return contactRelationService.updateRemark(head.getKey(), ownerUserId, contactUserId, remark);
	}

	/**
	 * 移动分组<br>
	 * Date 2019-01-20 17:37:33<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param contactUserId
	 * @param categoryId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0006")
	public ResultMessage moveCategory(
			UserSession userSession,
			HeadImpl head,
			@Define("body.contactUserIds") List<String> contactUserIds,
			@Define("body.categoryId") String categoryId) {
		String ownerUserId = userSession.getUserId();
		return contactRelationService.moveCategory(head.getKey(), ownerUserId, contactUserIds, categoryId);
	}

	/**
	 * 删除联系人<br>
	 * Date 2019-01-20 17:38:23<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param contactUserId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0007")
	public ResultMessage delete(
			UserSession userSession,
			HeadImpl head,
			@Define("body.contactUserId") String contactUserId) {
		String ownerUserId = userSession.getUserId();
		return contactRelationService.delete(head.getKey(), ownerUserId, contactUserId);
	}

	/**
	 * 
	 * 拉黑/移除黑名单 <br>
	 * Date 2019-05-08 21:01:16<br>
	 * 
	 * @param userSession
	 * @param head
	 * @param ownerUserId
	 * @param contactUserId
	 * @param isBlocked
	 * @return ResultMessage
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0008")
	public ResultMessage updateBlocked(
			UserSession userSession,
			HeadImpl head,
			@Define("body.ownerUserId") String ownerUserId,
			@Define("body.contactUserId") String contactUserId,
			@Define("body.isBlocked") String isBlocked) {
		ownerUserId = userSession.getUserId();
		return contactRelationService.updateBlocked(head.getKey(), ownerUserId, contactUserId, isBlocked);
	}
}
