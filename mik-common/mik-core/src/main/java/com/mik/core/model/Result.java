package com.mik.core.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

    private Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(){
        return new Result<>("200", "成功", null);
    }

    public static <T> Result<T> success(T t){
        return new Result<>("200", "成功", t);
    }

    public static Result fail(String code , String msg){
        return new Result<>(code, msg, null);
    }
}
