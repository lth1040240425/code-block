package com.doudanhua.basecode.aop.permission;

import java.lang.annotation.*;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2021/8/24 15:53
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {
    RoleCode[] rolecodes() default {};

    Relation relation() default Relation.OR;
}
