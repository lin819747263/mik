package com.mik.nav.dto;

import lombok.Data;

@Data
public class CategoryOutput {
    private Long id;
    private String name;
    private Integer sort;
    private Long parentId;
    private Long userId;
}
