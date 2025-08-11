package com.dohyun.blog.global.exception.handler;

import com.dohyun.blog.global.exception.exceptions.ApiException;
import com.dohyun.blog.global.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<Object> handleGlobalException(final ApiException e) {
        log.error("[에러 코드] {} [에러 메세지] {}", e.getStatus(), e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(ApiResponse.fail(e));
    }
}
