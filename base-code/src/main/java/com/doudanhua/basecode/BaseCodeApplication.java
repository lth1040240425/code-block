package com.doudanhua.basecode;

import com.doudanhua.basecode.dto.DogDto;
import com.doudanhua.basecode.singleton.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class BaseCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseCodeApplication.class, args);
        DogDto dogDto=new DogDto();
        dogDto.setAge(1);
        dogDto.setName("hhh");
        log.info("{}",dogDto);
        Singleton instance = Singleton.getInstance();
        assert instance != null : "123";
    }


}
