package com.oimchat.server.general.kernel.support.file.common.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oimchat.server.general.kernel.support.file.common.util.FilePathUtil;
import com.oimchat.server.general.kernel.support.file.module.common.entity.FileBaseData;

/**
 * @author XiaHui
 * @date 2017-11-24 22:32:28
 */
public class FileDownloadHandler {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	public void downloadByIO(OutputStream out, File file) {
		if (null != file && null != out) {
			InputStream in = null;
			try {
				if (file.exists()) {
					in = new FileInputStream(file);
					byte[] b = new byte[2048];
					int length;
					while ((length = in.read(b)) > 0) {
						out.write(b, 0, length);
					}
				}
			} catch (FileNotFoundException e) {
				// e.printStackTrace();
				logger.error(e.getMessage(), e);
			} catch (IOException e) {
				// e.printStackTrace();
				logger.error(e.getMessage(), e);
			} finally {// 这里主要关闭。
				if (null != in) {
					try {
						in.close();
					} catch (IOException e) {
						// e.printStackTrace();
						logger.error(e.getMessage(), e);
					}
				}
				if (null != out) {
					try {
						out.close();
					} catch (IOException e) {
						// e.printStackTrace();
						logger.error(e.getMessage(), e);
					}
				}
			}
			// 返回值要注意，要不然就出现下面这句错误！
			// java+getOutputStream() has already been called for this
			// response
		}
	}

	public void downloadByIO(OutputStream out, FileBaseData fd) {
		if (null != fd && null != out) {
			InputStream in = null;
			try {

				String rootPath = fd.getRootPath();
				String nodePath = fd.getNodePath();
				String saveFullName = fd.getSaveFullName();

				String fullPath = FilePathUtil.getFullPath(rootPath, nodePath);
				String saveFullPathName = FilePathUtil.getFullPathName(fullPath, saveFullName);

				File file = new File(saveFullPathName);

				if (file.exists()) {
					in = new FileInputStream(file);
					byte[] b = new byte[2048];
					int length;
					while ((length = in.read(b)) > 0) {
						out.write(b, 0, length);
					}
				}
			} catch (FileNotFoundException e) {
				// e.printStackTrace();
				logger.error(e.getMessage(), e);
			} catch (IOException e) {
				// e.printStackTrace();
				logger.error(e.getMessage(), e);
			} finally {// 这里主要关闭。
				if (null != in) {
					try {
						in.close();
					} catch (IOException e) {
						// e.printStackTrace();
						logger.error(e.getMessage(), e);
					}
				}
				if (null != out) {
					try {
						out.close();
					} catch (IOException e) {
						// e.printStackTrace();
						logger.error(e.getMessage(), e);
					}
				}
			}
			// 返回值要注意，要不然就出现下面这句错误！
			// java+getOutputStream() has already been called for this
			// response
		}
	}
}
