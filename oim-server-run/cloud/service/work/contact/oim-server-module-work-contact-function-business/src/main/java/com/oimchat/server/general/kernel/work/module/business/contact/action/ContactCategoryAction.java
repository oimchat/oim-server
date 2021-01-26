package com.oimchat.server.general.kernel.work.module.business.contact.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.contact.entity.ContactCategory;
import com.oimchat.server.general.kernel.work.module.business.contact.service.ContactCategoryService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.bean.CountInfo;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 联系人分组业务接口<br>
 * Date 2019-01-20 14:20:24<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.2.0
 */
@Component
@ActionMapping(value = "1.2.002")
public class ContactCategoryAction {

	@Resource
	private ContactCategoryService contactCategoryService;

	/**
	 * 
	 * 获取分组数量<br>
	 * Date 2020-04-10 20:01:01<br>
	 * 
	 * @param userSession
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0001")
	public CountInfo count(UserSession userSession) {
		String ownerUserId = userSession.getUserId();
		List<ContactCategory> list = contactCategoryService.getListByUserId(ownerUserId);
		return new CountInfo(list.size());
	}

	/**
	 * 获取分组列表<br>
	 * Date 2019-01-20 14:28:43<br>
	 * Description
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0002")
	public PageResult<List<ContactCategory>> list(
			UserSession userSession,
			@Define("body.page") Page page) {
		String userId = userSession.getUserId();
		List<ContactCategory> list = contactCategoryService.getListByUserId(userId);
		return new PageResult<>(page, list);
	}

	/**
	 * 
	 * 获取分组详情 <br>
	 * Date 2019-05-08 17:17:39<br>
	 * 
	 * @param userSession
	 * @param categoryId
	 * @return ResultMessage
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0003")
	public ContactCategory get(
			UserSession userSession,
			@Define("body.id") String categoryId) {
		String userId = userSession.getUserId();
		ContactCategory category = contactCategoryService.getById(userId, categoryId);
		return category;
	}

	/**
	 * 
	 * 新增分组 <br>
	 * Date 2019-05-08 17:18:00<br>
	 * 
	 * @param userSession
	 * @param contactCategory
	 * @return ResultMessage
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0004")
	public ResultBodyMessage<ContactCategory> add(
			UserSession userSession,
			@Define("body") ContactCategory contactCategory) {
		if (null == contactCategory.getUserId() || "".equals(contactCategory.getUserId())) {
			contactCategory.setUserId(userSession.getUserId());
		}
		return contactCategoryService.add(contactCategory);
	}

	/**
	 * 
	 * 修改名称<br>
	 * Date 2019-05-08 17:18:20<br>
	 * 
	 * @param userSession
	 * @param id
	 * @param name
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0006")
	public ResultMessage updateName(
			UserSession userSession,
			@Define("body.id") String id,
			@Define("body.name") String name,
			@Define("body.userId") String userId) {
		userId = userSession.getUserId();
		return contactCategoryService.updateName(userId, id, name);
	}

	/**
	 * 
	 * 修改排序<br>
	 * Date 2019-05-08 17:18:38<br>
	 * 
	 * @param userSession
	 * @param userId
	 * @param categoryId
	 * @param sort
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0007")
	public ResultMessage updateSort(
			UserSession userSession,
			@Define("body.id") String categoryId,
			@Define("body.userId") String userId,
			@Define("body.sort") int sort) {
		userId = userSession.getUserId();
		return contactCategoryService.updateSort(userId, categoryId, sort);
	}

	/**
	 * 
	 * 删除分组<br>
	 * Date 2019-05-08 17:18:57<br>
	 * 
	 * @param userSession
	 * @param id          分组id
	 * @param userId      用户id
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0008")
	public ResultMessage delete(
			UserSession userSession,
			@Define("body.id") String id,
			@Define("body.userId") String userId) {
		userId = userSession.getUserId();
		return contactCategoryService.delete(userId, id);
	}
}
