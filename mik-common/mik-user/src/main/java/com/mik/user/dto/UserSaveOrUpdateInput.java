package com.mik.user.dto;

import lombok.Data;

@Data
public class UserSaveOrUpdateInput {
    private Long id;
    private String username;
    private String nickname;
    private String headImgUrl;
    private String mobile;
    private Integer sex;
    private Boolean enabled;
    private String type;
}
