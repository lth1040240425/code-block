package com.doudanhua.basecode.aop.permission;

import java.lang.annotation.*;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2021/8/24 16:56
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionNotCheck {
}
