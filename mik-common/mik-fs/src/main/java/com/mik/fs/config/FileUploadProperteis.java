package com.mik.fs.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "file")
public class FileUploadProperteis {

    private String uploadFolder ;

    private String ip;

    public String getUploadFolder() {
        return uploadFolder;
    }

    public void setUploadFolder(String uploadFolder) {
        this.uploadFolder = uploadFolder;
    }

    public String getIp() {
        return ip;
    }

    public FileUploadProperteis setIp(String ip) {
        this.ip = ip;
        return this;
    }
}
