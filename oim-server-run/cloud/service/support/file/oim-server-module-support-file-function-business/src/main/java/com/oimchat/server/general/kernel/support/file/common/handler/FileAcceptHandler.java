
package com.oimchat.server.general.kernel.support.file.common.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.codec.multipart.FilePart;

import com.oimchat.server.basic.common.util.FileNameUtil;
import com.oimchat.server.basic.common.util.KeyUtil;
import com.oimchat.server.general.kernel.support.file.common.handler.data.FileInfo;
import com.oimchat.server.general.kernel.support.file.common.util.FilePathUtil;
import com.onlyxiahui.common.utils.base.io.FileUtil;

/**
 * Description <br>
 * Date 2020-04-20 09:08:04<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class FileAcceptHandler {

	public List<FileInfo> accept(List<FilePart> fileParts, String rootPath, String nodePath) {
		List<FileInfo> list = new ArrayList<>();
		if (null != fileParts) {
			for (FilePart filePart : fileParts) {
				FileInfo fi = accept(filePart, rootPath, nodePath);
				list.add(fi);
			}
		}
		return list;
	}

	public FileInfo accept(FilePart filePart, String rootPath, String nodePath) {

		String originalFullName = filePart.filename();
		String originalName = FileNameUtil.getName(originalFullName);

		String saveName = KeyUtil.getKey();
		String extension = FileNameUtil.getSuffixName(originalFullName);
		String saveFullName = saveName + "." + extension;

		String fullPath = FilePathUtil.getFullPath(rootPath, nodePath);
		String saveFullPathName = FilePathUtil.getFullPathName(fullPath, saveFullName);

		FileUtil.checkOrCreateFolder(fullPath);
		File localFile = new File(saveFullPathName);
		save(filePart, localFile);
		FileInfo fileInfo = new FileInfo();

		fileInfo.setRootPath(rootPath);
		fileInfo.setNodePath(nodePath);
		fileInfo.setFullPath(fullPath);
		fileInfo.setSaveName(saveName);
		fileInfo.setSaveFullName(saveFullName);
		fileInfo.setFullPathName(saveFullPathName);
		fileInfo.setOriginalName(originalName);
		fileInfo.setOriginalFullName(originalFullName);
		fileInfo.setExtension(extension);
		fileInfo.setFile(localFile);
		return fileInfo;
	}

	public void save(FilePart filePart, File localFile) {
		filePart.transferTo(localFile);
	}
}
