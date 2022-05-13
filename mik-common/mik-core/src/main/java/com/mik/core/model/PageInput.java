package com.mik.core.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PageInput {
    private Integer pageNum;
    private Integer pageSize;
}
