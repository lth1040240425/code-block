package com.douhua.rabbitmq_demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2020/8/26 15:17
 */
@Configuration
public class RabbitMqBindingConfig {
    public final static String Exchange_Test = "test";
    public final static String Queue_Test = "test";
    public final static String RoutingKey_Test = "test";

    @Bean
    public Queue testQueue() {
        return new Queue(Queue_Test);
    }

    @Bean
    public DirectExchange testExchange() {
        return new DirectExchange(Exchange_Test);
    }

    @Bean
    public Binding testBinding() {
        return BindingBuilder.bind(testQueue()).to(testExchange()).with(RoutingKey_Test);
    }

}
