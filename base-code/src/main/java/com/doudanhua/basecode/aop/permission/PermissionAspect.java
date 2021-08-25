package com.doudanhua.basecode.aop.permission;

import com.doudanhua.basecode.enums.ErrorCode;
import com.doudanhua.basecode.exception.ApiException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2021/8/24 16:15
 */
@Aspect
@Component //spring 容器才能扫描到
public class PermissionAspect {

    @Autowired
    private PermissionService permissionService;

    /**
     * 声明切面
     * 方法上 或者 类上有带  Permission 注解的都会被拦截
     */
    @Pointcut(value = "@annotation(com.doudanhua.basecode.aop.permission.Permission)||@within(com.doudanhua.basecode.aop" +
            ".permission.Permission)")
    private void poinCut() {

    }

    /**
     * 前置拦截   (@annotation(permission) ||@within(permission)) 获取注解对象
     *
     * @param permission
     */
    @Before("poinCut() && (@annotation(permission) ||@within(permission))")
    public void before(ProceedingJoinPoint pjp, Permission permission) {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        PermissionNotCheck permissionNotCheck = method.getAnnotation(PermissionNotCheck.class);
        if (permissionNotCheck != null) {
            return;
        }
        //mock 获取当前用户角色
        List<String> roles = permissionService.getCurrentUserRoles();
        //要检验的角色
        List<String> checkRoles =
                Arrays.stream(permission.rolecodes()).map(RoleCode::getName).collect(Collectors.toList());
        if (roles.contains(RoleCode.ANY.getName())) {
            return;
        }
        switch (permission.relation()) {
            case AND:
                if (!roles.containsAll(checkRoles)) {
                    throw ErrorCode.NO_PERMISSION.getError();
                }
                break;
            case OR:
                for (String role : checkRoles) {
                    if (roles.contains(role)) {
                        return;
                    }
                }
                throw ErrorCode.NO_PERMISSION.getError();
        }

    }
}
