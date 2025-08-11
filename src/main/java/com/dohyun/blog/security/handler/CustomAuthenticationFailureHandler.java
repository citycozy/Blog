package com.dohyun.blog.security.handler;

import com.dohyun.blog.global.exception.exceptions.UnauthorizedException;
import com.dohyun.blog.global.exception.msg.UnauthorizedMsg;
import com.dohyun.blog.global.response.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final ObjectMapper mapper;

    public CustomAuthenticationFailureHandler(ObjectMapper objectMapper) {
        this.mapper = objectMapper;
    }

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception)
            throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json; charset=UTF-8");

        ApiResponse<Object> errorResponse =
                ApiResponse.fail(new UnauthorizedException(UnauthorizedMsg.INVALID_EMAIL_PASSWORD));

        mapper.writeValue(response.getOutputStream(), errorResponse);
    }
}
