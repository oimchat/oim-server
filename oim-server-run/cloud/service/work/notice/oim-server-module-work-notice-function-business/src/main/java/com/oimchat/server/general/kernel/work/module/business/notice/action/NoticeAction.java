package com.oimchat.server.general.kernel.work.module.business.notice.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oimchat.server.basic.common.work.app.UserSession;
import com.oimchat.server.general.kernel.work.module.base.notice.entity.TextNotice;
import com.oimchat.server.general.kernel.work.module.business.notice.service.TextNoticeService;
import com.onlyxiahui.common.annotation.parameter.Define;
import com.onlyxiahui.common.data.common.data.Page;
import com.onlyxiahui.common.message.result.ResultMessage;
import com.onlyxiahui.extend.query.page.DefaultPage;
import com.onlyxiahui.framework.action.dispatcher.annotation.ActionMapping;

/**
 * 
 * @author XiaHui
 *
 */
@Component
@ActionMapping(value = "1.700")
public class NoticeAction {

	@Resource
	TextNoticeService textNoticeService;

	@ActionMapping(value = "1.1.0003")
	public ResultMessage getTextNoticeList(
			UserSession userSession,
			@Define("page") Page pageData) {
		String userId=userSession.getUserId();
		DefaultPage page = new DefaultPage();
		page.setPageSize(pageData.getSize());
		page.setPageNumber(pageData.getNumber());
		
		List<TextNotice> list = textNoticeService.getTextNoticeList(userId,page);
		ResultMessage message = new ResultMessage();
		message.bodyPut("list", list);
		
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("totalPage", page.getTotalPage());
		pageMap.put("pageNumber", page.getPageNumber());
		pageMap.put("pageSize", pageData.getSize());
		pageMap.put("startResult", page.getStartResult());
		pageMap.put("endResult", page.getEndResult());
		pageMap.put("totalCount", page.getTotalCount());

		message.bodyPut("page", page);
		return message;
	}
}
