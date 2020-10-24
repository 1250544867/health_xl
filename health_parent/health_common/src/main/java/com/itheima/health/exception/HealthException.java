package com.itheima.health.exception;

import com.alibaba.druid.util.StringUtils;

public class HealthException extends  RuntimeException {
    public HealthException(String message){
        super(message);
    }
}
