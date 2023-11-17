package com.goormthon.agoragoormthon.global.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ResponseType<T> {
    private static final String SUCCESS_RESULT = "success";
    private static final String FAIL_RESULT = "fail";
    private static final String ERROR_RESULT = "error";

    private String result;
    private HttpStatus httpStatus;
    private String message;
    private T data;

    public static <T> ResponseType<T> createSuccessWithData(T data) {
        return new ResponseType<>(SUCCESS_RESULT, HttpStatus.OK, null, data);
    }

    public static ResponseType<?> createSuccessWithNoData(String message) {
        return new ResponseType<>(SUCCESS_RESULT, HttpStatus.OK, message, null);
    }

    public static ResponseType<?> createError(HttpStatus httpStatus, String message) {
        return new ResponseType<>(ERROR_RESULT, httpStatus, message, null);
    }
}
