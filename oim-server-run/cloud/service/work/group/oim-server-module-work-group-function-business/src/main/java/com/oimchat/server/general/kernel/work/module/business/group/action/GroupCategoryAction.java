package com.oimchat.server.general.kernel.work.module.business.group.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupCategory;
import com.oimchat.server.general.kernel.work.module.business.group.service.GroupCategoryService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.base.HeadImpl;
import com.onlyxiahui.common.data.common.bean.CountInfo;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.data.common.data.PageResult;
import com.onlyxiahui.common.message.result.ResultBodyMessage;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 群分组业务接口<br>
 * Date 2019-01-20 21:12:18<br>
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 * @docModuleSuperKey 1.3.0
 */
@Component
@ActionMapping(value = "1.3.002")
public class GroupCategoryAction {

	@Resource
	private GroupCategoryService groupCategorySerivce;

	/**
	 * 获取分组数量<br>
	 * Date 2019-01-22 19:36:14<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0001")
	public CountInfo count(UserSession userSession) {
		String userId = userSession.getUserId();
		List<GroupCategory> list = groupCategorySerivce.getListByUserId(userId);
		return new CountInfo(list.size());
	}

	/**
	 * 获取分组列表<br>
	 * Date 2019-01-20 14:28:43<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0002")
	public PageResult<List<GroupCategory>> list(
			UserSession userSession,
			@Define("body.page") Page page) {
		String userId = userSession.getUserId();
		List<GroupCategory> list = groupCategorySerivce.getListByUserId(userId);
		return new PageResult<>(page, list);
	}

	/**
	 * 获取分组详情<br>
	 * Date 2020-04-12 20:00:54<br>
	 * 
	 * @param userSession
	 * @param categoryId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0003")
	public GroupCategory get(
			UserSession userSession,
			@Define("body.id") String categoryId) {
		String userId = userSession.getUserId();
		GroupCategory category = groupCategorySerivce.getById(userId, categoryId);
		return category;
	}

	/**
	 * 新增分组<br>
	 * Date 2019-01-20 14:22:21<br>
	 * 
	 * @author XiaHui<br>
	 * @param userSession
	 * @param groupCategory
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0004")
	public ResultBodyMessage<GroupCategory> add(
			UserSession userSession,
			HeadImpl head,
			@Define("body") GroupCategory groupCategory) {
		if (null == groupCategory.getUserId() || "".equals(groupCategory.getUserId())) {
			groupCategory.setUserId(userSession.getUserId());
		}
		return groupCategorySerivce.add(head.getKey(), groupCategory);
	}

	/**
	 * 修改名称<br>
	 * Date 2020-04-12 20:01:35<br>
	 * 
	 * @param userSession
	 * @param head
	 * @param id
	 * @param name
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0006")
	public ResultMessage updateName(
			UserSession userSession,
			HeadImpl head,
			@Define("body.id") String id,
			@Define("body.name") String name,
			@Define("body.userId") String userId) {
		userId = userSession.getUserId();
		return groupCategorySerivce.updateName(head.getKey(), userId, id, name);
	}

	/**
	 * 
	 * 修改排序<br>
	 * Date 2020-04-12 20:03:33<br>
	 * 
	 * @param userSession
	 * @param head
	 * @param id
	 * @param sort
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0007")
	public ResultMessage updateSort(
			UserSession userSession,
			HeadImpl head,
			@Define("body.id") String id,
			@Define("body.sort") int sort,
			@Define("body.userId") String userId) {
		userId = userSession.getUserId();
		return groupCategorySerivce.updateSort(head.getKey(), userId, id, sort);
	}

	/**
	 * 
	 * 删除分组<br>
	 * Date 2020-04-12 20:03:39<br>
	 * 
	 * @param userSession
	 * @param head
	 * @param id
	 * @param userId
	 * @return
	 * @since 1.0.0
	 */
	@ActionMapping(value = "1.1.0008")
	public ResultMessage delete(
			UserSession userSession,
			HeadImpl head,
			@Define("body.id") String id,
			@Define("body.userId") String userId) {
		userId = userSession.getUserId();
		return groupCategorySerivce.delete(head.getKey(), userId, id);
	}
}
