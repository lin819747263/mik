package com.mik.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class MenuOutput {
    @ApiModelProperty("菜单id")
    private Long id;
    @ApiModelProperty("上级ID")
    private Long parentId;
    @ApiModelProperty("菜单名称")
    private String name;
    @ApiModelProperty("css")
    private String css;
    @ApiModelProperty("url")
    private String url;
    @ApiModelProperty("路径")
    private String path;
    @ApiModelProperty("排序")
    private Integer sort;
    @ApiModelProperty("类型")
    private Integer type;
    @ApiModelProperty("是否隐藏")
    private Boolean hidden;
    @ApiModelProperty("请求方法")
    private String pathMethod;
    @ApiModelProperty("请求方法")
    private Boolean checked;
}
