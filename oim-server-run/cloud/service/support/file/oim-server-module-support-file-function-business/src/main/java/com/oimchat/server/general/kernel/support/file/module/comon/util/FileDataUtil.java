
package com.oimchat.server.general.kernel.support.file.module.comon.util;

import java.io.File;

import com.oimchat.server.general.kernel.support.file.common.handler.data.FileInfo;
import com.oimchat.server.general.kernel.support.file.module.common.entity.FileBaseData;
import com.onlyxiahui.common.utils.base.util.time.DateUtil;

/**
 * Description <br>
 * Date 2020-04-20 10:32:25<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class FileDataUtil {

	public static <T extends FileBaseData> void toFileData(FileInfo fi, T fd) {
		String rootPath = fi.getRootPath();
		String nodePath = fi.getNodePath();
		String fullPath = fi.getFullPath();

		String saveName = fi.getSaveName();
		String saveFullName = fi.getSaveFullName();
		String fullPathName = fi.getFullPathName();

		String originalName = fi.getOriginalName();
		String originalFullName = fi.getOriginalFullName();
		String extension = fi.getExtension();

		File file = fi.getFile();
		long size = file.length();

		fd.setRootPath(rootPath);
		fd.setNodePath(nodePath);
		fd.setFullPath(fullPath);

		fd.setSaveName(saveName);
		fd.setSaveFullName(saveFullName);
		fd.setFullPathName(fullPathName);

		fd.setOriginalName(originalName);
		fd.setOriginalFullName(originalFullName);
		fd.setExtension(extension);
		fd.setSize(size);

		fd.setCreatedTimestamp(System.currentTimeMillis());
		fd.setCreatedDateTime(DateUtil.getCurrentDateTime());
	}
}
