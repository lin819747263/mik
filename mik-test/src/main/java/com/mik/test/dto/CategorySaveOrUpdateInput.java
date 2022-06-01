package com.mik.test.dto;

import lombok.Data;

@Data
public class CategorySaveOrUpdateInput {
    private Long id;
    private String name;
    private Integer sort;
    private Long parentId;
    private Long userId;
}
