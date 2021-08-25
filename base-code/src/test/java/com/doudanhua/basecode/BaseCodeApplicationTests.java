package com.doudanhua.basecode;

import com.doudanhua.basecode.dto.DogDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {BaseCodeApplication.class})
@Slf4j
public class BaseCodeApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void sl4j_json_test(){
        DogDto dogDto=new DogDto();
        dogDto.setAge(1);
        dogDto.setName("hhh");
        log.info("{}",dogDto);
    }

}
