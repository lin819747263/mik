package com.mik.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class UserOutput {
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("头像")
    private String headImgUrl;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("性别")
    private Integer sex;
    @ApiModelProperty("是否启用")
    private Boolean enabled;
    @ApiModelProperty("用户类型")
    private String type;
}
