package com.doudanhua.basecode.sl4jDemo;

import org.springframework.stereotype.Service;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2020/8/31 17:02
 */
@Service
public class AopMethodTest {

    public String say(String name){
        return "hello:"+name;
    }
}
