package com.oimchat.server.general.kernel.support.file.common.handler.data;

import java.io.File;

/**
 * @author XiaHui
 * @date 2017-11-24 22:33:20
 */
public class FileInfo {

	/**
	 * 上传根目录(不含文件名)
	 */
	private String rootPath;

	/**
	 * 上传节点目录(不含文件名)
	 */
	private String nodePath;

	/**
	 * 上传完整路径(不含文件名)
	 */
	private String fullPath;

	/**
	 * 保存的文件名(不含扩展名)
	 */
	private String saveName;

	/**
	 * 保存的文件名(含扩展名)
	 */
	private String saveFullName;

	/**
	 * 文件名（全路径）
	 */
	private String fullPathName;

	/**
	 * 原文件全名（不含扩展名）
	 */
	private String originalName;
	/**
	 * 原文件全名（含扩展名）
	 */
	private String originalFullName;
	/**
	 * 扩展名
	 */
	private String extension;

	/**
	 * 上传后的文件对象
	 */
	private File file;

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public String getNodePath() {
		return nodePath;
	}

	public void setNodePath(String nodePath) {
		this.nodePath = nodePath;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getSaveFullName() {
		return saveFullName;
	}

	public void setSaveFullName(String saveFullName) {
		this.saveFullName = saveFullName;
	}

	public String getFullPathName() {
		return fullPathName;
	}

	public void setFullPathName(String fullPathName) {
		this.fullPathName = fullPathName;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getOriginalFullName() {
		return originalFullName;
	}

	public void setOriginalFullName(String originalFullName) {
		this.originalFullName = originalFullName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
