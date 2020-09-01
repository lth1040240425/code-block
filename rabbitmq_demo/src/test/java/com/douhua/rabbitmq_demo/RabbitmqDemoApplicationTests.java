package com.douhua.rabbitmq_demo;

import com.douhua.rabbitmq_demo.config.RabbitMqBindingConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqDemoApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    void contextLoads() {
    }

    @Test
    public void sendMQ_test(){
        rabbitTemplate.convertAndSend(RabbitMqBindingConfig.Exchange_Test,RabbitMqBindingConfig.RoutingKey_Test,"123");
    }

}
