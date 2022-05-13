package com.mik.core.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommonResult<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

    private CommonResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static CommonResult success(){
        return new CommonResult<>("200", "成功", null);
    }

    public static <T> CommonResult<T> success(T t){
        return new CommonResult<>("200", "成功", t);
    }

    public static CommonResult fail(String code ,String msg){
        return new CommonResult<>(code, msg, null);
    }
}
