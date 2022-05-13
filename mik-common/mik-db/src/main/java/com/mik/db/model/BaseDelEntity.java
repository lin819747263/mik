package com.mik.db.model;


import com.baomidou.mybatisplus.annotation.TableLogic;

public class BaseDelEntity extends BaseEntity{

    @TableLogic
    public Boolean deleted;

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
