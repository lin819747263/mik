package com.mik.fs.service;

import com.mik.fs.FileStorageException;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    /**
     * 上传文件
     * @param file
     */
    String upload(MultipartFile file, Boolean rename) throws FileStorageException;

    /**
     * 获取上传基础路径
     * @return
     */
    String getBaseUrl();

    /**
     * 获取本地路径
     * @return
     */
    String getLocalPath();

    /**
     * 生成文件的全路径
     * @param fileName
     * @return
     */
    String resolveUrl(String fileName);
}
