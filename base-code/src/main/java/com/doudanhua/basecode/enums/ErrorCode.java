package com.doudanhua.basecode.enums;

import com.doudanhua.basecode.exception.ApiException;
import sun.applet.resources.MsgAppletViewer;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2021/8/24 16:25
 */
public enum ErrorCode implements IEnum {
    NO_PERMISSION(401, "没有权限");
    private int code;
    private String name;

    ErrorCode(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    public ApiException getError(Object... args) {
        String format = String.format(this.name, args);
        return new ApiException(code, format);
    }


}
