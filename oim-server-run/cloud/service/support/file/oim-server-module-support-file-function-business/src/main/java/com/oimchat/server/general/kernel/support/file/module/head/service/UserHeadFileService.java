package com.oimchat.server.general.kernel.support.file.module.head.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.support.file.common.handler.data.FileInfo;
import com.oimchat.server.general.kernel.support.file.module.common.data.FileVO;
import com.oimchat.server.general.kernel.support.file.module.common.service.BaseFileService;
import com.oimchat.server.general.kernel.support.file.module.head.entity.UserHeadData;

/**
 * 描述：
 * 
 * @author XiaHui
 * @date 2015年12月30日 下午8:59:57
 * @version 0.0.1
 */
@Service
@Transactional
public class UserHeadFileService extends BaseFileService<UserHeadData> {

	public List<FileVO> add(List<FileInfo> fileInfoList, String downloadApi, String userId) {
		List<UserHeadData> datas = to(fileInfoList);
		if (null != datas && !datas.isEmpty()) {
			for (UserHeadData fd : datas) {

				fd.setIsDeleted(0);
				fd.setUserId(userId);
			}
		}
		List<FileVO> list = this.save(datas, downloadApi);
		return list;
	}
}
