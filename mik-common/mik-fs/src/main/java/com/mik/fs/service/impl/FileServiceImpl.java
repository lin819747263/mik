package com.mik.fs.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.mik.fs.FileStorageException;
import com.mik.fs.config.FileUploadProperteis;
import com.mik.fs.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileServiceImpl implements FileService {

    private final Path fileStorageLocation;

    @Autowired
    private Environment environment;

    @Autowired
    private FileUploadProperteis fileUploadProperteis;

    @Autowired
    public FileServiceImpl(FileUploadProperteis properteis) throws FileStorageException {
        this.fileStorageLocation = Paths.get(properteis.getUploadFolder()).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("文件夹创建失败");
        }
    }

    @Override
    public String upload(MultipartFile file, Boolean rename) throws FileStorageException {
        Objects.requireNonNull(file.getOriginalFilename());

        String fileName;
        if(rename){
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            fileName = org.apache.commons.lang3.StringUtils.substring(SecureUtil.md5(file.getOriginalFilename()),0,15) + "." + suffix;
        }else {
            fileName = StringUtils.cleanPath(file.getOriginalFilename());
        }

        try {
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("文件上传错误，请联系管理员");
        }
    }

    @Override
    public String getBaseUrl() {
        StringBuilder sb = new StringBuilder();

        sb.append("http://")
                .append(fileUploadProperteis.getIp())
                .append(":")
                .append(environment.getProperty("local.server.port"))
                .append("/upload")
                .append("/");

        return sb.toString();
    }

    @Override
    public String getLocalPath() {
        return fileUploadProperteis.getUploadFolder();
    }

    @Override
    public String resolveUrl(String fileName) {
        return getBaseUrl() + fileName;
    }
}
