package com.mik.test.dto;

import lombok.Data;

@Data
public class NavCardSaveOrUpdateInput {
    private Long id;
    private String url;
    private String desc;
    private String title;
    private String iconUrl;
    private Integer sort;
    private Long userId;
}
