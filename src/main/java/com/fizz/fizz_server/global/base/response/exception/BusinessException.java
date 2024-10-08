package com.fizz.fizz_server.global.base.response.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{

    private final ExceptionType exceptionType;

    public BusinessException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }
}
