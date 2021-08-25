package com.doudanhua.basecode.aop.permission;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2021/8/24 16:48
 */
@Service
public class PermissionService {

    public List<String>getCurrentUserRoles(){
        return Arrays.asList(RoleCode.ADMIN.getName(),RoleCode.STUDENT.getName(),RoleCode.STUDENT.getName());
    }

}
