package com.oimchat.server.general.kernel.support.file.module.head.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ServerWebExchange;

import com.oimchat.server.general.kernel.support.file.common.handler.FileAcceptHandler;
import com.oimchat.server.general.kernel.support.file.common.handler.FileDownloadHandler;
import com.oimchat.server.general.kernel.support.file.common.handler.data.FileInfo;
import com.oimchat.server.general.kernel.support.file.module.common.data.FileVO;
import com.oimchat.server.general.kernel.support.file.module.common.service.FileServerConfigService;
import com.oimchat.server.general.kernel.support.file.module.comon.util.WebDownloadHandler;
import com.oimchat.server.general.kernel.support.file.module.head.entity.UserHeadData;
import com.oimchat.server.general.kernel.support.file.module.head.service.UserHeadFileService;
import com.onlyxiahui.aware.basic.work.business.error.ErrorCode;
import com.onlyxiahui.common.message.result.ResultBodyMessage;

import com.onlyxiahui.aware.common.auth.annotation.PermissionMapping;
import com.onlyxiahui.aware.common.auth.type.PermissionType;

import reactor.core.publisher.Mono;

/**
 * 头像上传下载接口
 * 
 * @author XiaHui
 * @date 2017-11-25 09:30:45
 * @docModuleSuperKey file
 */
@Controller
public class UserHeadUploadController {

	@Autowired
	UserHeadFileService userHeadService;
	@Resource
	FileServerConfigService fileServerConfigService;

	FileAcceptHandler fah = new FileAcceptHandler();
	FileDownloadHandler fdh = new FileDownloadHandler();

	String downloadApi = "/v1/head/user/download";

	@PermissionMapping(type = PermissionType.skip)
	@ResponseBody
	@RequestMapping(value = "/v1/head/user/upload", method = RequestMethod.POST)
	public Mono<ResultBodyMessage<FileVO>> upload(ServerWebExchange exchange) {
		Mono<MultiValueMap<String, Part>> multipartData = exchange.getMultipartData();
		Mono<ResultBodyMessage<FileVO>> then = multipartData.map(map -> {
			List<FilePart> fs = new ArrayList<>();
			for (List<Part> list : map.values()) {
				if (null != list) {
					for (Part p : list) {
						if (p instanceof FilePart) {
							FilePart fp = (FilePart) p;
							fs.add(fp);
						}
					}
				}
			}
			return fs;
		}).flatMap(parts -> {

			List<FilePart> fs = new ArrayList<>();
			if (parts.size() > 0) {
				fs.add(parts.get(0));
			}
			String userId = exchange.getRequest().getQueryParams().getFirst("userId");
			String rootPath = fileServerConfigService.getRootPath();
			String nodePath = fileServerConfigService.getNodePath("file");

			List<FileInfo> fileInfoList = fah.accept(fs, rootPath, nodePath);
			List<FileVO> items = userHeadService.add(fileInfoList, downloadApi, userId);
			FileVO vo = null;
			if (null != items && !items.isEmpty()) {
				vo = items.get(0);
			}
			ResultBodyMessage<FileVO> r = new ResultBodyMessage<>(vo);
			if (null == vo) {
				r.addWarning(ErrorCode.business.code("001"), "上传失败！");
			}
			return Mono.just(r);
		});// .then(Mono.just("OK"));
//	    Mono<String> then = exchange.getMultipartData().map(it -> it.get("files"))
//	        .flatMapMany(Flux::fromIterable)
//	        .cast(FilePart.class)
//	        .flatMap(it -> it.transferTo())
//	        .then(Mono.just("OK"));
		return then;
	}

	@PermissionMapping(type = PermissionType.skip)
	@RequestMapping("/v1/head/user/download")
	public Mono<Void> download(
			ServerWebExchange exchange,
			String id) {
		if (StringUtil.isNotBlank(id)) {
			UserHeadData fd = userHeadService.getById(id);
			return WebDownloadHandler.download(fd, exchange);
		}
		return Mono.empty();
	}
}
