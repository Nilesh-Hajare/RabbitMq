package com.javacode.rabbit_mq_project.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {

    private String id;
    private String name;
    private String description;
    private double price;

    public Product(String id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
