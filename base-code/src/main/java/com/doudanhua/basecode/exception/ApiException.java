package com.doudanhua.basecode.exception;

import lombok.Data;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2021/8/24 16:27
 */
@Data
public class ApiException extends RuntimeException {
    private int code;
    private String msg;

    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
