package com.mik.user.dto;

import lombok.Data;

@Data
public class RoleSaveOrUpdateInput {
    private Long id;
    private String code;
    private String name;
}
