package com.oimchat.server.general.kernel.support.file.module.common.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.ColumnDefault;

import com.onlyxiahui.aware.basic.bean.PrimaryStringEntity;
import com.onlyxiahui.extend.hibernate.annotation.Comment;

/**
 * 
 * 文件信息<br>
 * Date 2017-11-24 22:35:51<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@MappedSuperclass
public class FileBaseData extends PrimaryStringEntity {

	/**
	 * 上传根目录(不含文件名)
	 */
	@Comment("根目录(D:/)")
	@ColumnDefault("''")
	@Column(nullable = false, length = 100)
	private String rootPath;

	/**
	 * 上传节点目录(不含文件名)
	 */
	@Comment("根目录以后的子目录(upload/)")
	@ColumnDefault("''")
	@Column(nullable = false, length = 300)
	private String nodePath;

	/**
	 * 上传完整路径(不含文件名)
	 */
	@Comment("上传完整路径(不含文件名)")
	@ColumnDefault("''")
	@Column(nullable = false, length = 800)
	private String fullPath;

	/**
	 * 保存的文件名(不含扩展名)
	 */
	@Comment("不包含后缀的保存在服务器的文件名(123)")
	@ColumnDefault("''")
	@Column(nullable = false, length = 250)
	private String saveName;

	/**
	 * 保存的文件名(含扩展名)
	 */
	@ColumnDefault("''")
	@Column(nullable = false, length = 300)
	private String saveFullName;

	/**
	 * 文件名（全路径）
	 */
	@ColumnDefault("''")
	@Column(nullable = false, length = 850)
	private String fullPathName;

	/**
	 * 原文件全名（不含扩展名）
	 */
	@ColumnDefault("''")
	@Column(nullable = false, length = 280)
	private String originalName;
	/**
	 * 原文件全名（含扩展名）
	 */
	@ColumnDefault("''")
	@Column(nullable = false, length = 300)
	private String originalFullName;
	/**
	 * 扩展名
	 */
	@Comment("后缀名 (.jpg)")
	@ColumnDefault("''")
	@Column(nullable = false, length = 50)
	private String extension;

	@Comment("完整下载url")
	@ColumnDefault("''")
	@Column(nullable = false, length = 800)
	private String url;

	@Comment("文件类型")
	@ColumnDefault("''")
	@Column(nullable = false, length = 10)
	private String type;

	@Comment("文件大小")
	@ColumnDefault("0")
	@Column(nullable = false, length = 32)
	private Long size;

	@Comment("文件md5")
	@ColumnDefault("''")
	@Column(nullable = false, length = 80)
	private String md5;

	@Comment("文件sha1")
	@ColumnDefault("''")
	@Column(nullable = false, length = 80)
	private String sha1;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getSha1() {
		return sha1;
	}

	public void setSha1(String sha1) {
		this.sha1 = sha1;
	}

}
