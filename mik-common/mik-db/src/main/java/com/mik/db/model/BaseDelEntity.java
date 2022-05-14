package com.mik.db.model;


import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;

public class BaseDelEntity<T extends Model<?>> extends BaseEntity<T>{

    @TableLogic
    public Boolean deleted = false;

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
