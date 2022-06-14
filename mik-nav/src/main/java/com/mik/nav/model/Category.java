package com.mik.nav.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mik.db.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("category")
public class Category  extends BaseEntity<Category> {
    private String name;
    private Integer sort;
    private Long parentId;
    private Long userId;
}
