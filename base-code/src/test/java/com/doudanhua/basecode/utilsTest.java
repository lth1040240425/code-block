package com.doudanhua.basecode;

import com.alibaba.fastjson.JSONObject;
import com.doudanhua.basecode.dto.DogDto;
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
        String str="ggggg";
        int a=1;
        long b=2L;
        Boolean c=false;
        log.info("object:{},string:{},int:{},long:{},boolean:{}",dogDto,str,a,b,c);
    }
}
