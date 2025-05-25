package com.javacode.rabbit_mq_project.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    private final RabbitMqProperties properties;

    public RabbitMqConfiguration(RabbitMqProperties properties) {
        this.properties = properties;
    }

    @Bean
    public Queue queue() {
        return new Queue(properties.getQueue());
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(properties.getExchange());
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(properties.getBinding());
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}