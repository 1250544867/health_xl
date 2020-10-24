package com.itheima.health.controller;


import com.itheima.health.pojo.Result;
import com.itheima.health.exception.HealthException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class HealExceptionAdvice {

    private static final Logger log = LoggerFactory.getLogger(HealExceptionAdvice.class);

    @ExceptionHandler(HealthException.class)
    public Result handleHealthException(HealthException he) {
        return new Result(false,he.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception he){
        log.error("发生异常",he);
        return new Result(false,"发生未知错误，操作失败，请联系管理员");
    }

}
