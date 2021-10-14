package com.doudanhua.basecode;

import com.doudanhua.basecode.dto.Animal;
import com.doudanhua.basecode.dto.AnimalDto;
import com.doudanhua.basecode.dto.Dog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.print.Printer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest(classes = {BaseCodeApplication.class})
@Slf4j
public class BaseCodeApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void sl4j_json_test() {
        Dog dog = new Dog();
        dog.setAge(1);
        dog.setName("hhh");
        log.info("{}", dog);
    }

    @Test
    public void json_test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        AnimalDto animalDto = new AnimalDto();
        Dog dog = new Dog();
        dog.setName("dog");
        dog.setAge(1);
        animalDto.setAnimal(dog);
        String s = objectMapper.writeValueAsString(animalDto);
        System.out.print(s);
        animalDto = objectMapper.readValue(s, AnimalDto.class);
        assert animalDto != null;
    }

}
