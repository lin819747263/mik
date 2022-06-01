package com.mik.test.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mik.db.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("top_bar")
public class TopBar  extends BaseEntity<TopBar> {
    private String name;
    private String logoUrl;
    private Long userId;
}
