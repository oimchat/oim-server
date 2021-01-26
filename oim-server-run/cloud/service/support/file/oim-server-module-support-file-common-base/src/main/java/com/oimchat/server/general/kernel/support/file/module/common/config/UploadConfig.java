package com.oimchat.server.general.kernel.support.file.module.common.config;

import org.springframework.stereotype.Component;

/**
 * Description <br>
 * Date 2020-10-12 09:21:55<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class UploadConfig {

	private long fileMaxSize = 1024L;
	private long imageMaxSize = 1024L;
	private long headMaxSize = 1024L;

	public long getFileMaxSize() {
		return fileMaxSize;
	}

	public void setFileMaxSize(long fileMaxSize) {
		this.fileMaxSize = fileMaxSize;
	}

	public long getImageMaxSize() {
		return imageMaxSize;
	}

	public void setImageMaxSize(long imageMaxSize) {
		this.imageMaxSize = imageMaxSize;
	}

	public long getHeadMaxSize() {
		return headMaxSize;
	}

	public void setHeadMaxSize(long headMaxSize) {
		this.headMaxSize = headMaxSize;
	}
}
