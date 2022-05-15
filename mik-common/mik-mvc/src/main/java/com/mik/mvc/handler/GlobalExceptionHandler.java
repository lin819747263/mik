package com.mik.mvc.handler;


import com.mik.core.exception.ServiceException;
import com.mik.core.model.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public CommonResult serviceExceptionHandler(ServiceException ex) {
        log.info("666", ex);
        return CommonResult.fail(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public CommonResult throwableHandler(Throwable throwable) {
        log.info("666", throwable);
        return CommonResult.fail("1", throwable.getMessage());
    }

}
