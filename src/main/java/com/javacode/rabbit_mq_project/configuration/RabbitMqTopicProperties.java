package com.javacode.rabbit_mq_project.configuration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@Data
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitMqTopicProperties {
    private String topicExchange;
    private String productQueue;
    private String orderQueue;
    private String productBinding;
    private String orderBinding;
}