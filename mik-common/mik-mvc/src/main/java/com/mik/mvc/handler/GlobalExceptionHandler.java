package com.mik.mvc.handler;


import com.mik.core.exception.ServiceException;
import com.mik.core.model.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public CommonResult serviceExceptionHandler(ServiceException ex) {
        return CommonResult.fail(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public CommonResult throwableHandler(Throwable throwable) {
        return CommonResult.fail("1", throwable.getMessage());
    }

}
