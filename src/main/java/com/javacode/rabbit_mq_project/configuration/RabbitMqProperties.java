package com.javacode.rabbit_mq_project.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitMqProperties {
    private String queue;
    private String exchange;
    private String binding;

}