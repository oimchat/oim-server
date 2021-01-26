package com.oimchat.server.general.kernel.work.module.business.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.work.module.base.user.dao.UserHeadDAO;
import com.oimchat.server.general.kernel.work.module.base.user.entity.UserHead;

/**
 * 
 * @author: XiaHui
 * @date 2018-01-29 14:38:30
 */
@Service
@Transactional
public class UserHeadService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private UserHeadDAO userHeadDAO;

	public UserHead getUserHeadByUserId(String userId) {
		return userHeadDAO.getLastByUserId(userId);
	}

	public List<UserHead> getUserHeadListByUserIds(List<String> ids) {
		return userHeadDAO.getUserHeadListByUserIds(ids);
	}
}
