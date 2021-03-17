package com.oimchat.server.general.kernel.support.file.module.head.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.onlyxiahui.common.utils.base.lang.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ServerWebExchange;

import com.oimchat.server.general.kernel.support.file.common.handler.FileAcceptHandler;
import com.oimchat.server.general.kernel.support.file.common.handler.FileDownloadHandler;
import com.oimchat.server.general.kernel.support.file.common.handler.data.FileInfo;
import com.oimchat.server.general.kernel.support.file.module.common.config.UploadConfig;
import com.oimchat.server.general.kernel.support.file.module.common.data.FileVO;
import com.oimchat.server.general.kernel.support.file.module.common.service.FileServerConfigService;
import com.oimchat.server.general.kernel.support.file.module.comon.util.WebDownloadHandler;
import com.oimchat.server.general.kernel.support.file.module.comon.util.WebUplaodHandler;
import com.oimchat.server.general.kernel.support.file.module.head.entity.GroupHeadData;
import com.oimchat.server.general.kernel.support.file.module.head.service.GroupHeadFileService;
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
public class GroupHeadUploadController {

	@Autowired
	GroupHeadFileService userHeadService;
	@Resource
	FileServerConfigService fileServerConfigService;

	FileAcceptHandler fah = new FileAcceptHandler();
	FileDownloadHandler fdh = new FileDownloadHandler();

	String downloadApi = "/v1/head/group/download";

	@Autowired
	UploadConfig uploadConfig;

	@PermissionMapping(type = PermissionType.skip)
	@ResponseBody
	@RequestMapping(value = "/v1/head/group/upload", method = RequestMethod.POST)
	public Mono<ResultBodyMessage<FileVO>> upload(ServerWebExchange exchange) {

		Mono<ResultBodyMessage<FileVO>> then = WebUplaodHandler.upload(exchange, (parts) -> {
			List<FilePart> fs = new ArrayList<>();
			if (parts.size() > 0) {
				FilePart fp = parts.get(0);
				fs.add(fp);

				// long length = fp.headers().getContentLength();

				// System.out.println(length);
			}
			String userId = exchange.getRequest().getQueryParams().getFirst("userId");
			String groupId = exchange.getRequest().getQueryParams().getFirst("groupId");
			String rootPath = fileServerConfigService.getRootPath();
			String nodePath = fileServerConfigService.getNodePath("file");

			List<FileInfo> fileInfoList = fah.accept(fs, rootPath, nodePath);
			List<FileVO> items = userHeadService.add(fileInfoList, downloadApi, userId, groupId);
			FileVO vo = null;
			if (null != items && !items.isEmpty()) {
				vo = items.get(0);
			}
			ResultBodyMessage<FileVO> r = new ResultBodyMessage<>(vo);
			if (null == vo) {
				r.addWarning(ErrorCode.business.code("001"), "上传失败！");
			}
			return r;
		});
		return then;
	}

	@PermissionMapping(type = PermissionType.skip)
	@RequestMapping("/v1/head/group/download")
	public Mono<Void> download(
			ServerWebExchange exchange,
			String id) {
		if (StringUtil.isNotBlank(id)) {
			GroupHeadData fd = userHeadService.getById(id);
			return WebDownloadHandler.download(fd, exchange);
		}
		return Mono.empty();
	}
}
