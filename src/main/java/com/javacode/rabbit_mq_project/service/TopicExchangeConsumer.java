package com.javacode.rabbit_mq_project.service;
import com.javacode.rabbit_mq_project.common.Order;
import com.javacode.rabbit_mq_project.common.Product;
import com.javacode.rabbit_mq_project.configuration.RabbitMqTopicProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class TopicExchangeConsumer {

    private final RabbitMqTopicProperties topicProperties;

    public TopicExchangeConsumer(RabbitMqTopicProperties topicProperties) {
        this.topicProperties = topicProperties;
    }

    @RabbitListener(queues = "#{@rabbitMqTopicProperties.productQueue}")
    public void receiveProductMessage(Product product) {
        // Process product message
        System.out.println("Received product message: " + product);
    }

    @RabbitListener(queues = "#{@rabbitMqTopicProperties.orderQueue}")
    public void receiveOrderMessage(Order order) {
        // Process order message
        System.out.println("Received order message: " + order);
    }
}