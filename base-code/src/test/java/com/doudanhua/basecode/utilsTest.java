package com.doudanhua.basecode;

import com.alibaba.fastjson.JSONObject;
import com.doudanhua.basecode.dto.DogDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2020/8/28 16:24
 */
@Slf4j
public class utilsTest {

    @Test
    public void sl4j_json_test() {
        DogDto dogDto = new DogDto();
        dogDto.setAge(1);
        dogDto.setName("hhh");
        String str = "ggggg";
        int a = 1;
        long b = 2L;
        Boolean c = false;
        log.info("object:{},string:{},int:{},long:{},boolean:{}", dogDto, str, a, b, c);

    }

    @Test
    public void test() throws JsonProcessingException {
        A a = new A();
        B b = new B();
        a.b = b;
        b.a = a;
        System.out.println(a.toString());
    }

    @Data
    class A {
        private B b;
    }

    @Data
    class B {
        private A a;
    }
}
