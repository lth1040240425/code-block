package com.doudanhua.basecode.aop.permission;

import org.springframework.stereotype.Service;

/**
 * @Author zhangqian
 * @Description 课程测试
 * @Date 2021/8/24 16:54
 */
@Service
@Permission(rolecodes = {RoleCode.ADMIN})
public class CourseTest {


    @Permission(rolecodes = RoleCode.TEACHER)
    public void create() {

    }

    @Permission(rolecodes = {RoleCode.ANY})
    public void getList() {

    }

    @PermissionNotCheck
    public void noCheck() {

    }
}
