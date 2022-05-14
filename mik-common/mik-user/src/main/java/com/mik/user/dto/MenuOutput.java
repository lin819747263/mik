package com.mik.user.dto;

import lombok.Data;

@Data
public class MenuOutput {
    private Long id;
    private Long parentId;
    private String name;
    private String css;
    private String url;
    private String path;
    private Integer sort;
    private Integer type;
    private Boolean hidden;
    private String pathMethod;
}
