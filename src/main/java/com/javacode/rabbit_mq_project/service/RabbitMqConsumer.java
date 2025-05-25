package com.javacode.rabbit_mq_project.service;

import com.javacode.rabbit_mq_project.common.Product;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receiveProductMessage(Product message) {
        System.out.println("Received message: " + message);
    }
}