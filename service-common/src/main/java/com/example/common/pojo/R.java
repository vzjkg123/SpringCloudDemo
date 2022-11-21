package com.example.common.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class R<T> {
    private final static int DEFAULT_SUCCEED_CODE = 0;
    private final static String DEFAULT_SUCCEED_MSG = "ok";

    private final static int DEFAULT_FAILED_CODE = -1;
    private final static String DEFAULT_FAILED_MSG = "error";

    private int code;

    private String msg;

    private T data;

    public static <T> R<T> success() {
        return new <T>R<T>(DEFAULT_SUCCEED_CODE, DEFAULT_SUCCEED_MSG, null);
    }

    public static<T> R<T> success(T data) {
        return new R<>(DEFAULT_SUCCEED_CODE, DEFAULT_SUCCEED_MSG, data);
    }

    public static <T> R<T> fail() {
        return new R<>(DEFAULT_FAILED_CODE, DEFAULT_FAILED_MSG, null);
    }
    public static <T> R<T> fail(T msg) {
        return new R<T>(DEFAULT_FAILED_CODE, DEFAULT_FAILED_MSG, msg);
    }
}
