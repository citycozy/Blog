package com.dohyun.blog.global.response;

import com.dohyun.blog.global.exception.exceptions.ApiException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@JsonPropertyOrder({"isSuccess", "code", "message", "data"})
public class ApiResponse<T> {

    @JsonProperty("isSuccess")
    private boolean success;

    private String code;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, "200", "요청에 성공하였습니다.", data);
    }

    public static <T> ApiResponse<T> create(T data) {
        return new ApiResponse<>(true, "201", "리소스가 성공적으로 생성되었습니다.", data);
    }

    public static <T> ApiResponse<T> fail(ApiException e) {
        return new ApiResponse<>(
                false, String.valueOf(e.getStatus().value()), e.getMessage(), null);
    }

    public static <T> ApiResponse<T> fail(String message) {
        return new ApiResponse<>(false, "400", message, null);
    }
}
