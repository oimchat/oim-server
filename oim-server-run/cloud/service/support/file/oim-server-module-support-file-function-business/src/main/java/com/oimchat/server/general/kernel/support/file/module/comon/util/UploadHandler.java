package com.oimchat.server.general.kernel.support.file.module.comon.util;

import java.util.List;

import org.springframework.http.codec.multipart.FilePart;

/**
 * Description <br>
 * Date 2020-07-17 09:24:51<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public interface UploadHandler<T> {

	T handle(List<FilePart> files);
}
