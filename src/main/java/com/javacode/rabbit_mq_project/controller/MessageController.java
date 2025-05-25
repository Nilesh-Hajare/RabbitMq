package com.javacode.rabbit_mq_project.controller;


import com.javacode.rabbit_mq_project.common.Product;
import com.javacode.rabbit_mq_project.service.RabbitMqProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final RabbitMqProducer producer;

    public MessageController(RabbitMqProducer producer) {
        this.producer = producer;
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
}