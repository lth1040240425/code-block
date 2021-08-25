package com.doudanhua.basecode.aop.permission;

import com.doudanhua.basecode.enums.IEnum;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2021/8/24 16:11
 */
public enum Relation implements IEnum {
    AND(1, "and"),
    OR(2, "or"),
    ;

    private int code;
    private String name;

    Relation(int code, String name) {
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
}
