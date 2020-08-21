package com.doudanhua.basecode;

import com.sun.istack.internal.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaseCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseCodeApplication.class, args);
        Singleton instance = Singleton.getInstance();
        assert instance!=null:"123";
    }


}
