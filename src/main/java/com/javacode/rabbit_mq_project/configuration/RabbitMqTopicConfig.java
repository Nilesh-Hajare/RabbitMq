package com.javacode.rabbit_mq_project.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqTopicConfig {

    @Bean
    public Queue productQueue() {
        return new Queue("product.queue");
    }

    @Bean
    public Queue orderQueue() {
        return new Queue("order.queue");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("demo-topic-exchange");
    }

    @Bean
    public Binding productBinding(Queue productQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(productQueue).to(topicExchange).with("product.*");
    }

    @Bean
    public Binding orderBinding(Queue orderQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(orderQueue).to(topicExchange).with("order.#");
    }

}