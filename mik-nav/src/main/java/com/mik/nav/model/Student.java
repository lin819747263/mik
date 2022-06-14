package com.mik.nav.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mik.db.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("student")
public class Student extends BaseEntity<Student> {

    private String name;

    private Integer age;

    private Integer sex;
}
