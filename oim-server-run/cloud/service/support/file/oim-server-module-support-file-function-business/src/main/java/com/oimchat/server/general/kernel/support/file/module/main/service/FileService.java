package com.oimchat.server.general.kernel.support.file.module.main.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.general.kernel.support.file.common.handler.data.FileInfo;
import com.oimchat.server.general.kernel.support.file.common.util.FilePathUtil;
import com.oimchat.server.general.kernel.support.file.module.common.dao.FileDataDAO;
import com.oimchat.server.general.kernel.support.file.module.common.data.FileVO;
import com.oimchat.server.general.kernel.support.file.module.common.manager.FileServerConfigManager;
import com.oimchat.server.general.kernel.support.file.module.comon.util.FileDataUtil;
import com.oimchat.server.general.kernel.support.file.module.main.entity.FileData;

/**
 * 描述：
 * 
 * @author XiaHui
 * @date 2015年12月30日 下午8:59:57
 * @version 0.0.1
 */
@Service
@Transactional
public class FileService {

	@Autowired
	FileDataDAO fileDataDAO;
	@Resource
	private FileServerConfigManager fileServerConfigManager;

	public List<FileVO> add(List<FileInfo> fileInfoList, String downloadApi, String userId) {
		List<FileVO> list = new ArrayList<>();

		if (null != fileInfoList && !fileInfoList.isEmpty()) {
			for (FileInfo fi : fileInfoList) {

				// String originalName = fi.getOriginalName();
				String originalFullName = fi.getOriginalFullName();
				// String extension = fi.getExtension();

				String nodePath = fi.getNodePath();
				String saveFullName = fi.getSaveFullName();

				File file = fi.getFile();
				long size = file.length();

				FileData fd = new FileData();
				FileDataUtil.toFileData(fi, fd);
				fd.setIsDeleted(0);
				fd.setUserId(userId);
				fileDataDAO.saveOrUpdate(fd);

				String url = fileServerConfigManager.getFileUrlByApi(downloadApi + "?id=" + fd.getId());
				String path = fileServerConfigManager.getFileUrlPath(FilePathUtil.mergeUrlPath(nodePath, saveFullName));

				FileVO vo = new FileVO();
				vo.setId(fd.getId());
				vo.setName(originalFullName);
				vo.setSize(size);
				vo.setPath(path);
				vo.setUrl(url);
				list.add(vo);
			}
		}
		return list;
	}

	public FileData getFileData(String id) {
		return this.fileDataDAO.get(FileData.class, id);
	}
}
