package com.javacode.rabbit_mq_project.common;

import lombok.Data;

import java.io.Serializable;
@Data
public class Order implements Serializable {
    private Long id;
    private String productName;
    private int quantity;
    private double price;

    public Order() {
    }

    public Order(Long id, String productName, int quantity, double price) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}