package com.oimchat.server.general.kernel.support.file.module.common.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.oimchat.server.general.kernel.support.file.common.handler.data.FileInfo;
import com.oimchat.server.general.kernel.support.file.common.util.FilePathUtil;
import com.oimchat.server.general.kernel.support.file.module.common.data.FileVO;
import com.oimchat.server.general.kernel.support.file.module.common.entity.FileBaseData;
import com.oimchat.server.general.kernel.support.file.module.common.manager.FileServerConfigManager;
import com.oimchat.server.general.kernel.support.file.module.comon.util.FileDataUtil;
import com.onlyxiahui.aware.basic.dao.CommonDAO;

/**
 * 描述：
 * 
 * @author XiaHui
 * @date 2015年12月30日 下午8:59:57
 * @version 0.0.1
 */
public abstract class BaseFileService<T extends FileBaseData> {

	@Autowired
	CommonDAO commonDAO;
	@Resource
	private FileServerConfigManager fileServerConfigManager;

	@SuppressWarnings("unchecked")
	public Class<T> getBeanClass() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		Type[] types = parameterizedType.getActualTypeArguments();
		Class<T> beanClass = null;
		if (types.length > 0) {
			Type valueType = types[0];
			if (valueType instanceof Class<?>) {
				beanClass = (Class<T>) valueType;
			}
		}
		return beanClass;
	}

	public T getObject() {
		T fd = null;
		try {
			Class<T> clls = getBeanClass();
			fd = clls.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return fd;
	}

	public List<T> to(List<FileInfo> fileInfoList) {
		List<T> list = new ArrayList<>();
		if (null != fileInfoList && !fileInfoList.isEmpty()) {
			for (FileInfo fi : fileInfoList) {
				T fd = getObject();
				if (null != fd) {
					FileDataUtil.toFileData(fi, fd);
					fd.setIsDeleted(0);
					list.add(fd);
				}
			}
		}
		return list;
	}

	public List<FileVO> save(List<T> list, String downloadApi) {
		List<FileVO> vos = new ArrayList<>();
		for (T fd : list) {
			if (null != fd) {

				// String originalName = fi.getOriginalName();
				String originalFullName = fd.getOriginalFullName();
				// String extension = fi.getExtension();
				String nodePath = fd.getNodePath();
				String saveFullName = fd.getSaveFullName();
				long size = fd.getSize();

				commonDAO.saveOrUpdate(fd);

				String url = fileServerConfigManager.getFileUrlByApi(downloadApi + "?id=" + fd.getId());
				String path = fileServerConfigManager.getFileUrlPath(FilePathUtil.mergeUrlPath(nodePath, saveFullName));

				FileVO vo = new FileVO();
				vo.setId(fd.getId());
				vo.setName(originalFullName);
				vo.setSize(size);
				vo.setPath(path);
				vo.setUrl(url);
				vos.add(vo);
			}
		}
		return vos;
	}

	public T getById(String id) {
		return this.commonDAO.get(getBeanClass(), id);
	}
}
