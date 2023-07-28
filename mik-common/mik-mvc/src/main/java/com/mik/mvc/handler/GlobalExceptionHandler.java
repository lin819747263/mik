package com.mik.mvc.handler;


import com.mik.core.exception.ServiceException;
import com.mik.core.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public Result serviceExceptionHandler(ServiceException ex) {
        log.info("666", ex);
        return Result.fail(ex.getCode(), ex.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception ex) {
        log.info("666", ex);
        return Result.fail("666", "未知错误，请联系管理员");
    }

    @ExceptionHandler(Throwable.class)
    public Result throwableHandler(Throwable throwable) {
        log.info("666", throwable);
        return Result.fail("666", "未知错误，请联系管理员");
    }

}
