package com.kisin.blog.result;

import io.lettuce.core.dynamic.annotation.Param;

public class Result {
    private final int code;
    private final String message;
    private final Object data;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public Result(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        data = null;
    }

    /**
     *
     * @param resultCode resultCode
     * @param data
     */
    public Result(@Param("resultCode") ResultCode resultCode,@Param("data") Object data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }
}
