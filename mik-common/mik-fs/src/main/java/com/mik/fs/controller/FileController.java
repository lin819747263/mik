package com.mik.fs.controller;

import com.mik.core.exception.ServiceException;
import com.mik.fs.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("file")
@RestController
public class FileController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FileService fileService;

    @PostMapping("uploadFile")
    public String uploadFile(MultipartFile file, Boolean rename) {
        if(file == null || file.getOriginalFilename() == null
                || !file.getOriginalFilename().contains(".")){
            throw new ServiceException("1","文件或者文件名称不能为空");
        }
        try {
            String fileName = fileService.upload(file, rename);
            return fileService.resolveUrl(fileName);
        }catch (Exception e){
            logger.warn("文件上传失败", e);
            throw new ServiceException("1", "文件上传失败");
        }
    }

}