package com.mik.user.dto;

import lombok.Data;

@Data
public class UserOutput {
    private String username;
    private String nickname;
    private String headImgUrl;
    private String mobile;
    private Integer sex;
    private Boolean enabled;
    private String type;
}
