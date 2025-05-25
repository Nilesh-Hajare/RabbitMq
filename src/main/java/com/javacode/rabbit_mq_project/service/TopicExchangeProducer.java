package com.javacode.rabbit_mq_project.service;

import com.javacode.rabbit_mq_project.common.Product;
import com.javacode.rabbit_mq_project.configuration.RabbitMqTopicProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class TopicExchangeProducer {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMqTopicProperties topicProperties;

    public TopicExchangeProducer(RabbitTemplate rabbitTemplate, RabbitMqTopicProperties topicProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.topicProperties = topicProperties;
    }

    public void sendProductMessage(Product product) {
        rabbitTemplate.convertAndSend(
                topicProperties.getTopicExchange(),
                topicProperties.getProductBinding().replace("*", "create"),
                product
        );
    }

    public void sendOrderMessage(Object order) {
        rabbitTemplate.convertAndSend(
                topicProperties.getTopicExchange(),
                topicProperties.getOrderBinding().replace("#", "created.new"),
                order
        );
    }

    public void sendCustomMessage(String routingKey, Object message) {
        rabbitTemplate.convertAndSend(
                topicProperties.getTopicExchange(),
                routingKey,
                message
        );
    }
}