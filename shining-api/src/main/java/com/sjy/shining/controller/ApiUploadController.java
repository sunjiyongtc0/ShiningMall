package com.sjy.shining.controller;

import com.sjy.shining.annotation.IgnoreAuth;
import com.sjy.shining.oss.OSSFactory;
import com.sjy.shining.utils.ApiBaseAction;
import com.sjy.shining.utils.RRException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 */
@Api(tags = "上传")
@RestController
@RequestMapping("/api/upload")
public class ApiUploadController extends ApiBaseAction {

    /**
     * 上传文件
     */
	@ApiOperation(value = "上传文件")
    @IgnoreAuth
    @PostMapping("/upload")
    public Object upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        //上传文件
        String url = OSSFactory.build().upload(file);
        return toResponsSuccess(url);
    }
}
