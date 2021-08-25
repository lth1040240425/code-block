package com.doudanhua.basecode.aop.permission;

import com.doudanhua.basecode.enums.IEnum;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2021/8/24 15:47
 */
public enum RoleCode implements IEnum {
    ANY(0,"any"),
    ADMIN(1,"admin"),
    TEACHER(2,"teacher"),
    STUDENT(3,"student")
    ;
    private int code;
    private String name;

     RoleCode(int code,String name){
        this.code=code;
        this.name=name;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }
}
