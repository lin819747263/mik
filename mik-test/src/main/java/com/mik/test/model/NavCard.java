package com.mik.test.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mik.db.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("nav_card")
public class NavCard  extends BaseEntity<NavCard> {
    private String url;
    private String desc;
    private String title;
    private String iconUrl;
    private Integer sort;
    private Long userId;
}
