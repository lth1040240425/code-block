package com.doudanhua.basecode;

import com.doudanhua.basecode.dto.Dog;
import com.fasterxml.jackson.core.JsonProcessingException;
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
        Dog dog = new Dog();
        dog.setAge(1);
        dog.setName("hhh");
        String str = "ggggg";
        int a = 1;
        long b = 2L;
        Boolean c = false;
        log.info("object:{},string:{},int:{},long:{},boolean:{}", dog, str, a, b, c);

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
