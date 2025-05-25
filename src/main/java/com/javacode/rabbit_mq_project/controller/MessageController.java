package com.javacode.rabbit_mq_project.controller;


import com.javacode.rabbit_mq_project.common.Order;
import com.javacode.rabbit_mq_project.common.Product;
import com.javacode.rabbit_mq_project.service.RabbitMqProducer;
import com.javacode.rabbit_mq_project.service.TopicExchangeProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final RabbitMqProducer producer;

    private final TopicExchangeProducer tproducer;

    public MessageController(RabbitMqProducer producer, TopicExchangeProducer tproducer) {
        this.producer = producer;
        this.tproducer = tproducer;
    }

    @PostMapping
    public String sendMessage(@RequestBody String message) {
        producer.sendMessage(message);
        return "Message sent: " + message;
    }

    @PostMapping("/product")
    public String ProductMessage(@RequestBody Product product) {
        producer.sendProductMessage(product);
        return "Test message sent: " + product;
    }

    @PostMapping("/topic/product")
    public String sendProductToTopicExchange(@RequestBody Product product) {
        tproducer.sendProductMessage(product);
        return "Product message sent to topic exchange: " + product;
    }

    @PostMapping("/topic/order")
    public String sendOrderToTopicExchange(@RequestBody Order order) {
        tproducer.sendOrderMessage(order);
        return "Order message sent to topic exchange: " + order;
    }
}