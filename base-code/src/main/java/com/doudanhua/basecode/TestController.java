package com.doudanhua.basecode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2020/9/1 15:18
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/say")
    public String say(){
        return "hello word";
    }
}
