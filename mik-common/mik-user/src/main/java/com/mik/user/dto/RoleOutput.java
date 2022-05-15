package com.mik.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class RoleOutput {
    @ApiModelProperty("角色ID")
    private Long id;
    @ApiModelProperty("角色编码")
    private String code;
    @ApiModelProperty("角色名称")
    private String name;
}
