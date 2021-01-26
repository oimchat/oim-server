package com.oimchat.server.general.kernel.support.file.module.picture.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.support.file.common.handler.data.FileInfo;
import com.oimchat.server.general.kernel.support.file.module.common.data.FileVO;
import com.oimchat.server.general.kernel.support.file.module.common.service.BaseFileService;
import com.oimchat.server.general.kernel.support.file.module.picture.entity.ImageData;

/**
 * 描述：
 * 
 * @author XiaHui
 * @date 2015-12-30 08:59:57
 * @version 0.0.1
 */
@Service
@Transactional
public class ImageService extends BaseFileService<ImageData> {

	public List<FileVO> add(List<FileInfo> fileInfoList, String downloadApi, String userId) {
		List<ImageData> datas = to(fileInfoList);
		if (null != datas && !datas.isEmpty()) {
			for (ImageData fd : datas) {

				fd.setIsDeleted(0);
				fd.setUserId(userId);
			}
		}
		List<FileVO> list = this.save(datas, downloadApi);
		return list;
	}
}
